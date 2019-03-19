package com.fremtidmedia.httpwww.busadvisory;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
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
import com.here.android.mpa.routing.RouteTta;
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
    private MapRoute m_mapRoute;
    private int arrTime;
    Timer t = null;
    BusTask tt = null;



    private ArrayList<MapMarker> busStops = new ArrayList<>();
    private ArrayList<MapObject> markerList = new ArrayList<>();
    RequestQueue queue;
    Cache cache;
    Network network;
    String id;

    public void testBus(View views){
        t = new Timer();
        tt = new BusTask();
        t.schedule(tt, 0, 5000);
        TextView t3 = findViewById(R.id.textView3);
        t3.setClickable(false);
        centerView(busLocation);


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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                     if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
                         Log.d("HERE", "Permissions not accepted");
                     } else {
                         ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS);
                     }
                }
                else{
                    positioningManager.start(PositioningManager.LocationMethod.GPS_NETWORK);
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
                if(!markerList.isEmpty()) {
                    map.removeMapObjects(markerList);
                    markerList.clear();
                }
                tt.cancel();
                t.cancel();
                TextView t3 = findViewById(R.id.textView3);
                t3.setClickable(true);

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
                arrivalEst();
            }
        });


        }



    class BusTask extends TimerTask {

        @Override
         public void run() {
            makeGetRequest("https://oyojktxw02.execute-api.us-east-1.amazonaws.com/dev/buslocation");
            int time = arrivalEst();
            if (time != 0){
                Log.d("kyle", Integer.toString(time));
            }

            createBus(busLocation);
            Log.d("HERE", "Bus location updated");
        }
    }

    public void centerView (GeoCoordinate location){
        map.setZoomLevel((map.getMaxZoomLevel() + map.getMinZoomLevel()) / 1.6);
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



    public int arrivalEst () {

        RouteManager rm = new RouteManager();
        RoutePlan routePlan = new RoutePlan();
        RouteOptions routeOptions = new RouteOptions();
        routeOptions.setTransportMode(RouteOptions.TransportMode.CAR);
        routeOptions.setHighwaysAllowed(false);
        routeOptions.setRouteType(RouteOptions.Type.SHORTEST);
        routeOptions.setRouteCount(1);
        routePlan.setRouteOptions(routeOptions);

        routePlan.addWaypoint(busLocation);
        routePlan.addWaypoint(closestStop(busStops));

        rm.calculateRoute(routePlan,
                new RouteManager.Listener() {
                    @Override
                    public void onProgress(int i) {

                    }

                    @Override
                    public void onCalculateRouteFinished(RouteManager.Error error, List<RouteResult> routeResults) {
                        if (error == RouteManager.Error.NONE) {
                            if (routeResults.get(0).getRoute() != null) {
                                m_mapRoute = new MapRoute(routeResults.get(0).getRoute());
                                m_mapRoute.setManeuverNumberVisible(true);
                                arrTime = m_mapRoute.getRoute().getTta(Route.TrafficPenaltyMode.DISABLED, Route.WHOLE_ROUTE).getDuration();
                                map.addMapObject(m_mapRoute);

                            } else {
                                Log.e("Kyle", "Results are not valid");


                            }
                        } else {
                            Log.e("Kyle", "Route calculation error");

                        }
                    }
                });
        return arrTime;
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
