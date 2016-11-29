package com.eueh.yohonow.magazine;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.eueh.yohonow.R;
import com.eueh.yohonow.base.BaseFragment;
import com.eueh.yohonow.magazine.magapage.MagazinePageFragment;
import com.eueh.yohonow.magazine.magazinemag.MagazineMaFragment;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/23.
 */

public class MagazineFragment extends BaseFragment {
    private ArrayList<Fragment> data;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected int setLayout() {
        return R.layout.fragment_magazine;
    }

    @Override
    public void initView(View view) {
        data = new ArrayList<>();
        tabLayout = (TabLayout) view.findViewById(R.id.tb_magazine);
        viewPager = (ViewPager) view.findViewById(R.id.vp_magazine);
    }

    @Override
    public void initData() {
        addFragment();
    }

    private void addFragment() {
        data.add(new MagazineMaFragment());
        data.add(new MagazinePageFragment());

        TabMagaAdapter adapter = new TabMagaAdapter(getChildFragmentManager(),data);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
