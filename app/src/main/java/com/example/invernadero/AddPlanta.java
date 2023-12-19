package com.example.invernadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invernadero.clases.Planta;
import com.example.invernadero.controller.DispositivoController;
import com.example.invernadero.controller.PlantaController;
import com.example.invernadero.dispositivo.Dispositivo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPlanta extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    EditText etId, etNombre, etIdDispositivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_planta);

        etId = findViewById(R.id.etId);
        etNombre = findViewById(R.id.etNombre);
        etIdDispositivo = findViewById(R.id.etIdDispositivo);


        iniciarFireBase();


    }

    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    public void GuardarPlanta(View view){
        String id = etId.getText().toString();
        String nombre = etNombre.getText().toString();
        String dispositivoID = etIdDispositivo.getText().toString();
        Dispositivo d = new Dispositivo(dispositivoID,"","","");
        Planta p = new Planta(id, nombre, d);

            databaseReference.child("Plantas").child(p.getId()).setValue(p);
            Toast.makeText(this, "Planta Agregada", Toast.LENGTH_SHORT).show();

            DispositivoController.addDispositivo(dispositivoID,"","","");

            //Toast.makeText(this,"No existe dispositivo",Toast.LENGTH_SHORT).show();

    }

    ///String nombre = String.valueOf(etNombre.getText());
    ///    PlantaController.addPlanta(1253,nombre);

    ///finish();
    ///Intent irListado = new Intent(AddPlanta.this, ListadoPlanta.class);
    ///startActivity(irListado);


    public void irOpciones(View v){
        finish();
        Intent irOpciones = new Intent(AddPlanta.this, Opciones.class);
        startActivity(irOpciones);
    }

}