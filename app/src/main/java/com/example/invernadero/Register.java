package com.example.invernadero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText etUsuario, etCorreo, etPassword;
    FirebaseAuth fbAuth;
    FirebaseDatabase fbdb;
    DatabaseReference dbrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fbdb = FirebaseDatabase.getInstance();
        dbrf = fbdb.getReference();
        fbAuth = FirebaseAuth.getInstance();

        etUsuario = findViewById(R.id.etUsuario);
        etCorreo = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);
    }

    public void registrarUsuario(View view){
        String userName = etUsuario.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String pass = etPassword.getText().toString().trim();
        
        if (userName.isEmpty() && correo.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (userName.isEmpty() && correo.isEmpty()) {
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (correo.isEmpty() && pass.isEmpty()) {
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (userName.isEmpty() && pass.isEmpty()){
            Toast.makeText(this, "Complete todos los datos", Toast.LENGTH_SHORT).show();
        } else if (pass.length()<3){
            Toast.makeText(this, "La contraseña debe tener como minimo 8 caracteres", Toast.LENGTH_SHORT).show();
        } else {
            registrarUsuariofb(userName,correo,pass);
        }
    }

    public void registrarUsuariofb(String userName, String correo, String pass) {
        fbAuth.createUserWithEmailAndPassword(correo,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = fbAuth.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("name",userName);
                map.put("email",correo);
                map.put("password",pass);

                dbrf.child("user").child(id).setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        Intent iLogin = new Intent(Register.this,Login.class);
                        startActivity(iLogin);

                        Toast.makeText(Register.this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Register.this, "error 2", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Register.this, "error 1", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void irAMain(View view){
        finish();
        Intent iLogin = new Intent(Register.this,MainActivity.class);
        startActivity(iLogin);
    }


}