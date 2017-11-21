package com.mindnotix.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Admin on 11/21/2017.
 */

public class DrawerActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout mDrawerLayout;
    boolean doubleBackToExitPressedOnce = false;
    private ImageView ivMenu;

    View vProfile;
    View vEnquiry;
    View vOrders;
    View vPackages;
    View vPriceList;
    View vAbout;
    View vLogout;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ivMenu = (ImageView) findViewById(R.id.btnMenu);

        ivMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer();
            }
        });

        vProfile = findViewById(R.id.vProfile);
        vEnquiry = findViewById(R.id.vEnquiry);
        vOrders = findViewById(R.id.vOrders);
        vPackages = findViewById(R.id.vPackages);


        vProfile.setOnClickListener(this);
        vEnquiry.setOnClickListener(this);
        vOrders.setOnClickListener(this);
        vPackages.setOnClickListener(this);

        super.onPostCreate(savedInstanceState);
    }

    private void drawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.vProfile:
                mDrawerLayout.closeDrawers();
                Intent intentProfile = new Intent(DrawerActivity.this, ProfileActivity.class);
                startActivity(intentProfile);
                finish();
                break;
            case R.id.vEnquiry:
                mDrawerLayout.closeDrawers();
                Intent intentEnquiry = new Intent(DrawerActivity.this, EnquiryListActivity.class);
                startActivity(intentEnquiry);
                finish();
                break;
            case R.id.vOrders:
                mDrawerLayout.closeDrawers();
                Intent intentOrders = new Intent(DrawerActivity.this, OrdersActivity.class);
                startActivity(intentOrders);
                finish();
                break;
            case R.id.vPackages:
                mDrawerLayout.closeDrawers();
                Intent intentPackages = new Intent(DrawerActivity.this, PackagesActivity.class);
                startActivity(intentPackages);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
