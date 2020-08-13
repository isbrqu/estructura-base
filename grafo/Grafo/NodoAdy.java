package grafo.Grafo;

public class NodoAdy {

    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int etiqueta;

    public NodoAdy(NodoVert vertice, NodoAdy sigAdyacente, int etiqueta) {
        this.vertice = vertice;
        this.sigAdyacente = sigAdyacente;
        this.etiqueta = etiqueta;
    }

    public NodoVert getVertice() {
        return vertice;
    }

    public void setVertice(NodoVert vertice) {
        this.vertice = vertice;
    }

    public NodoAdy getSigAdyacente() {
        return sigAdyacente;
    }

    public void setSigAdyacente(NodoAdy sigAdyacente) {
        this.sigAdyacente = sigAdyacente;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

    public boolean equals(NodoVert vertice, int etiqueta) {
        return (this.vertice == vertice && this.etiqueta.equals(etiqueta));
    }

    public boolean conectado(NodoVert vertice, int etiqueta) {
        return (this.vertice == vertice && this.etiqueta.equals(etiqueta));
    }

}
