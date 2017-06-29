package test.bwei.com.era;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.TextureMapView;
import com.xys.libzxing.zxing.activity.CaptureActivity;


public class SecondA extends Activity {


	private TextureMapView mMapView;
    private BaiduMap map;
    private Button sao;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.second);

        sao = (Button)findViewById(R.id.saodanche);

		mMapView = (TextureMapView) findViewById(R.id.mMapView);
        map = mMapView.getMap();

        //普通地图
        map.setMapType(BaiduMap.MAP_TYPE_NORMAL);


        sao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondA.this, CaptureActivity.class));
            }
        });


    }


}