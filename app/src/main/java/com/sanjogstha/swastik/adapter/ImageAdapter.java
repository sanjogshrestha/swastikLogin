package com.sanjogstha.swastik.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sanjogstha.swastik.GalleryActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by SanjogStha on 5/15/2016.
 */
public class ImageAdapter extends BaseAdapter {

    String[] imageList = {"DSC_2390.jpg", "DSC_2386.jpg", "DSC_2383.jpg"};

    String urlPath = "http://swastikcollege.edu.np/wp-content/gallery/students-in-lab/";

    Context context;

    public ImageAdapter(GalleryActivity galleryActivity) {
        context = galleryActivity;
    }

    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public Object getItem(int i) {
        return imageList[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(context);
        Picasso.with(context)
                .load(urlPath + imageList[i])
                .into(imageView);
        imageView.setLayoutParams(new GridView.LayoutParams(240,240));
        return imageView;
    }
}
