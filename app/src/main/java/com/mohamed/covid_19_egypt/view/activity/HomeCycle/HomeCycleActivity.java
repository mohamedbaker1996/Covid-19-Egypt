package com.mohamed.covid_19_egypt.view.activity.HomeCycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.utiles.HelperMethod;
import com.mohamed.covid_19_egypt.view.activity.BaseActivity;
import com.mohamed.covid_19_egypt.view.activity.SplashCycle.SplashCycleActivity;
import com.mohamed.covid_19_egypt.view.fragment.homeCycle.HomeFragment;

public class HomeCycleActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cycle);
        HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.frame_home_activity, new HomeFragment());
//        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
//        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
//        if(!previouslyStarted) {
//            SharedPreferences.Editor edit = prefs.edit();
//            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
//            edit.apply();
//            Intent intent = new Intent(HomeCycleActivity.this, SplashCycleActivity.class);
//            startActivity(intent);
//        }



        /*  Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show start activity
            Intent intent = new Intent(HomeCycleActivity.this, SplashCycleActivity.class);
            startActivity(intent);


        } else {
            HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.frame_home_activity, new HomeFragment());
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();
*/
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
