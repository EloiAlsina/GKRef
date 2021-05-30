package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import cat.itb.gkref.R;
import cat.itb.gkref.Activities.GameActivity;


public class Part1Activity extends AppCompatActivity {
    private Button next;
    private TextView local_players, visitor_players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part1);
        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        local_players=findViewById(R.id.local_players);
        visitor_players=findViewById(R.id.visitor_players);

        next=findViewById(R.id.game);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Part1Activity.this, GameActivity.class);
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
            Intent i = new Intent(Part1Activity.this, GameActivity.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }
}