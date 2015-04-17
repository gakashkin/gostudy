package com.example.grisha.gostudy.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by grisha on 4/16/15.
 */
public abstract class DefaultFragment extends Fragment {
    @Override
    public void onInflate(Activity activity,AttributeSet attribs, Bundle savedInstanceState){
        FragmentManager fr = getFragmentManager();
        if (fr != null){
            fr.beginTransaction().remove(this).commit();
        }
        super.onInflate(activity, attribs, savedInstanceState);
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        super.onCreateOptionsMenu(menu, inflater);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
