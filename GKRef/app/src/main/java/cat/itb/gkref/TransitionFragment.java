package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

import cat.itb.gkref.Activities.LoginActivity;
import cat.itb.gkref.Activities.MainActivity;
import cat.itb.gkref.Activities.MenuActivity;

public class TransitionFragment extends Fragment {

    private Button login, start, logout;
    private static final int RC_SIGN_IN = 123;
    FirebaseAuth firebaseAuth;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_transition, container, false);
        firebaseAuth = FirebaseAuth.getInstance();
        login = root.findViewById(R.id.login);
        start=root.findViewById(R.id.start);
        logout=root.findViewById(R.id.logout);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        if (firebaseAuth.getCurrentUser() != null) {
            String currentUser = firebaseAuth.getCurrentUser().getEmail();
            login.setVisibility(View.INVISIBLE);
            logout.setVisibility(View.VISIBLE);
            start.setVisibility(View.VISIBLE);

        } else
            login.setVisibility(View.VISIBLE);
            logout.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);
        return root;
    }
}