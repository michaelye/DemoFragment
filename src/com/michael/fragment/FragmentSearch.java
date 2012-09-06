package com.michael.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.michael.main.R;

public class FragmentSearch extends Fragment
{

	public FragmentSearch()
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
	    View layout = myInflater.inflate(R.layout.frag_search, container, false); 
		
		return layout;
	}

	
	
}
