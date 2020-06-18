package jerarquicas.ArbolGen;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;

public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public boolean insertar(Object nuevo, Object padre) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoGen(nuevo);
        } else {
            NodoGen nodoPadre = obtenerNodo(this.raiz, padre);
            if (nodoPadre != null) {
                NodoGen nodoHijo = nodoPadre.getHijoIzquierdo();
                NodoGen nodoNuevo = new NodoGen(nuevo);
                if (nodoHijo != null) {
                    while (nodoHijo.getHermanoDerecho() != null)
                        nodoHijo = nodoHijo.getHermanoDerecho();
                    nodoHijo.setHermanoDerecho(nodoNuevo);
                } else {
                    nodoPadre.setHijoIzquierdo(nodoNuevo);
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen nodo, Object elemento) {
        NodoGen res = null;
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                res = nodo;
            } else {
                res = obtenerNodo(nodo.getHijoIzquierdo(), elemento);
                if (res == null)
                    res = obtenerNodo(nodo.getHermanoDerecho(), elemento);
            }
        }
        return res;
    }

    public boolean pertenece(Object elemento) {
        return perteneceAux(this.raiz, elemento);
    }

    private boolean perteneceAux(NodoGen nodo, Object elemento) {
        boolean pertenece = false;
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                pertenece = true;
            } else {
                pertenece = perteneceAux(nodo.getHijoIzquierdo(), elemento);
                if (!pertenece)
                    pertenece = perteneceAux(nodo.getHermanoDerecho(), elemento);
            }
        }
        return pertenece;
    }

    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        ancestrosAux(this.raiz, lista, elemento);
        // invierto la lista debido a la que se inserta siempre en 1
        lista.invertir();
        return lista;
    }
    
    private boolean ancestrosAux(NodoGen nodo, Lista lista, Object elemento) {
        boolean encontrado = false;
        if (nodo != null){
            if (nodo.getElemento().equals(elemento)) {
                encontrado = true;
            } else {
                NodoGen hijo = nodo.getHijoIzquierdo();
                while (hijo != null && !encontrado) {
                    encontrado = ancestrosAux(hijo, lista, elemento);
                    hijo = hijo.getHermanoDerecho();
                }
                if (encontrado)
                    lista.insertar(nodo.getElemento(), 1);
            }
        }
        return encontrado;
    }

    private boolean ancestrosAuxx(NodoGen nodo, Lista lista, Object elemento) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                encontrado = true;
            } else {
                encontrado = ancestrosAux(nodo.getHijoIzquierdo(), lista, elemento);
                if (encontrado) {
                    lista.insertar(nodo.getElemento(), 1);
                } else {
                    encontrado = ancestrosAux(nodo.getHermanoDerecho(), lista, elemento);
                }
            }
        }
        return encontrado;
    }

    public int altura() {
        return alturaAux(this.raiz, -1);
    }

    private int alturaAux(NodoGen nodo, int altura) {
        if (nodo != null) {
            int n = alturaAux(nodo.getHijoIzquierdo(), altura + 1);
            int m = alturaAux(nodo.getHermanoDerecho(), altura);
            altura = (n > m) ? n : m;
        }
        return altura;
    }

    public int nivel(Object elemento) {
        return nivelAux(this.raiz, elemento, -1);
    }

    public int nivelAux(NodoGen nodo, Object elemento, int nivel) {
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                nivel++;
            } else {
                nivel = nivelAux(nodo.getHijoIzquierdo(), elemento, nivel);
                nivel = (nivel != -1) ? (nivel + 1) : nivelAux(nodo.getHermanoDerecho(), elemento, nivel);
            }
        }
        return nivel;
    }

    public Object padre(Object elemento) {
        return (this.raiz == null || this.raiz.getElemento().equals(elemento)) ? 
                null : padreAux(this.raiz, elemento);
    }

    private Object padreAux(NodoGen nodo, Object elemento) {
        Object res = null;
        if (nodo != null) {
            NodoGen sig = nodo.getHijoIzquierdo();
            while (sig != null && !sig.getElemento().equals(elemento))
                sig = sig.getHermanoDerecho();
            if (sig != null) {
                res = nodo.getElemento();
            } else {
                res = padreAux(nodo.getHijoIzquierdo(), elemento);
                if (res == null)
                    res = padreAux(nodo.getHermanoDerecho(), elemento);
            }
        }
        return res;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        listarPreordenAux(this.raiz, lista);
        return lista;
    }

    private void listarPreordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            listarPreordenAux(nodo.getHermanoDerecho(), lista);
            listarPreordenAux(nodo.getHijoIzquierdo(), lista);
            lista.insertar(nodo.getElemento(), 1);
        }
    }

    public Lista listarInorden() {
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            NodoGen hijoIzquierdo = nodo.getHijoIzquierdo();
            if (hijoIzquierdo != null)
                listarInordenAux(hijoIzquierdo, lista);
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
            if (hijoIzquierdo != null) {
                NodoGen hijo = hijoIzquierdo.getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, lista);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        // soy de O(n) si insertas simpre en 1 y de orden mayor si insertas en longitud + 1
        listarPosordenAux(this.raiz, lista);
        // soy de O(n)
        // return lista.invertir();
        return lista;
    }

    private void listarPosordenAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                listarPosordenAux(hijo, lista);
                hijo = hijo.getHermanoDerecho();
            }
            // soy de O(1)
            // lista.insertar(nodo.getElemento(), 1);
            // soy de o(n), n = cant. de elementos en el momento
            lista.insertar(nodo.getElemento(), lista.longitud() + 1);
        }
    }

    public Lista listarNiveles() {
        Lista lista = new Lista();
        if (this.raiz != null) {
            Cola cola = new Cola();
            NodoGen nodo, hijo;
            cola.poner(this.raiz);
            while (!cola.esVacia()) {
                nodo = (NodoGen) cola.obtenerFrente();
                lista.insertar(nodo.getElemento(), 1);
                cola.sacar();
                hijo = nodo.getHijoIzquierdo(); 
                while (hijo != null) {
                    cola.poner(hijo);
                    hijo = hijo.getHermanoDerecho();
                }
            }
            lista.invertir();
        }
        return lista;
    }

    public ArbolGen clone() {
        ArbolGen clon = new ArbolGen();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoGen cloneAux(NodoGen orig) {
        return (orig == null) ? null : new NodoGen(orig.getElemento(), cloneAux(orig.getHijoIzquierdo()), cloneAux(orig.getHermanoDerecho()));
    }

    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen nodo) {
        String s = "Arbol Vacio"; // sera inicializado siempre, aunque nunca sera retornado para un hijo
        if (nodo != null) {
            s = nodo.getElemento().toString() + " -> ";
            NodoGen hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElemento().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }
            hijo = nodo.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }
        }
        return s;
    }

    public boolean verificarPatron(Lista lista) {
        return verificarPatronAux(this.raiz, lista, 1);
    }

    private boolean verificarPatronAux(NodoGen nodo, Lista lista, int pos) {
        boolean exito = false;
        if (nodo != null) {
            Object elemento = lista.recuperar(pos);
            if (nodo.getElemento().equals(elemento)) {
                // pregunta si llego al final, sino es así continua buscando hacia abajo
                exito = (lista.longitud() == pos) ? true : verificarPatronAux(nodo.getHijoIzquierdo(), lista, pos + 1);
            } else {
                exito = verificarPatronAux(nodo.getHermanoDerecho(), lista, pos);
            }
        }
        return exito;
    }

    public Lista frontera() {
        Lista lista = new Lista();
        fronteraAux(this.raiz, lista);
        lista.invertir();
        return lista;
    }

    private void fronteraAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            if (nodo.getHijoIzquierdo() == null) {
                lista.insertar(nodo.getElemento(), 1);
            } else {
                fronteraAux(nodo.getHijoIzquierdo(), lista);
            }
            fronteraAux(nodo.getHermanoDerecho(), lista);
        }
    }

    // ocupa mucha memoria, modificar
    public Lista caminoLargo() {
        return caminoLargoAux(this.raiz, new Lista());
    }

    private Lista caminoLargoAux(NodoGen nodo, Lista lista) {
        if (nodo != null) {
            Lista n = caminoLargoAux(nodo.getHijoIzquierdo(), new Lista());
            Lista m = caminoLargoAux(nodo.getHermanoDerecho(), new Lista());
            n.insertar(nodo.getElemento(), 1);
            lista = (n.longitud() > m.longitud()) ? n : m;
        }
        return lista;
    }

}
