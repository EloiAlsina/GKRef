package cat.itb.gkref;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.datepicker.MaterialDatePicker;

public class ActActivity extends Fragment {

    private Button mPickTimeButton, next;
    private int tHour, tMinute;
    private TextView mShowSelectedDateText, mShowSelectedTimeText;
    private Spinner category, league, gender;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_act, container, false);

        category = root.findViewById(R.id.category);
        league = root.findViewById(R.id.league);
        gender = root.findViewById(R.id.gender);

        next =root.findViewById(R.id.next);
        Button mPickDateButton = root.findViewById(R.id.pick_date_button);
        mPickTimeButton=root.findViewById(R.id.pick_time_button);
        mShowSelectedDateText = root.findViewById(R.id.show_selected_date);
        mShowSelectedTimeText = root.findViewById(R.id.show_selected_time);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.league, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        league.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(getContext(), R.array.category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(getContext(), R.array.gender, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gender.setAdapter(adapter);

        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();

        materialDateBuilder.setTitleText("SELECT A DATE");

        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        mPickDateButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        materialDatePicker.show(getParentFragmentManager(), "MATERIAL_DATE_PICKER");
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
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_ActFragment_to_TeamsFragment);

            }
        });
        return root;
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

        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), onTimeSetListener, tHour, tMinute, false );
        timePickerDialog.setTitle("Select Time: ");
        timePickerDialog.show();
    }

}