package jerarquicas.ArbolBin;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;
import lineales.dinamicas.Pila;

public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        preordenAux(this.raiz, lista);
        return lista;
    }

    private void preordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            preordenAux(nodo.getDerecho(), lista);
            preordenAux(nodo.getIzquierdo(), lista);
            lista.insertar(nodo.getElemento(), 1);
        }
    }

    public Lista listarInorden() {
        Lista lista = new Lista();
        inordenAux(this.raiz, lista);
        return lista;
    }

    private void inordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            inordenAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemento(), 1);
            inordenAux(nodo.getIzquierdo(), lista);
        }
    }

    public Lista listarPosorden() {
        Lista lista = new Lista();
        posordenAux(this.raiz, lista);
        return lista;
    }

    private void posordenAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            lista.insertar(nodo.getElemento(), 1);
            posordenAux(nodo.getDerecho(), lista);
            posordenAux(nodo.getIzquierdo(), lista);
        }
    }

    public Lista niveles() {
        Cola cola = new Cola();
        Pila pila = new Pila();
        Lista lista = new Lista();
        cola.poner(this.raiz);
        NodoArbol nodo;
        while (cola.obtenerFrente() != null) {
            nodo = (NodoArbol) cola.obtenerFrente();
            cola.sacar();
            pila.apilar(nodo.getElemento());
            if (nodo.getIzquierdo() != null)
                cola.poner(nodo.getIzquierdo());
            if (nodo.getDerecho() != null)
                cola.poner(nodo.getDerecho());
        }
        while (pila.obtenerTope() != null) {
            lista.insertar(pila.obtenerTope(), 1);
            pila.desapilar();
        }
        return lista;
    }

    public boolean insertar(Object elementoNuevo, Object elementoPadre, char lugar) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoArbol(elementoNuevo);
        } else {
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elementoPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new NodoArbol(elementoNuevo));
                } else if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new NodoArbol(elementoNuevo));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoArbol obtenerNodo(NodoArbol nodo, Object elemento) {
        NodoArbol result = null;
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento) && (nodo.getIzquierdo() == null || nodo.getDerecho() == null)) {
                result = nodo;
            } else {
                result = this.obtenerNodo(nodo.getIzquierdo(), elemento);
                if (result == null)
                    result = this.obtenerNodo(nodo.getDerecho(), elemento);
            }
        }
        return result;
    }

    public int altura() {
        return alturaAux(this.raiz,  -1);
    }

    private int alturaAux(NodoArbol nodo, int altura) {
        if (nodo != null) {
            int n1 = alturaAux(nodo.getIzquierdo(), altura + 1);
            int n2 = alturaAux(nodo.getDerecho(), altura + 1);
            altura = (n1 > n2) ? n1 : n2;
        }
        return altura;
    }

    public int nivel(Object elemento) {
        return nivelAux(elemento, this.raiz, -1);
    }

    private int nivelAux(Object elemento, NodoArbol nodo, int nivel) {
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                nivel = 0;
            } else {
                nivel = nivelAux(elemento, nodo.getIzquierdo(), nivel);
                if (nivel != -1) {
                    nivel++;
                } else {
                    nivel = nivelAux(elemento, nodo.getDerecho(), nivel);
                    if (nivel != -1)
                        nivel++;
                }
            }
        }
        return nivel;
    }

    public Object padre(Object elemento) {
        return (this.raiz == null || this.raiz.getElemento().equals(elemento)) ?
        null : padreAux(this.raiz, elemento);
    }

    private Object padreAux(NodoArbol nodo, Object elemento) {
        Object res = null;
        if (nodo != null) {
            NodoArbol izq = nodo.getIzquierdo();
            NodoArbol der = nodo.getDerecho();
            if ((izq != null && izq.getElemento().equals(elemento)) || (der != null && der.getElemento().equals(elemento))) {
                res = nodo.getElemento();
            } else {
                res = padreAux(nodo.getIzquierdo(), elemento);
                if (res == null)
                    res = padreAux(nodo.getDerecho(), elemento);
            }
        }
        return res;
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoArbol cloneAux(NodoArbol orig) {
        return (orig == null) ? null : new NodoArbol(orig.getElemento(), cloneAux(orig.getIzquierdo()), cloneAux(orig.getDerecho()));
    }

    public String toString() {
        return (this.raiz != null) ?
        toStringAux(this.raiz, "") : "Arbol Vacio";
    }

    public String toStringAux(NodoArbol nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoArbol izq = nodo.getIzquierdo();
            NodoArbol der = nodo.getDerecho();
            s += "HI: " + ((izq != null) ? izq.getElemento() : "-") + "\t"
            + "HD: " + ((der != null) ? der.getElemento() : "-");
            s = toStringAux(izq, s);
            s = toStringAux(der, s);
        }
        return s;
    }

    public Lista frontera() {
        Lista lista = new Lista();
        fronteraAux(this.raiz, lista);
        return lista;
    }

    private void fronteraAux(NodoArbol nodo, Lista lista) {
        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                lista.insertar(nodo.getElemento(), 1);
            } else {
                fronteraAux(nodo.getDerecho(), lista);
                fronteraAux(nodo.getIzquierdo(), lista);
            }
        }
    }

    // metodo pedido
    public Lista ancestros(Object elemento) {
        Lista lista = new Lista();
        ancestrosAux(this.raiz, lista, elemento);
        // dependiendo de la salida que se desea se invierte o no
        lista.invertir();
        return lista;
    }

    public boolean ancestrosAux(NodoArbol nodo, Lista lista, Object elemento) {
        boolean encontrado = false;
        if (nodo != null) {
            if (nodo.getElemento().equals(elemento)) {
                encontrado = true;
            } else if (ancestrosAux(nodo.getIzquierdo(), lista, elemento) || ancestrosAux(nodo.getDerecho(), lista, elemento)) {
                // verifica si se encuentra a la izquierda, aprovecho el corto circuito para en caso de que este, no se busque
                // caso contraria se ejecutara el siguiente llamado recursivo
                // la condicion diria de forma coloquial: se encuentra a la izquierda o a la derecha del nodo actual?
                lista.insertar(nodo.getElemento(), 1);
                encontrado = true;
            }
        }
        return encontrado;
    }

}
