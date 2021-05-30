package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Selection;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.firebase.database.DatabaseReference;

import java.sql.Time;
import java.util.Calendar;
import java.util.Locale;

import cat.itb.gkref.R;

;

public class ActActivity extends AppCompatActivity {

    private Button mPickTimeButton, next;
    private int tHour, tMinute;
    private TextView mShowSelectedDateText, mShowSelectedTimeText;
    private Spinner category, league, gender;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        category = findViewById(R.id.category);
        league = findViewById(R.id.league);
        gender = findViewById(R.id.gender);

        next =findViewById(R.id.next);
        Button mPickDateButton = findViewById(R.id.pick_date_button);
        mPickTimeButton=findViewById(R.id.pick_time_button);
        mShowSelectedDateText = findViewById(R.id.show_selected_date);
        mShowSelectedTimeText = findViewById(R.id.show_selected_time);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.league, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        league.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        mPickDateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDatePicker.show(getSupportFragmentManager(), "MATERIAL_DATE_PICKER");
                    }
                });

        materialDatePicker.addOnPositiveButtonClickListener(
                selection -> {

                    mShowSelectedDateText.setText( materialDatePicker.getHeaderText());
                });

        mPickTimeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popTimePicker(v);
                    }
    });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActActivity.this, TeamsActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void popTimePicker(View view){
        TimePickerDialog.OnTimeSetListener onTimeSetListener=new TimePickerDialog.OnTimeSetListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                tHour=selectedHour;
                tMinute=selectedMinute;
                boolean isPM = (tHour >= 12);

                mShowSelectedTimeText.setText(String.format("%02d:%02d %s", (tHour == 12 || tHour == 0) ? 12 : tHour % 12, tMinute, isPM ? "PM" : "AM"));            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, tHour, tMinute, false );
        timePickerDialog.setTitle("Select Time: ");
        timePickerDialog.show();
    }

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

}
