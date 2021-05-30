package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import cat.itb.gkref.R;
import cat.itb.gkref.models.Team;

public class TeamsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner visitor_team, local_players, visitor_players;
    private FirebaseDatabase mDatabase;
    private Button next;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();

        //-------------------------------------------------------------------------------------------
        List<String> local_team_string = new ArrayList<>();

        CollectionReference local_teamRef = rootRef.collection("teams");

        Spinner local_team = (Spinner) findViewById(R.id.local_team);
        ArrayAdapter<String> local_team_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, local_team_string);
        local_team_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        local_team.setAdapter(local_team_adapter);
        local_teamRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        local_team_string.add(name);
                    }
                    local_team_adapter.notifyDataSetChanged();
                }
            }
        });

        //-------------------------------------------------------------------------------------------

        List<String> visitor_team_string = new ArrayList<>();

        CollectionReference visitor_teamRef = rootRef.collection("teams");

        Spinner visitor_team = (Spinner) findViewById(R.id.visitor_team);
        ArrayAdapter<String> visitor_team_adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, visitor_team_string);
        visitor_team_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitor_team.setAdapter(visitor_team_adapter);
        visitor_teamRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        visitor_team_string.add(name);
                    }
                    visitor_team_adapter.notifyDataSetChanged();
                }
            }
        });

        local_players = findViewById(R.id.local_players);
        visitor_players = findViewById(R.id.visitor_players);

        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TeamsActivity.this, Part1Activity.class);
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
            Intent i = new Intent(TeamsActivity.this, ActActivity.class);
            startActivity(i);
            finish();
        };
        new Handler().postDelayed(runnable,5);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
