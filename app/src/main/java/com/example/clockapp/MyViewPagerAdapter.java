package com.example.clockapp;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.example.clockapp.fragments.*;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fg;
        switch(position){

            case 0: {
                Log.e("case 0", "log e");
                fg = new ClockFragment();
                break;

            }case 1: {
                Log.e("case 1", "log e");
                fg = new DigitalClock();
                break;

            }case 2: {
                Log.e("case 2", "log e");
                fg = new StopwatchFragment();
                break;

            }case 3: {
                Log.e("case 3", "log e");
                fg = new WorldclockFragment();
                break;
            }default:
            {   Log.e("case Default","log e");
                fg= new ClockFragment();
                break;
        }}
        return fg;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
