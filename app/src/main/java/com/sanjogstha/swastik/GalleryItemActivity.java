package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GalleryItemActivity extends AppCompatActivity {

    ImageView galleryItemImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_item);

        galleryItemImageView = (ImageView) findViewById(R.id.galleryItemImageView);

        Intent getPosition = getIntent();
        int position = getPosition.getIntExtra("position", 0);


        Picasso.with(this)
                .load(Constant.urlPath + Constant.imageList[position])
                .into(galleryItemImageView);
    }
}
