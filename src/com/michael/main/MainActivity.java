package com.michael.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.michael.fragment.FragmentExecute;
import com.michael.fragment.FragmentSetting;
import com.michael.fragment.FragmentLaunch;
import com.michael.fragment.FragmentSearch;
import com.michael.fragment.FragmentTeam;
import com.michael.widget.BottomBar;
import com.michael.widget.BottomBar.OnItemChangedListener;


/**
 * This demo shows how to use FragmentActivity to build the frame of a common application.
 * To replace the deprecated class such as TabActivity, ActivityGroup,and so on.
 * 
 * 这个demo展示了如何使用FragmentActivity来构建应用程序的框架
 * 可以使用这个来替代原来的TabActivity，ActivityGroup等等
 * 
 * @author MichaelYe
 * @since 2012-9-6
 * @see http://developer.android.com/reference/android/app/Fragment.html
 * @see http://developer.android.com/training/basics/fragments/index.html
 * @see http://developer.android.com/guide/components/fragments.html
 * */
public class MainActivity extends FragmentActivity 
{

	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final BottomBar bottomBar = (BottomBar)findViewById(R.id.ll_bottom_bar);
        bottomBar.setOnItemChangedListener(new OnItemChangedListener() 
        {
			
			@Override
			public void onItemChanged(int index) 
			{

				showDetails(index);
			}
		});
        bottomBar.setSelectedState(0);
        
//        bottomBar.hideIndicate();//这个代码原来控制红色小图标的可见性
//        bottomBar.showIndicate(12);
        
    }
	
	private void showDetails(int index)
	{
		Fragment details = (Fragment)
	            getSupportFragmentManager().findFragmentById(R.id.details);
		switch(index)
		{
		case 0:
			details = new FragmentExecute();
			break;
		case 1:
			details = new FragmentLaunch();
			break;
		case 2:
			details = new FragmentTeam();
			break;
		case 3:
			details = new FragmentSearch();
			break;
		case 4:
			details = new FragmentSetting();
			break;
		}
		// Execute a transaction, replacing any existing
        // fragment with this one inside the frame.
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.details, details);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//        ft.addToBackStack(null);//这行代码可以返回之前的操作（横屏的情况下，即两边都显示的情况下）
        ft.commit();
	}

    
}
