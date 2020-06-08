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
            if (elemento.compareTo(x) == 0) {
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
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximoElem() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    public String toString() {
        return (this.raiz != null) ? 
                toStringAux(this.raiz, "") : "Arbol Vacio";
    }

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
            if (elemento.compareTo(maximo) < 0) {
                listarRangoAux(nodo.getDerecho(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                lista.insertar(elemento, 1);
            }
            if (elemento.compareTo(minimo) > 0) {
                listarRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
            }
        }
    }

    public boolean eliminar(Comparable x) {
        return eliminarAux(this.raiz, null, x);
    }

    private boolean eliminarAux(NodoABB nodo, NodoABB padre, Comparable x) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            // System.out.print(elemento + ", ");
            if (elemento.equals(x)) {
                exito = eliminarNodo(nodo, padre, x);
            } else if (elemento.compareTo(x) > 0) {
                exito = eliminarAux(nodo.getIzquierdo(), nodo, x);
            } else {
                exito = eliminarAux(nodo.getDerecho(), nodo, x);
            }
        }
        return exito;
    }

    private boolean eliminarNodo(NodoABB nodo, NodoABB padre, Comparable x) {
        NodoABB izquierdo = nodo.getIzquierdo();
        NodoABB derecho = nodo.getDerecho();
        if (izquierdo == null && derecho == null) {
            eliminarHoja(nodo, padre);
        } else if (izquierdo != null && derecho != null) {
            eliminarConDosHijos(nodo);
        } else {
            eliminarConUnHijo(nodo, padre);
        }
        return true;
    }

    private void eliminarHoja(NodoABB hijo, NodoABB padre) {
        if (padre == null) {
            this.raiz = null;
        } else if (padre.getIzquierdo() == hijo) {
            padre.setIzquierdo(null);
        } else {
            padre.setDerecho(null);
        }
    }

    private void eliminarConUnHijo(NodoABB hijo, NodoABB padre) {
        NodoABB izquierdo = hijo.getIzquierdo();
        NodoABB derecho = hijo.getDerecho();
        if (padre == null) {
            this.raiz = (izquierdo != null) ? izquierdo : derecho;
        } else if (izquierdo != null) {
            padre.setIzquierdo(izquierdo);
        } else {
            padre.setDerecho(derecho);
        }
    }

    private void eliminarConDosHijos(NodoABB hijo) {
        NodoABB candidato = hijo.getDerecho();
        NodoABB padreCandidato = hijo;
        while (candidato.getIzquierdo() != null) {
            padreCandidato = candidato;
            candidato = candidato.getIzquierdo();
        }
        Comparable elemento = candidato.getElemento();
        Comparable elementoDerecho = candidato.getDerecho();
        if (hijo.getDerecho() == candidato) {
            hijo.setElemento(elemento);
            hijo.setDerecho(candidato.getDerecho());
        } else {
            hijo.setElemento(elemento);
            padreCandidato.setIzquierdo(candidato.getDerecho());
        }
    }

    public void llenar(int[] num) {
        for (int i = 0; i < num.length; i++) {
            insertar(num[i]);
        }
    }

}