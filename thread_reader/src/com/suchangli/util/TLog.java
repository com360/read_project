package com.suchangli.util;

import android.util.Log;
/**
 * 日志打印工具类
 * @author suchangli
 * @date 2014-6-22
 */
public class TLog {
	private static boolean sLogable = false;
	
	public static void setLogable(boolean logable){
		sLogable = logable;
	}
	
	public static boolean getLogable(){
		
		return sLogable;
	}
	
	public static void logi(String tag, String msg){
		if(sLogable){
			Log.i(tag, msg);
		}
	}
	public static void loge(String tag, String msg){
		if(sLogable){
			Log.e(tag, msg);
		}
	}
	public static void logd(String tag, String msg){
		if(sLogable){
			Log.d(tag, msg);
		}
	}
	public static void logw(String tag, String msg){
		if(sLogable){
			Log.w(tag, msg);
		}
	}
	
}
