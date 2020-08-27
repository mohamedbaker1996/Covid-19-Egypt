package com.mohamed.covid_19_egypt.view.fragment.homeCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.mohamed.covid_19_egypt.R;
import com.mohamed.covid_19_egypt.view.fragment.BaseFragment;

import butterknife.Unbinder;

public class SymptomsFragment extends BaseFragment {


    private Unbinder unbinder;
    private ExpandingList expandingList;


    public SymptomsFragment() {
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
        View view = inflater.inflate(R.layout.fragment_symptoms, container, false);
        expandingList = (ExpandingList) view.findViewById(R.id.expanding_list_main);


        //epxpandingListDeploy();
        setUpActivity();
        createItems();
        return view;


    }

    /*
        private void epxpandingListDeploy() {
            ExpandingItem mostCommonSymptoms = (ExpandingItem) expandingList.createNewItem(R.layout.expanding_layout);
            TextView tvMostCommon = (TextView) mostCommonSymptoms.findViewById(R.id.tv_item_title);
            tvMostCommon.setText("أعراض الاكثر شيوعا");

            ExpandingItem lessCommonSymptoms = expandingList.createNewItem(R.layout.expanding_layout);
            TextView tvLessCommon = lessCommonSymptoms.findViewById(R.id.tv_item_title);
            tvLessCommon.setText("أعراض أقل شيوعا");

            ExpandingItem seriousSymptoms = expandingList.createNewItem(R.layout.expanding_layout);
            TextView tvSeriousSymptoms = seriousSymptoms.findViewById(R.id.tv_item_title);
            tvSeriousSymptoms.setText("أعراض خطيره");



            mostCommonSymptoms.createSubItems(7);
            mostCommonSymptoms.setIndicatorColor(R.color.colorLightBlue2);

    //get a sub item View
            View subItemZero = mostCommonSymptoms.getSubItemView(0);
            ((TextView) subItemZero.findViewById(R.id.tv_item_sub_title)).setText("حمي");

            View subItemOne = mostCommonSymptoms.getSubItemView(1);
            ((TextView) subItemOne.findViewById(R.id.tv_item_sub_title)).setText("كحه جافه");

            View subItemTwo = mostCommonSymptoms.getSubItemView(2);
            ((TextView) subItemTwo.findViewById(R.id.tv_item_sub_title)).setText("ارهاق");
    //-------------------------------------------------------------------
         //   lessCommonSymptoms.createSubItems(3);
            lessCommonSymptoms.setIndicatorColor(R.color.colorLightPurple);

            View lessCommonSubItemZero = lessCommonSymptoms.getSubItemView(0);
            ((TextView) lessCommonSubItemZero.findViewById(R.id.tv_item_sub_title)).setText("آلام العضلات");

            View lessCommonSubItemOne = mostCommonSymptoms.getSubItemView(1);
            ((TextView) lessCommonSubItemOne.findViewById(R.id.tv_item_sub_title)).setText("التهاب الحلق");

            View lessCommonSubItemTwo = mostCommonSymptoms.getSubItemView(2);
            ((TextView) lessCommonSubItemTwo.findViewById(R.id.tv_item_sub_title)).setText("إسهال");

            View lessCommonSubItemThree = mostCommonSymptoms.getSubItemView(3);
            ((TextView) lessCommonSubItemThree.findViewById(R.id.tv_item_sub_title)).setText("الصداع");

            View lessCommonSubItemFour = mostCommonSymptoms.getSubItemView(4);
            ((TextView) lessCommonSubItemFour.findViewById(R.id.tv_item_sub_title)).setText("فقدان حاسة التذوق أو الشم");

            View lessCommonSubItemFive = mostCommonSymptoms.getSubItemView(5);
            ((TextView) lessCommonSubItemFive.findViewById(R.id.tv_item_sub_title)).setText("طفح جلدي");

            View lessCommonSubItemSix = mostCommonSymptoms.getSubItemView(6);
            ((TextView) lessCommonSubItemSix.findViewById(R.id.tv_item_sub_title)).setText("القشعريرة");

         //  -----------------------------------
           // seriousSymptoms.createSubItems(3);
            seriousSymptoms.setIndicatorColor(R.color.colorLightYellow);


            View seriousSubItemZero = lessCommonSymptoms.getSubItemView(0);
            ((TextView) seriousSubItemZero.findViewById(R.id.tv_item_sub_title)).setText(" صعوبه فى التنفس");

            View seriousSubItemOne = mostCommonSymptoms.getSubItemView(1);
            ((TextView) seriousSubItemOne.findViewById(R.id.tv_item_sub_title)).setText("شعورًا مستمرًا بألم أو ضغط في الصدر");

            View seriousSubItemTwo = mostCommonSymptoms.getSubItemView(2);
            ((TextView) seriousSubItemTwo.findViewById(R.id.tv_item_sub_title)).setText("فقدان الكلام أو الحركة");

        }
        */
    private void createItems() {
        addItem("أعراض أكثر شيوعا",new String[]{"حمي","كحه جافه","ارهاق"} , R.color.colorRedThree);
        addItem("أعراض أقل شيوعا", new String[]{"آلام العضلات", "إلتهاب الحلق", "إسهال","الصداع","فقدان حاسة التذوق أو الشم","طفح جلدي","القشعريرة"}, R.color.colorRedTwo);
        addItem("أعراض خطيره", new String[]{"صعوبه فى التنفس","شعورًا مستمرًا بألم أو ضغط في الصدر","فقدان الكلام أو الحركة"}, R.color.colorRed);

    }

    private void addItem(String title, String[] subItem,int colorRes) {
        final ExpandingItem item = expandingList.createNewItem(R.layout.expanding_layout);

        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            TextView txt = item.findViewById(R.id.tv_item_title);
            txt.setText(title);

            int subItemSize = subItem.length ;
            item.createSubItems(subItemSize);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                final View view = item.getSubItemView(i);

                configureSubItem(item, view, subItem[i]);

            }

        }
    }



    private void configureSubItem(final ExpandingItem item,final View view, String subTitle) {
     TextView tvSubTitle = view.findViewById(R.id.tv_item_sub_title);
    tvSubTitle.setText(subTitle);
    }


    @Override
    public void onBack() {
        super.onBack();
    }

}
