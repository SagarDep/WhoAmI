package kr.co.sangcomz.whoami.ui.main;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;

import kr.co.sangcomz.whoami.R;
import kr.co.sangcomz.whoami.core.lifecycle.CycleControllerAppCombatActivity;
import kr.co.sangcomz.whoami.view.DeclareView;

public class MainActivity extends CycleControllerAppCombatActivity {

    @DeclareView(id = R.id.tabs)
    TabLayout tabLayout;

    @DeclareView(id = R.id.viewpager)
    ViewPager viewPager;

    @DeclareView(id = R.id.toolbar)
    Toolbar toolbar;

    MainActivityController mainActivityController;
    MainFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main, true);

        setSupportActionBar(toolbar); //actionBar ¼³Á¤

        final ActionBar ab = getSupportActionBar();
        ab.setTitle(R.string.title_profile);
        ab.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        ab.setDisplayHomeAsUpEnabled(true);


        mainActivityController = new MainActivityController();
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
        if (viewPager != null) {
            mainActivityController.setUpViewPager(this, viewPager, adapter);
        }


        tabLayout.setupWithViewPager(viewPager);
    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
