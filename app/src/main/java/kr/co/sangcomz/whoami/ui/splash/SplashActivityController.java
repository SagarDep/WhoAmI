package kr.co.sangcomz.whoami.ui.splash;

import android.app.Activity;
import android.content.Intent;

import kr.co.sangcomz.whoami.ui.main.MainActivity;

/**
 * Created by 석원 on 2015-07-02.
 */
public class SplashActivityController {
    Activity activity;
    SplashActivityController(Activity activity){
        this.activity = activity;
    }

    public void directMainPage(){
        Intent i = new Intent(activity, MainActivity.class);
        activity.startActivity(i);
        activity.finish();

    }
}
