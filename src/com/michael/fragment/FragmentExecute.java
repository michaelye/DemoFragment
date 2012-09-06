package com.michael.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.main.R;

/**
 * 需要使用不带参数的构造器，可以使用getActivity()替换context参数
 * 否则屏幕在旋转的时候会抛出异常：
 * Caused by: java.lang.InstantiationException: 
 * can't instantiate class com.michael.fragment.FragmentExecute; no empty constructor
 * 
 * @see http://stackoverflow.com/questions/7016632/unable-to-instantiate-fragment
 * */
public class FragmentExecute extends Fragment
{

	public FragmentExecute()
	{
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) 
	{
		if (container == null) 
		{
            // Currently in a layout without a container, so no
            // reason to create our view.
            return null;
        }
		LayoutInflater myInflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	    View layout = myInflater.inflate(R.layout.frag_execute, container, false); 
		
		return layout;
	}
}
