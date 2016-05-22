package com.sanjogstha.swastik.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.sanjogstha.swastik.Constant;
import com.sanjogstha.swastik.GalleryActivity;
import com.sanjogstha.swastik.R;
import com.squareup.picasso.Picasso;

/**
 * Created by SanjogStha on 5/15/2016.
 */
public class ImageAdapter extends BaseAdapter {

    Context context;

    LayoutInflater layoutInflater;

    ImageView galleryImageView;
    private String[] imageList;
    private String urlPath;

    public ImageAdapter(GalleryActivity galleryActivity) {
        context = galleryActivity;
        imageList = Constant.imageList;
        urlPath = Constant.urlPath;
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
        //ImageView imageView = new ImageView(context);
        if(layoutInflater == null){
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(view == null){
            view = layoutInflater.inflate(R.layout.gallery_gridview_items, null);
        }

        galleryImageView = (ImageView) view.findViewById(R.id.gridImageView);

        Picasso.with(context)
                .load(urlPath + imageList[i])
                .fit()
                .into(galleryImageView);

        return galleryImageView;
    }
}
