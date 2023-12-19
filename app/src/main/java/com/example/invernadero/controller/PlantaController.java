package com.example.invernadero.controller;

import com.example.invernadero.clases.Planta;
import com.example.invernadero.dispositivo.Dispositivo;

import java.util.ArrayList;

public class PlantaController {
    private static ArrayList<Planta> listaPlanta = new ArrayList<>();

    //Create ADD
    public static String addPlanta (String id, String nombre, Dispositivo dispositivo) {

        try {
            Planta p = new Planta(id, nombre, dispositivo);
            listaPlanta.add(p);
            return "Planta Agregada";
        }catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }

    //READ --FIND ALL
    public static ArrayList<Planta> findAll(){ return listaPlanta; }

    /*READ --FIND*/
    public static Planta findPlanta(String id){

        for (Planta p: listaPlanta) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

}
