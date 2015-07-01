package kr.co.sangcomz.whoami.ui.main;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 석원 on 2015-07-02.
 */
public class MainActivityController {

    public MainActivityController(){

    }

    public void setUpViewPager(ViewPager viewPager, FragmentManager fragmentManager, MainFragmentAdapter mainFragmentAdapter){
        mainFragmentAdapter = new MainFragmentAdapter(fragmentManager);
//        adapter.addFragment(new Note(), "지각 노트");
//        adapter.addFragment(new Meeting(), "모임 계획");
//        adapter.addFragment(new GatheringMember(), "모임 멤버");
        viewPager.setAdapter(mainFragmentAdapter);
    }


}
