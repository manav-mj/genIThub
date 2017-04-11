package com.genithub.app.client.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.genithub.app.client.Portfolio;
import com.genithub.app.client.PortfolioAdapter;
import com.genithub.app.client.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.ArrayList;
import java.util.Map;

import static android.content.ContentValues.TAG;

/**
 * Created by YourFather on 11-04-2017.
 */

public class PortfolioFragment extends android.support.v4.app.Fragment {

    RecyclerView recyclerView;
    ArrayList<Portfolio> portfolioArrayList;
    PortfolioAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_portfolio, container, false);

        portfolioArrayList = new ArrayList<>();

        recyclerView = (RecyclerView) view.findViewById(R.id.portfolio_list);

        adapter = new PortfolioAdapter(getActivity(), portfolioArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        DatabaseReference mPortfolioRef = FirebaseDatabase.getInstance().getReference().child("portfolio");

        mPortfolioRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Log.e("manav", "onDataChange: " + dataSnapshot.getValue().toString() );
//                portfolioArrayList = (ArrayList<Portfolio>) dataSnapshot.getValue();
                for (DataSnapshot d :
                        dataSnapshot.getChildren()) {
                    Map<String, String> map = (Map<String, String>) d.getValue();
                    Log.d("manav", "onDataChange: " + d.getValue());
                    Log.d(TAG, "onDataChange: " + map.toString());
                    portfolioArrayList.add(new Portfolio(map.get("name"), map.get("type"), map.get("imgUrl"), ""));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return view;
    }
}
