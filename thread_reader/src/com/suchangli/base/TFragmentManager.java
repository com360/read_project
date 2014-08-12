package com.suchangli.base;

import java.util.ArrayList;
import java.util.List;

import com.suchangli.thread.ui.HomeFragment;
import com.suchangli.thread.ui.NewsFragment;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

public class TFragmentManager {
	private static TFragmentManager instance;
	
	private TFragmentManager(){
		
	}
	
	public static TFragmentManager getInstance(){
		synchronized (TFragmentManager.class) {
			if(instance == null){
				instance = new TFragmentManager();
			}
		}
		
		return instance;
	}
	
	public Fragment newFragment(String fragmentTag){
		
		if(TextUtils.isEmpty(fragmentTag)){
			return null;
		}
		
		Fragment retFragment = null;
		if(TextUtils.equals(fragmentTag, "home_fragment")){
			retFragment = new HomeFragment();
		}else if(TextUtils.equals(fragmentTag, "news_fragment")){
			retFragment = new NewsFragment();
		}
		
		return retFragment;
	}
	
	public List<MenuInfo> getLeftMenuList(){
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		
		MenuInfo menu1 = new MenuInfo();
		menu1.setChecked(true);
		menu1.setFragment("home_fragment");
		menu1.setMenuName("Ê×Ò³");
		menuList.add(menu1);
		
		MenuInfo menu2 = new MenuInfo();
		menu2.setChecked(true);
		menu2.setFragment("news_fragment");
		menu2.setMenuName("×ÊÑ¶");
		menuList.add(menu2);
		
		return menuList;
	}
}
