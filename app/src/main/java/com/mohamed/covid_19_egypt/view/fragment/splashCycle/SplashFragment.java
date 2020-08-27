package com.mohamed.covid_19_egypt.view.fragment.splashCycle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.utiles.HelperMethod;
import com.mohamed.covid_19_egypt.view.activity.HomeCycle.HomeCycleActivity;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

import static com.mohamed.covid_19_egypt.R.id.splash_cycle_activity_frame;
import static java.util.Objects.requireNonNull;

public class SplashFragment extends BaseFragment {


    public SplashFragment() {
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

        View view = inflater.inflate(R.layout.fragment_splash, container, false);



        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(baseActivity.getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.apply();
            final Handler handler = new Handler();
            handler.postDelayed(() -> {

                HelperMethod.replaceFragment(requireNonNull(getActivity()).getSupportFragmentManager(), splash_cycle_activity_frame, new SliderFragment());
                // HelperMethods.replaceFragment(getActivity().getSupportFragmentManager(), R.id.splash_cycle_activity_frame, new SliderFragment());

            }, 3000);
        }else {

            final Handler handler = new Handler();
            handler.postDelayed(() -> {

                Intent intent = new Intent(getActivity(), HomeCycleActivity.class);
                startActivity(intent);                // HelperMethods.replaceFragment(getActivity().getSupportFragmentManager(), R.id.splash_cycle_activity_frame, new SliderFragment());

            }, 3000);
        }




        return view;
    }

    @Override
    public void onBack() {
        baseActivity.finish();
    }

}
