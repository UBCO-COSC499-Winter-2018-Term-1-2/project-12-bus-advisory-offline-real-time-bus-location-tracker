package com.fremtidmedia.httpwww.busadvisory;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.Location;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public Location startTest(){
        MapActivity testMap = new MapActivity();
        Location loc = testMap.locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        return loc;
    }


    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void longCorrect() {
        Double lon = startTest().getLongitude();
        assertTrue((119.4960) > (lon - 1.0) && (119.4960) < (lon + 1.0));
    }

    @Test
    public void latCorrect() {
        Double lat = startTest().getLatitude();
        assertTrue((49.8880) > (lon - 1.0) && (49.8880) < (lon + 1.0));
    }

}