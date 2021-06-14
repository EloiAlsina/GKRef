package cat.itb.gkref.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cat.itb.gkref.MenuFragment;
import cat.itb.gkref.R;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email, password;
    FirebaseAuth firebaseAuth;
    MaterialButton login_button;
    public Button login, start, logout;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_editText);
        password = findViewById(R.id.password_editText);
        login_button = findViewById(R.id.login_button);
        login=findViewById(R.id.login);
        logout=findViewById(R.id.logout);
        start=findViewById(R.id.start);


        autentification();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigInUser();
            }
        });
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
                                    setContentView(R.layout.activity_menu);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            else Toast.makeText(LoginActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}