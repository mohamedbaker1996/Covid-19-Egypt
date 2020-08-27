package com.mohamed.covid_19_egypt.view.fragment.homeCycle;

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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.data.model.CountryStatsEgypt;
import com.mohamed.covid_19_egypt.network.InternetState;
import com.mohamed.covid_19_egypt.utiles.HelperMethod;
import com.mohamed.covid_19_egypt.view.activity.HomeCycle.HomeCycleActivity;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mohamed.covid_19_egypt.data.api.RetrofitClient.getClient;

public class StatsFragment extends BaseFragment {

    @BindView(R.id.stats_fragment_btn_world_stats)
    Button statsFragmentBtnWorldStats;
    @BindView(R.id.stats_fragment_btn_egypt_stats)
    Button statsFragmentBtnEgyptStats;

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.tv_critical)
    TextView tvCritical;
    @BindView(R.id.tv_total_deaths)
    TextView tvTotalDeaths;
    @BindView(R.id.tv_cases)
    TextView tvCases;
    @BindView(R.id.tv_active)
    TextView tvActive;
    @BindView(R.id.tv_recoverd)
    TextView tvRecoverd;
    @BindView(R.id.tv_new_deaths)
    TextView tvNewDeaths;
    @BindView(R.id.tv_today_cases)
    TextView tvTodayCases;
    @BindView(R.id.tv_deaths_per_milion)
    TextView tvDeathsPerMilion;
    @BindView(R.id.img_btn_back_stats_fragment)
    ImageButton imgBtnBackStatsFragment;


    private Unbinder unbinder;
    private InterstitialAd mInterstitialAd;


    public StatsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

          setUpActivity();
        unbinder = ButterKnife.bind(this, view);
        HelperMethod.showProgressDialog(baseActivity,"Loading,Please wait!",false);
        egyptStats();

        return view;
    }

    @Override
    public void onBack() {

        super.onBack();
    }



    private void egyptStats() {
        try {
            getClient().countryState("egypt").enqueue(new Callback<CountryStatsEgypt>() {
                @Override
                public void onResponse(Call<CountryStatsEgypt> call, Response<CountryStatsEgypt> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        setData(response.body());

                    } else
                        Toast.makeText(baseActivity, "Server Error", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<CountryStatsEgypt> call, Throwable t) {
                    Toast.makeText(baseActivity, t.toString(), Toast.LENGTH_LONG).show();

                }
            });
        } catch (Exception e) {
        }
    }

    private void worldStats() {
        try {
            getClient().worldState("world").enqueue(new Callback<CountryStatsEgypt>() {
                @Override
                public void onResponse(Call<CountryStatsEgypt> call, Response<CountryStatsEgypt> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        setData(response.body());

                    } else
                        Toast.makeText(baseActivity, "Server Error", Toast.LENGTH_LONG).show();
                }


                @Override
                public void onFailure(Call<CountryStatsEgypt> call, Throwable t) {
                    Toast.makeText(baseActivity, t.toString(), Toast.LENGTH_LONG).show();

                }
            });
        } catch (Exception e) {
        }
    }

    private void setData(CountryStatsEgypt body) {
        //tvTest.setText(body.getCountry().toString());
        // etTest.getEditableText().append(body.getCountry());
        String active = HelperMethod.getFormatedNumber(body.getActive().toString());
        String cases = HelperMethod.getFormatedNumber(body.getCases().toString());
        String critical = HelperMethod.getFormatedNumber(body.getCritical().toString());
        String deathsPerMilion = HelperMethod.getFormatedNumber(body.getDeathsPerOneMillion().toString());
        String newDeaths = HelperMethod.getFormatedNumber(body.getTodayDeaths().toString());
        String recoverd = HelperMethod.getFormatedNumber(body.getRecovered().toString());
        String todayCases = HelperMethod.getFormatedNumber(body.getTodayCases().toString());
        String totalDeaths = HelperMethod.getFormatedNumber(body.getDeaths().toString());


        tvActive.setText(active);
        tvCases.setText(cases);
        tvCritical.setText(critical);
        tvDeathsPerMilion.setText(deathsPerMilion);
        tvNewDeaths.setText(newDeaths);
        tvRecoverd.setText(recoverd);
        tvTodayCases.setText(todayCases);
        tvTotalDeaths.setText(totalDeaths);
        HelperMethod.dismissProgressDialog();
    }



    @OnClick({R.id.stats_fragment_btn_world_stats, R.id.stats_fragment_btn_egypt_stats})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.stats_fragment_btn_world_stats:
                worldStats();

                break;
            case R.id.stats_fragment_btn_egypt_stats:
                egyptStats();

                break;
        }
    }

    @OnClick(R.id.img_btn_back_stats_fragment)
    public void onViewClicked() {
        onBack();
    }
}
