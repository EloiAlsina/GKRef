package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cat.itb.gkref.R;

import static cat.itb.gkref.Activities.GameActivity.local_final_score4;
import static cat.itb.gkref.Activities.GameActivity.local_parts_result4;
import static cat.itb.gkref.Activities.GameActivity.visitor_final_score4;
import static cat.itb.gkref.Activities.GameActivity.visitor_parts_result4;

public class FinalActivity extends AppCompatActivity {
    private Button end_match;
    private TextView show_local_final_score, show_visitor_final_score, local_parts_result, visitor_parts_result;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        show_local_final_score=findViewById(R.id.show_local_final_score);
        show_visitor_final_score=findViewById(R.id.show_visitor_final_score);

        local_parts_result=findViewById(R.id.local_parts_result);
        visitor_parts_result=findViewById(R.id.visitor_parts_result);

        show_local_final_score.setText("" + local_final_score4+" goals");
        show_visitor_final_score.setText("" + visitor_final_score4+" goals");

        local_parts_result.setText("" + local_parts_result4+" points");
        visitor_parts_result.setText("" + visitor_parts_result4+" points");

        end_match=findViewById(R.id.end_match);

        end_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FinalActivity.this, MenuActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Runnable runnable = () -> {
            Intent i = new Intent(FinalActivity.this, GameActivity.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }
}
