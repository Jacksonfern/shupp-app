package shuppproject.shupp.mainfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import shuppproject.shupp.R;
import shuppproject.shupp.locaisfragment.ListaLocaisFragment;

public class LocaisFragment extends Fragment {

    private View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_locais, container, false);

        TabLayout tabs = rootView.findViewById(R.id.tabs_locais);
        ViewPager mPager = rootView.findViewById(R.id.view_pager_locais);

        FragmentPagerAdapter pagerAdapter = new LocaisPagerAdapter(getChildFragmentManager());
        mPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(mPager);
        return rootView;
    }

    private class LocaisPagerAdapter extends FragmentPagerAdapter {

        private static final int PAGE_COUNT = 2;
        private final String[] page_titles = new String[] { "Lista", "Mapa" };

        public LocaisPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0: return new ListaLocaisFragment();
                case 1: return new ListaLocaisFragment();
            }
            return null;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return page_titles[position];
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}