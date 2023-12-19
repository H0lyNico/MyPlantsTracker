package com.example.invernadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void iniciologin(View v){
        finish();
        Intent ilogin = new Intent(MainActivity.this, Login.class);
        startActivity(ilogin);
    }

    public void irARegistro(View view){
        finish();
        Intent irRegistro = new Intent(MainActivity.this, Register.class);
        startActivity(irRegistro);
    }

}