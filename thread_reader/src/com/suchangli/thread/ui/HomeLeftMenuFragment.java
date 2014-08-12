package com.suchangli.thread.ui;

import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.suchangli.base.MenuInfo;
import com.suchangli.base.TFragmentManager;
import com.suchangli.thread.R;


public class HomeLeftMenuFragment extends ListFragment {
	private List<MenuInfo> mLeftMenuList;
	private LeftMenuAdapter mLeftMenuAdapter;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_left_menu_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//获得menu信息
		getLeftMenuList();
		mLeftMenuAdapter = new LeftMenuAdapter(getActivity(), mLeftMenuList);
		setListAdapter(mLeftMenuAdapter);
	}

	private void getLeftMenuList() {
		mLeftMenuList =  TFragmentManager.getInstance().getLeftMenuList();
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		MenuInfo menu = (MenuInfo) mLeftMenuAdapter.getItem(position);
		if(menu == null){
			return;
		}
		boolean changed = mLeftMenuAdapter.setCheckedMenu(menu);
		 
		switchFragment(menu.getFragment());
	}

	
	private void switchFragment(String fragment) {
		
		if (getActivity() == null || !(getActivity() instanceof HomeActivity))
			return;
		
		HomeActivity activity =  (HomeActivity) getActivity();
		activity.switchContent(fragment);
	}

	class LeftMenuAdapter extends BaseAdapter{
		private List<MenuInfo> mLeftMenus = null;
		private Context mContext;
		private MenuInfo mCheckedMenu;
		public LeftMenuAdapter(Context context, List<MenuInfo> leftMenus){
			this.mContext = context;
			this.mLeftMenus = leftMenus;
		}
		public boolean setCheckedMenu(MenuInfo checkedMenu){
			MenuInfo newCheckedMenu = checkedMenu;
			MenuInfo oldCheckedMenu = mCheckedMenu;
			if(newCheckedMenu == null || newCheckedMenu == oldCheckedMenu){
				return false;
			}
			if(oldCheckedMenu != null){
				oldCheckedMenu.setChecked(false);
			} 
			newCheckedMenu.setChecked(true);
			mCheckedMenu = newCheckedMenu;
			notifyDataSetChanged();
			
			return true;
		}
		@Override
		public int getCount() {
			 
			return mLeftMenus == null ? 0 : mLeftMenus.size();
		}

		@Override
		public Object getItem(int position) {
			if(mLeftMenus == null || mLeftMenus.size() == 0){
				return null;
			}
			 
			return  position >= mLeftMenus.size() ? null : mLeftMenus.get(position);
		}

		@Override
		public long getItemId(int position) {
			
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if(convertView == null){
				convertView = LayoutInflater.from(mContext).inflate(R.layout.home_left_menu_item, null);
				holder = new ViewHolder();
				holder.menuNameTextView = (TextView) convertView.findViewById(R.id.menu_name_tv);
				
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			
			MenuInfo menu = mLeftMenus.get(position);
			holder.menuNameTextView.setText(menu.getMenuName());
			if(menu.isChecked()){
				
			}else{
				
			}
			
			return convertView;
		}
		
		class ViewHolder{
			TextView menuNameTextView;
			
		}
		
	}

}
