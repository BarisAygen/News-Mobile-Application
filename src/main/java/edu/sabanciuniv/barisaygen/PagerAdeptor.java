package edu.sabanciuniv.barisaygen;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdeptor extends FragmentPagerAdapter {

    int tabs;

    public PagerAdeptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new EconomicsFragment();
        }
        else if(position == 1){
            return new SportsFragment();
        }
        else if(position == 2){
            return new PoliticsFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabs;
    }
}
