package com.sanjogstha.swastik;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by SanjogStha on 5/14/2016.
 */
public class FacultyActivity extends AppCompatActivity{

    ListView facultyListView;
    Toolbar toolbar;

    String[] facultyList = {
            "Suraj Karki" ,
            "Murari Karki" ,
            "Bishnu Rawal" ,
            "Deep Bhujel" ,
            "Thaneswor Paneru" ,
            "Anju Khadka" ,
            "Bikram Rawat" ,
            "Samir Giri" ,
            "Sushil Nepal" ,
            "Ganesh Joshi" ,
            "Rakesh K. Bachhan" ,
            "Rajendra Shrestha" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        facultyListView = (ListView) findViewById(R.id.facultyListView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, facultyList);
        facultyListView.setAdapter(adapter);

        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(FacultyActivity.this, facultyList[i], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
