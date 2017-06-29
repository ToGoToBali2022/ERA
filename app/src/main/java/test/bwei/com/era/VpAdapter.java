package test.bwei.com.era;

import android.content.Context;
import android.support.v4.print.PrintHelper;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2017/6/29.
 */

public class VpAdapter extends PagerAdapter {

    private Context  context;
    private List<TextView>  list;

    public VpAdapter(Context context, List<TextView> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(View container, int position) {
         TextView  tv=new TextView(context);
         tv.setText(list.get(position).getText());

       // container.addView(tv);
        return tv;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        super.destroyItem(container, position, object);

      //  container.removeView(list.get(position).getText());
    }
}
