package grafo.Grafo;

public class NodoAdy {

    private NodoVert vertice;
    private NodoAdy sigAdyacente;
    private int etiqueta;

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
        this.sigAdyacente = sigAdyacente
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    public int setEtiqueta(int etiqueta) {
        this.etiqueta = etiqueta;
    }

}
