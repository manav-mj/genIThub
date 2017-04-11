package com.genithub.app.client;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.genithub.app.client.fragments.ContactFragment;
import com.genithub.app.client.fragments.PortfolioFragment;
import com.genithub.app.client.fragments.TeamFragment;

public class MainActivity extends AppCompatActivity {

    private ContactFragment contactFragment;
    private PortfolioFragment portfolioFragment;
    private TeamFragment teamFragment;
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    final static int PORTFOLIO = 1;
    final static int CONTACT = 2;
    final static int TEAM = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contactFragment = new ContactFragment();
        portfolioFragment = new PortfolioFragment();
        teamFragment = new TeamFragment();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        mViewPager.setCurrentItem(PORTFOLIO);

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case TEAM:
                    return teamFragment;
                case PORTFOLIO:
                    return portfolioFragment;
                case CONTACT:
                    return contactFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case TEAM:
                    return "Team";
                case PORTFOLIO:
                    return "Portfolio";
                case CONTACT:
                    return "Contact US";
            }
            return null;
        }
    }
}
