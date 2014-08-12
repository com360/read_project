package com.suchangli.base;

import java.io.Serializable;
/**
 * 左侧菜单信息类
 * @author suchangli
 *
 */
public class MenuInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String menuName;
	
	private String fragment;
	
	private boolean checked;

	public String getFragment() {
		return fragment;
	}

	public void setFragment(String fragment) {
		this.fragment = fragment;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
	
}
