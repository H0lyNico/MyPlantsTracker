package com.example.invernadero;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText etEmail, etPass;
    FirebaseAuth fbAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        fbAuth = FirebaseAuth.getInstance();
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
    }

    public void setup(View view){
        String correo = etEmail.getText().toString().trim();
        String pass = etPass.getText().toString().trim();
        if (!correo.isEmpty() && !pass.isEmpty()){
            loginUser(correo, pass);
        } else {
            Toast.makeText(this, "Debe ingresar ambas datos", Toast.LENGTH_SHORT).show();
        }
    }

    public void loginUser(String correo, String pass){
        fbAuth.signInWithEmailAndPassword(correo, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    finish();
                    Intent iHome = new Intent(Login.this, Opciones.class);
                    startActivity(iHome);
                    Toast.makeText(Login.this, "Bienvenid@", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Login.this, "Error al iniciar sesion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void irARegistro(View view){
        finish();
        Intent iRegister = new Intent(Login.this, Register.class);
        startActivity(iRegister);
    }

    public void IrOpciones(View v) {
        finish();
        Intent iopciones = new Intent(Login.this, Opciones.class);
        startActivity(iopciones);
    }

    public void IraMain(View v){
        finish();
        Intent irMain = new Intent(Login.this, MainActivity.class);
        startActivity(irMain);
    }
}
