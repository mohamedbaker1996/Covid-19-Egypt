package com.mohamed.covid_19_egypt.view.fragment.homeCycle;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.network.InternetState;
import com.mohamed.covid_19_egypt.utiles.HelperMethod;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.tv_desc_feeling_tired)
    TextView tvDescFeelingTired;
    @BindView(R.id.btn_call_now)
    Button btnCallNow;
    @BindView(R.id.btn_check_stats)
    Button btnCheckStats;
    @BindView(R.id.img_symptoms)
    ImageButton imgSymptoms;
    private Unbinder unbinder;
    private InterstitialAd mInterstitialAd;

    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setUpActivity();
        unbinder = ButterKnife.bind(this, view);
        loadAd();

        return view;

    }
    private void loadAd(){
        MobileAds.initialize(baseActivity, getString(R.string.admob_app_id));
        mInterstitialAd = new InterstitialAd(baseActivity);
        mInterstitialAd.setAdUnitId("ca-app-pub-1640388995037866/7348146095");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });

    }
    private void displayInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    @Override
    public void onBack() {
        Objects.requireNonNull(getActivity()).finish();
    }

    public void onCall(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL); //use ACTION_CALL class
        callIntent.setData(Uri.parse("tel:15335"));    //this is the phone number calling
        //check permission150
        //If the device is running Android 6.0 (API level 23) and the app's targetSdkVersion is 23 or higher,
        //the system asks the user to grant approval.
        if (ActivityCompat.checkSelfPermission(baseActivity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //request permission from user if the app hasn't got the required permission
            ActivityCompat.requestPermissions(baseActivity,
                    new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                    10);
            return;
        } else {     //have got permission
            try {
                startActivity(callIntent);  //call activity and make phone call
            } catch (ActivityNotFoundException ex) {
                Toast.makeText(baseActivity.getApplicationContext(), "yourActivity is not founded", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @OnClick({R.id.btn_call_now, R.id.btn_check_stats})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_call_now:
                onCall(view);
                break;
            case R.id.btn_check_stats:

                if (InternetState.isConnected(baseActivity)) {
                    HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.frame_home_activity, new StatsFragment());
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            displayInterstitial();
                        }
                    }, 7000);

                }else {
                HelperMethod.showProgressDialog(baseActivity,"يرجي الاتصال بالانترنت لمتابعه الاحصائيات!",true);
                }
                break;
        }
    }

    @OnClick(R.id.img_symptoms)
    public void onViewClicked() {
        HelperMethod.replaceFragment(getActivity().getSupportFragmentManager(), R.id.frame_home_activity, new SymptomsFragment());

    }
}
