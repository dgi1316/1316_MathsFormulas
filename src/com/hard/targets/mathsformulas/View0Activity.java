package com.hard.targets.mathsformulas;

import java.util.LinkedList;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

public class View0Activity extends Activity implements AdListener {

	String SUB_TITLE;
	AdView av;
	InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Locale l = Locale.getDefault();
		Intent t = getIntent();
		int pos = t.getIntExtra("id", 0);
		String sub = getResources().getString(R.string.title_section1).toUpperCase(l);
		
		switch (pos) {
		case 0:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_11);
			setContentView(R.layout.frame00);
			break;
		case 1:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_12);
			setContentView(R.layout.frame01);
			String[] item1 = {
					getResources().getString(R.string.sub_12_1),
					getResources().getString(R.string.sub_12_2),
					getResources().getString(R.string.sub_12_3) };
			final ListView lv12 = (ListView) findViewById(R.id.lvFrame01);
			LinkedList<String> ll12 = new LinkedList<String>();
			for(String i:item1)
				ll12.add(i);
			ArrayAdapter<String> aa12 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ll12);
			lv12.setAdapter(aa12);
			lv12.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					int id12 = Integer.parseInt("" + lv12.getItemIdAtPosition(arg2));
					Intent i12 = new Intent("com.hard.targets.mathsformulas.VIEW01ACTIVITY");
					i12.putExtra("id", id12);
					startActivity(i12);
				}
			});
			break;
		case 2:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_13);
			setContentView(R.layout.frame02);
			break;
		case 3:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_14);
			setContentView(R.layout.frame03);
			String[] item3 = {
					getResources().getString(R.string.sub_14_1),
					getResources().getString(R.string.sub_14_2),
					getResources().getString(R.string.sub_14_3),
					getResources().getString(R.string.sub_14_4) };
			final ListView lv14 = (ListView) findViewById(R.id.lvFrame03);
			LinkedList<String> ll14 = new LinkedList<String>();
			for(String i:item3)
				ll14.add(i);
			ArrayAdapter<String> aa14 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ll14);
			lv14.setAdapter(aa14);
			lv14.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					int id14 = Integer.parseInt("" + lv14.getItemIdAtPosition(arg2));
					Intent i14 = new Intent("com.hard.targets.mathsformulas.VIEW03ACTIVITY");
					i14.putExtra("id", id14);
					startActivity(i14);
				}
			});
			break;
		case 4:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_15);
			setContentView(R.layout.frame04);
			break;
		case 5:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_16);
			setContentView(R.layout.frame05);
			break;
		default:
			break;
		}
		
		setUpActionBar();
		loadAds();
	}

	private void setUpActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setSubtitle(SUB_TITLE);
	}

	private void loadAds() {
		av = (AdView) findViewById(R.id.adView0);
		av.loadAd(new AdRequest());
		interstitial = new InterstitialAd(this, "a15274c523bafd4");
		interstitial.loadAd(new AdRequest());
		interstitial.setAdListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view0, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		if (av != null)
			av.destroy();
		interstitial.stopLoading();
		super.onDestroy();
	}

	@Override
	public void onDismissScreen(Ad arg0) {
	}

	@Override
	public void onFailedToReceiveAd(Ad arg0, ErrorCode arg1) {
	}

	@Override
	public void onLeaveApplication(Ad arg0) {
	}

	@Override
	public void onPresentScreen(Ad arg0) {
	}

	@Override
	public void onReceiveAd(Ad arg0) {
		if (arg0 == interstitial)
			interstitial.show();
	}

}
