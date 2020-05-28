package test;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class Utils {

    public static void llenarCola(Cola cola, String texto) {
        cola.vaciar();
        for (int i = 0; i < texto.length(); i++)
            cola.poner(texto.charAt(i));
    }

    public static void llenarPila(Pila pila, String texto) {
        pila.vaciar();
        for (int i = 0; i < texto.length(); i++)
            pila.apilar(texto.charAt(i));
    }

    public static void llenarLista(Lista lista, String texto) {
        lista.vaciar();
        for (int i = 0; i < texto.length(); i++)
            lista.insertar(texto.charAt(i));
    }

}
