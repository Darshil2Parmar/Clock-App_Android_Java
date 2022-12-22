package com.example.clockapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {


    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        myViewPagerAdapter = new MyViewPagerAdapter(MainActivity.this);
        viewPager2.setAdapter(myViewPagerAdapter);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position) -> {

            switch (position) {
                case 0:
                    tab.setText(getString(R.string.tab1));
                    tab.setIcon(R.drawable.clocktime);
                    break;
                case 1:
                    tab.setText(getString(R.string.tab21));
                    tab.setIcon(R.drawable.digitalc);
                    break;
                case 2:
                    tab.setText(getString(R.string.tab3));
                    tab.setIcon(R.drawable.stopwatch);
                    break;
                case 3:
                    tab.setText(getString(R.string.tab4));
                    tab.setIcon(R.drawable.globewc);
                    break;

            }
        })).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            public void refreshAdapter(Context context) {


            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // viewPager2.setCurrentItem(tab.getPosition());
            }
        });


//
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                tabLayout.getTabAt(position).select();
//            }
//        });

    }


}