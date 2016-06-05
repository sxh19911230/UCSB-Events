package edu.ucsb.cs.cs185.shadeebarzin.ucsbevents;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class EventCreateAcitvity extends AppCompatActivity {
    private final int REQUEST_LOCATION = 4;
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
    TextView tvlocation;

    double latitude;
    double longitude;

    Button submitButton;
    Button cancelButton;

    ArrayAdapter<CharSequence> adapter;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_create_acitvity);

        Intent intent = getIntent();
        uid = intent.getExtras().getInt("uid");
        name = intent.getExtras().getString("name");

        title = (EditText) findViewById(R.id.input_title);
        description = (EditText) findViewById(R.id.input_event_description);
        host = (EditText) findViewById(R.id.input_host);

        tvlocation = (TextView) findViewById(R.id.enter_location);

        host.setText(name);

        date=new Date();

        Calendar newCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat( "MMMM dd, yyyy", Locale.US );
        SimpleDateFormat timeFormat = new SimpleDateFormat( "HH:mm", Locale.US );
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

        adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner = (Spinner)findViewById(R.id.spin_cato);
        spinner.setAdapter(adapter);

        submitButton = (Button) findViewById(R.id.btn_submit);
        cancelButton = (Button) findViewById(R.id.btn_cancel);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });

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

    public void setLocation(View view) {
        Intent intent = new Intent(getApplicationContext(), GetLocationActivity.class);
        startActivityForResult(intent, REQUEST_LOCATION);

    }

    public void submit() {
        if (!validate()) {
            Toast.makeText(this,"Failed to creat Event",Toast.LENGTH_SHORT);
        } else {
            //http://localhost/request.php?activity=set_event&uid=2&event_title=asd&event_date=2016-06-02+03:02:06&event_description=kjashd+askjdh&location_name=kashd+asd&latitude=3.14&longitude=15.43&event_host=asdasd+asdasd&category=asd
            StringBuilder sb = new StringBuilder("activity=set_event");
            try {
                sb.append("&uid=");
                sb.append(uid);
                sb.append("&event_title=");
                sb.append(URLEncoder.encode(title.getText().toString(), "utf-8"));
                sb.append("&event_date=");
                sb.append(URLEncoder.encode(new java.sql.Timestamp(date.getTime()).toString(),"utf-8"));
                sb.append("&event_description=");
                sb.append(URLEncoder.encode(description.getText().toString(), "utf-8"));
                sb.append("&location_name=");
                sb.append(URLEncoder.encode(tvlocation.getText().toString(), "utf-8"));
                sb.append("&latitude=");
                sb.append(latitude);
                sb.append("&longitude=");
                sb.append(longitude);
                sb.append("&event_host=");
                sb.append(host.getText().toString());
                sb.append("&category=");

                if (spinner.getSelectedItem().toString().equals("-- CATEGORY --"))
                    sb.append("All");
                else sb.append(URLEncoder.encode(spinner.getSelectedItem().toString(),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            final ProgressDialog progressDialog = new ProgressDialog(EventCreateAcitvity.this,
                    R.style.AppTheme_Dark_Dialog);
            progressDialog.setIndeterminate(true);
            progressDialog.setMessage("Creating...");
            progressDialog.show();

            class SendRequest extends AsyncTask<String, Void, String> {
                @Override
                protected String doInBackground(String... params) {
                    String t = CS185Connector.sendRequest(params[0]);

                    return t;
                }

                @Override
                protected void onPostExecute(String result) {
                    super.onPostExecute(result);
                    if (result.equals("success")) {
                        Toast.makeText(EventCreateAcitvity.this,"Success",Toast.LENGTH_SHORT);
                    } else {
                        Toast.makeText(EventCreateAcitvity.this,result,Toast.LENGTH_SHORT);
                    }

                }
            }

            SendRequest sendRequest = new SendRequest();
            sendRequest.execute(sb.toString());

            new android.os.Handler().postDelayed(
                    new Runnable() {
                        public void run() {
                            progressDialog.dismiss();
                            finish();
                        }
                    }, 3000);
        }
    }



    public void cancel() {
        setResult(RESULT_CANCELED,null);
        finish();
    }

    public boolean validate() {
        boolean valid = true;

        String t = title.getText().toString();
        String d = description.getText().toString();
        String h = host.getText().toString();

        String l = tvlocation.getText().toString();

        if (t.isEmpty() ) {
            title.setError("enter a valid title");
            valid = false;
        } else {
            title.setError(null);
        }

        if (d.isEmpty()) {
            description.setError("enter a valid description");
            valid = false;
        } else {

            description.setError(null);
        }

        if (h.isEmpty()) {
            host.setError("enter a valid Host");
            valid = false;
        } else {
            host.setError(null);
        }

        if (l.isEmpty()) {
            tvlocation.setError("Please select a location");
            valid = false;
        } else {
            host.setError(null);
        }

        return valid;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_LOCATION) {
            if (resultCode == RESULT_OK) {
                tvlocation.setText(data.getStringExtra("location"));
                latitude = data.getDoubleExtra("latitude",0.0);
                longitude = data.getDoubleExtra("longitude",0.0);

            } else if (resultCode == RESULT_CANCELED) {

            }
        }
    }
}
