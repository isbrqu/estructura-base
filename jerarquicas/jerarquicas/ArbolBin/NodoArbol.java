package jerarquicas.ArbolBin;

public class NodoArbol {

    private Object elemento;
    private NodoArbol izquierdo;
    private NodoArbol derecho;

    public NodoArbol(Object elemento, NodoArbol izquierdo, NodoArbol derecho) {
        this.elemento = elemento;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public NodoArbol(Object elemento) {
        this(elemento, null, null);
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }	

}
