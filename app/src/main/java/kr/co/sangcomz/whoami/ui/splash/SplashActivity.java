package kr.co.sangcomz.whoami.ui.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import kr.co.sangcomz.whoami.R;
import kr.co.sangcomz.whoami.ui.main.MainActivity;


public class SplashActivity extends Activity {

    SplashActivityController splashActivityController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        this.requestWindowFeature(Window.FEATURE_NO_TITLE); // 액션바 제거
        setContentView(R.layout.activity_splash);
        splashActivityController = new SplashActivityController(this);

        Handler mHandler = new Handler();
        Runnable runnable;
        runnable = new Runnable() {
            @Override
            public void run() {
                splashActivityController.directMainPage(); //MainActivity로 이동
            }
        };
        mHandler.postDelayed(runnable, 2000);


//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                splashActivityController.directMainPage();
//            }
//        }, 1000);
    }
}
