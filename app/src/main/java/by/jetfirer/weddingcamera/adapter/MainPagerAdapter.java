package by.jetfirer.weddingcamera.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.jetfirer.weddingcamera.fragment.FirstFragment;
import by.jetfirer.weddingcamera.fragment.SecondFragment;

/**
 * Created by Konstantin on 26.07.2017.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
        }
        return null;
    }

}
