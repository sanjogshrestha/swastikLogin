package com.sanjogstha.swastik;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Sanjog Shrestha on 6/25/2016.
 */
public class ContactActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout collegeWebsiteLinearLayout, collegeEmailLinearLayout, collegeLocationLinearLayout;
    TextView collegePhone1TextView, collegePhone2TextView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        collegeWebsiteLinearLayout = (LinearLayout) findViewById(R.id.collegeWebsiteLinearLayout);
        collegeEmailLinearLayout = (LinearLayout) findViewById(R.id.collegeEmailLinearLayout);
        collegeLocationLinearLayout = (LinearLayout) findViewById(R.id.collegeLocationLinearLayout);
        collegePhone1TextView = (TextView) findViewById(R.id.collegePhone1TextView);
        collegePhone2TextView = (TextView) findViewById(R.id.collegePhone2TextView);

        collegeEmailLinearLayout.setOnClickListener(this);
        collegeLocationLinearLayout.setOnClickListener(this);
        collegeWebsiteLinearLayout.setOnClickListener(this);
        collegePhone1TextView.setOnClickListener(this);
        collegePhone2TextView.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle(R.string.contact_us);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.collegeEmailLinearLayout:
                    sendEmail();
                    break;

                case R.id.collegeLocationLinearLayout:
                    openLocation();
                    break;

                case R.id.collegePhone1TextView:
                    callCollege("+97716635174");
                    break;

                case R.id.collegePhone2TextView:
                    break;

                case R.id.collegeWebsiteLinearLayout:
                    openCollegeWebsite();
                    break;
            }
    }

    private void sendEmail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "info@swastik.edu.np");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Help : ");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    private void callCollege(final String number) {
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:" + Uri.encode(number)));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(callIntent);
    }

    private void openLocation(){
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=27.673751,85.380688"));
        startActivity(intent);
    }

    private void openCollegeWebsite(){
        String url = String.valueOf(R.string.www_swastik_edu_np);
        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(url));
        startActivity(browserIntent);
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
        Intent main = new Intent(ContactActivity.this, HomeActivity.class);
        startActivity(main);
        super.onBackPressed();
    }
}
