package conjuntistas.ArbolBB;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

public class ArbolBB {

    protected NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public void vaciar() {
        this.raiz = null;
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
            } else {
                nodo = nodo.getDerecho();
            }
        }
        return pertenece;
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
        if (elemento.equals(nodo.getElemento())) {
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

    private void listarAux(NodoABB nodo, Lista lista) {
        if (nodo != null) {
            listarAux(nodo.getDerecho(), lista);
            lista.insertar(nodo.getElemento(), 1);
            listarAux(nodo.getIzquierdo(), lista);
        }
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

    public Comparable minimo() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        // bajada por la izquierda
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getIzquierdo();
        }
        return elemento;
    }

    public Comparable maximo() {
        Comparable elemento = null;
        NodoABB nodo = this.raiz;
        // bajada por la derecha
        while (nodo != null) {
            elemento = nodo.getElemento();
            nodo = nodo.getDerecho();
        }
        return elemento;
    }

    public boolean eliminarMinimo() {
        boolean exito = false;
        if (this.raiz != null) {
            NodoABB padre = null;
            NodoABB hijo = this.raiz;
            while (hijo.getIzquierdo() != null) {
                padre = hijo;
                hijo = hijo.getIzquierdo();
            }
            if (padre == null) {
                this.raiz = hijo.getDerecho();
            } else {
                padre.setIzquierdo(hijo.getDerecho());
            }
            exito = true;
        }
        return exito;
    }

    public boolean eliminarMaximo() {
        boolean exito = false;
        if (this.raiz != null) {
            NodoABB padre = null;
            NodoABB hijo = this.raiz;
            while (hijo.getDerecho() != null) {
                padre = hijo;
                hijo = hijo.getDerecho();
            }
            if (padre == null) {
                this.raiz = hijo.getIzquierdo();
            } else {
                padre.setDerecho(hijo.getIzquierdo());
            }
            exito = true;
        }
        return exito;
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
                exito = eliminarNodo(nodo, padre);
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

    protected boolean eliminarNodo(NodoABB nodo, NodoABB padre) {
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
    protected void eliminarHoja(NodoABB hijo, NodoABB padre) {
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
        // determino el nodo que tiene que reemplazar al hijo
        NodoABB remplazo = (hijo.getIzquierdo() != null) ? hijo.getIzquierdo() : hijo.getDerecho();
        if (padre == null) {
            // caso especial de la raiz con un hijo
            this.raiz = remplazo;
        } else if (padre.getIzquierdo() == hijo) {
            padre.setIzquierdo(remplazo);
        } else {
            padre.setDerecho(remplazo);
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

    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
        clon.raiz = cloneAux(this.raiz);
        return clon;
    }

    private NodoABB cloneAux(NodoABB orig) {
        return (orig == null) ? null : new NodoABB(orig.getElemento(), cloneAux(orig.getIzquierdo()), cloneAux(orig.getDerecho()));
    }

    // copiado de arbol binario
    public String toString() {
        return (this.raiz != null) ? toStringAux(this.raiz, "") : "Arbol Vacío";
    }

    // copiado de arbol binario
    private String toStringAux(NodoABB nodo, String s) {
        if (nodo != null) {
            s += "\n" + nodo.getElemento() + "\t";
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            s += "HI: " + ((izquierdo != null) ? izquierdo.getElemento() : "-") + "\t"
               + "HD: " + ((derecho != null) ? derecho.getElemento() : "-");
            s = toStringAux(izquierdo, s);
            s = toStringAux(derecho, s);
        }
        return s;
    }

    public int altura() {
        return alturaAux(this.raiz,  -1);
    }

    private int alturaAux(NodoABB nodo, int altura) {
        if (nodo != null) {
            int n1 = alturaAux(nodo.getIzquierdo(), altura + 1);
            int n2 = alturaAux(nodo.getDerecho(), altura + 1);
            altura = (n1 > n2) ? n1 : n2;
        }
        return altura;
    }

    public void imprimir() {
        int altura = altura();
        Cola cola = new Cola();
        cola.poner(this.raiz);
        int i = 1, j = 1;
        String texto = "";
        int longitud = xcalc(altura);
        String brazoIzq = repetir(longitud-1, "-");
        String brazoDer = brazoIzq + "-";
        if (altura == 1)
            longitud = 2;
        String espacioIzq = repetir(longitud, " ");
        String espacioDer = espacioIzq + "   ";
        NodoABB nodo;
        // Comparable elemento;
        while (altura > 0) {
            nodo = (NodoABB) cola.obtenerFrente();
            cola.sacar();
            if (nodo == null) {
                cola.poner(null);
                cola.poner(null);
            } else {
                cola.poner(nodo.getIzquierdo());
                cola.poner(nodo.getDerecho());
            }
            texto += espacioIzq + "|" + brazoIzq + nodificar(nodo) + brazoDer + "|" + espacioDer;
            if (i == j) {
                texto += "\n";
                altura--;
                longitud = xcalc(altura);
                brazoIzq = repetir(longitud-1, "-");
                brazoDer = brazoIzq + "-";
                if (altura == 1)
                    longitud = 2;
                espacioIzq = repetir(longitud, " ");
                espacioDer = espacioIzq + "   ";
                i *= 2;
                j = 1;
            } else {
                j++;
            }
        }
        boolean bandera = true;
        while (!cola.esVacia()) {
            nodo = (NodoABB) cola.obtenerFrente();
            cola.sacar();
            texto += nodificarFinal(nodo) + ((bandera) ? "        " : "    ");
            bandera = !bandera;
        }
        System.out.println(texto);
    }

    private String nodificar(NodoABB nodo) {
        String resultado = "-[-]";
        if (nodo != null) {
            int n = (int) nodo.getElemento();
            resultado = ((n < 10) ? "-" : "") + "[" + n + "]";
        }
        return resultado;
    }

    private String nodificarFinal(NodoABB nodo) {
        String resultado = " [-]";
        if (nodo != null) {
            int n = (int) nodo.getElemento();
            resultado = ((n < 10) ? " " : "") + "[" + n + "]";
        }
        return resultado;
    }

    private String repetir(int n, String s) {
        String c = "";
        for (int i = 0; i < n; i++)
            c += s;
        return c;
    }

    private int xcalc(int n) {
        int resultado = 4;
        if (n > 1) {
            resultado = 8;
            int j = 1;
            for (int i = 2; i < n; i++) {
                resultado += 10 * j;
                j *= 2;
            }
        }
        return resultado;
    }

}
