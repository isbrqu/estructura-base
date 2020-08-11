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
        return exito;
    }

    private NodoVert ubicarVertice(Object elemento) {
        NodoVert vertice = this.inicio;
        while (vertice != null && !vertice.getElemento().equals(elemento))
            vertice = vertice.getSigVertice();
        return vertice;
    }

    public boolean eliminarVertice(Object elemento) {
        //
        return false;
    }

    public boolean insertarArco(Object origen, Object destino) {
        //
        return false;
    }

    public boolean eliminarArco(Object origen, Object destino) {
        //
        return false;
    }

    public boolean existeVertice(Object elemento) {
        //
        return false;
    }

    public boolean existeArco(Object origen, Object destino) {
        //
        return false;
    }

    public boolean existeCamino(Object origen, Object destino) {
        boolean exito = false;
        // verifica si ambos vertices existen
        NodoVert vertice = this.inicio;
        NodoVert verticeOrigen = null;
        NodoVert verticeDestino = null;
        Object elemento;
        while ((verticeOrigen == null || verticeDestino == null) && vertice != null) {
            elemento = vertice.getElemento();
            verticeOrigen = (elemento.equals(origen)) ? vertice : null;
            verticeDestino = (elemento.equals(destino)) ? vertice : null;
            vertice = vertice.getSigVertice();
        }
        if (verticeOrigen != null && verticeDestino != null) {
            // si ambos vertices existen busca si existe camino entre ambos
            Lista visitados = new Lista();
            exito = existeCaminoAux(verticeOrigen, destino, visitados);
        }
        return exito;
    }

    public boolean existeCaminoAux(NodoVert origen, Object destino, Lista visitados) {
        boolean exito = false;
        if (origen != null) {
            // si vertice origen es el destino: HAY CAMINO!
            Object elemento = origen.getElemento();
            if (elemento.equals(destino)) {
                exito = true;
            } else {
                // si no es el destino verifica si hay camino entre origen y destino
                visitados.insertar(elemento, 1);
                NodoAdy adyacente = origen.getPrimerAdy();
                NodoVert vertice;
                while (!exito && adyacente != null) {
                    vertice = adyacente.getVertice();
                    if (visitados.localizar(vertice.getElemento()) < 0) {
                        exito = existeCaminoAux(vertice, destino, visitados);
                    }
                    adyacente = adyacente.getSigAdyacente();
                }
            }
        }
        return exito;
    }

    public Lista caminoMasCorto(Object origen, Object destino) {
        //
        return new Lista();
    }

    public Lista caminoMasLargo(Object origen, Object destino) {
        //
        return new Lista();
    }

    public Lista lisarEnProfundidad() {
        Lista visitados = new Lista();
        // define un vertice donde comenzar a recorrer
        NodoVert vertice = this.inicio;
        while (vertice != null) {
            // si el vertice no fue visitado aun, avanza en profundidad
            if (visitados.localizar(vertice.getElemento()) < 0)
                listarEnProfundidadAux(vertice, visitados);
            vertice = vertice.getSigVertice();
        }
        return visitados;
    }

    public void listarEnProfundidadAux(NodoVert origen, Lista visitados) {
        if (origen != null) {
            // marca el vertice origen como visitado
            visitados.insertar(origen.getElemento(), visitados.longitud() + 1);
            NodoAdy adyacente = origen.getPrimerAdy();
            NodoVert vertice;
            // visita en profundidad los adyacentes de origen aun no visitados
            while (adyacente != null) {
                vertice = adyacente.getVertice();
                if (visitados.localizar(vertice.getElemento()) < 0) {
                    listarEnProfundidadAux(vertice, visitados);
                }
                adyacente = adyacente.getSigAdyacente();
            }
        }
    }

    public Lista listarEnAnchura() {
        //
        return new Lista();
    }

    public boolean esVacio() {
        return this.inicio != null;
    }

    public Grafo clone() {
        //
        return new Grafo();
    }

    public String toString() {
        String texto = "grafo vacio";
        if (this.inicio != null) {
            texto = "";
            NodoVert vertice = this.inicio;
            NodoAdy adyacente;
            while (vertice != null) {
                texto += vertice.getElemento() + ":";
                adyacente = vertice.getPrimerAdy();
                if (adyacente == null) {
                    texto += " sin adyacentes\n";
                } else {
                    texto += "\n";
                    while (adyacente != null) {
                        texto += "\t" + adyacente.getEtiqueta() + " --> " + adyacente.getVertice().getElemento() + "\n";
                        adyacente = adyacente.getSigAdyacente();
                    }
                }
                vertice = vertice.getSigVertice();
            }
        }
        return texto;
    }

    public void llenar(int[] arreglo) {
        for (int i : arreglo) {
            this.insertarVertice(i);
        }
    }

}
