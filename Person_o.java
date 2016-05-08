package com.example.admin.sunflower.activities;

import com.example.admin.sunflower.R;
import com.example.admin.sunflower.R.layout;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
public class Person_o extends Activity {
	OnClickListener listener1 = null;
	OnClickListener listener2 = null;
	TextView t1 = null;
	ImageView i1 = null;
	Button b1 = null;

	@Override

	protected void onCreate(Bundle savedInstanceState) {

		listener1 = new OnClickListener() {

			public void onClick(View v) {
				Intent intent00 = new Intent(Person_o.this, Info_o.class);
				startActivity(intent00);
			}
		};
		listener2 = new OnClickListener() {

			public void onClick(View v) {
				finish();
				System.exit(0);
			}
		};
		super.onCreate(savedInstanceState);
		setContentView(layout.person_o);

		t1 = (TextView) findViewById(R.id.t1);
		t1.setOnClickListener(listener1);

		i1 = (ImageView) findViewById(R.id.i1);
		i1.setOnClickListener(listener1);

		b1 = (Button) findViewById(R.id.b1);
		b1.setOnClickListener(listener2);

	}
}
