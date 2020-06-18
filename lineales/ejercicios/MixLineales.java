package lineales.ejercicios;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.dinamicas.Pila;

public class MixLineales {

    public static Cola generarCola(Cola cola) {
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

    public static Cola generarColaTriple(Cola cola) {
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

    public static Lista generarSecuencia(Cola q, int t) {
        Cola cola = q.clone();
        Lista lista = new Lista();
        Object elemento;
        int ext = 1, i = 0, r = 1;
        while (!cola.esVacia()) {
            i += 2;
            elemento = cola.obtenerFrente();
            lista.insertar(elemento, r);
            lista.insertar(elemento, i);
            cola.sacar();
            if (ext % t == 0 && !cola.esVacia()) {
                i++;
                lista.insertar('$', i);
                r = i + 1;
            }
            ext++;
        }
        return lista;
    }

    public static Cola listaToCola(Lista orig, int t) {
        Lista lista = orig.clone();
        Cola cola = new Cola();
        Pila pila1 = new Pila();
        Pila pila2 = new Pila();
        Object elemento;
        int i = 1;
        while (!lista.esVacia()) {
            elemento = lista.recuperar(1);
            cola.poner(elemento);
            pila1.apilar(elemento);
            pila2.apilar(elemento);
            lista.eliminar(1);
            if (i % t == 0 || lista.esVacia()) {
                while (!pila1.esVacia()) {
                    cola.poner(pila1.obtenerTope());
                    pila1.desapilar();
                }
                while (!pila2.esVacia()) {
                    cola.poner(pila2.obtenerTope());
                    pila2.desapilar();
                }
                if (!lista.esVacia()) {
                    cola.poner('&');
                    cola.poner('&');
                }
            }
            i++;
        }
        return cola;
    }

    public static Lista generarSecuenciaExpress(Cola q, int t) {
        Cola cola = q.clone();
        Lista lista = new Lista();
        Pila pila = new Pila();
        Pila rever = new Pila();
        Object elemento;
        int i = 1;
        while (!cola.esVacia()) {
            pila.apilar(cola.obtenerFrente());
            cola.sacar();
            if (i % t == 0 && !cola.esVacia())
                pila.apilar('$');
            i++;
        }
        while (!pila.esVacia()) {
            elemento = pila.obtenerTope();
            if (elemento.equals('$')) {
                while (!rever.esVacia()) {
                    lista.insertar(rever.obtenerTope(), 1);
                    rever.desapilar();
                }
                lista.insertar('$', 1);
            } else {
                lista.insertar(elemento, 1);
                rever.apilar(elemento);
            }
            pila.desapilar();
        }
        while (!rever.esVacia()) {
            lista.insertar(rever.obtenerTope(), 1);
            rever.desapilar();
        }
        return lista;
    }

    public static boolean verificarBalanceo(Cola q) {
        Cola clon = q.clone();
        Pila pila = new Pila();
        String elemento;
        Object tope;
        boolean hayBalance = true;
        while (!clon.esVacia() && hayBalance) {
            // realizo conversion Object->char->String para poder utilizar contains
            elemento = Character.toString((char) clon.obtenerFrente());
            if ("([{".contains(elemento)) {
                if (!pila.esVacia()) {
                    tope = pila.obtenerTope();
                    hayBalance =
                            (tope.equals("(") && elemento.equals("(")) ||
                            (tope.equals("[") && !elemento.equals("{")) ||
                            tope.equals("{");
                }
                pila.apilar(elemento);
            } else if (")]}".contains(elemento)) {
                if (!pila.esVacia()) {
                    tope = pila.obtenerTope();
                    hayBalance =
                            (tope.equals("(") && elemento.equals(")")) ||
                            (tope.equals("[") && elemento.equals("]")) ||
                            (tope.equals("{") && elemento.equals("}"));
                    pila.desapilar();
                } else {
                    hayBalance = false;
                }
            }
            clon.sacar();
        }
        return hayBalance;
    }

}
