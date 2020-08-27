package com.mohamed.covid_19_egypt.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

public class BaseActivity extends AppCompatActivity {

    public BaseFragment baseFragment;


    public void superBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onBackPressed() {
        baseFragment.onBack();
    }
}