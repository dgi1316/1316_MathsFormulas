package com.hard.targets.mathsformulas;

import com.google.ads.AdRequest;
import com.google.ads.AdView;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class AboutActivity extends Activity {

	WebView wv;
	AdView av;

	String url = "file:///android_asset/about.html";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		setupActionBar();
		
		wv = (WebView) findViewById(R.id.wvAbout);
		wv.loadUrl(url);
		
		av = (AdView) findViewById(R.id.adViewAbout);
		av.loadAd(new AdRequest());
	}

	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setSubtitle("About Us");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.about, menu);
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
		super.onDestroy();
	}

}
