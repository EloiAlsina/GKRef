package cat.itb.gkref.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import cat.itb.gkref.R;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText email, password;
    FirebaseAuth firebaseAuth;
    MaterialButton login_button;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_editText);
        password = findViewById(R.id.password_editText);
        login_button = findViewById(R.id.login_button);
        autentification();

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigInUser();
                Log.i(TAG, "Fa clic");

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
                                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                                    startActivity(i);
                                    finish();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(LoginActivity.this,"Wrong email or password",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
            else {
                Toast.makeText(LoginActivity.this,"Please fill all the fields",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}