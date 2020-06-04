package lineales.testspropios;

import lineales.estaticas.Pila;

public class TestPilaEstatica {

    public static void main(String[] args) {
        Pila pila = new Pila();
        Pila clon;

        System.out.println("probando validacion de vacio y apilamiento con desapilamiento");
        System.out.println("¿pila vacia? " + pila.esVacia());
        pila.apilar(0);
        System.out.println("apiló ¿pila vacia? " + pila.esVacia());
        pila.desapilar();
        System.out.println("desapilo ¿pila vacia? " + pila.esVacia());
        System.out.println();

        System.out.println("probando vaciado");
        pila.vaciar();
        System.out.println("vació con vacio, " + pila);
        pila.apilar(0);	pila.vaciar();
        System.out.println("vació con 0, " + pila);
        pila.apilar(1); pila.apilar(2); pila.vaciar();
        System.out.println("vació con 1 y 2, " + pila);
        pila.vaciar();
        System.out.println();

        System.out.println("probando apilado extremo");
        for (int i = 0; i < 100; i++) pila.apilar(i);
        System.out.println(pila);
        System.out.println();

        System.out.println("pobando desapilado extremo");
        for (int i = 0; i < 100; i++) pila.desapilar();
        System.out.println(pila);
        System.out.println();

        System.out.println("probando obtener tope");
        System.out.println("vació, " + pila.obtenerTope());
        pila.apilar(0);
        System.out.println("debe ser 0, " + pila.obtenerTope());
        pila.desapilar(); pila.apilar(1); pila.apilar(2);
        System.out.println("debe ser 2, " + pila.obtenerTope());
        System.out.println();


        System.out.println("probando clonación");
        System.out.println();

        System.out.println("IC o NAO debil");
        pila.vaciar();
        System.out.println("orig: " + pila);
        clon = pila.clone();
        System.out.println("clon: " + clon);
        pila.apilar(0);
        System.out.println("cambio en original");
        System.out.println("orig: " + pila);
        System.out.println("clon: " + clon);
        pila.apilar(3);
        System.out.println("cambio en original");
        System.out.println();

        System.out.println("Clon vacio");
        pila.vaciar();
        clon = pila.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + pila);
        System.out.println();

        System.out.println("clon con 3");
        pila.apilar(3);
        clon = pila.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + pila);
        System.out.println();

        System.out.println("clon con 3 y 4");
        pila.apilar(4);
        clon = pila.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + pila);
        System.out.println();

        System.out.println("clon con 3, 4 y 5");
        pila.apilar(5);
        clon = pila.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + pila);
        System.out.println();

    }

}
