package lineales.dinamicas;

public class Cola {

    private Nodo frente;
    private Nodo fin; 

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean esVacia() {
        return this.frente == null;
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    public Object obtenerFrente() {
        return (this.frente != null) ? this.frente.getElemento() : null;
    }

    public boolean poner(Object elemento) {
        Nodo nuevo = new Nodo(elemento, null);
        if (this.fin == null)
            this.frente = nuevo;
        else 
            this.fin.setEnlace(nuevo);
        this.fin = nuevo;
        return true;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.frente != null) {
            this.frente = this.frente.getEnlace();
            if (this.frente == null)
                this.fin = null;
            exito = true;
        }
        return exito;
    }

    public Cola clone() {
        Cola clon = new Cola();
        if (this.frente != null) {
            Nodo orig = this.frente;
            Nodo copia = new Nodo(orig.getElemento(), null);
            clon.frente = copia;
            orig = orig.getEnlace();
            while (orig != null) {
                copia.setEnlace(new Nodo(orig.getElemento(), null));
                copia = copia.getEnlace();
                orig = orig.getEnlace();
            }
            clon.fin = copia;
        }
        return clon;
    }

    public String toString() {
        String texto = "cola vacia";
        if (this.frente != null) {
            Nodo aux = this.frente;
            texto = "[";
            while (aux != null) {
                texto += aux.getElemento();
                aux = aux.getEnlace();
                if (aux != null)
                    texto += ", ";
            }
            texto += "]";
        }
        return texto;
    }

}
