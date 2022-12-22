package com.example.clockapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clockapp.R;
import com.google.android.material.tabs.TabItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class WorldclockFragment extends Fragment {

    Calendar current;
    Spinner spinner;
    TextView timezone, txtCurrentTime, txtTimeZoneTime;
    long miliSeconds;
    ArrayAdapter<String> idAdapter;
    SimpleDateFormat sdf;
    Date resultDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_worldclock, container, false);
        spinner = (Spinner) root.findViewById(R.id.spin1);

        timezone = (TextView) root.findViewById(R.id.timezone);

        txtCurrentTime = (TextView) root.findViewById(R.id.txtCurrentTime);

        txtTimeZoneTime = (TextView) root.findViewById(R.id.txtTimeZoneTime);

        String[] idArray = TimeZone.getAvailableIDs();

        sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
//        String[] alsa = new String[] {"India", "China","Us"};

        idAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, idArray);

        idAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(idAdapter);

        getGMTtime();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("onItemSelected: ", "starting");

                getGMTtime();


                String selectedID = (String) (parent.getItemAtPosition(position));

                TimeZone timeZone = TimeZone.getTimeZone(selectedID);
                String TimeZoneName = timeZone.getDisplayName();


                int TimeZoneOffset = timeZone.getRawOffset() / (60 * 1000);


                int hrs = TimeZoneOffset / 60;
                int mins = TimeZoneOffset % 60;

                miliSeconds = miliSeconds + timeZone.getDSTSavings();

                resultDate = new Date(miliSeconds);
                System.out.println(sdf.format(resultDate));

                timezone.setText(TimeZoneName + " : GMT " + hrs + ":" + mins);
                txtTimeZoneTime.setText("" + sdf.format((resultDate)));
                miliSeconds = 0;
                Log.e("onItemSelected: ", "ending");
            }
        });


        return root;
    }

    private void getGMTtime() {
        current = Calendar.getInstance();
        // ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_worldclock, null);

        // txtCurrentTime = (TextView) root.findViewById(R.id.txtCurrentTime);

        txtCurrentTime.setText(("" + current.getTime()));
/*

        binding.txtCurrentTime.text="" + current.getTime();*/
        Log.e("Current time is :  ", " ------" + current.getTime());
        miliSeconds = current.getTimeInMillis();

        TimeZone tzCurrent = current.getTimeZone();
        int offset = tzCurrent.getRawOffset();
        if (tzCurrent.inDaylightTime(new Date())) {
            offset = offset + tzCurrent.getDSTSavings();
        }

        miliSeconds = miliSeconds - offset;

        resultDate = new Date(miliSeconds);
        System.out.println(sdf.format(resultDate));
        Log.e("eroor in here ", "sdf.format(resultDate) = " + sdf.format(resultDate));
    }

}