package com.mohamed.covid_19_egypt.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.mohamed.covid_19_egypt.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    private int[] GalImages = new int[]{R.drawable.intro_slider_1, R.drawable.intro_slider_2};


    public String [] textsIntro = {
            "التطبيق ده معمول لمساعدتك خلال فتره الوباء  لو حسيت بأعراض او تعرف حد عنده أعراض تقدر تبلغ عن طريق التطبيق .",
            "وكمان تقدر تشوف أعراض الفيرس من الاعراض الشائعه الي الأعراض الخطره وتقدر تتابع الاحصائيات الموثوقه من منظمة الصحه العالمية في أي وقت حيث يتم تحديث الاحصائيات تلقائيا كل عشر دقايق ."
    };
    LayoutInflater mLayoutInflater;

    public SlideAdapter(Context context) {
        this.context = context;
     //   this.txtIntro =txtIntro;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GalImages.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        try {

            View itemView = mLayoutInflater.inflate(R.layout.fragment_intro_slider1, container, false);

            TextView txtIntroslider;
            txtIntroslider =(TextView) itemView.findViewById(R.id.tv_intro_slider_1);
            txtIntroslider.setText(textsIntro[position]);

            ImageView imageView = itemView.findViewById(R.id.img_intro_slider_1);
            imageView.setImageResource(GalImages[position]);

            container.addView(itemView);

            return itemView;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}

