package com.hard.targets.mathsformulas;

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

public class View03Activity extends Activity implements AdListener {

	String TITLE, SUB_TITLE;
	AdView av;
	InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent t = getIntent();
		int pos = t.getIntExtra("id", 0);
		
		TITLE = getResources().getString(R.string.app_name) + ": " + getResources().getString(R.string.title_section1);
		String sub = getResources().getString(R.string.sub_14);
		
		switch (pos) {
		case 0:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_14_1);
			setContentView(R.layout.frame030);
			break;
		case 1:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_14_2);
			setContentView(R.layout.frame031);
			break;
		case 2:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_14_3);
			setContentView(R.layout.frame032);
			break;
		case 3:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_14_4);
			setContentView(R.layout.frame033);
			break;
		default:
			break;
		}
		
		setUpActionBar();
		loadAds();
	}

	private void setUpActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle(TITLE);
		getActionBar().setSubtitle(SUB_TITLE);
	}
	
	private void loadAds() {
		av = (AdView) findViewById(R.id.adView03);
		av.loadAd(new AdRequest());
		interstitial = new InterstitialAd(this, "a15274c523bafd4");
		interstitial.loadAd(new AdRequest());
		interstitial.setAdListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view03, menu);
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
