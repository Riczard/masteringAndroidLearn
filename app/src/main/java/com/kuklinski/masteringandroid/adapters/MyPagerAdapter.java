package com.kuklinski.masteringandroid.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kuklinski.masteringandroid.fragments.ContactFragment;
import com.kuklinski.masteringandroid.fragments.ListFragment;
import com.kuklinski.masteringandroid.fragments.SettingFragment;

/**
 * Created by antonio on 28/04/2015.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0 :
                return new ListFragment();
            case 1 :
                return new ContactFragment();
            case 2 :
                return new SettingFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0 :
                return "LIST";
            case 1 :
                return "CONTACT";
            case 2 :
                return "SETTINGS";
            default:
                return null;
        }
    }

}
