package com.chartdemo.jackiecustomview.utills;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.widget.ListView;

/**
 * Created by Jackie on 2018/3/28.
 */

public class LocationUtils {

    private static final long REFRESH_TIME = 5000L;
    private static final float METER_POSITION = 0.0f;
    private static ILocationListener mLocationListener;

    private static class MylocationListener implements LocationListener{

        @Override
        public void onLocationChanged(Location location) {   //定位改变监听
            if (mLocationListener != null){
                mLocationListener.onSuccessLocation(location);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    }

//    public static Location getNetWorkLocation(Context context){
//        Location location = null;
//        LocationManager manager = getLocationManager(context);
//        if (ActivityCompat.checkSelfPermission(context
//                , Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
//            return null;
//        }
////        <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"></uses-permission>
//        if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){
//            location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//        }
//        return location;
//    }

    private static LocationManager getLocationManager(@NonNull Context context) {
        return (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
    }



    /**
     * 自定义接口
     */
    public interface ILocationListener {
        void onSuccessLocation(Location location);
    }
}
