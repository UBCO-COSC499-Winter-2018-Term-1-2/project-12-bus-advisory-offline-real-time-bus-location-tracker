package com.fremtidmedia.httpwww.busadvisory;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;
import android.util.Log;
import android.view.View;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.here.android.mpa.common.GeoCoordinate;
import com.here.android.mpa.common.GeoPosition;
import com.here.android.mpa.common.Image;
import com.here.android.mpa.common.OnEngineInitListener;
import com.here.android.mpa.common.PositioningManager;
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.here.android.mpa.mapping.MapRoute;
import com.here.android.mpa.routing.Route;
import com.here.android.mpa.routing.RouteManager;
import com.here.android.mpa.routing.RouteOptions;
import com.here.android.mpa.routing.RoutePlan;
import com.here.android.mpa.routing.RouteResult;
import com.kontakt.sdk.android.ble.manager.listeners.IBeaconListener;
import com.kontakt.sdk.android.ble.manager.listeners.simple.SimpleIBeaconListener;
import com.kontakt.sdk.android.common.KontaktSDK;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;
import com.kontakt.sdk.android.common.profile.IBeaconRegion;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;

public class MapActivity extends Activity {

    private final static int REQUEST_CODE_ASK_PERMISSIONS = 1;
    private static final String[] REQUIRED_SDK_PERMISSIONS = new String[] {
            Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE };

    IBeaconDevice searchBeacon;

    private Map map = null;
    private MapFragment mapFragment = null;
    private GeoCoordinate userLocation;
    private GeoCoordinate busLocation;
    private PositioningManager positioningManager = null;
    private PositioningManager.OnPositionChangedListener positionListener;
    private boolean tracking = false;
    private MapRoute m_mapRoute;
    private int arrTime;
    Timer t = null;
    BusTask tt = null;
    protected FloatingActionButton fabEXIT;
    protected TextView BottomBar;


    private ArrayList<MapRoute> mRoute = new ArrayList<>();
    private ArrayList<MapMarker> busStops = new ArrayList<>();
    private ArrayList<MapObject> markerList = new ArrayList<>();
    RequestQueue queue;
    Cache cache;
    Network network;
    String id;

    public void testBus(View views){
      /*  t = new Timer();
        tt = new BusTask();
        t.schedule(tt, 0, 5000);
        TextView t3 = findViewById(R.id.textView3);
        t3.setClickable(false);
        centerView(busLocation);
*/

    }


    protected void checkPermissions() {
        final List<String> missingPermissions = new ArrayList<String>();
        // check all required dynamic permissions
        for (final String permission : REQUIRED_SDK_PERMISSIONS) {
            final int result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                missingPermissions.add(permission);
            }
        }
        if (!missingPermissions.isEmpty()) {
            // request all missing permissions
            final String[] permissions = missingPermissions
                    .toArray(new String[missingPermissions.size()]);
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE_ASK_PERMISSIONS);
        } else {
            final int[] grantResults = new int[REQUIRED_SDK_PERMISSIONS.length];
            Arrays.fill(grantResults, PackageManager.PERMISSION_GRANTED);
            onRequestPermissionsResult(REQUEST_CODE_ASK_PERMISSIONS, REQUIRED_SDK_PERMISSIONS,
                    grantResults);
        }
    }



    public void centerView (View views) {
        centerView(userLocation);
    }

    public void onResume() {
        super.onResume();
        if (positioningManager != null) {
             positioningManager.start(
                PositioningManager.LocationMethod.GPS_NETWORK);
    }
}

    public void onPause() {
        super.onPause();
        if (positioningManager != null) {
            positioningManager.stop();
        }

    }

    public void onDestroy() {
        if (positioningManager != null) {
            // Cleanup
            positioningManager.removeListener(
                    positionListener);
        }
        tt.cancel();
        t.cancel();
        map = null;
        super.onDestroy();
    }

    public void makePostRequest(String url) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(stringRequest);
    }


    public void makeGetRequest(String url){
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            try {
                               JSONArray location = response.getJSONArray("buslocation");
                               JSONObject object1 = location.getJSONObject(0);
                               JSONObject object2 = object1.getJSONObject("location");
                               JSONArray object3 = object2.getJSONArray("coordinates");
                               String lon = object3.getString(0);
                               String lat = object3.getString(1);
                               busLocation = new GeoCoordinate(Double.parseDouble(lat), Double.parseDouble(lon) );
                               Log.d("Location", busLocation.getLatitude() + ", " +  busLocation.getLongitude());
                            }
                            catch (Exception e){

                                Log.e("HERE", "Caught: " + e.getMessage());

                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });
            queue.add(jsonObjectRequest);
        }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int index = permissions.length - 1; index >= 0; --index) {
                    if (grantResults[index] != PackageManager.PERMISSION_GRANTED) {
                        // exit the app if one permission is not granted
                        Toast.makeText(this, "Required permission '" + permissions[index]
                                + "' not granted, exiting", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                }
                initialize();
                break;
        }
    }

    public void initialize (){
        setContentView(R.layout.activity_map);
        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        network = new BasicNetwork(new HurlStack());
        queue = Volley.newRequestQueue(this);
        queue.start();
        makeGetRequest("https://oyojktxw02.execute-api.us-east-1.amazonaws.com/dev/buslocation");
        id = FirebaseInstanceId.getInstance().getInstanceId().toString();
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
                    map.setCenter(userLocation, Map.Animation.NONE);
                    map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) /1.75);



                    try {
                        Image image = new Image();
                        image.setImageResource(R.drawable.ic_trip_origin);
                        MapMarker stop1 = new MapMarker(new GeoCoordinate(49.939073 , -119.394334, 0.0), image);
                        map.addMapObject(stop1);
                        MapMarker stop2 = new MapMarker(new GeoCoordinate(49.934023, -119.401581, 0.0), image);
                        map.addMapObject(stop2);
                        Image userImage = new Image();
                        userImage.setImageResource(R.drawable.ic_action_person_pin);
                        map.getPositionIndicator().setMarker(userImage);

                        busStops.add(stop1);
                        busStops.add(stop2);

                    } catch (Exception e) {
                        Log.e("HERE", e.getMessage());
                    }



                    positioningManager = PositioningManager.getInstance();
                    positionListener = new PositioningManager.OnPositionChangedListener() {
                        @Override
                        public void onPositionUpdated(PositioningManager.LocationMethod method, GeoPosition position, boolean isMapMatched) {
                            userLocation = position.getCoordinate();
                            BottomBar = findViewById(R.id.BottomBAR);
                            GeoCoordinate stop = closestStop(busStops);
                            if (stop.getLatitude() == 49.939073 && stop.getLongitude() == -119.394334){
                                BottomBar.setText("UBCO Exchange");
                            }
                            else if (stop.getLatitude() == 49.934023 && stop.getLongitude() == -119.401581){
                                BottomBar.setText("Academy Hill Stop");
                            }

                        }
                        @Override
                        public void onPositionFixChanged(PositioningManager.LocationMethod method, PositioningManager.LocationStatus status) { }
                    };

                    try {
                        positioningManager.addListener(new WeakReference<PositioningManager.OnPositionChangedListener>(positionListener));
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






        //TRACKING & its animation (might not use)
        //final TextView TRACKING = findViewById(R.id.tracking);
        final TextView newTRACKING = findViewById(R.id.NEWtrack);
        newTRACKING.setVisibility(View.INVISIBLE);

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        //final TextView GoText = findViewById(R.id.GoText);
        //GoText.setVisibility(View.INVISIBLE);
        final FloatingActionButton fabGO = findViewById(R.id.startBell);
        //fabGO.hide();


        fabEXIT = findViewById(R.id.floatingActionButtonEXIT);
        fabEXIT.hide();
        fabEXIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "Exit pressed");

                //ARE U SURE ALERT
                AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
                builder.setTitle("Confirmation");
                builder.setMessage("Are you sure you want to cancel your reminder?");

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fabEXIT.hide();
                        if(!markerList.isEmpty()) {
                            map.removeMapObjects(markerList);
                            markerList.clear();
                        }
                        if(m_mapRoute != null) {
                            map.removeMapObject(m_mapRoute);
                        }
                        if (tracking == true){
                            tt.cancel();
                            t.cancel();

                            tracking = false;
                        }

                        fabGO.show();
                        //GoText.setVisibility(View.INVISIBLE);
                        newTRACKING.setVisibility(View.INVISIBLE);
                        anim.cancel();

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                AlertDialog al = builder.create();
                al.show();





            }
        });






        fabGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "GO pressed");

                //NUMBER PICKER
                MaterialNumberPicker numberPicker = new MaterialNumberPicker(MapActivity.this);

                numberPicker.setMinValue(1);
                numberPicker.setMaxValue(100);
                numberPicker.setBackgroundColor(Color.WHITE);
                numberPicker.setSeparatorColor(Color.TRANSPARENT);
                numberPicker.setTextColor(Color.BLACK);
                numberPicker.setTextSize(50);
                numberPicker.setWrapSelectorWheel(true);
                numberPicker.buildLayer();

                final AlertDialog.Builder newAL = new AlertDialog.Builder(MapActivity.this);

                TextView AlTitle = new TextView(MapActivity.this);
                AlTitle.setText("Remind me before the bus arrival \n (in minutes) at my stop");
                AlTitle.setTextSize(17);
                AlTitle.setTextColor(Color.BLACK);
                AlTitle.setTypeface(null, Typeface.BOLD);
                centerView(busLocation);
                //newAL.setTitle("Remind me before the bus arrival \n (in minutes) at my stop");
                newAL.setCustomTitle(AlTitle);
                newAL.setView(numberPicker);
                if (tracking == false) {
                    tracking = true;
                    t = new Timer();
                    tt = new BusTask();
                    t.schedule(tt, 0, 5000);
                }

                newAL.setPositiveButton(getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        fabEXIT.show();
                        fabGO.hide();
                        newTRACKING.setVisibility(View.VISIBLE);
                        anim.start();

                        // THANK YOU ALERT
                        final AlertDialog.Builder TY = new AlertDialog.Builder(MapActivity.this);
                        TY.setTitle("Reminder");
                        TY.setMessage("Thank you for setting a reminder. We will notifiy you.");

                        TY.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                //here you can add functions
                                dialog.dismiss();

                            } });

                        AlertDialog TYdone = TY.create();
                        TYdone.show();


                    }
                });

                newAL.create().show();


            }
        });

        TextView t0 = findViewById(R.id.textView97);
        BottomBar = findViewById(R.id.BottomBAR);

        BottomBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fabGO.show();
                if (tracking == false) {
                    tracking = true;
                    t = new Timer();
                    tt = new BusTask();
                    t.schedule(tt, 0, 5000);
                }

                centerView(busLocation);
            }
        });




    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermissions();

        }



    class BusTask extends TimerTask {

        @Override
         public void run() {
            makeGetRequest("https://oyojktxw02.execute-api.us-east-1.amazonaws.com/dev/buslocation");
            createBus(busLocation);
            Log.d("HERE", "Bus location updated");
        }
    }


    public void createStops(GeoCoordinate location) {
        Image marker_img = new Image();
        try {
            marker_img.setImageResource(R.drawable.bus_stop);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map = mapFragment.getMap();
        MapMarker stop1 = new MapMarker(location, marker_img);
        busStops.add(stop1);
        map.addMapObject(stop1);
        MapMarker stop2 = new MapMarker(location, marker_img);
        busStops.add(stop2);
        map.addMapObject(stop2);

    }

    public void centerView (GeoCoordinate location){
        map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) / 1.5);
        map.setCenter(location, Map.Animation.NONE);
    }

    public void createBus(GeoCoordinate location) {
        try {
            Image image = new Image();
            image.setImageResource(R.drawable.ic_action_directions_bus);

            if(!markerList.isEmpty()) {
                map.removeMapObjects(markerList);
                markerList.clear();
            }
            MapMarker busMarker = new MapMarker(location, image);
            markerList.add(busMarker);
            map.addMapObjects(markerList);

        }catch (Exception e) {
            Log.e("HERE", "Caught: " + e.getMessage());
        }

    }


    public GeoCoordinate closestStop(ArrayList<MapMarker> stops ) {
        double tempY1 = Math.abs(userLocation.getLatitude() - stops.get(0).getCoordinate().getLatitude());
        double tempX1 = Math.abs(userLocation.getLongitude() - stops.get(0).getCoordinate().getLatitude());
        double smallestHyp = Math.hypot(tempY1, tempX1);
        MapMarker closest = stops.get(0);
        for (int i = 0; i < stops.size() ; i++) {
            double tempY = Math.abs(stops.get(i).getCoordinate().getLatitude() - userLocation.getLatitude());
            double tempX = Math.abs(stops.get(i).getCoordinate().getLongitude() - userLocation.getLongitude());
            double tempHyp = Math.hypot(tempY, tempX);
            if ( tempHyp < smallestHyp ){
                smallestHyp = tempHyp;
                closest = stops.get(i);

            }
        }
        GeoCoordinate closeStop = new GeoCoordinate(closest.getCoordinate().getLatitude(),closest.getCoordinate().getLongitude());
        return closeStop;

    }


    private void topicSubscribe(String topic){
        FirebaseMessaging.getInstance().subscribeToTopic(topic)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(MapActivity.this, "Couldn't connect to server", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
