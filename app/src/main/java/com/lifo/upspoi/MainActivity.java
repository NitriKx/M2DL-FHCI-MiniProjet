package com.lifo.upspoi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.activeandroid.ActiveAndroid;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.lifo.upspoi.listener.MyOnMarkerClickListener;
import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.PointInteret;
import com.lifo.upspoi.services.PointInteretService;
import com.lifo.upspoi.services.UtilisateurService;

import java.io.File;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback
        // Pour récupérer position
        /*GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener*/ {

    private GoogleMap mMap;
    private Uri imageUri;
    private UiSettings mUiSettings;
    private List<? extends ElementDeCarte> elementsCarte;

    //Pour récupérer position
    /*private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize l'ORM de gestion de la base de donnée locale
        ActiveAndroid.initialize(this);

        // Vérifie que l'utilisateur est bien authentifié, sinon on lui montre l'acitivité de login
        verifierLogin();

        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        // Pour récupérer position
        // Create an instance of GoogleAPIClient.
        /*if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }*/
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
        mUiSettings = mMap.getUiSettings();

        // Positionnement map
        LatLng universite = new LatLng(43.560724, 1.468703);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(universite)      // Centre la map sur Paul Sabatier
                .zoom(15)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        // Ajout marqueurs pour éléments du plan de recyclage
        elementsCarte = PointInteretService.getInstance().getElementDeCarteDansZone(null);

        for(ElementDeCarte element : elementsCarte)
        {
            if(element instanceof PointInteret)
            {
                if(element.getNom().equals("verre"))
                {
                    mMap.addMarker(new MarkerOptions()
                            .position(((PointInteret) element).getPosition())
                            .title("Verre")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                }

                if(element.getNom().equals("textile"))
                {
                    mMap.addMarker(new MarkerOptions()
                            .position(((PointInteret) element).getPosition())
                            .title("Textiles")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
                }
            }
        }

        // Affichage position utilisateur
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mUiSettings.setMyLocationButtonEnabled(false);
            mUiSettings.setZoomControlsEnabled(true);
        }
    }

    public void clickPrendrePhoto(View arg0) {

        // Création de l'intent de type ACTION_IMAGE_CAPTURE
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
// Création d'un fichier de type image
        File photo = new File(Environment.getExternalStorageDirectory(),  "Pic.jpg");
        imageUri = Uri.fromFile(photo);
// On fait le lien entre la photo prise et le fichier que l'on vient de créer
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));
// Lancement de l'intent
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        mMap.addMarker(new MarkerOptions().position(new LatLng(43.560724, 1.468703)));
        mMap.setOnMarkerClickListener(new MyOnMarkerClickListener(this, imageUri));
    }

    // Pour récupérer position
    /*protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                    mGoogleApiClient);
        }

        if(mLastLocation != null)
        {
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()))
                    .title("Ma position"));
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }*/


    //
    //
    //   PRIVATE
    //
    //

    /**
     *
     */
    private void verifierLogin() {

        if(UtilisateurService.getInstance().estLoggue() == false) {
            Intent lancerAcitiviteLogin = new Intent(this, LoginActivity.class);
            this.startActivity(lancerAcitiviteLogin);
        }
    }

}
