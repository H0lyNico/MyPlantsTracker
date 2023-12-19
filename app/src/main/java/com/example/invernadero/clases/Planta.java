package com.example.invernadero.clases;

import com.example.invernadero.dispositivo.Dispositivo;

public class Planta {
    public String id;
    public String nombre;

    public Dispositivo dispositivo;

    public Planta(String id, String nombre, Dispositivo dispositivo) {
        this.id = id;
        this.nombre = nombre;
        this.dispositivo = dispositivo;
    }

    public Planta(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String toString(){
        return " Nombre: "+getNombre()+"\n"+" Temperatura: "+dispositivo.getTemperatura()+"°\n"+" Humedad: "+dispositivo.getHumedad()+"%\n"+" Iluminacion: "+dispositivo.getIluminacion();
    }
}