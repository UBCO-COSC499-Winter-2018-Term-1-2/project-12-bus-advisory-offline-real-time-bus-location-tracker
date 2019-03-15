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
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.TypedValue;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import android.content.DialogInterface;
import android.app.AlertDialog.Builder;
import android.app.AlertDialog;


import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;

import static com.here.android.mpa.internal.r.H;

public class MapActivity extends Activity {

    private TimePicker time_picker;

    private Button button_set_time;










   // FloatingActionButton FABexit = (FloatingActionButton) findViewById(R.id.FAB_exit);

   // FABexit.setOnClickListener(new View.OnClickListener()



// Buttons

    Button exitButton;
   // Button trackButton;
    Button fiveButton;
    Button tenButton;
    Button fifteenButton;
    Button okButton;




// TextView

    TextView ETAmenu;


/*
    TimePicker.setOnTimeChangedListener( new TimePicker.onTimeChangedListener(){

        String date;


        @Override
        public void onTimeChanged (TimePicker view,int hourOfDay, int minute){
        // TODO Auto-generated method stub
        date = String.valueOf(hourOfDay).toString() + ":" + String.valueOf(minute).toString();
        Log.i("Info", date);
    }

    }
    */







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

    /*

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

        TextView newTrack = (TextView)findViewById(R.id.track_button);
        newTrack.setText("TRACK");
        newTrack.setBackgroundColor(Color.GRAY);
        newTrack.setTextSize(TypedValue.COMPLEX_UNIT_SP,30f);


    }
*/

/*

    public void clickFive(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is 5 minutes away.");

        okButton.setVisibility(View.VISIBLE);
    }

    public void clickTen(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is 10 minutes away.");

        okButton.setVisibility(View.VISIBLE);

    }

    public void clickFifteen(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is 15 minutes away.");

        okButton.setVisibility(View.VISIBLE);

    }
        public void clickOK(View views){
        TextView new1 = (TextView)findViewById(R.id.ETA_text);
        new1.setText("When would you like to be notified about the busses ETA (in minutes)?");

        TextView newTrack = (TextView)findViewById(R.id.track_button);
        newTrack.setText("TRACKING");
        newTrack.setBackgroundColor(Color.RED);
        newTrack.setTextSize(TypedValue.COMPLEX_UNIT_SP,18f);

        // sets exit button to be invisible
        exitButton.setVisibility(View.INVISIBLE);

        // sets ETA menu to be invisible
        fiveButton.setVisibility(View.INVISIBLE);

        tenButton.setVisibility(View.INVISIBLE);

        fifteenButton.setVisibility(View.INVISIBLE);

        ETAmenu.setVisibility(View.INVISIBLE);

        okButton.setVisibility(View.INVISIBLE);

        exitButton.setVisibility(View.VISIBLE);
    }
    */


    // Button methods

    LocationManager locationManager;
    LocationListener locationListener;
    IBeaconDevice searchBeacon;

    // map embedded in the map fragment
    private Map map = null;

    // map fragment embedded in this activity
    private MapFragment mapFragment = null;

    List<MapObject> objList = new ArrayList<>();


//



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


        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                initialize();

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
        };


            if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
            } else {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2,0,locationListener);
            }

/*
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
        TRACKING = findViewById(R.id.tracking);
            ETAmenu.setVisibility(View.VISIBLE);



*/

        //TRACKING & its animation
        final TextView TRACKING = findViewById(R.id.tracking);
        TRACKING.setVisibility(View.INVISIBLE);

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);







        /*
        numberPicker.build();


        numberPicker.defaultValue(1);

        numberPicker.minValue(1);
        numberPicker.maxValue(100);
        numberPicker.defaultValue(1);
        numberPicker.backgroundColor(Color.WHITE);
        numberPicker.separatorColor(Color.TRANSPARENT);
        numberPicker.textColor(Color.BLACK);
        numberPicker.textSize(20);
        numberPicker.enableFocusability(false);
        numberPicker.wrapSelectorWheel(true);
        numberPicker.build();

        new AlertDialog.Builder(this)
                .setTitle("How much time?");
                .setView(numberPicker)
        NUM.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Snackbar.make(findViewById(R.id.your_container), "You picked : " + numberPicker.getValue(), Snackbar.LENGTH_LONG).show();
            }
        })
        NUM.show();

        */
        /*


        <biz.kasual.materialnumberpicker.MaterialNumberPicker
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        app:npBackgroundColor="@color/colorAccent"
        app:npDefaultValue="10"
        app:npMaxValue="50"
        app:npMinValue="1"
        app:npSeparatorColor="@color/colorAccent"
        app:npTextColor="@color/colorPrimary"
        app:npTextSize="25sp" />
         */


        // FAB Buttons onClicks & Number Picker

        //EXIT ()
        final FloatingActionButton fabEXIT = findViewById(R.id.floatingActionButtonEXIT);
        fabEXIT.hide();
        fabEXIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "Exit pressed");
                TRACKING.clearAnimation();
                TRACKING.setVisibility(View.INVISIBLE);
                fabEXIT.hide();
                //fabGO.show(); <- tears, for some reason this isn't working...
                // i think itds because the function is undeneath it

            }
        });

        //NUMBER PICKER
        final MaterialNumberPicker numberPicker = new MaterialNumberPicker(this);

        numberPicker.setMinValue(1);
        numberPicker.setMaxValue(100);
        numberPicker.setBackgroundColor(Color.WHITE);
        numberPicker.setSeparatorColor(Color.TRANSPARENT);
        numberPicker.setTextColor(Color.BLACK);
        numberPicker.setTextSize(50);
        //numberPicker.isFocusabilityEnabled();
        numberPicker.setWrapSelectorWheel(true);
        numberPicker.buildLayer();

        final AlertDialog.Builder newAL = new AlertDialog.Builder(this);

        newAL.setTitle("How much time?");
        newAL.setView(numberPicker);

        newAL.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                fabEXIT.show();
                TRACKING.setVisibility(View.VISIBLE);
                TRACKING.startAnimation(anim);


            }
        });

        //GO BUTTON (this function is for the GO button... the methods go in here)
        final FloatingActionButton fabGO = findViewById(R.id.newGO
        );
        fabGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "GO pressed");
                //fabEXIT.show();
               // TRACKING.setVisibility(View.VISIBLE);
               // TRACKING.startAnimation(anim);
                newAL.create().show();



            }
        });

        //BUSNUM BUTTON (the functions for the BUSNUM GO HERE)
        FloatingActionButton fabBusNum = findViewById(R.id.newBusNum);
        fabBusNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "GO pressed");

            }
        });


        }

        /*
        <android.support.design.button.MaterialButton
        android:id="@+id/fab_GO"
        style="@style/Widget.MaterialComponents.Button.UnelevatedButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentStart="true"
        android:layout_alignParentTop="true"
        android:layout_marginStart="3dp"
        android:layout_marginTop="0dp"
        android:background="@android:color/holo_green_light"
        android:text="GO"
        android:textSize="36sp"
        android:textStyle="bold"
        app:cornerRadius="56dp"
        app:layout_constraintEnd_toEndOf="parent" />

        <android.support.design.widget.FloatingActionButton
        android:id="@+id/floatingActionButtonGO"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentEnd="true"
        android:layout_alignParentBottom="true"
        android:layout_marginEnd="82dp"
        android:layout_marginBottom="117dp"
        android:clickable="true"
        app:backgroundTint="@android:color/holo_green_light"
        app:fabCustomSize="60dp" />

        <android.support.design.widget.FloatingActionButton
        android:id="@+id/floatingActionButtonBUSNUM"
        android:layout_width="107dp"
        android:layout_height="87dp"
        android:layout_above="@+id/textView3"
        android:layout_alignParentEnd="true"
        android:layout_marginEnd="127dp"
        android:layout_marginBottom="191dp"
        android:clickable="true"
        app:backgroundTint="@android:color/darker_gray"
        app:fabCustomSize="80dp"
        app:srcCompat="@mipmap/ic_launcher" />
         */




// creates map marker at users location and centers map on that location
    private void initialize() {
        // Search for the map fragment to finish setup by calling init().
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);

        mapFragment.init(new OnEngineInitListener() {
            @Override
            public void onEngineInitializationCompleted(OnEngineInitListener.Error error) {
                if (error == OnEngineInitListener.Error.NONE) {
                    // retrieve a reference of the map from the map fragment
                    map = mapFragment.getMap();
                    map.removeMapObjects(objList);
                    userLocation();
                    createMapMarker(userLocation());

                    // Set the zoom level to the average between min and max
                    map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) / 2);
                } else {
                    System.out.println("ERROR: Cannot initialize Map Fragment");
                }
            }
        });
    }

    public void createMapMarker(Location loc) {
        Image marker_img = new Image();
        try {
            marker_img.setImageResource(R.drawable.iconfinder_map_marker_299087);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.getCenter();
        map = mapFragment.getMap();
        MapMarker marker = new MapMarker(new GeoCoordinate(loc.getLatitude(),loc.getLongitude()), marker_img);
        objList.add(marker);
        map.addMapObject(marker);

    }

    private Location userLocation() {
        Location loc = null;
        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
             loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
             map.setCenter(new GeoCoordinate(loc.getLatitude(), loc.getLongitude(), 0.0),
                    Map.Animation.NONE);
        }

        return loc;
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
