package com.example.invernadero;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.invernadero.adapter.PlantaAdapter;
import com.example.invernadero.clases.Planta;
import com.example.invernadero.controller.PlantaController;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class ListadoPlanta extends AppCompatActivity {

    ListView ListViewPlanta;

    FirebaseDatabase fbdb;

    DatabaseReference dbrf;

    private List<Planta> listPlanta = new ArrayList<Planta>() ;

    ArrayAdapter<Planta> adapter;

    Planta plantaSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listadoplanta);
        ListViewPlanta=findViewById(R.id.listaPlanta);
        iniciarFireBase();
        listarPlantas();



        ListViewPlanta.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                plantaSeleccionado = (Planta) adapterView.getItemAtPosition(i);
                Intent findPlanta = new Intent(ListadoPlanta.this, FindPlanta.class);

                findPlanta.putExtra("id",i);
                findPlanta.putExtra("nombre",plantaSeleccionado.getNombre());
                findPlanta.putExtra("humedad",plantaSeleccionado.dispositivo.getHumedad());
                findPlanta.putExtra("temperatura",plantaSeleccionado.dispositivo.getTemperatura());
                findPlanta.putExtra("iluminacion",plantaSeleccionado.dispositivo.getIluminacion());
                findPlanta.putExtra("Id Dispositivo",plantaSeleccionado.dispositivo.getId());

                startActivity(findPlanta);
            }
        });
    }

    public void  listarPlantas(){
        dbrf.child("Plantas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPlanta.clear();
                for (DataSnapshot item : snapshot.getChildren()){
                    try {
                        Planta p = item.getValue(Planta.class);
                        //String id = item.getValue()
                        listPlanta.add(p);

                    }catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(ListadoPlanta.this,e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                adapter = new ArrayAdapter<Planta>(ListadoPlanta.this,
                        android.R.layout.simple_list_item_1, listPlanta);
                ListViewPlanta.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    //Botones
    public void irOpciones(View v){
        finish();
        Intent irOpciones = new Intent(ListadoPlanta.this, Opciones.class);
        startActivity(irOpciones);
    }

    public void iniciarFireBase(){
        FirebaseApp.initializeApp(this);
        fbdb = FirebaseDatabase.getInstance();
        dbrf = fbdb.getReference();
    }

}
