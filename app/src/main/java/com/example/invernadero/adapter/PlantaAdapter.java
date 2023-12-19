package com.example.invernadero.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.invernadero.R;
import com.example.invernadero.clases.Planta;
import com.example.invernadero.controller.PlantaController;

import org.w3c.dom.Text;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class PlantaAdapter extends BaseAdapter {

    Context context;
    List<Planta> lst;

    public PlantaAdapter(Context context, List<Planta> lst) {
        this.context = context;
        this.lst = lst;

    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView TextViewNombre;
        TextView TextViewHumedad;
        TextView TextViewTemperatura;
        TextView TextViewIluminacion;

        Planta p=lst.get(i);

        if (view==null)
            view=LayoutInflater.from(context).inflate(R.layout.plantas,null);


        TextViewNombre=view.findViewById(R.id.textViewNombre);
        TextViewHumedad=view.findViewById(R.id.textViewHumedad);
        TextViewTemperatura=view.findViewById(R.id.textViewTemperatura);
        TextViewIluminacion=view.findViewById(R.id.textViewIluminacion);


        TextViewNombre.setText(p.nombre);
        TextViewHumedad.setText(p.dispositivo.getHumedad());
        TextViewTemperatura.setText(p.dispositivo.getTemperatura());
        TextViewIluminacion.setText(p.dispositivo.getIluminacion());

        return view;
    }
}