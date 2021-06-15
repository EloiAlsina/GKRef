package cat.itb.gkref;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner visitor_team, local_players, visitor_players;
    private FirebaseDatabase mDatabase;
    private Button next;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_teams, container, false);

        FirebaseFirestore rootRef = FirebaseFirestore.getInstance();
        FirebaseFirestore players_rootRef = FirebaseFirestore.getInstance();
        FirebaseFirestore coach_rootRef = FirebaseFirestore.getInstance();


        //-------------------------------------------------------------------------------------------
        List<String> local_team_string = new ArrayList<>();

        CollectionReference local_teamRef = rootRef.collection("teams");

        Spinner local_team = (Spinner) root.findViewById(R.id.local_team);
        ArrayAdapter<String> local_team_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, local_team_string);
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

        Spinner visitor_team = (Spinner) root.findViewById(R.id.visitor_team);
        ArrayAdapter<String> visitor_team_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, visitor_team_string);
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

        //-------------------------------------------------------------------------------------------
        List<String> local_players_string = new ArrayList<>();

        CollectionReference local_playersRef = players_rootRef.collection("teams").document("FCB").collection("Players");
        Spinner local_players = (Spinner) root.findViewById(R.id.local_players);
        ArrayAdapter<String> local_players_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, local_players_string);
        local_players_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        local_players.setAdapter(local_players_adapter);
        local_playersRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        local_players_string.add(name);
                    }
                    local_players_adapter.notifyDataSetChanged();
                }
            }
        });

        //-------------------------------------------------------------------------------------------
        List<String> visitor_players_string = new ArrayList<>();

        CollectionReference visitor_playersRef = players_rootRef.collection("teams").document("CHSEP").collection("Players");
        Spinner visitor_players = (Spinner) root.findViewById(R.id.visitor_players);
        ArrayAdapter<String> visitor_players_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, visitor_players_string);
        visitor_players_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitor_players.setAdapter(visitor_players_adapter);
        visitor_playersRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        visitor_players_string.add(name);
                    }
                    visitor_players_adapter.notifyDataSetChanged();
                }
            }
        });

        //-------------------------------------------------------------------------------------------
        List<String> local_coach_string = new ArrayList<>();

        CollectionReference local_coachRef = players_rootRef.collection("teams").document("FCB").collection("Coach");
        Spinner local_coach = (Spinner) root.findViewById(R.id.local_coach);
        ArrayAdapter<String> local_coach_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, local_coach_string);
        local_coach_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        local_coach.setAdapter(local_coach_adapter);
        local_coachRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        local_coach_string.add(name);
                    }
                    local_coach_adapter.notifyDataSetChanged();
                }
            }
        });

        //-------------------------------------------------------------------------------------------
        List<String> visitor_coach_string = new ArrayList<>();

        CollectionReference visitor_coachRef = players_rootRef.collection("teams").document("CHSEP").collection("Coach");
        Spinner visitor_coach = (Spinner) root.findViewById(R.id.visitor_coach);
        ArrayAdapter<String> visitor_coach_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, visitor_coach_string);
        visitor_coach_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitor_coach.setAdapter(visitor_coach_adapter);
        visitor_coachRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        visitor_coach_string.add(name);
                    }
                    visitor_coach_adapter.notifyDataSetChanged();
                }
            }
        });

        local_players = root.findViewById(R.id.local_players);
        visitor_players = root.findViewById(R.id.visitor_players);

        next=root.findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_TeamsFragment_to_parts);

            }
        });
        return root;
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
