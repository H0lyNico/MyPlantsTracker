package com.example.invernadero;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Opciones extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);
    }

    public void IrAdd(View v){
        finish();
        Intent iAdd= new Intent(Opciones.this, AddPlanta.class);
        startActivity(iAdd);
    }

    public void IrListado(View v) {
        finish();
        Intent ilista = new Intent(Opciones.this, ListadoPlanta.class);
        startActivity(ilista);
    }

    public void IrLogin(View v){
        finish();
        Intent irLogin = new Intent(Opciones.this, Login.class);
        startActivity(irLogin);
    }

    public void IrAddDispositivo(View view){
        finish();
        Intent irAddDispositivo = new Intent(Opciones.this, AddDispositivo.class);
        startActivity(irAddDispositivo);
    }
}
