package hr.dominik.library.FragmentiProgramiranje;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public MyFragmentAdapter(Context context,FragmentManager fm,int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                DostupnoFragment dostupnoFragment = new DostupnoFragment();
                return dostupnoFragment;
            case 1:
                PozajmljenoFragment pozajmljenoFragment = new PozajmljenoFragment();
                return pozajmljenoFragment;
            case 2:
                WishListFragment wishListFragment = new WishListFragment();
                return wishListFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
