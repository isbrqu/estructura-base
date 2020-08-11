package grafo.Grafo;

import lineales.dinamicas.Lista;

public class Grafo {

    private NodoVert inicio;

    public Grafo() {
        this.inicio = null;
    }

    public boolean insertarVertice(Object elemento) {
        boolean exito = false;
        if (this.ubicarVertice(elemento) == null) {
            this.inicio = new NodoVert(elemento, this.inicio);
            exito = true;
        }
    }

    public boolean eliminarVertice(Object elemento) {
        //
    }

    public boolean insertarArco(Object origen, Object destino) {
        //
    }

    public boolean eliminarArco(Object origen, Object destino) {
        //
    }

    public boolean existeVertice(Object elemento) {
        //
    }

    public boolean existeArco(Object origen, Object destino) {
        //
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        // verifica si ambos vertices existen
        NodoVert auxOrigen = null;
        NodoVert auxDestino = null;
        NodoVert aux = this.inicio;
        Object elemento;
        while ((auxOrigen == null || auxDestino == null) && aux != null) {
            elemento = aux.getElemento();
            auxOrigen = (elemento.equals(origen)) ? aux : null;
            auxDestino = (elemento.equals(destino)) ? aux : null;
            aux = aux.getSigVertice();
        }
        if (auxOrigen != null && auxDestino != null) {
            // si ambos vertices existen busca si existe camino entre ambos
            Lista visitados = new Lista();
            exito = existeCaminoAux(auxOrigen, destino, visitados);
        }
        return exito;
    }

    public boolean existeCaminoAux(NodoVert nodo, Object destino, Lista visitados) {
        boolean exito = false;
        if (nodo != null) {
            // si vertice nodo es el destino: HAY CAMINO!
            Object elemento = nodo.getElemento();
            if (elemento.equals(destino)) {
                exito = true;
            } else {
                // si no es el destino verifica si hay camino entre nodo y destino
                visitados.insertar(elemento, 1);
                NodoAdy ady = nodo.getPrimerAdy();
                NodoVert vert;
                while (!exito && ady != null) {
                    vert = ady.getVertice();
                    if (vert.localizar(vert.getElemento()) < 0) {
                        exito = existeCaminoAux(vert, destino, visitados);
                    }
                    ady = ady.getSigAdyacente();
                }
            }
        }
        return exito;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        //
    }

    public Lista caminoMasLargo(Object origen, Object destino) {
        //
    }

    public Lista lisarEnProfundidad() {
        Lista visitados = new Lista();
        // define un vertice donde comenzar a recorrer
        NodoVert aux = this.inicio;
        while (aux != null) {
            // si el vertice no fue visitado aun, avanza en profundidad
            if (visitados.localizar(aux.getElemento()) < 0) {
                listarEnProfundidadAux(aux, visitados);
            }
            aux = aux.getSigVertice();
        }
        return visitados;
    }

    public void listarEnProfundidadAux(NodoVert nodo, Lista visitados) {
        if (nodo != null) {
            // marca el vertice nodo como visitado
            visitados.insertar(nodo.getElemento(), visitados.longitud() + 1);
            NodoAdy ady = nodo.getPrimerAdy();
            NodoVert vert;
            // visita en profundidad los adyacentes de nodo aun no visitados
            while (ady != null) {
                vert = ady.getVertice()
                if (visitados.localizar(vert.getElemento()) < 0) {
                    listarEnProfundidadAux(vert, visitados);
                }
                ady = ady.getSigAdyacente();
            }
        }
    }

    public Lista listarEnAnchura() {
        //
    }

    public boolean esVacio() {
        return this.inicio != null;
    }

    public Grafo clone() {
        //
    }

    public String toString() {
        //
    }

    public NodoVert ubicarVertice(Object elemento) {
        NodoVert aux = this.inicio;
        while (aux != null && !aux.getElemento().equals(elemento))
            aux = aux.getSigVertice();
        return aux;
    }

}
