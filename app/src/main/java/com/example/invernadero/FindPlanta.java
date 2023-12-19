package com.example.invernadero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.invernadero.clases.Planta;

import java.util.ArrayList;

public class FindPlanta extends AppCompatActivity {
    String nombre,temperatura,humedad,iluminacion, editID, idDispositivo;
    TextView nombrePlanta, temperaturaPlanta, humedadPlanta, iluminacionPlanta;
    ArrayList<Planta> lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_planta);


        nombrePlanta = findViewById(R.id.plDatos);
        humedadPlanta = findViewById(R.id.pl_humedadtxt);
        temperaturaPlanta = findViewById(R.id.pl_temperaturatxt);
        iluminacionPlanta = findViewById(R.id.pl_iluminaciontxt);


        cargar();


    }

    public void cargar(){
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            nombre = bundle.getString("nombre");
            temperatura = bundle.getString("temperatura");
            humedad = bundle.getString("humedad");
            iluminacion = bundle.getString("iluminacion");
            editID = bundle.getString("id");
            idDispositivo = bundle.getString("Id Dispositivo");


            nombrePlanta.setText(nombre);
            temperaturaPlanta.setText(temperatura + "C°");
            humedadPlanta.setText(humedad +" %");
            iluminacionPlanta.setText(iluminacion);
        }
    }
    public void editarPlanta(View v){
        finish();
        Intent ePlanta = new Intent(FindPlanta.this, editar_planta.class);
        ePlanta.putExtra("nombre",nombre);
        ePlanta.putExtra("id",editID);
        ePlanta.putExtra("Id Dispositivo", idDispositivo);
        startActivity(ePlanta);
    }

    public void irListado(View v){
        finish();
        Intent irListado = new Intent(FindPlanta.this, ListadoPlanta.class);
        startActivity(irListado);
    }


}