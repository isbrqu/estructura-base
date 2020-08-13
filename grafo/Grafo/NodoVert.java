package grafo.Grafo;

public class NodoVert {

    private Object elemento;
    private NodoVert sigVertice;
    private NodoAdy primerAdy;

    public NodoVert(Object elemento, NodoVert sigVertice) {
        this.elemento = elemento;
        this.sigVertice = sigVertice;
        this.primerAdy = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }

    public void setSigVertice(NodoVert sigVertice) {
        this.sigVertice = sigVertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }

    public boolean esAdyacente(NodoVert vertice) {
        boolean exito = false;
        NodoAdy adyacente = this.primerAdy;
        while (adyacente != null && !exito) {
            exito = adyacente.getVertice() == vertice;
            adyacente = adyacente.getSigAdyacente();
        }
        return exito;
    }

    public boolean conectar(NodoVert vertice, int etiqueta) {
        this.primerAdy = new NodoAdy(vertice, this.primerAdy, etiqueta);
        if (this != vertice)
            vertice.primerAdy = new NodoAdy(this, vertice.primerAdy, etiqueta);
        return true;
    }

    public boolean desconectar(NodoVert vertice, int etiqueta) {
        boolean exito = false;
        NodoAdy anterior1 = this.primerAdy;
        NodoAdy anterior2 = vertice.primerAdy;
        if (anterior1 != null && anterior2 != null) {
            exito = true;
            NodoAdy actual1 = anterior1;
            NodoAdy actual2 = anterior2;
            boolean parar1 = actual1.equals(vertice, etiqueta);
            boolean parar2 = actual2.equals(vertice, etiqueta);
            while ((!parar1 || !parar2) && exito) {
                if (!parar1) {
                    actual1 = actual1.getSigAdyacente();
                    if (actual1 == null) {
                        exito = false;
                    } else {
                        parar1 = actual1.equals(vertice, etiqueta);
                        if (!parar1)
                            anterior1 = actual1;
                    }
                }
                if (!parar2) {
                    actual2 = actual2.getSigAdyacente();
                    if (actual2 == null) {
                        exito = false;
                    } else {
                        parar2 = actual2.equals(this, etiqueta);
                        if (!parar2)
                            anterior2 = actual2;
                    }
                }
            }
            if (exito) {
                anterior1.setSigVertice(anterior1.sigVertice().sigVertice());
                anterior2.setSigVertice(anterior2.sigVertice().sigVertice());
            }
        }
        return exito;
    }

}
