package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

        galleryGridView.setAdapter(new ImageAdapter(this));

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.gallery);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        galleryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent galleryItem = new Intent(GalleryActivity.this, GalleryItemActivity.class);
                galleryItem.putExtra("position", i);
                startActivity(galleryItem);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent main = new Intent(GalleryActivity.this, HomeActivity.class);
        startActivity(main);
        super.onBackPressed();
    }
}
