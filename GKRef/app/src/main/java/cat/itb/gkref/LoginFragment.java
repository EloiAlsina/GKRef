package cat.itb.gkref;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends AppCompatActivity {
    TextInputEditText emailET, passwordET;
    MaterialButton logIn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailET = findViewById(R.id.email_editText);
        passwordET = findViewById(R.id.password_editText);
        logIn_button = findViewById(R.id.login_button);

        logIn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sigInUser();
            }
        });
    }

    private void sigInUser() {
    }

}
