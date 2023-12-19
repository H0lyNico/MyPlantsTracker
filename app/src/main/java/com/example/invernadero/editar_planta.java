package com.example.invernadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.invernadero.clases.Planta;
import com.example.invernadero.controller.DispositivoController;
import com.example.invernadero.controller.PlantaController;
import com.example.invernadero.dispositivo.Dispositivo;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class editar_planta extends AppCompatActivity {
    String idPlanta;
    String nombre, idDispositivo;
    EditText EditNombre;
    Planta p;
    ArrayList<Planta> lst;

    FirebaseDatabase fbdb;
    DatabaseReference dbrf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_planta);
        lst = PlantaController.findAll();

        EditNombre = findViewById(R.id.txtNomPlanta2);
        iniciarFireBase();
        cargar();


    }

    public void cargar(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            nombre = bundle.getString("nombre");
            idPlanta = bundle.getString("id");
            idDispositivo = bundle.getString("Id Dispositivo");
            Dispositivo d = new Dispositivo(idDispositivo,"","","");
            Planta p = new Planta();
            p.setId(idPlanta);
            p.setNombre(nombre);
            p.setDispositivo(d);

            dbrf.child("Plantas").child(idPlanta).setValue(p);
            Toast.makeText(this, "llego", Toast.LENGTH_SHORT).show();
            //EditNombre.setText(nombre);
            //p = lst.get(idPlanta);

        }
    }

    public void GuardarNombre(View view) {

        String nuevoNombre = String.valueOf(EditNombre.getText());
        PlantaController.findPlanta(p.getId()).setNombre(nuevoNombre);

        finish();
        Intent irListado = new Intent(editar_planta.this, ListadoPlanta.class);
        startActivity(irListado);
    }

    public void IrListado(View v){
        finish();
        Intent irListado = new Intent(editar_planta.this, ListadoPlanta.class);
        startActivity(irListado);
    }

    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        fbdb = FirebaseDatabase.getInstance();
        dbrf = fbdb.getReference();
    }
}