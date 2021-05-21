package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import cat.itb.gkref.R;

;

public class ActActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String zero = "0";
    private static final String bar = "/";
    private static final String points = ":";

    public final Calendar c = Calendar.getInstance();

    final int hour = c.get(Calendar.HOUR_OF_DAY);
    final int minute = c.get(Calendar.MINUTE);

    final int month = c.get(Calendar.MONTH);
    final int day = c.get(Calendar.DAY_OF_MONTH);
    final int year = c.get(Calendar.YEAR);

    //Widgets
    EditText etDate, etTime;
    ImageButton ibGetTime, ibGetDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);
        ibGetTime = (ImageButton) findViewById(R.id.ib_get_time);
        ibGetTime.setOnClickListener(this);

        etTime = (EditText) findViewById(R.id.et_show_time_picker);
        category=findViewById(R.id.category);
        gender=findViewById(R.id.gender);
        league=findViewById(R.id.league);
    }

    private void getDate(){
        DatePickerDialog takeDate = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                final int monthActual = month + 1;
                String dayFormat = (dayOfMonth < 10)? zero + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String monthFormat = (monthActual < 10)? zero + String.valueOf(monthActual):String.valueOf(monthActual);
                etDate.setText(dayFormat + bar + monthFormat + bar + year);


            }
        },year, month, day);
        takeDate.show();

    }

    private void getTime(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String hourFormat =  (hourOfDay < 10)? String.valueOf(zero + hourOfDay) : String.valueOf(hourOfDay);
                String minuteFormat = (minute < 10)? String.valueOf(zero + minute):String.valueOf(minute);
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                etTime.setText(hourFormat + points + minuteFormat + " " + AM_PM);
            }
        }, hour, minute, false);

        recogerHora.show();
    }


    Spinner category, gender, league;
    Button next;
    EditText location;


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Runnable runnable = () -> {
            Intent i = new Intent(ActActivity.this, MenuActivity.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }

    @Override
    public void onClick(View v) {

    }
}
