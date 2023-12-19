package com.example.invernadero.controller;

import com.example.invernadero.dispositivo.Dispositivo;

import java.util.ArrayList;
import java.util.Objects;

public class DispositivoController {

    private static ArrayList<Dispositivo> listaDipositivo = new ArrayList<>();

    //Create ADD
    public static String addDispositivo (String id,String humedad,String temperatura,String iluminacion) {
        try {
            Dispositivo d = new Dispositivo(id, humedad, temperatura, iluminacion);
            listaDipositivo.add(d);
            return "Dispositivo Agregado";
        }catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }
    public static void addDispositivo (String id) {
        try {
            Dispositivo d = new Dispositivo(id);
            listaDipositivo.add(d);
        }catch (Exception e){
            e.getMessage();
        }
    }

    //READ --FIND ALL
    public static ArrayList<Dispositivo> findAll(){return listaDipositivo;}

    //READ --FIND

    public static Dispositivo findDispositivo(String id){
        for (Dispositivo d: listaDipositivo){
            if (d.getId().equalsIgnoreCase(id)){
                return d;
            }
        }
        return null;
    }
}
