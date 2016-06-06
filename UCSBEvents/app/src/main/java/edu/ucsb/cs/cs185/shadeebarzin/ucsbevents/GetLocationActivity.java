package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class GetLocationActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Button btnsearch;
    private Button confirm;

    private EditText etsearch;
    private String location;
    private Double latitude;
    private Double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_location);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        etsearch = (EditText) findViewById(R.id.input_search);

        btnsearch = (Button) findViewById(R.id.btn_search);
        confirm = (Button)findViewById(R.id.btn_confirm);


        confirm.setEnabled(false);
    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng ucsb = new LatLng(34.4133491,-119.8472604);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(ucsb, 16.0f));

    }


    public void search(View view) {
        mMap.clear();
        location = etsearch.getText().toString();
        List<Address> addressList = null;
        if (location != null && !location.equals("")) {
            Geocoder geocoder = new Geocoder(GetLocationActivity.this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            latitude = address.getLatitude();
            longitude = address.getLongitude();
            LatLng l = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions().position(l).title(location));
            confirm.setEnabled(true);
        }
    }

    public void confirm(View view) {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("location", location);
        resultIntent.putExtra("latitude", latitude);
        resultIntent.putExtra("longitude", longitude);
        setResult(RESULT_OK, resultIntent);
        finish();
    }
}
