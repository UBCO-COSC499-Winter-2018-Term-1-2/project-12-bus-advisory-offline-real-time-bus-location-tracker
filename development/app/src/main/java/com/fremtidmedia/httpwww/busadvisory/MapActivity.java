package com.fremtidmedia.httpwww.busadvisory;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.common.ViewObject;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.common.GeoPosition;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;
import com.here.android.mpa.mapping.MapState;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import com.kontakt.sdk.android.ble.manager.listeners.IBeaconListener;
import com.kontakt.sdk.android.ble.manager.listeners.simple.SimpleIBeaconListener;
import com.kontakt.sdk.android.common.KontaktSDK;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;
import com.kontakt.sdk.android.common.profile.IBeaconRegion;

import static com.here.android.mpa.internal.r.H;

public class MapActivity extends Activity {

// Buttons

    Button exitButton;
   // Button trackButton;
    Button fiveButton;
    Button tenButton;
    Button fifteenButton;
    Button okButton;

// TextView

    TextView ETAmenu;


    public void clickTrack(View views) {

        Log.i("Info", "TRACK pressed");


        // Making the ETA menu visible
        fiveButton.setVisibility(View.VISIBLE);

        tenButton.setVisibility(View.VISIBLE);

        fifteenButton.setVisibility(View.VISIBLE);

        ETAmenu.setVisibility(View.VISIBLE);


        // Making the exit button visible
        exitButton.setVisibility(View.VISIBLE);
    }

    public void clickBusNum(View views) {

        Log.i("Info", "BusNum pressed");

        exitButton.setVisibility(View.VISIBLE);

        // NEW ACTIVITY METHOD
       // Intent intent = new Intent(this, );
        //startActivity(intent);
       // openBusNumAc();
    }

    public void clickExit(View views) {

        Log.i("Info", "clickExit pressed");

        // sets exit button to be invisible
        exitButton.setVisibility(View.INVISIBLE);

        // sets ETA menu to be invisible
        fiveButton.setVisibility(View.INVISIBLE);

        tenButton.setVisibility(View.INVISIBLE);

        fifteenButton.setVisibility(View.INVISIBLE);

        okButton.setVisibility(View.INVISIBLE);

        ETAmenu.setVisibility(View.INVISIBLE);

        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("When would you like to be notified about the busses ETA (in minutes)?");


    }

    public void clickFive(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is nearby");

        okButton.setVisibility(View.VISIBLE);
    }

    public void clickTen(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is nearby");

        okButton.setVisibility(View.VISIBLE);

    }

    public void clickFifteen(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is nearby");

        okButton.setVisibility(View.VISIBLE);

    }

    public void clickOK(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("When would you like to be notified about the busses ETA (in minutes)?");

       // TextView newTrack = (TextView)findViewById(R.id.track_button);
       // newTrack.setText("TRACKING");
       // newTrack.setBackgroundColor(Color.RED);

        // sets exit button to be invisible
        exitButton.setVisibility(View.INVISIBLE);

        // sets ETA menu to be invisible
        fiveButton.setVisibility(View.INVISIBLE);

        tenButton.setVisibility(View.INVISIBLE);

        fifteenButton.setVisibility(View.INVISIBLE);

        ETAmenu.setVisibility(View.INVISIBLE);

        okButton.setVisibility(View.INVISIBLE);
    }


    // Button methods

    LocationManager locationManager;
    LocationListener locationListener;
    IBeaconDevice searchBeacon;

    private Map map = null;
    private MapFragment mapFragment = null;
    private MapMarker marker;
    private GeoCoordinate userLocation;
    private PositioningManager positioningManager = null;
    private PositioningManager.OnPositionChangedListener positionListener;
    private boolean paused;

    List<MapObject> objList = new ArrayList<>();


// Resume positioning listener on wake up
public void onResume() {
    super.onResume();
    paused = false;
    if (positioningManager != null) {
        positioningManager.start(
                PositioningManager.LocationMethod.GPS_NETWORK);
    }
}

    // To pause positioning listener
    public void onPause() {
        if (positioningManager != null) {
            positioningManager.stop();
        }
        super.onPause();
        paused = true;
    }

    // To remove the positioning listener
    public void onDestroy() {
        if (positioningManager != null) {
            // Cleanup
            positioningManager.removeListener(
                    positionListener);
        }
        map = null;
        super.onDestroy();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 0, locationListener);
                }
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(MapActivity.this, new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {
                String newToken = instanceIdResult.getToken();
                Log.e("This Token", newToken);
            }
        });
        KontaktSDK.initialize("zwPcatzTlLvusdiKXJKImhTqqhVbAJyN");
        kontaktDetect();

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);

        mapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {
                if (error == OnEngineInitListener.Error.NONE) {
                    map = mapFragment.getMap();
                    map.removeMapObjects(objList);
                    map.setCenter(userLocation, Map.Animation.NONE);
                    map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) / 2);
                    positioningManager = PositioningManager.getInstance();
                    positionListener = new PositioningManager.OnPositionChangedListener() {
                        @Override
                        public void onPositionUpdated(PositioningManager.LocationMethod method, GeoPosition position, boolean isMapMatched) {
                            userLocation = position.getCoordinate();
                        }
                        @Override
                        public void onPositionFixChanged(PositioningManager.LocationMethod method, PositioningManager.LocationStatus status) { }
                    };

                    try {
                        positioningManager.addListener(new WeakReference<>(positionListener));
                        if(!positioningManager.start(PositioningManager.LocationMethod.GPS_NETWORK)) {
                            Log.e("HERE", "PositioningManager.start: Failed to start...");
                        }
                    } catch (Exception e) {
                        Log.e("HERE", "Caught: " + e.getMessage());
                    }
                    map.getPositionIndicator().setVisible(true);
                } else {
                    System.out.println("ERROR: Cannot initialize Map Fragment");
                }
            }
        });





        //Buttons
        exitButton = findViewById(R.id.exit_button);
            exitButton.setVisibility(View.INVISIBLE);

        fiveButton = findViewById(R.id.five_button);
            fiveButton.setVisibility(View.INVISIBLE);


        tenButton = findViewById(R.id.ten_button);
            tenButton.setVisibility(View.INVISIBLE);

        fifteenButton = findViewById(R.id.fifteen_button);
            fifteenButton.setVisibility(View.INVISIBLE);

        okButton = findViewById(R.id.ok_button);
            okButton.setVisibility(View.INVISIBLE);


        // Text View
        ETAmenu = findViewById(R.id.ETA_text);
            ETAmenu.setVisibility(View.INVISIBLE);


        }




    public void createMapMarker(GeoCoordinate location) {
        Image marker_img = new Image();
        try {
            marker_img.setImageResource(R.drawable.iconfinder_map_marker_299087);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map = mapFragment.getMap();
        MapMarker marker = new MapMarker(location, marker_img);
        objList.add(marker);
        map.addMapObject(marker);

    }



    private void kontaktDetect() {
        IBeaconListener iBeaconListener = new SimpleIBeaconListener() {
            @Override
            public void onIBeaconDiscovered(IBeaconDevice ibeacon, IBeaconRegion region) {
                Log.e("beacon", ibeacon.toString());
                if(ibeacon.equals(searchBeacon)){

                }
            }
        };
    }
}
