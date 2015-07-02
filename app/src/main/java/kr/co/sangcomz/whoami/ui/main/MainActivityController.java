package kr.co.sangcomz.whoami.ui.main;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import kr.co.sangcomz.whoami.R;
import kr.co.sangcomz.whoami.ui.main.Fragment.Hobby;
import kr.co.sangcomz.whoami.ui.main.Fragment.MyAlbum;
import kr.co.sangcomz.whoami.ui.main.Fragment.Portfolio;
import kr.co.sangcomz.whoami.ui.main.Fragment.Profile;

/**
 * Created by 석원 on 2015-07-02.
 */
public class MainActivityController {

    public MainActivityController(){

    }

    public void setUpViewPager(Context context, ViewPager viewPager, MainFragmentAdapter mainFragmentAdapter){
        mainFragmentAdapter.addFragment(new Profile(), context.getResources().getString(R.string.title_profile));
        mainFragmentAdapter.addFragment(new Hobby(), context.getResources().getString(R.string.title_hobby));
        mainFragmentAdapter.addFragment(new MyAlbum(), context.getResources().getString(R.string.title_my_album));
        mainFragmentAdapter.addFragment(new Portfolio(), context.getResources().getString(R.string.title_portfolio));
        viewPager.setAdapter(mainFragmentAdapter);
    }


}
