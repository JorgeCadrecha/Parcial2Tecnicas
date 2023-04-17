package Battleship;

import java.util.HashMap;
public class HashBarcos {
    HashMap<String, HashMap<Integer, Barco>> tabla1 = new HashMap<>();
    HashMap<Integer, Barco> tabla2 = new HashMap<>();
    HashMap<String, Barco> tabla3 = new HashMap<>();

    private int hash1(String tipo) {
        int hash = tipo.hashCode();
        int indice = hash % (tabla1.size() + 1);
        return indice;
    }

    private int hash2(int numero) {
        int indice = numero % 15;
        return indice;
    }

    private int hash3(String nombre) {
        int hash = nombre.hashCode();
        int indice = hash % 15;
        return indice;
    }

    public void cargarTipoBarco(String tipo) {
        int indice = hash1(tipo);
        if (!tabla1.containsKey(tipo)) {
            tabla1.put(tipo, new HashMap<Integer, Barco>());
            System.out.println("Se ha creado una nueva tabla para el tipo de barco " + tipo);
        } else {
            System.out.println("La tabla para el tipo de barco " + tipo + " ya existe");
        }
    }
    public void cargarBarco(int numero, String nombre, String tipo) {
        Barco barco = new Barco(numero, nombre, tipo);
        int indice1 = hash1(tipo);
        int indice2_1 = hash2(numero);
        int indice2_2 = hash3(nombre);

        tabla2.put(numero, barco);
        tabla3.put(nombre, barco);
        tabla2.put(numero, barco);

        System.out.println("Se ha cargado el barco " + nombre + " en las tres tablas");
    }

    private class Barco {
        int numero;
        String nombre;
        String tipo;
        int nivel;

        public Barco(int numero, String nombre, String tipo) {
            this.numero = numero;
            this.nombre = nombre;
            this.tipo = tipo;
            this.nivel = nivel;
        }
    }
}


