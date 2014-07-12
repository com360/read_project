package com.suchangli.thread.ui;

import com.suchangli.thread.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HomeLeftMenuFragment extends ListFragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.home_left_menu_fragment, null);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		String[] colors = getResources().getStringArray(R.array.color_names);
		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(getActivity(), 
				android.R.layout.simple_list_item_1, android.R.id.text1, colors);
		setListAdapter(colorAdapter);
	}

	@Override
	public void onListItemClick(ListView lv, View v, int position, long id) {
		Fragment newContent = null;
		switch (position) {
		case 0:
			newContent = new HomeCenterFragment();
			break;
		case 1:
			newContent = new HomeCenterFragment();
			break;
		case 2:
			newContent = new HomeCenterFragment();
			break;
		case 3:
			newContent = new HomeCenterFragment();
			break;
		case 4:
			newContent = new HomeCenterFragment();
			break;
		}
		if (newContent != null)
			switchFragment(newContent);
	}

	// the meat of switching the above fragment
	private void switchFragment(Fragment fragment) {
		if (getActivity() == null)
			return;
		
		if (getActivity() instanceof HomeActivity) {
			HomeActivity fca = (HomeActivity) getActivity();
			fca.switchContent(fragment);
		}
	}
	
	private void switchFragment(String fragment) {
		
		if (getActivity() == null || !(getActivity() instanceof HomeBaseActivity))
			return;
		 
		HomeBaseActivity activity =  (HomeBaseActivity) getActivity();
		
		
	}


}
