package com.mohamed.covid_19_egypt.view.activity.SplashCycle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Toast;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.utiles.HelperMethod;
import com.mohamed.covid_19_egypt.view.activity.BaseActivity;
import com.mohamed.covid_19_egypt.view.activity.HomeCycle.HomeCycleActivity;
import com.mohamed.covid_19_egypt.view.fragment.splashCycle.SplashFragment;

public class SplashCycleActivity extends BaseActivity {
    String prevStarted = "prevStarted";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_cycle);

            HelperMethod.replaceFragment(getSupportFragmentManager(), R.id.splash_cycle_activity_frame, new SplashFragment());



    }



}
