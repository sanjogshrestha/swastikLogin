package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
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
        Intent main = new Intent(GalleryItemActivity.this, GalleryActivity.class);
        startActivity(main);
        super.onBackPressed();
    }
}
