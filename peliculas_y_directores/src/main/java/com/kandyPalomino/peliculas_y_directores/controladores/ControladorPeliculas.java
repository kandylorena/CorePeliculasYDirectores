package com.kandyPalomino.peliculas_y_directores.controladores;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {

    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");	
    }

    @GetMapping("/peliculas")
    public String obtenerTodasLasPeliculas() {
        String peliculas = "";
        for(String pelicula : listaPeliculas.keySet()){
            String director = listaPeliculas.get(pelicula);
            peliculas += pelicula + " " + director + "<br>";
        }

        return peliculas;
    }

    @GetMapping("/peliculas/{nombre}")
    public String obtenerPeliculas(@PathVariable String nombre) {
        for (String pelicula : listaPeliculas.keySet()) {
            if (pelicula.equalsIgnoreCase(nombre)) {
                String director = listaPeliculas.get(pelicula);
                return "Pelicula: " + pelicula + " Director: " + director;
            }
        }
        return "Pelicula no encontrada";
    }

    @GetMapping("/peliculas/director/{nombre}")

    public String obtenerPeliculasPorDirector(@PathVariable String nombre) {
        String resultado = "";
        boolean encontrado = false;
        for (String pelicula : listaPeliculas.keySet()) {
            String director = listaPeliculas.get(pelicula);
            if (director.equalsIgnoreCase(nombre)) {
                resultado += "Pelicula: " + pelicula + " Director: " + director + "<br>";
                encontrado = true;
            }
        }
        if (!encontrado) {
            return "No se encontraron peliculas para el director: " + nombre;
            
        }
        return"Peliculas de " + nombre + ":<br>" + resultado;
    }


}
