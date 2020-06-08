package conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;

public class ArbolBB {

    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    public boolean insertarAux(NodoABB nodo, Comparable elemento) {
        // precondicion: nodo no es nulo
        boolean exito = true;
        if (elemento.compareTo(nodo.getElemento()) == 0) {
            // reportar error: elemento repetido
            exito = false;
        } else if (elemento.compareTo(nodo.getElemento()) < 0) {
            // elemento es menor que nodo.getElemento()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if (nodo.getIzquierdo() != null) {
                exito = insertarAux(nodo.getIzquierdo(), elemento);
            } else {
                nodo.setIzquierdo(new NodoABB(elemento));
            }
        } else if (nodo.getDerecho() != null) {
            // elemento es mayor que nodo.getElemento()
            // si tiene HD baja a la derecha, sino agrega elemento
            exito = insertarAux(nodo.getDerecho(), elemento);
        } else {
            nodo.setDerecho(new NodoABB(elemento));
        }
        return exito;
    }

    public Lista listar() {
        Lista lista = new Lista();
        listarAux(this.raiz, lista);
        return lista;
    }

    public void listarAux(NodoABB nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemento(), 1);
            listarAux(nodo.getIzquierdo(), lista);
        }
    }

    public boolean pertenece(Comparable x) {
        boolean pertenece = false;
        NodoABB nodo = this.raiz;
        Comparable elemento;
        while (nodo != null && !pertenece) {
            elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                pertenece = true;
            } else if (elemento.compareTo(x) > 0) {
                nodo = nodo.getIzquierdo();
            } else if (elemento.compareTo(x) < 0) {
                nodo = nodo.getDerecho();
            }
        }
        return pertenece;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public Comparable minimoElem() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        // bajada por la izquierda
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximoElem() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        // bajada por la derecha
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    // copiado de arbol binario
    public String toString() {
        return (this.raiz != null) ? 
                toStringAux(this.raiz, "") : "Arbol Vacio";
    }

    // copiado de arbol binario
    private String toStringAux(NodoABB nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            s += "HI: " + ((izquierdo != null) ? izquierdo.getElemento() : "-") + "\t" 
                    + "HD: " + ((derecho != null) ? derecho.getElemento() : "-");
            s = toStringAux(nodo.getIzquierdo(), s);
            s = toStringAux(nodo.getDerecho(), s);
        }
        return s;
    }

    public Lista listarRango(int minimo, int maximo) {
        Lista lista = new Lista();
        listarRangoAux(this.raiz, lista, minimo, maximo);
        return lista;
    }

    private void listarRangoAux(NodoABB nodo, Lista lista, int minimo, int maximo) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(maximo) < 0)
                listarRangoAux(nodo.getDerecho(), lista, minimo, maximo);
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0)
                lista.insertar(elemento, 1);
            if (elemento.compareTo(minimo) > 0)
                listarRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
        }
    }

    public boolean eliminar(Comparable x) {
        return eliminarAux(this.raiz, null, x);
    }

    private boolean eliminarAux(NodoABB nodo, NodoABB padre, Comparable x) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                // elimina el nodo
                exito = eliminarNodo(nodo, padre, x);
            } else if (elemento.compareTo(x) > 0) {
                // desciende por la izquierda del arbol (es menor)
                exito = eliminarAux(nodo.getIzquierdo(), nodo, x);
            } else {
                // desciende por la derecha del arbol (es mayor)
                exito = eliminarAux(nodo.getDerecho(), nodo, x);
            }
        }
        return exito;
    }

    private boolean eliminarNodo(NodoABB nodo, NodoABB padre, Comparable x) {
        NodoABB izquierdo = nodo.getIzquierdo();
        NodoABB derecho = nodo.getDerecho();
        // determino el caso a eliminar
        if (izquierdo == null && derecho == null) {
            // elimino un nodo hoja (sin hijos)
            eliminarHoja(nodo, padre);
        } else if (izquierdo != null && derecho != null) {
            // elimino un nodo con dos hijos
            eliminarConDosHijos(nodo);
        } else {
            // elimino un nodo con un hijo, uno izquiedo o derecho, pero no ambos
            eliminarConUnHijo(nodo, padre);
        }
        return true;
    }

    // caso 1
    private void eliminarHoja(NodoABB hijo, NodoABB padre) {
        if (padre == null) {
            // caso especial un unico elemento
            this.raiz = null;
        } else if (padre.getIzquierdo() == hijo) {
            padre.setIzquierdo(null);
        } else {
            padre.setDerecho(null);
        }
    }

    // caso 2
    private void eliminarConUnHijo(NodoABB hijo, NodoABB padre) {
        NodoABB izquierdo = hijo.getIzquierdo();
        NodoABB derecho = hijo.getDerecho();
        if (padre == null) {
            // caso especial de la raiz con un hijo
            this.raiz = (izquierdo != null) ? izquierdo : derecho;
        } else if (izquierdo != null) {
            padre.setIzquierdo(izquierdo);
        } else {
            padre.setDerecho(derecho);
        }
    }

    // caso 3
    private void eliminarConDosHijos(NodoABB nodo) {
        NodoABB candidato = nodo.getDerecho();
        NodoABB padreCandidato = nodo;
        // obtengo el menor de los mayores (candidato)
        while (candidato.getIzquierdo() != null) {
            padreCandidato = candidato;
            candidato = candidato.getIzquierdo();
        }
        // remplazo el valor del nodo a eliminar por el valor del candidato
        nodo.setElemento(candidato.getElemento());
        // hijo pude ser null o no
        NodoABB hijoCandidato = candidato.getDerecho();
        // elimina el nodo
        // el candidato es el hijo derecho del nodo a eliminar?
        if (nodo.getDerecho() == candidato) {
            // caso especial, el candidato es hijo del nodo
            nodo.setDerecho(hijoCandidato);
        } else {
            // caso comun, el candidato no es hijo del nodo
            padreCandidato.setIzquierdo(hijoCandidato);
        }
    }

    // utilidad, no prestar antencion
    public void llenar(int[] num) {
        for (int i = 0; i < num.length; i++) {
            insertar(num[i]);
        }
    }

}