package test;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class Utils {

    public static void llenar(Cola cola, String texto) {
        cola.vaciar();
        for (int i = 0; i < texto.length(); i++)
            cola.poner(texto.charAt(i));
    }

    public static void llenar(Cola cola, int[] arr) {
        cola.vaciar();
        for (int i = 0; i < arr.length; i++)
            cola.poner(arr[i]);
    }

    public static void llenar(Pila pila, String texto) {
        pila.vaciar();
        for (int i = 0; i < texto.length(); i++)
            pila.apilar(texto.charAt(i));
    }

    public static void llenar(Pila pila, int[] arr) {
        pila.vaciar();
        for (int i = 0; i < arr.length; i++)
            pila.apilar(arr[i]);
    }

    public static void llenar(Lista lista, String texto) {
        lista.vaciar();
        for (int i = 0; i < texto.length(); i++)
            lista.insertar(texto.charAt(i), i + 1);
    }

    public static void llenar(Lista lista, int[] arr) {
        lista.vaciar();
        for (int i = 0; i < arr.length; i++)
            lista.insertar(arr[i], i + 1);
    }

}
