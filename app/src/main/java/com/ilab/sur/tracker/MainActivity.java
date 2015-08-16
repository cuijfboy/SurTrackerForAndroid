package com.ilab.sur.tracker;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.ilab.lbs.baidu.BaiduLocationService;
import com.ilab.lbs.baidu.BaiduMapView;
import com.ilab.lbs.sur.location.SurLocation;
import com.ilab.lbs.sur.location.SurLocationService;
import com.ilab.lbs.sur.map.SurMap;


public class MainActivity extends Activity {

    private MapView mapView = null;

    private SurLocationService locationService = null;
    private SurMap map = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_main);
        mapView = (MapView) findViewById(com.ilab.lbs.R.id.bmapView);

        locationService = BaiduLocationService.getInstance(this);
        map = new BaiduMapView(this, mapView);

        locationService.registerLocationUpdateListener(new SurLocation.Listener() {
            @Override
            public void onLocationUpdate(SurLocation location) {
                map.setLocation(location, true);
            }
        });
        locationService.start();


    }


}
