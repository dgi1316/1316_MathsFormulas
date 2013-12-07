package com.hard.targets.mathsformulas;

import java.util.LinkedList;
import java.util.Locale;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class View3Activity extends Activity implements AdListener {

	String SUB_TITLE;
	AdView av;
	InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Locale l = Locale.getDefault();
		Intent t = getIntent();
		int pos = t.getIntExtra("id", 0);
		String sub = getResources().getString(R.string.title_section4).toUpperCase(l);
		
		switch (pos) {
		case 0:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_41);
			setContentView(R.layout.frame30);
			break;
		case 1:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_42);
			setContentView(R.layout.frame31);
			break;
		case 2:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_43);
			setContentView(R.layout.frame32);
			String[] item2 = {
					getResources().getString(R.string.sub_43_1),
					getResources().getString(R.string.sub_43_2) };
			final ListView lv32 = (ListView) findViewById(R.id.lvFrame32);
			LinkedList<String> ll32 = new LinkedList<String>();
			for(String i:item2)
				ll32.add(i);
			ArrayAdapter<String> aa32 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ll32);
			lv32.setAdapter(aa32);
			lv32.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					int id32 = Integer.parseInt("" + lv32.getItemIdAtPosition(arg2));
					Intent i32 = new Intent("com.hard.targets.mathsformulas.VIEW32ACTIVITY");
					i32.putExtra("id", id32);
					startActivity(i32);
				}
			});
			break;
		case 3:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_44);
			setContentView(R.layout.frame33);
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
		av = (AdView) findViewById(R.id.adView3);
		av.loadAd(new AdRequest());
		interstitial = new InterstitialAd(this, "a15274c523bafd4");
		interstitial.loadAd(new AdRequest());
		interstitial.setAdListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view3, menu);
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
