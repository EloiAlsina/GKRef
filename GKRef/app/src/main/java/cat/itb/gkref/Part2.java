package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Part2 extends Fragment {
    private Button next;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.part2, container, false);

        next = root.findViewById(R.id.game);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_part2_to_game);

                GameActivity.next2.setFocusable(false);
                GameActivity.screen=1;
                GameActivity.next3.bringToFront();
            }
        });
        return root;
    }
}