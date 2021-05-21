package cat.itb.gkref;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cat.itb.gkref.Activities.LoginActivity;
import cat.itb.gkref.Activities.MainActivity;
import cat.itb.gkref.Activities.MenuActivity;

public class TransitionFragment extends Fragment {

    public static Button login, start, logout;
    private static final int RC_SIGN_IN = 123;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase FirebaseDB;
    DatabaseReference myRef;
    String email;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_transition, container, false);
        FirebaseDB=FirebaseDatabase.getInstance();
        myRef=FirebaseDB.getReference("User");
        firebaseAuth = FirebaseAuth.getInstance();
        login = root.findViewById(R.id.login);
        start=root.findViewById(R.id.start);
        logout=root.findViewById(R.id.logout);
        logout.setVisibility(View.INVISIBLE);
        start.setVisibility(View.INVISIBLE);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email==null) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), MenuActivity.class);
                startActivity(intent);
                }
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MenuActivity.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });
        return root;
    }
}