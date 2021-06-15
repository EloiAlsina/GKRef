package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cat.itb.gkref.R;

public class LoginActivity extends Fragment {
    TextInputEditText email, password;
    FirebaseAuth firebaseAuth;
    MaterialButton login_button;
    public Button login, start, logout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_login, container, false);

        email = root.findViewById(R.id.email_editText);
        password = root.findViewById(R.id.password_editText);
        login_button = root.findViewById(R.id.login_button);
        login=root.findViewById(R.id.login);
        logout=root.findViewById(R.id.logout);
        start=root.findViewById(R.id.start);

        autentification();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigInUser();
            }
        });
        return root;
    }

    private void autentification() {
        firebaseAuth = FirebaseAuth.getInstance();

    }

    private void sigInUser(){
        try {
            if (!email.getText().toString().isEmpty() && !password.getText().toString().isEmpty()){
                if (firebaseAuth!=null){
                    firebaseAuth.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString())
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    NavHostFragment.findNavController(getParentFragment()).navigate(R.id.action_loginActivity_to_menu_history);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //Toast.makeText(LoginActivity.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            //else Toast.makeText(LoginActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            //Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}