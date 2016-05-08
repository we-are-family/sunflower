package com.example.admin.sunflower.activities;

import com.example.admin.sunflower.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Info_v_modify extends Activity {    
	OnClickListener listener1 = null;
	Button b;
    @Override    
    protected void onCreate(Bundle savedInstanceState) {    
    	// TODO Auto-generated method stub
    	 listener1 = new OnClickListener(){ 
	        	
	            public void onClick(View v) {

					 Toast.makeText(Info_v_modify.this, "修改成功", Toast.LENGTH_LONG).show();
	           Intent intent0 = new Intent(Info_v_modify.this,Info_v.class); 
	           startActivity(intent0);
	            }
	    };
    	super.onCreate(savedInstanceState);    
        setContentView(R.layout.info_v_modify);
        
        b = (Button) findViewById(R.id.v_save_button);   
        b.setOnClickListener(listener1);
    }

}