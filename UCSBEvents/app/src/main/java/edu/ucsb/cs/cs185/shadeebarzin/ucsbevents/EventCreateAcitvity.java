package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EventCreateAcitvity extends AppCompatActivity {
    DatePickerDialog dp;
    String dateOutput;
    TextView tvdate;

    TimePickerDialog tp;
    String timeOutput;
    TextView tvtime;

    Date date;

    String name;
    int uid;

    EditText title;
    EditText description;
    EditText host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create_acitvity);

        uid = savedInstanceState.getInt("uid");
        name = savedInstanceState.getString("name");

        title = (EditText) findViewById(R.id.input_title);
        description = (EditText) findViewById(R.id.input_event_description);
        host = (EditText) findViewById(R.id.input_host);

        host.setText(name);

        date=new Date();

        Calendar newCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "MMMM dd, yyyy", Locale.US );
        SimpleDateFormat timeFormat = new SimpleDateFormat( "hh:mm", Locale.US );
        dateOutput = dateFormat.format(date);
        timeOutput = timeFormat.format(date);


        tvdate = (TextView) findViewById(R.id.enter_date);
        dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                SimpleDateFormat dateFormat = new SimpleDateFormat( "MMMM dd, yyyy", Locale.US );
                date.setYear(year-1900);
                date.setMonth(monthOfYear);
                date.setDate(dayOfMonth);
                dateOutput = dateFormat.format(date);
                tvdate.setText(dateOutput);
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));


        tvtime = (TextView) findViewById(R.id.enter_time);
        tp = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                date.setHours(hourOfDay);
                date.setMinutes(minute);
                timeOutput = ""+hourOfDay+':'+minute;
                tvtime.setText(timeOutput);
            }
        },newCalendar.HOUR_OF_DAY,newCalendar.MINUTE,true);


        tvdate.setText(dateOutput);
        tvtime.setText(timeOutput);

    }

    public void setDate(View view) {
        showDialog(0);
    }

    public void setTime(View view) {
        showDialog(1);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id==0) return dp;
        if (id==1) return tp;
        return null;
    }
}
