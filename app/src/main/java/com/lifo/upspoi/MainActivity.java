package com.lifo.upspoi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.common.collect.Lists;
import com.lifo.upspoi.Utils.MySpinnerAdapter;
import com.lifo.upspoi.listener.MyOnInfoWindowClickListener;
import com.lifo.upspoi.listener.MyOnItemSelectedListener;
import com.lifo.upspoi.model.ElementDeCarte;
import com.lifo.upspoi.model.Image;
import com.lifo.upspoi.model.PointTag;
import com.lifo.upspoi.services.InitialisationService;
import com.lifo.upspoi.services.PointInteretService;
import com.lifo.upspoi.services.UtilisateurService;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private GoogleMap mMap;
    private Uri imageUri;
    private UiSettings mUiSettings;
    private List<? extends ElementDeCarte> elementsCarte;
    private List<LatLng> delimitationFac;
    private Spinner spinner;
    private PointInteretService pointInteretService = PointInteretService.getInstance();

    //Pour récupérer position
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialise la base de données locale avec les données par défaut
        InitialisationService.getInstance().initialiserBaseSiBesoin();

        // Vérifie que l'utilisateur est bien authentifié, sinon on lui montre l'acitivité de login
        verifierLogin();

        setContentView(R.layout.activity_main);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

        // Pour récupérer position
        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        ajoutTagListe();
    }

    private void ajoutTagListe() {
        spinner = (Spinner) findViewById(R.id.tags_spinner);

        List<String> list = new ArrayList<String>();

        list.add("Tous");
        list.addAll(pointInteretService.getTagsDeclare().keySet());

        MySpinnerAdapter dataAdapter = new MySpinnerAdapter(this, list, Lists.newArrayList(pointInteretService.getTagsDeclare().values()));
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener(this));
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

        afficherPOI(null);

        // Affichage position utilisateur
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mUiSettings.setMyLocationButtonEnabled(false);
            mUiSettings.setZoomControlsEnabled(true);
        }
    }

    public void afficherPOI(String filtre) {

        boolean correspondAuFiltre = false;

        elementsCarte = pointInteretService.getElementDeCarteDansZone(null);

        mMap.setOnInfoWindowClickListener(new MyOnInfoWindowClickListener(this));

        mMap.clear();

        // Ajout marqueurs pour éléments du plan de recyclage

        for (ElementDeCarte element : elementsCarte) {
            correspondAuFiltre = false;

            if (filtre != null) {
                for (Object o : element.tagsAssocies) {
                    PointTag tag = (PointTag) o;
                    if (tag.nomTag.equals(filtre)) {
                        correspondAuFiltre = true;
                    }
                }
            } else {
                correspondAuFiltre = true;
            }

            if (correspondAuFiltre) {
                List<LatLng> positionPourCetElement = element.getPoints();

                // MARKER - Si le nombre de position est égal à 1, cela signifie que l'on souhaite dessiner un point
                if (positionPourCetElement.size() == 1) {

                    String snippetText = element.getNomTags();
                    if (element.image != null) {
                        snippetText = String.format("Afficher la photo", element.getNomTags(), element.image.imageURL);
                    }

                    mMap.addMarker(new MarkerOptions()
                            .position(positionPourCetElement.get(0))
                            .title(element.element_id + " - " + element.nom)
                            .snippet(snippetText)
                            .icon(BitmapDescriptorFactory.defaultMarker(element.getCouleur().getHue())));
                }

                // ZONE - Si le nombre de position est égal à 1, cela signifie que l'on souhaite dessiner un point
                else if (positionPourCetElement.size() > 1) {
                    PolygonOptions rectOptions = new PolygonOptions().strokeWidth(5);

                    for (LatLng point : positionPourCetElement) {
                        rectOptions.add(point);
                    }

                    mMap.addPolygon(rectOptions.fillColor(element.getCouleur().getIntCouleur()).strokeColor(element.getCouleur().getIntCouleur()));
                }
            }
        }

        // Delimitation de la fac
        delimitationFac = PointInteretService.getInstance().getDelimitationFac();
        PolylineOptions polylineOptions = new PolylineOptions();

        for (LatLng point : delimitationFac) {
            polylineOptions.add(point);
        }

        mMap.addPolyline(polylineOptions.width(4));
    }

    public void clickPrendrePhoto(View arg0) {

        // Création de l'intent de type ACTION_IMAGE_CAPTURE
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Création d'un fichier de type image
        File photo = new File(Environment.getExternalStorageDirectory() + "/UPSPOI", "Photo_POI_" + new Date().getTime() + ".jpg");
        imageUri = Uri.fromFile(photo);

        // On fait le lien entre la photo prise et le fichier que l'on vient de créer
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));

        // Lancement de l'intent
        startActivityForResult(intent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && mLastLocation != null) {
            PointInteretService.getInstance().ajouterElement(getString(R.string.default_poi_marker_name), new ArrayList<PointTag>(), imageUri.getPath(), new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()));

            // On redessine les points
            spinner.setSelection(0);
            afficherPOI(null);
        }
    }

    // Pour récupérer position
    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(5000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    //
    //
    //   PRIVATE
    //
    //

    /**
     *
     */
    private void verifierLogin() {

        if (UtilisateurService.getInstance().estLoggue() == false) {
            Intent lancerAcitiviteLogin = new Intent(this, LoginActivity.class);
            this.startActivity(lancerAcitiviteLogin);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
    }
}
