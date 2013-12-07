package com.hard.targets.mathsformulas;

import java.util.LinkedList;
import java.util.Locale;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

public class MainActivity extends FragmentActivity implements AdListener {

	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;
	
	InterstitialAd interstetial;
	
	static AdView av0, av1, av2, av3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		interstetial = new InterstitialAd(this, "a15274c523bafd4");
		interstetial.loadAd(new AdRequest());
		interstetial.setAdListener(this);

		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.rate:
			
			return true;
		case R.id.share:
			Intent localIntent = new Intent("android.intent.action.SEND");
		    localIntent.setType("text/plain");
		    localIntent.putExtra("android.intent.extra.SUBJECT", "Maths Formulas - In your Pocket");
		    localIntent.putExtra("android.intent.extra.TEXT", "Find all the important Maths Formulas right in your pocket anytime & anywhere.");
		    startActivity(Intent.createChooser(localIntent, "Share Via"));
			return true;
		case R.id.disclaimer:
			Intent disclaimer = new Intent(this, DisclaimerActivity.class);
			startActivity(disclaimer);
			return true;
		case R.id.aboutUs:
			Intent aboutUs = new Intent(this, AboutActivity.class);
			startActivity(aboutUs);
			return true;
		case R.id.exit:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new DummySectionFragment();
			Bundle args = new Bundle();
			args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 4;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			}
			return null;
		}
	}

	public static class DummySectionFragment extends Fragment {
		public static final String ARG_SECTION_NUMBER = "section_number";

		public DummySectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			int position = getArguments().getInt(ARG_SECTION_NUMBER);
			View rootView = null;
			switch (position) {
			case 0:
				rootView = inflater.inflate(R.layout.fragment0, container, false);
				String[] item0 = { 
						getResources().getString(R.string.sub_11), 
						getResources().getString(R.string.sub_12), 
						getResources().getString(R.string.sub_13), 
						getResources().getString(R.string.sub_14), 
						getResources().getString(R.string.sub_15),
						getResources().getString(R.string.sub_16) };
				final ListView lv0 = (ListView) rootView.findViewById(R.id.lvFragment0);
				LinkedList<String> ll0 = new LinkedList<String>();
				for(String i:item0)
					ll0.add(i);
				ArrayAdapter<String> aa0 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ll0);
				lv0.setAdapter(aa0);
				lv0.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						int id0 = Integer.parseInt("" + lv0.getItemIdAtPosition(arg2));
						Intent i0 = new Intent("com.hard.targets.mathsformulas.VIEW0ACTIVITY");
						i0.putExtra("id", id0);
						startActivity(i0);
					}
				});
				
				av0 = (AdView) rootView.findViewById(R.id.adViewFragment0);
				av0.loadAd(new AdRequest());
				break;
			case 1:
				rootView = inflater.inflate(R.layout.fragment1, container, false);
				String[] item1 = {
						getResources().getString(R.string.sub_21),
						getResources().getString(R.string.sub_22),
						getResources().getString(R.string.sub_23),
						getResources().getString(R.string.sub_24),
						getResources().getString(R.string.sub_25),
						getResources().getString(R.string.sub_26),
						getResources().getString(R.string.sub_27),
						getResources().getString(R.string.sub_28) };
				final ListView lv1 = (ListView) rootView.findViewById(R.id.lvFragment1);
				LinkedList<String> ll1 = new LinkedList<String>();
				for(String i:item1)
					ll1.add(i);
				ArrayAdapter<String> aa1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ll1);
				lv1.setAdapter(aa1);
				lv1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						int id1 = Integer.parseInt("" + lv1.getItemIdAtPosition(arg2));
						Intent i1 = new Intent("com.hard.targets.mathsformulas.VIEW1ACTIVITY");
						i1.putExtra("id", id1);
						startActivity(i1);
					}
				});
				
				av1 = (AdView) rootView.findViewById(R.id.adViewFragment1);
				av1.loadAd(new AdRequest());
				break;
			case 2:
				rootView = inflater.inflate(R.layout.fragment2, container, false);
				String[] item2 = {
						getResources().getString(R.string.sub_31),
						getResources().getString(R.string.sub_32),
						getResources().getString(R.string.sub_33),
						getResources().getString(R.string.sub_34),
						getResources().getString(R.string.sub_35),
						getResources().getString(R.string.sub_36) };
				final ListView lv2 = (ListView) rootView.findViewById(R.id.lvFragment2);
				LinkedList<String> ll2 = new LinkedList<String>();
				for(String i:item2)
					ll2.add(i);
				ArrayAdapter<String> aa2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ll2);
				lv2.setAdapter(aa2);
				lv2.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						int id2 = Integer.parseInt("" + lv2.getItemIdAtPosition(arg2));
						Intent i2 = new Intent("com.hard.targets.mathsformulas.VIEW2ACTIVITY");
						i2.putExtra("id", id2);
						startActivity(i2);
					}
				});
				
				av2 = (AdView) rootView.findViewById(R.id.adViewFragment2);
				av2.loadAd(new AdRequest());
				break;
			case 3:
				rootView = inflater.inflate(R.layout.fragment3, container, false);
				String[] item3 = {
						getResources().getString(R.string.sub_41),
						getResources().getString(R.string.sub_42),
						getResources().getString(R.string.sub_43),
						getResources().getString(R.string.sub_44) };
				final ListView lv3 = (ListView) rootView.findViewById(R.id.lvFragment3);
				LinkedList<String> ll3 = new LinkedList<String>();
				for(String i:item3)
					ll3.add(i);
				ArrayAdapter<String> aa3 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, ll3);
				lv3.setAdapter(aa3);
				lv3.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
						int id3 = Integer.parseInt("" + lv3.getItemIdAtPosition(arg2));
						Intent i3 = new Intent("com.hard.targets.mathsformulas.VIEW3ACTIVITY");
						i3.putExtra("id", id3);
						startActivity(i3);
					}
				});
				
				av3 = (AdView) rootView.findViewById(R.id.adViewFragment3);
				av3.loadAd(new AdRequest());
				break;
			default:
				break;
			}
			return rootView;
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			new AlertDialog.Builder(this)
			.setIcon(R.drawable.ic_action_alert)
			.setTitle(R.string.dialog_title)
			.setMessage(R.string.dialog_message)
			.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					// User clicked OK button
					MainActivity.this.finish();
				}
			})
			.setNegativeButton(R.string.no, null)
			.show();
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onDestroy() {
		if (av0 != null)
			av0.destroy();
		if (av1 != null)
			av1.destroy();
		if (av2 != null)
			av2.destroy();
		if (av3 != null)
			av3.destroy();
		interstetial.stopLoading();
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
		if (arg0 == interstetial) {
			interstetial.show();
		}
	}

}
