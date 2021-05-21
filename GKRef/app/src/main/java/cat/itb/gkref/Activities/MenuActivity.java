package cat.itb.gkref.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import cat.itb.gkref.R;
import cat.itb.gkref.TransitionFragment;

public class MenuActivity extends AppCompatActivity {
    Button newact, history;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    newact=findViewById(R.id.newact);
    history=findViewById(R.id.history);

    newact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(MenuActivity.this, ActActivity.class);
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
            Intent i = new Intent(MenuActivity.this, TransitionFragment.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }

}
