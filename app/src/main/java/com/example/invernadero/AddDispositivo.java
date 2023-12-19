package com.example.invernadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invernadero.controller.DispositivoController;
import com.example.invernadero.controller.PlantaController;

public class AddDispositivo extends AppCompatActivity {

    EditText etIdDisp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dispositivo);

        etIdDisp = findViewById(R.id.etIdDispositivo);

    }

    public void GuardarDispositivo(View view){
        String id = etIdDisp.getText().toString();


        DispositivoController.addDispositivo(id,"","","");
        Toast.makeText(this,DispositivoController.findDispositivo(id).getId(),Toast.LENGTH_SHORT).show();

    }

    public void irOpciones(View view) {
        finish();
        Intent irOpciones = new Intent(AddDispositivo.this, Opciones.class);
        startActivity(irOpciones);
    }
}