package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.firebase.auth.FirebaseAuth;

import cat.itb.gkref.Activities.LoginActivity;

public class TransitionFragment extends Fragment {

    private Button login;
    private static final int RC_SIGN_IN = 123;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_transition, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        login = root.findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }
        });

        if (firebaseAuth.getCurrentUser() != null) {
            String currentUser = firebaseAuth.getCurrentUser().getEmail();
            login.setVisibility(View.INVISIBLE);
        } else login.setVisibility(View.VISIBLE);

        return root;
    }
}