package com.fremtidmedia.httpwww.busadvisory;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
<<<<<<< HEAD
import android.nfc.Tag;
=======
>>>>>>> 129-Theme-Change
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
<<<<<<< HEAD
import com.here.android.mpa.common.PositioningManager;
=======
>>>>>>> 129-Theme-Change
import com.here.android.mpa.mapping.Map;
import com.here.android.mpa.mapping.MapFragment;
import com.here.android.mpa.mapping.MapMarker;
import com.here.android.mpa.mapping.MapObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kontakt.sdk.android.ble.manager.listeners.IBeaconListener;
import com.kontakt.sdk.android.ble.manager.listeners.simple.SimpleIBeaconListener;
import com.kontakt.sdk.android.common.KontaktSDK;
import com.kontakt.sdk.android.common.profile.IBeaconDevice;
import com.kontakt.sdk.android.common.profile.IBeaconRegion;

<<<<<<< HEAD
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.here.android.mpa.internal.r.H;
import static com.here.android.mpa.internal.r.e;

public class MapActivity extends Activity {

// Buttons

    Button exitButton;
   // Button trackButton;
    Button fiveButton;
    Button tenButton;
    Button fifteenButton;
    Button okButton;
    Button testTrack;
    String id;
    RequestQueue queue;
    Cache cache;
    Network network;



    TextView ETAmenu;



    public void clickTrack(View views) {

        Log.i("Info", "TRACK pressed");


        // Making the ETA menu visible
        fiveButton.setVisibility(View.VISIBLE);

        tenButton.setVisibility(View.VISIBLE);

        fifteenButton.setVisibility(View.VISIBLE);

        ETAmenu.setVisibility(View.VISIBLE);

        testTrack.setVisibility(View.VISIBLE);




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

        TextView new1 = findViewById(R.id.ETA_text);
        new1.setText("When would you like to be notified about the busses ETA (in minutes)?");


    }

    public void clickFive(View views){
        TextView new1 = findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is nearby");

        okButton.setVisibility(View.VISIBLE);
    }

    public void clickTen(View views){
        TextView new1 = findViewById(R.id.ETA_text);
        new1.setText("\n Bus Tracker Activated! \n \n \n We will notify you once the bus is nearby");

        okButton.setVisibility(View.VISIBLE);

    }

    public void clickFifteen(View views){
        TextView new1 = findViewById(R.id.ETA_text);
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

    public void centerButton(View views){
        map = mapFragment.getMap();
        map.setCenter(userLocation, Map.Animation.NONE);

    }

    public void testBus(View views){
       makeGetRequest("https://oyojktxw02.execute-api.us-east-1.amazonaws.com/dev/buslocation");
    }


    // Button methods

=======
import biz.kasual.materialnumberpicker.MaterialNumberPicker;

public class MapActivity extends Activity {

>>>>>>> 129-Theme-Change
    LocationManager locationManager;
    LocationListener locationListener;
    IBeaconDevice searchBeacon;

    private Map map = null;
<<<<<<< HEAD
=======

>>>>>>> 129-Theme-Change
    private MapFragment mapFragment = null;
    private GeoCoordinate userLocation;
    private GeoCoordinate busLocation;
    private PositioningManager positioningManager = null;
    private PositioningManager.OnPositionChangedListener positionListener;
    private boolean paused;

    List<MapObject> objList = new ArrayList<>();
    List<MapMarker> busStops = new ArrayList<>();
    private ArrayList<MapObject> markerList = new ArrayList<>();
//    RequestQueue queue;


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

<<<<<<< HEAD
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
                               createBus(busLocation);
                               centerView(busLocation);
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
            //TODO @Matthew implement get method with JSON parsing

=======
>>>>>>> 129-Theme-Change
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
<<<<<<< HEAD

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    positioningManager.start(PositioningManager.LocationMethod.GPS_NETWORK);
=======
                 if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 2, 0, locationListener);
>>>>>>> 129-Theme-Change
                }
            }
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        network = new BasicNetwork(new HurlStack());
        queue = Volley.newRequestQueue(this);
        queue.start();
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
                        image.setImageResource(R.drawable.bus_stop);
                        MapMarker stop1 = new MapMarker(new GeoCoordinate(49.939073 , -119.394334, 0.0), image);
                        map.addMapObject(stop1);
                        MapMarker stop2 = new MapMarker(new GeoCoordinate(49.976448, -119.394334, 0.0), image);
                        map.addMapObject(stop2);
                        Image userImage = new Image();
                        userImage.setImageResource(R.drawable.iconfinder_map_marker_299087);
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






        //TRACKING & its animation
        final TextView TRACKING = findViewById(R.id.tracking);
        TRACKING.setVisibility(View.INVISIBLE);

        final Animation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(200);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        final FloatingActionButton fabEXIT = findViewById(R.id.floatingActionButtonEXIT);
        fabEXIT.hide();
        fabEXIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "Exit pressed");
                TRACKING.clearAnimation();
                TRACKING.setVisibility(View.INVISIBLE);
                fabEXIT.hide();

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

        final FloatingActionButton fabGO = findViewById(R.id.newGO
        );
        fabGO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "GO pressed");
                newAL.create().show();



            }
        });

        FloatingActionButton fabBusNum = findViewById(R.id.newBusNum);
        fabBusNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("Info", "GO pressed");

            }
        });


        }


<<<<<<< HEAD
=======




// creates map marker at users location and centers map on that location
    private void initialize() {
        // Search for the map fragment to finish setup by calling init().
        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapfragment);
>>>>>>> 129-Theme-Change



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
            image.setImageResource(R.drawable.bus);

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

    public MapMarker closestStop(ArrayList<MapMarker> stops ) {
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

        return closest;
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
