package cat.itb.gkref.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import cat.itb.gkref.R;

public class LaunchActivity extends AppCompatActivity {
    private ImageView splash_backgroundImage;
    private TextView by;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        splash_backgroundImage=(ImageView) findViewById(R.id.splash_backgroundImage);
        by=(TextView) findViewById(R.id.by);
        Animation start = AnimationUtils.loadAnimation(this,R.anim.start);
        splash_backgroundImage.startAnimation(start);
        by.startAnimation(start);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Runnable runnable = () -> {
            Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
            intent.putExtra("Start",true);
            startActivity(intent);
            finish();
        };
        new Handler().postDelayed(runnable,5000);
    }
}