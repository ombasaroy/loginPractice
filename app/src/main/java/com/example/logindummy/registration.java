package com.example.logindummy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registration extends AppCompatActivity {
    private EditText email,password;
    private Button register;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.etRegEmail);
        password = findViewById(R.id.etRegPassword);
        register = findViewById(R.id.btnRegister);

        firebaseAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser(email.getText().toString().toLowerCase().trim(),password.getText().toString().trim());

            }
        });


    }
    private void createUser(String email2, String password2){
//        String email2 = email.getText().toString().toLowerCase().trim();
//        String password2 = password.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(email2,password2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isComplete()) {
                    Toast.makeText(registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(registration.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
