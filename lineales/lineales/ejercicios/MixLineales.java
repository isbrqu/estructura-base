package lineales.ejercicios;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class MixLineales {

    public static Cola generarOtraCola(Cola cola) {
        Cola mix = new Cola();
        if (!cola.esVacia()) {
            Cola clon = cola.clone();
            Pila pila = new Pila();
            Object caracter;
            clon.poner('$');
            while (!clon.esVacia()) {
                caracter = clon.obtenerFrente();
                clon.sacar();
                if (caracter.equals('$')) {
                    while (!pila.esVacia()) {
                        mix.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    if (!clon.esVacia())
                        mix.poner('$');
                } else {
                    mix.poner(caracter);
                    pila.apilar(caracter);
                }
            }
        }
        return mix;
    }

    public static Cola generarOtraColaTriple(Cola cola) {
        Cola mix = new Cola();
        if (!cola.esVacia()) {
            Cola clon = cola.clone();
            Pila pila = new Pila();
            Cola aux = new Cola();
            Object caracter;
            clon.poner('$');
            while (!clon.esVacia()) {
                caracter = clon.obtenerFrente();
                if (caracter.equals('$')) {
                    while (!pila.esVacia()) {
                        mix.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    while (!aux.esVacia()) {
                        mix.poner(aux.obtenerFrente());
                        aux.sacar();
                    }
                    if (!clon.esVacia())
                        mix.poner('$');
                } else {
                    mix.poner(caracter);
                    pila.apilar(caracter);
                    aux.poner(caracter);
                }
                clon.sacar();
            }
        }
        return mix;
    }

    public static boolean verificarBalanceo(Cola q) {
        Cola clon = q.clone();
        Pila pila = new Pila();
        String elemento;
        Object tope;
        boolean hayBalance = true;
        while (!clon.esVacia() && hayBalance) {
            elemento = Character.toString((char) clon.obtenerFrente());
            if ("([{".contains(elemento)) {
                pila.apilar(elemento);
            } else if (")]}".contains(elemento)) {
                if (pila.esVacia()) {
                    hayBalance = false;
                } else {
                    tope = pila.obtenerTope();
                    hayBalance =
                            (tope.equals("(") && elemento.equals(")")) ||
                            (tope.equals("[") && elemento.equals("]")) ||
                            (tope.equals("{") && elemento.equals("}"));
                    pila.desapilar();
                }
            }
            clon.sacar();
        }
        return hayBalance;
    }

    public static void generarCola(Cola cola, String texto) {
        cola.vaciar();
        for (int i = 0; i < texto.length(); i++) 
            cola.poner(texto.charAt(i));
    }

    public static void caso(Cola cola, String texto) {
        generarCola(cola, texto);
        System.out.println("texto: " + texto);
        System.out.println("cola: " + cola);
        Cola mix = generarOtraColaTriple(cola);
        System.out.println("mixCola: " + mix + "\n");
    }

    public static void casoBalance(Cola cola, String texto) {
        generarCola(cola, texto);
        System.out.println("texto: " + texto);
        System.out.println("cola: " + cola);
        System.out.println("hay balance? " + verificarBalanceo(cola));
    }

    public static void main(String[] args) {
        Cola cola = new Cola();
        System.out.println("test generarOtraCola");
        caso(cola, "");
        caso(cola, "A");
        caso(cola, "A$B");
        caso(cola, "A$BA$B");
        caso(cola, "A$B$C$D$E$F");
        caso(cola, "AB$C$DEF");
        System.out.println("test verificarBalance");
        casoBalance(cola, "{5+[8*9-(4/2)+7]-1}");
        casoBalance(cola, "{ 5 + [ 8 * 9 -( 4 / 2  + 7 ] -1 }");
        casoBalance(cola, "{ 5 + [ 8 * 9 -( 4 / 2  + 7 ] )-1 }");
        casoBalance(cola, "){ 5 + [ 8 * 9 -( 4 / 2 ) + 7 ] -1 }");
        casoBalance(cola, "{ 5} + [ 8 * 9 -( 4 / 2 ) + 7 ] -1 }");
    }

}
