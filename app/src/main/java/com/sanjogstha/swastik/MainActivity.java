package com.sanjogstha.swastik;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView loginButton;
    private EditText username, password;
    private String userName, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadUI();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = username.getText().toString().trim();
                pass = password.getText().toString().trim();
                System.out.println("user"+ userName + "pass" + pass);

                if(userName.isEmpty() || pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter valid credentials",Toast.LENGTH_SHORT).show();
                }else if(userName.equals("a") && pass.equals("a")){
                    Toast.makeText(MainActivity.this, "welcome",Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(MainActivity.this, HomeActivity.class);
                    home.putExtra("username",userName);
                    startActivity(home);

                }else{
                    Toast.makeText(MainActivity.this, "Invalid User",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadUI() {
        loginButton = (TextView) findViewById(R.id.submitLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
}
