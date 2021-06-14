package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import cat.itb.gkref.R;
import cat.itb.gkref.TransitionFragment;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        TransitionFragment.login.setVisibility(View.INVISIBLE);
        TransitionFragment.logout.setVisibility(View.VISIBLE);
        TransitionFragment.start.setVisibility(View.VISIBLE);



        return root;
    }


}
