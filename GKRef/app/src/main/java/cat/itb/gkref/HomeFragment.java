package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import cat.itb.gkref.Activities.MainActivity;

public class HomeFragment extends Fragment {
    Button start;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View root = inflater.inflate(R.layout.fragment_home, container, false);

    start=root.findViewById(R.id.start);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity parentActivity = (MainActivity) getActivity();
                assert parentActivity != null;
                NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_HomeFragment_to_TransitionFragment);
            }
        });
        return root;
    }


}
