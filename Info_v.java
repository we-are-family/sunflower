package com.example.admin.sunflower.activities;

import com.example.admin.sunflower.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info_v extends Activity {    
    View.OnClickListener listener1 = null;
    Button b;
    @Override    
    protected void onCreate(Bundle savedInstanceState) {    
    	// TODO Auto-generated method stub

        listener1 = new View.OnClickListener(){

            public void onClick(View v) {
                Intent intent0 = new Intent(Info_v.this,Info_v_modify.class);
                startActivity(intent0);
            }
        };
    	super.onCreate(savedInstanceState);    
        setContentView(R.layout.info_v);
        b = (Button) findViewById(R.id.v_modify_button);
        b.setOnClickListener(listener1);
    }

}
