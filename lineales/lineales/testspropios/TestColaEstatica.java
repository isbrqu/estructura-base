package lineales.testspropios;

import lineales.estaticas.Cola;

public class TestColaEstatica {
    public static void main(String[] args) {
        Cola cola = new Cola();
        Cola clon;

        System.out.println("probando validacion de vacio y poner con sacar");
        System.out.println("¿cola vacia? " + cola.esVacia());
        cola.poner(0);
        System.out.println("apiló ¿cola vacia? " + cola.esVacia());
        cola.sacar();
        System.out.println("desapilo ¿cola vacia? " + cola.esVacia());
        System.out.println();

        System.out.println("probando vaciado");
        cola.vaciar();
        System.out.println("vació con vacio, " + cola);
        cola.poner(0);	cola.vaciar();
        System.out.println("vació con 0, " + cola);
        cola.poner(1); cola.poner(2); cola.vaciar();
        System.out.println("vació con 1 y 2, " + cola);
        cola.vaciar();
        System.out.println();

        System.out.println("probando poner extremo");
        for (int i = 0; i < 100; i++) cola.poner(i);
        System.out.println(cola);
        System.out.println();

        System.out.println("pobando sacar extremo");
        for (int i = 0; i < 100; i++) cola.sacar();
        System.out.println(cola);
        System.out.println();

        System.out.println("probando obtener tope");
        System.out.println("vació, " + cola.obtenerFrente());
        cola.poner(0);
        System.out.println("debe ser 0, " + cola.obtenerFrente());
        cola.sacar(); cola.poner(1); cola.poner(2);
        System.out.println("debe ser 2, " + cola.obtenerFrente());
        System.out.println();


        System.out.println("probando clonación");
        System.out.println();

        System.out.println("IC o NAO debil");
        cola.vaciar();
        System.out.println("orig: " + cola);
        clon = cola.clone();
        System.out.println("clon: " + clon);
        cola.poner(0);
        System.out.println("cambio en original");
        System.out.println("orig: " + cola);
        System.out.println("clon: " + clon);
        cola.poner(3);
        System.out.println("cambio en original");
        System.out.println();

        System.out.println("Clon vacio");
        cola.vaciar();
        clon = cola.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + cola);
        System.out.println();

        System.out.println("clon con 3");
        cola.poner(3);
        clon = cola.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + cola);
        System.out.println();

        System.out.println("clon con 3 y 4");
        cola.poner(4);
        clon = cola.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + cola);
        System.out.println();

        System.out.println("clon con 3, 4 y 5");
        cola.poner(5);
        clon = cola.clone();
        System.out.println("clon: " + clon);
        System.out.println("orig: " + cola);
        System.out.println();
    }
}
