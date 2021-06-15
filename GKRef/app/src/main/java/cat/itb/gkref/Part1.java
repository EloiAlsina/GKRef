package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Part1 extends Fragment {
    private Button next;
    FirebaseFirestore players_rootRef = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.part1, container, false);



        //-------------------------------------------------------------------------------------------
        List<String> part_local_players_string = new ArrayList<>();

        CollectionReference local_playersRef = players_rootRef.collection("teams").document("FCB").collection("Players");
        Spinner part_local_players = (Spinner) root.findViewById(R.id.part_local_players);
        ArrayAdapter<String> part_local_players_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, part_local_players_string);
        part_local_players_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        part_local_players.setAdapter(part_local_players_adapter);
        local_playersRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        part_local_players_string.add(name);
                    }
                    part_local_players_adapter.notifyDataSetChanged();
                }
            }
        });

        //-------------------------------------------------------------------------------------------
        List<String> visitor_players_string = new ArrayList<>();

        CollectionReference visitor_playersRef = players_rootRef.collection("teams").document("CHSEP").collection("Players");
        Spinner visitor_players = (Spinner) root.findViewById(R.id.part_visitor_players);
        ArrayAdapter<String> part_visitor_players_adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, visitor_players_string);
        part_visitor_players_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        visitor_players.setAdapter(part_visitor_players_adapter);
        visitor_playersRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {

            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        String name = document.getString("Name");
                        visitor_players_string.add(name);
                    }
                    part_visitor_players_adapter.notifyDataSetChanged();
                }
            }
        });

        next = root.findViewById(R.id.game);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_part1_to_game);

            }
        });
        return root;
    }
}