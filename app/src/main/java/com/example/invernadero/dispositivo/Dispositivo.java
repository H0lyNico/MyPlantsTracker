package com.example.invernadero.dispositivo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.invernadero.R;
import com.example.invernadero.clases.Planta;

public class Dispositivo {

    String id;

    String humedad;

    String temperatura;

    String iluminacion;

    public Dispositivo(String id, String humedad, String temperatura, String iluminacion){
        this.id = id;
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.iluminacion = iluminacion;
    }

    public Dispositivo(){

    }



    public Dispositivo(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHumedad() {
        return humedad;
    }

    public void setHumedad(String humedad) {
        this.humedad = humedad;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getIluminacion() {
        return iluminacion;
    }

    public void setIluminacion(String iluminacion) {
        this.iluminacion = iluminacion;
    }
}