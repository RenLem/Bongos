package omy.boston.bongos.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import omy.boston.bongos.fragments.DrumCfragment;
import omy.boston.bongos.fragments.DrumFfragment;


/**
 * Created by LosFrancisco on 05-May-17.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if (position == 0){
            return DrumCfragment.newInstance(position + 1);
        }else {
            return DrumFfragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Bongos";
            case 1:
                return "Story";
        }
        return null;
    }
}
