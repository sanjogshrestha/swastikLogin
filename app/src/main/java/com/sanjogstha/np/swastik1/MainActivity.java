package com.sanjogstha.np.swastik1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
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
                }else if(userName.equals("Swastik") && pass.equals("123")){
                    Toast.makeText(MainActivity.this, "welcome",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Invalid User",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loadUI() {
        loginButton = (Button) findViewById(R.id.submitLogin);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }
}
