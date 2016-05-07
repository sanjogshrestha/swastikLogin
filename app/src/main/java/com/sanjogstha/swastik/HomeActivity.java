package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by SanjogStha on 5/1/2016.
 */
public class HomeActivity extends AppCompatActivity{

    private TextView userNameTextView;
    String userName = null;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mDrawerLayout  = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView =(NavigationView) findViewById(R.id.navigation);
        userNameTextView = (TextView) findViewById(R.id.userNameTextView);
        Intent getValue = getIntent();
        userName = getValue.getStringExtra("username");
        //userNameTextView.setText(userName);
    }
}
