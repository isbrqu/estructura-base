package lineales.ejercicios;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class MixLineales {

    public static Cola generarOtraCola(Cola cola) {
        Cola mix = new Cola();
        if (!cola.esVacia()) {
            Cola clon = cola.clone();
            Pila pila = new Pila();
            char caracter;
            clon.poner('$');
            while (!clon.esVacia()) {
                caracter = (char) clon.obtenerFrente();
                clon.sacar();
                if (caracter != '$') {
                    mix.poner(caracter);
                    pila.apilar(caracter);
                } else {
                    while (!pila.esVacia()) {
                        mix.poner(pila.obtenerTope());
                        pila.desapilar();
                    }
                    if (!clon.esVacia())
                        mix.poner('$');
                }
            }
        }
        return mix;
    }

    public static Cola generarOtraCola2(Cola c1){
        Cola c2 = new Cola();
        Pila aux = new Pila();
        Object info;
        Cola colaclon = new Cola();
        colaclon = c1.clone();
        colaclon.poner('$');
        while (colaclon.obtenerFrente() != null){
            info = colaclon.obtenerFrente();
            if (!info.equals('$')){
                aux.apilar(info);
                c2.poner(info);
                colaclon.sacar();
            } else {
                while (aux.obtenerTope() != null){
                    c2.poner(aux.obtenerTope());
                    aux.desapilar(); 
                }
            }
            c2.poner(info);
            colaclon.sacar();
        }
        return c2;
    }

    public static void caso(Cola cola, String texto) {
        cola.vaciar();
        for (int i = 0; i < texto.length(); i++) 
            cola.poner(texto.charAt(i));
        System.out.println("texto: " + texto);
        System.out.println("cola: " + cola);
        Cola mix = generarOtraCola2(cola);
        System.out.println("mixCola: " + mix);
        System.out.println();
    }

    public static void main(String[] args) {
        Cola cola = new Cola();
        caso(cola, "");
        caso(cola, "A");
        caso(cola, "A$B");
        caso(cola, "A$BA$B");
        caso(cola, "A$B$C$D$E$F");
        caso(cola, "AB$C$DEF");
    }

}
