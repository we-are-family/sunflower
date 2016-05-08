package com.example.admin.sunflower.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.sunflower.R;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class Register_v extends AppCompatActivity implements AsyncResponse, View.OnClickListener {
    EditText etUsername, etPassword, etRepeatPassword;
    Button	btnRegister;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_v);

        etUsername = (EditText) findViewById(R.id.username_edit);
        etPassword = (EditText) findViewById(R.id.password_edit);
        etRepeatPassword = (EditText) findViewById(R.id.password_edit2);
        btnRegister = (Button) findViewById(R.id.vbutton2);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("exists")){
            Toast.makeText(this, "该用户已存在", Toast.LENGTH_LONG).show();
        }  else if (result.equals("empty")) {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_LONG).show();
        } else if (result.equals("fail")) {
            Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_LONG).show();
        } else if (result.equals("success")) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
            Intent in = new Intent(this,Login_v.class);
            startActivity(in);
        }
    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());
        postData.put("txtRepeatPassword", etRepeatPassword.getText().toString());


        PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
        task.execute("http://163.44.151.225/register_v.php");
    }
}