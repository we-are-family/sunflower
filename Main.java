package com.example.admin.sunflower.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.admin.sunflower.R;

public class Main extends Activity {

	 
	 protected void onCreate(Bundle savedInstanceState) {    
		    OnClickListener listener1 = null;
		    OnClickListener listener2= null;
		    ImageView page1=null;
		    ImageView page2=null;
		    
	        listener1 = new OnClickListener(){ 
	        	
	            public void onClick(View v) { 
	            	Intent intent0 = new Intent(Main.this,Login_v.class);
	            	startActivity(intent0);  
	            }
	        };
           listener2 = new OnClickListener(){ 
	        	
	            public void onClick(View v) { 
	            	Intent intent1 = new Intent(Main.this,Login_o.class);
	            	startActivity(intent1);  
	            }
	        };
	        super.onCreate(savedInstanceState);              
	        setContentView(R.layout.main);

			page1= (ImageView) findViewById(R.id.page1);   
	        page1.setOnClickListener(listener1);
	        page2= (ImageView) findViewById(R.id.page2);   
	        page2.setOnClickListener(listener2);
	        
	        
	    }    
		
}
