package com.hard.targets.mathsformulas;

import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;

public class View1Activity extends Activity implements AdListener {

	String SUB_TITLE;
	AdView av;
	InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Locale l = Locale.getDefault();
		Intent t = getIntent();
		int pos = t.getIntExtra("id", 0);
		String sub = getResources().getString(R.string.title_section2).toUpperCase(l);
		
		switch (pos) {
		case 0:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_21);
			setContentView(R.layout.frame10);
			break;
		case 1:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_22);
			setContentView(R.layout.frame11);
			break;
		case 2:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_23);
			setContentView(R.layout.frame12);
			break;
		case 3:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_24);
			setContentView(R.layout.frame13);
			break;
		case 4:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_25);
			setContentView(R.layout.frame14);
			break;
		case 5:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_26);
			setContentView(R.layout.frame15);
			break;
		case 6:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_27);
			setContentView(R.layout.frame16);
			break;
		case 7:
			SUB_TITLE = sub + ": " + getResources().getString(R.string.sub_28);
			setContentView(R.layout.frame17);
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
		av = (AdView) findViewById(R.id.adView1);
		av.loadAd(new AdRequest());
		interstitial = new InterstitialAd(this, "a15274c523bafd4");
		interstitial.loadAd(new AdRequest());
		interstitial.setAdListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view1, menu);
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
