package com.framgia.wsm.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tri on 24/05/2017.
 */

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final int ITEM_NUMBER = 8;

    private Fragment mCurrentFragment;
    private List<Fragment> mFragments;

    MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = MainContainerFragment.newInstance(position);
        mFragments.add(position, fragment);
        return fragment;
    }

    @Override
    public int getCount() {
        return ITEM_NUMBER;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        mCurrentFragment = ((Fragment) object);
        super.setPrimaryItem(container, position, object);
    }

    Fragment getCurrentFragment() {
        return mCurrentFragment;
    }

    public Fragment getFragment(@MainViewModel.Page int position) {
        return mFragments.get(position);
    }
}
