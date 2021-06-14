package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Part1 extends Fragment {
    private Button next;
    private TextView local_players, visitor_players;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.part1, container, false);

        local_players = root.findViewById(R.id.local_players);
        visitor_players = root.findViewById(R.id.visitor_players);

        next = root.findViewById(R.id.game);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), GameActivity.class);
                startActivity(i);
            }
        });
        return root;
    }
}