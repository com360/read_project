package com.suchangli.app;

import com.suchangli.util.TLog;

import android.app.Application;

public class TApplicatioin extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		init();
	}
	
	private void init(){
		initLog();
	}
	
	private void initLog(){
		TLog.setLogable(true);
	}
}
