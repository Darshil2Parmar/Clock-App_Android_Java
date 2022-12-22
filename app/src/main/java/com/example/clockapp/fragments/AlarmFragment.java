package com.example.clockapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.clockapp.R;


public class AlarmFragment extends Fragment {
    private TextView mTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_alarm, container, false);
        //-----
        mTextView = root.findViewById(R.id.textView);
        Button buttonTimePicker = root.findViewById(R.id.button_timepicker);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent launchIntent = getActivity().getPackageManager().getLaunchIntentForPackage("com.whatsapp");

                if(launchIntent != null){
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(getActivity(),"There is no such app",Toast.LENGTH_LONG).show();
//                    Toast.makeText(AlarmFragment.this,"There is no such app",Toast.LENGTH_LONG).show();
                }
/*
                DialogFragment timePicker = new TimePickerFragment();
*/
                /*timePicker.show(getActivity().getSupportFragmentManager(), "time picker");
                Log.e("Time PiCKer", timePicker.toString());*/
/*
                timePicker.show(getParentFragmentManager(), "time picker");
*/

            }

        });

        /*Button buttonCancelAlarm = root.findViewById(R.id.button_cancel);
        buttonCancelAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e( "onClick Cancel  : ", "onClick is Cicked__________");
*//*
                cancelAlarm();
*//*
            }
        });*/


        return root;
    }


/*
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);
        Log.e( "OntimeSet UPDATE---- ",c.toString());
        updateTimeText(c);
        startAlarm(c);
    }


    private void updateTimeText(Calendar c) {
        String timeText = "Alarm set for: ";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        mTextView.setText(timeText);
        Log.e("New UPDATED TIME TEXT IS: ", timeText);
    }


    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
        Log.e("startAlarm: ", "ALARM IS START JALSA DO.............");
    }
    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getActivity(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(), 1, intent, 0);

        alarmManager.cancel(pendingIntent);
        mTextView.setText("Alarm canceled");
        Log.e("cancelAlarm: ", "ALARM IS DEAD IN PIPELINE");
    }*/
}