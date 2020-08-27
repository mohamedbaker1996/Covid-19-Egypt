package com.mohamed.covid_19_egypt.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.view.activity.BaseActivity;

public class BaseFragment extends Fragment {
    public BaseActivity baseActivity;
    public void setUpActivity() {
        baseActivity = (BaseActivity) getActivity();

        baseActivity.baseFragment = this;
    }
    public void onBack(){
        baseActivity.superBackPressed();
    }
}