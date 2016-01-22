package com.lifo.upspoi;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.io.IOException;

public class PhotoActivity extends AppCompatActivity {

    private Uri imageUri;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        imageUri = getIntent().getParcelableExtra("bitmapImage");

        try {
            image = MediaStore.Images.Media.getBitmap(getContentResolver(),imageUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageView v = (ImageView) findViewById(R.id.imageView);
        v.setImageBitmap(image);
    }

}
