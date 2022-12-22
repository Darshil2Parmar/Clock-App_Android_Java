package com.example.clockapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.clockapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClockFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClockFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clock, container, false);
    }
}