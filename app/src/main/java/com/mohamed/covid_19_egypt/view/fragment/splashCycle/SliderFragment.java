package com.mohamed.covid_19_egypt.view.fragment.splashCycle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.adapter.SlideAdapter;
import com.mohamed.covid_19_egypt.adapter.ViewPagerWithFragmentAdapter;
import com.mohamed.covid_19_egypt.view.activity.HomeCycle.HomeCycleActivity;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

import java.util.Objects;

public class SliderFragment extends BaseFragment {

    private SlideAdapter sliderAdapter;
    private TextView[] mDots;
    private Button slideNextBtn;
    private Button slideBackBtn;
    private int slideCurrnentPage;
    String prevStarted = "prevStarted";

    ViewPager slideViewPager;
    //  @BindView(R.id.dots_layout)
    LinearLayout mDotsLayout;
    private ViewPagerWithFragmentAdapter viewPagerWithFragmentAdapter;


    public SliderFragment() {
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
        View view = inflater.inflate(R.layout.fragment_slider, container, false);
        slideViewPager = view.findViewById(R.id.slide_view_pager);
        mDotsLayout = view.findViewById(R.id.dots_layout);
        slideNextBtn = view.findViewById(R.id.btn_next_slide);
        slideBackBtn = view.findViewById(R.id.btn_prev_slide);
        sliderAdapter = new SlideAdapter(Objects.requireNonNull(this.getActivity()));
        slideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);
        slideViewPager.addOnPageChangeListener(viewListener);

        slideNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(slideCurrnentPage + 1,true);
            }
        });
        slideBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideViewPager.setCurrentItem(slideCurrnentPage - 1,true );

            }
        });
        return view;
    }


    public void addDotsIndicator(int position) {
        mDots = new TextView[2];
        mDotsLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this.getActivity());
            mDots[i].setText(Html.fromHtml("&#9673;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorLightBlue));
            mDotsLayout.addView(mDots[i]);

        }
        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {
            addDotsIndicator(i);
            slideCurrnentPage = i;
            if (i == 0) {
                slideNextBtn.setEnabled(true);
                slideBackBtn.setEnabled(false);
                slideBackBtn.setVisibility(View.INVISIBLE);
                slideNextBtn.setText("Next");
                slideBackBtn.setText("");
                slideNextBtn.setTextColor(getResources().getColor(R.color.colorWhite));
                slideBackBtn.setTextColor(getResources().getColor(R.color.colorWhite));

            } else if (i == mDots.length -1) {
                slideNextBtn.setEnabled(true);
                slideBackBtn.setEnabled(true);
                slideBackBtn.setVisibility(View.VISIBLE);
                slideNextBtn.setText("Finish");
                slideBackBtn.setText("Back");
                slideNextBtn.setTextColor(getResources().getColor(R.color.colorWhite));
                slideBackBtn.setTextColor(getResources().getColor(R.color.colorWhite));

                slideNextBtn.setOnClickListener(v -> {
                    Intent intent = new Intent(getActivity(), HomeCycleActivity.class);
                    startActivity(intent);
                });

            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    @Override
    public void onBack() {

        Objects.requireNonNull(getActivity()).finish();
    }

}
