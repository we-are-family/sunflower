package com.example.admin.sunflower.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.TabHost;

import com.example.admin.sunflower.R;


public class Home_o extends TabActivity {

	RadioGroup g=null;
	TabHost tabHost;

	public static final String TAB_HOME="fbhd";
	public static final String TAB_2="tab_zyhd";
	public static final String TAB_3="tab_wdtz";
	public static final String TAB_4="tab_grzx";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_o);

		g = (RadioGroup)findViewById(R.id.main_tab_group);
		tabHost = getTabHost();
		tabHost.addTab(tabHost.newTabSpec(TAB_HOME)
				.setIndicator(TAB_HOME)
				.setContent(new Intent(this,Apply_v.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_2)
				.setIndicator(TAB_2)
				.setContent(new Intent(this,Activity_inform_v.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_3)
				.setIndicator(TAB_3)
				.setContent(new Intent(this,Activity_inform_v.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_4)
				.setIndicator(TAB_4)
				.setContent(new Intent(this,Person_o.class)));

		g.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
					case R.id.fbhd:
						tabHost.setCurrentTabByTag(TAB_HOME);
						break;
					case R.id.zyhd:
						tabHost.setCurrentTabByTag(TAB_2);
						break;
					case R.id.wdtz:
						tabHost.setCurrentTabByTag(TAB_3);
						break;
					case R.id.grzx:
						tabHost.setCurrentTabByTag(TAB_4);
						break;
					default:
						break;
				}
			}
		});

	}


}
