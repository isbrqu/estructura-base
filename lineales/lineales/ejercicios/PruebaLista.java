package lineales.ejercicios;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;
import lineales.dinamicas.Cola;

public class PruebaLista {

    public static Lista concatenar(Lista l1, Lista l2) {
        int len1 = l1.longitud();
        int len2 = l2.longitud();
        Lista l3 = l1.clone();
        for (int i = 1; i <= len2; i++) {
            l3.insertar(l2.recuperar(i), len1 + i);
        }
        return l3;
    }

    public static boolean comprobar(Lista lista) {
        boolean valido = true, seguir = true;
        int i = 0, fin = 0;
        Pila pila = new Pila();
        Cola cola = new Cola();
        int len = lista.longitud();
        Object elemento;
        for (i = 1; i <= len && valido; i++) {
            elemento = lista.recuperar(i);
            if (seguir) {
                seguir = (elemento.equals(0)) ? !cola.poner(elemento) : cola.poner(elemento);
                fin++;
            } 
            pila.apilar(elemento);
        }
        i = 1;
        len -= fin;
        while (i <= len && valido) {
            elemento = cola.obtenerFrente();
            if (i <= fin) {
                valido = pila.obtenerTope().equals(elemento);
                pila.desapilar();
            }
            valido = lista.recuperar(i).equals(elemento) && valido;
            cola.sacar();
            cola.poner(elemento);
            i++;
        }
        return valido;
    }

    public static void llenar(Lista lista, int[] arr) {
        lista.vaciar();
        for (int i = 0; i < arr.length; i++) 
            lista.insertar(arr[i], i + 1);
    }

    public static Lista invertir(Lista lista) {
        Lista invertido = new Lista();
        int len = lista.longitud();
        for (int i = 1; i <= len; i++)
            invertido.insertar(lista.recuperar(i), 1);
        return invertido;
    }

    public static Lista intercalar(Lista l1, Lista l2) {
        Lista l3;
        if (l1.longitud() > 0) {
            int pos;
            int len = l2.longitud();
            Object elemento;
            l3 = l1.clone();
            for (int i = 1; i <= len; i++) {
                elemento = l2.recuperar(i);
                pos = i * 2;
                if (pos <= l3.longitud() + 1) {
                    l3.insertar(elemento, pos);				
                } else {
                    l3.insertar(elemento, l3.longitud());
                }
            }
        } else {
            l3 = l2.clone();
        }
        return l3;
    }

    public static int contarIterativo(Lista lista, Object x) {
        int cont = 0;
        int len = lista.longitud();
        for (int i = 1; i <= len; i++) {
            if (lista.recuperar(i).equals(x))
                cont++;
        }
        return cont;
    }

    public static int contarRecursivo(Lista lista, Object x) {
        return contarRecursivo(lista, x, 1);
    }

    public static int contarRecursivo(Lista lista, Object x, int i) {
        int cont = 0;
        if (i <= lista.longitud()) {
            if (lista.recuperar(i).equals(x))
                cont = contarRecursivo(lista, x, i + 1) + 1;
            else
                cont = contarRecursivo(lista, x, i + 1);
        }
        return cont;
    }

    public static void main(String[] args) {
        Lista l1 = new Lista();
        Lista l2 = new Lista();
        int[] arr1 = {1, 1, 1, 1};
        int[] arr2 = {};
        llenar(l1, arr1);
        llenar(l2, arr2);
        System.out.println("Lista 1: " + l1);
        System.out.println("Lista 2: " + l2);
        System.out.println("Interca: " + l1.intercalar(l2));
    }

}