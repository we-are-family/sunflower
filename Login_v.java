package com.example.admin.sunflower.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.sunflower.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Login_v extends AppCompatActivity implements AsyncResponse, View.OnClickListener {
    EditText etUsername, etPassword;
    Button	btnLogin;
    TextView t=null;
    View.OnClickListener listener = null;

    protected void onCreate(Bundle savedInstanceState) {
        listener = new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent = new Intent(Login_v.this,Register_v.class);
                startActivity(intent);
            }
        };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_volunteer);

        etUsername = (EditText) findViewById(R.id.vname_edit);
        etPassword = (EditText) findViewById(R.id.vpassword_edit);
        btnLogin = (Button) findViewById(R.id.button2);
        btnLogin.setOnClickListener(this);
        t = (TextView) findViewById(R.id.no_input2);
        t.setOnClickListener(listener);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("success")) {
            Intent in = new Intent(this,Home_v.class);
            startActivity(in);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());

        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://163.44.151.225/login_v.php");
    }


}
