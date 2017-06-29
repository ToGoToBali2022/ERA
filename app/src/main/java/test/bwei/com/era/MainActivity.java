package test.bwei.com.era;

import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;


public class MainActivity extends Activity {

    private ViewPager vp;
    private List<View> listview;
    private List<ImageView> imageViews;
    private LinearLayout linear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (isFirst()) {
            gotoActivity();
            return;
        }
        vp = (ViewPager) findViewById(R.id.vp);
        linear = (LinearLayout) findViewById(R.id.linear);
        dataVP();

        setVP();

        imageViews = new ArrayList<>();

        linear.removeAllViews();

        imageViews.clear();

        for (int i = 0; i < listview.size(); i++) {
            ImageView imageView = new ImageView(this);
            if (i == 0) {
                imageView.setImageResource(R.drawable.shape2);
            } else {
                imageView.setImageResource(R.drawable.shape1);

            }

            LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);

            params.setMargins(5, 0, 5, 0);
            linear.addView(imageView, params);
            imageViews.add(imageView);
        }

        vp.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                for (int i = 0; i < imageViews.size(); i++) {
                    if (i == arg0) {
                        imageViews.get(i).setImageResource(R.drawable.shape2);
                    } else {
                        imageViews.get(i).setImageResource(R.drawable.shape1);

                    }
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    private boolean isFirst() {
        boolean  is= (boolean) SharedPreferencedUtils.take(MainActivity.this,"flag", false);
        return is;
    }

    private void setVP() {
        vp.setAdapter(new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return listview.size();
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(listview.get(position));
                return listview.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(listview.get(position));

            }
        });

    }

    private void dataVP() {
        listview = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.one, null);
        View view2 = View.inflate(this, R.layout.two, null);

        view2.findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoActivity();

                SharedPreferencedUtils.save(MainActivity.this,"flag",true);


            }
        });



        listview.add(view1);
        listview.add(view2);

    }

    private void gotoActivity() {
        Intent intent = new Intent(MainActivity.this, SecondA.class);
         startActivity(intent);
        finish();
    }

}
