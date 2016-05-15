package com.sanjogstha.swastik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.sanjogstha.swastik.adapter.ImageAdapter;

/**
 * Created by SanjogStha on 5/15/2016.
 */

public class GalleryActivity extends AppCompatActivity{

    GridView galleryGridView;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        galleryGridView = (GridView) findViewById(R.id.galleryGridView);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.gallery);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        galleryGridView.setAdapter(new ImageAdapter(this));
    }
}
