package com.suchangli.thread.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.suchangli.base.TFragmentManager;
import com.suchangli.thread.R;

public class HomeActivity extends HomeBaseActivity {

	private Fragment mCurrentContent;
	
	public HomeActivity() {
		super(R.string.app_name);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// set the Above View
		if (savedInstanceState != null)
			mCurrentContent = getSupportFragmentManager().getFragment(
					savedInstanceState, "mContent");
		if (mCurrentContent == null)
			mCurrentContent = getFragmentByTag("home_fragment");

		// set the Above View(content fragment)
		setContentView(R.layout.content_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, mCurrentContent).commit();

		// set the Behind View(left menu)
		setBehindContentView(R.layout.menu_frame);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, new HomeLeftMenuFragment()).commit();
 
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getSupportFragmentManager().putFragment(outState, "mContent", mCurrentContent);
	}

	public void switchContent(Fragment fragment) {
		mCurrentContent = fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
	}
	/**
	 * 更加tag切换响应的Fragment
	 * @param fragmentTag
	 */
	public void switchContent(String fragmentTag) {
		
		Fragment fragment = getFragmentByTag(fragmentTag);
		

		if(fragment == null){
			return;
		}
		
		if( mCurrentContent == fragment ){
			getSlidingMenu().showContent();
			return;
		}
		
		mCurrentContent =  fragment;
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		getSlidingMenu().showContent();
	}
	/**
	 * 根据tag返回一个Fragment实例
	 * @param fragmentTag
	 * @return
	 */
	private Fragment getFragmentByTag(String fragmentTag){
		if(TextUtils.isEmpty(fragmentTag)){
			return null;
		}
		Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
		
		if(fragment == null){
			fragment = newFragment(fragmentTag);
		}
		
		return fragment;
	}
	/**
	 * 根据Tag创建一个Fragment实例
	 * @param fragmentTag
	 * @return
	 */
	private Fragment newFragment(String fragmentTag){
		return TFragmentManager.getInstance().newFragment(fragmentTag);
	}

}
