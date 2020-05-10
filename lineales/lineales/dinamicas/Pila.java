package lineales.dinamicas;

public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Object obtenerTope() {
        return (this.tope != null) ? this.tope.getElemento() : null;
    }

    public boolean apilar(Object elemento) {
        this.tope = new Nodo(elemento, this.tope);
        return true;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (this.tope != null) {
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Pila clone() {
        Pila clon = new Pila();
        if (this.tope != null) {
            Nodo orig = this.tope;
            Nodo copia = new Nodo(orig.getElemento(), null);
            clon.tope = copia;
            orig = orig.getEnlace();
            while (orig != null) {
                copia.setEnlace(new Nodo(orig.getElemento(), null));
                copia = copia.getEnlace();
                orig = orig.getEnlace();
            }
        }
        return clon;
    }

    public String toString() {
        String s = "Pila vacia";
        if (this.tope != null) {
            Nodo aux = this.tope;
            s = "[";
            while (aux != null) {
                s += aux.getElemento().toString();
                aux = aux.getEnlace();
                if (aux != null)
                    s += ", ";
            }
            s += "]";
        }
        return s;
    }

    public Pila cloneR() {
        Pila clon = new Pila();
        if (this.tope != null) {
            Nodo orig = this.tope;
            Nodo copia = new Nodo(orig.getElemento(), null);
            this.cloneR(copia, orig.getEnlace());
            clon.tope = copia;
        }
        return clon;
    }

    private void cloneR(Nodo copia, Nodo orig) {
        if (orig != null) {
            copia.setEnlace(new Nodo(orig.getElemento(), null));
            this.cloneR(copia, orig.getEnlace());
        }
    }



}
