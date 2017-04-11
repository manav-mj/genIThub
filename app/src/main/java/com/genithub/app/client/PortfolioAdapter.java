package com.genithub.app.client;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by YourFather on 11-04-2017.
 */

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder> {
    private LayoutInflater mInflater;
    ArrayList<Portfolio> mData;
    Context mContext;

    public PortfolioAdapter(Context context, ArrayList<Portfolio> data){
        mInflater = LayoutInflater.from(context);
        mData = data;
        mContext = context;
    }

    @Override
    public PortfolioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.portfolio_list_item, parent, false);
        PortfolioViewHolder viewHolder = new PortfolioViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PortfolioViewHolder holder, int position) {
        Portfolio currentObject = mData.get(position);

        holder.projectName.setText(currentObject.name);
        holder.projectType.setText(currentObject.type);
        Picasso.with(mContext).load(currentObject.imgUrl).into(holder.imgPreview);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class PortfolioViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPreview;
        TextView projectName;
        TextView projectType;

        public PortfolioViewHolder(View itemView) {
            super(itemView);
            imgPreview = (ImageView) itemView.findViewById(R.id.img_preview);
            projectName = (TextView) itemView.findViewById(R.id.project_name);
            projectType = (TextView) itemView.findViewById(R.id.project_type);
        }
    }
}
