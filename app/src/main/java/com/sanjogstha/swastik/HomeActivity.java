package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sanjogstha.swastik.api.ApiService;
import com.sanjogstha.swastik.api.RetroClient;
import com.sanjogstha.swastik.model.Contact;
import com.sanjogstha.swastik.model.Content;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by SanjogStha on 5/1/2016.
 */
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Toolbar mToolbar;
    private ArrayList<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView =(NavigationView) findViewById(R.id.navigation);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mNavigationView.setNavigationItemSelectedListener(this);

        mToolbar.setTitle(R.string.app_name);

        /*This is used to set the toggle button for navigation drawer*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        /**
         * Calling JSON
         */
        Call<Content> call = api.getMyJSON();

        contactList = new ArrayList<>();
        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {

                if(response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                     contactList = response.body().getContacts();


                } else {
                }
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {

            }
        });
    }

    /*Method for selection of the navigation menu items*/
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_faculty:
                Intent faculty = new Intent(HomeActivity.this, FacultyActivity.class);
                startActivity(faculty);
                finish();
                break;

            case R.id.item_gallery:
                Intent gallery = new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(gallery);
                finish();
                break;

            case R.id.item_location:
                Intent location = new Intent(HomeActivity.this, MapsActivity.class);
                startActivity(location);
                finish();
                break;

            case R.id.item_contact:
                break;

            case R.id.item_program:
                break;

            case R.id.item_about:
                break;

        }
        return false;
    }
}
