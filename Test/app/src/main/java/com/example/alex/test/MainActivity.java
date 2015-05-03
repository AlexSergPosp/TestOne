package com.example.alex.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;  // по какой то причине подключаем эту библтотеку
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar bar = getSupportActionBar();

        assert bar != null;
        bar.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        android.support.v7.app.ActionBar.Tab tab = bar.newTab();
    // add tabs
        tab.setText("List")
            .setIcon(R.drawable.list2)
            .setTabListener(this);
        bar.addTab(tab);

        tab = bar.newTab()
            .setText("Gallery")
            .setIcon(R.drawable.gallary)
            .setTabListener(this);
        bar.addTab(tab);

        tab = bar.newTab()
            .setText("Service")
            .setIcon(R.drawable.service)
            .setTabListener(this);
        bar.addTab(tab);

        Intent intent = new Intent(this,Gallery.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }
}
