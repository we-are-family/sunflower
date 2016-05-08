package com.example.admin.sunflower.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;


import com.example.admin.sunflower.R;
import com.jauker.widget.BadgeView;

public class Home_v extends TabActivity {
	RadioGroup g=null;
	TabHost tabHost;
    Button b;

	public static final String TAB_1="tab_zyhd";
	public static final String TAB_2="tab_wdtz";
	public static final String TAB_3="tab_grzx";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_v);

		g = (RadioGroup)findViewById(R.id.vmain_tab_group);
		tabHost = getTabHost();

		b = (Button)findViewById(R.id.bt);
		BadgeView badgeView = new com.jauker.widget.BadgeView(this);
		badgeView.setTargetView(b);
		badgeView.setBadgeCount(2);
		tabHost.addTab(tabHost.newTabSpec(TAB_1)
				.setIndicator(TAB_1)
				.setContent(new Intent(this, Apply_v.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_2)
				.setIndicator(TAB_2)
				.setContent(new Intent(this,Activity_inform_v.class)));
		tabHost.addTab(tabHost.newTabSpec(TAB_3)
				.setIndicator(TAB_3)
				.setContent(new Intent(this, Person_v.class)));

		g.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {

					case R.id.v_volunteer_activities:
						tabHost.setCurrentTabByTag(TAB_1);
						break;
					case R.id.v_message:
						tabHost.setCurrentTabByTag(TAB_2);
						break;
					case R.id.v_person_center:
						tabHost.setCurrentTabByTag(TAB_3);
						break;
					default:
						break;
				}
			}
		});


	}


}
