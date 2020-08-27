package com.mohamed.covid_19_egypt.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamed.covid_19_egypt.R;

public class EmptyFragment extends BaseFragment {

    public EmptyFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setUpActivity();
        return inflater.inflate(R.layout.fragment_empty, container, false);

    }
    @Override
    public void onBack(){
        super.onBack();
    }

}
