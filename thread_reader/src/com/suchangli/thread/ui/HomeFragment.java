package com.suchangli.thread.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.RelativeLayout;

import com.suchangli.thread.R;

public class HomeFragment extends Fragment {
	
	private View mRootView;
	
	public HomeFragment() { 
		 
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.home_fragment, container, false);
		return mRootView;
	}
	
	
	
}
