package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cat.itb.gkref.R;

public class Part4Activity extends AppCompatActivity {
    private Button next;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part4);

        next=findViewById(R.id.game);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Part4Activity.this, GameActivity.class);
                startActivity(i);
                GameActivity.next4.setFocusable(false);
                GameActivity.screen=3;
                GameActivity.end_match.bringToFront();
                finish();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        Runnable runnable = () -> {
            Intent i = new Intent(Part4Activity.this, GameActivity.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }
}