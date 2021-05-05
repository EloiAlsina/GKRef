package cat.itb.gkref.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import cat.itb.gkref.R;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_launch);
        Runnable runnable = () -> {
            Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
            intent.putExtra("Start",true);
            startActivity(intent);
            finish();
        };
        new Handler().postDelayed(runnable,5000);
    }
}