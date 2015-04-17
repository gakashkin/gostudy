package com.example.grisha.gostudy;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import android.os.Handler;

import static com.example.grisha.gostudy.R.mipmap.ic_navigation_drawer;

/**
 * Created by grisha on 4/15/15.
 */
public class DrawerActivity extends Activity{
    private final String LOG_TAG = getLogTag();

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle, mTitle;
    private android.os.Bundle savedInstanceState;
    private ListView mDrawerList;



    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(getLayout());

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        mTitle = mDrawerTitle = getTitle();
        mDrawerList = (ListView) findViewById(R.id.drawerList);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerList.setOnItemClickListener(new DrawerListener());

        init();

        mDrawerList.setAdapter(getAdapter());

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView){
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView){
                getActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if(savedInstanceState == null){
            displayView(0, null);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title){
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState){
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private class DrawerListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, final int position, long id){

            mDrawerLayout.closeDrawer(mDrawerList);
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run(){
                    displayView(position, null);
                }
            }, 300);
        }

    }

    public void displayView(int position, Bundle fragmentBundle) {

    }

    public void init() {

    }

    public String getLogTag(){
        return "DrawerActivity";
    }
    private int getLayout(){
        return R.layout.drawer_activity;
    }
    public ActionBarDrawerToggle getDrawerToggle(){
        return  mDrawerToggle;
    }
    public  ListView getDrawerList(){
        return mDrawerList;
    }
    public DrawerLayout getDrawerLayout(){
        return mDrawerLayout;
    }

    protected BaseAdapter getAdapter() {
        return null;
    }

}
