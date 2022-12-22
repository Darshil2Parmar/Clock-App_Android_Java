package com.example.clockapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.clockapp.R;

import java.text.DateFormat;
import java.util.Date;


public class DigitalClock extends Fragment {
    private TextClock clockTC;
    private TextView dateDisplay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_digital_clock, container, false);
        clockTC = (TextClock) root.findViewById(R.id.idTCClock);
        clockTC.setFormat12Hour("hh:mm:ss a");

        dateDisplay = (TextView) root.findViewById(R.id.Ddate);
        dateDisplay.setText(this.getDate());
        return root;
    }

    private String getDate(){


        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String d = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
        return d;

    }
}