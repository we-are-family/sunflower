package com.example.admin.sunflower.activities;

import com.example.admin.sunflower.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;

public class Person_v extends Activity {    
	OnClickListener listener1 = null;
    OnClickListener listener2 = null;
	TextView tt1=null;
	ImageView ii1 = null;
    Button bb1 = null;
    @Override    
    protected void onCreate(Bundle savedInstanceState) {    

         listener1 = new OnClickListener(){ 
	        	
	            public void onClick(View v) {
	           Intent intent0 = new Intent(Person_v.this,Info_v.class);
	           startActivity(intent0);
	            }
	    };
        listener2 = new OnClickListener(){

            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        };
        super.onCreate(savedInstanceState);   
        setContentView(R.layout.person_v);

        tt1=(TextView) findViewById(R.id.tt1);
        tt1.setOnClickListener(listener1);
        
        ii1=(ImageView) findViewById(R.id.ii1);
        ii1.setOnClickListener(listener1);

        bb1 = (Button) findViewById(R.id.bb1);
        bb1.setOnClickListener(listener2);
    }    

}
