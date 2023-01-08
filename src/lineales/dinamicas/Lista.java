package lineales.dinamicas;

public class Lista {

    private Nodo cabecera;
    private int longitud;

    public Lista() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public Lista(Object[] arreglo) {
        int len = arreglo.length;
        for (int i = 0; i < len; i++)
            insertar(arreglo[i], i + 1);
    }

    public int longitud() {
        return this.longitud;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public void vaciar() {
        this.cabecera = null;
        this.longitud = 0;
    }

    public boolean insertar(Object elemento) {
        return this.insertar(elemento, this.longitud + 1);
    }

    public boolean insertar(Object elemento, int pos) {
        boolean exito;
        if (pos < 1 || pos > this.longitud + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elemento, this.cabecera);
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elemento, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
            this.longitud++;
            exito = true;
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito;
        if ((pos < 1 || pos > this.longitud())) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();				
            } else {
                int i = 1;
                Nodo aux = this.cabecera;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
            this.longitud--;
            exito = true;
        }
        return exito;
    }

    // precondición es que pos < longitud, sino salta error, pero no va en el metodo.
    // edit: segun el TestingPila si debe verificar lo anterior, se modifico para que asi fuera.
    public Object recuperar(int pos) {
        Object res = null;
        if (pos > 0 && pos <= this.longitud) {
            int i = 1;
            Nodo aux = this.cabecera;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            res = aux.getElemento();
        }
        return res; 
    }

    public int localizar(Object elemento) {
        int pos = -1;
        int i = 1;
        Nodo aux = this.cabecera;
        while (aux != null) {
            if (aux.getElemento().equals(elemento)) {
                aux = null;
                pos = i;
            } else {
                aux = aux.getEnlace();
                i++;				
            }
        }
        return pos;
    }

    public Lista clone() {
        Lista clon = new Lista();
        if (this.cabecera != null) {
            Nodo orig = this.cabecera;
            Nodo copia = new Nodo(orig.getElemento(), null);
            clon.cabecera = copia;
            clon.longitud = this.longitud;
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
        String s = "lista vacía";
        if (this.cabecera != null) {
            Nodo aux = this.cabecera;
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

    public void invertir() {
        Nodo anterior = this.cabecera;
        invertirAux(this.cabecera);
        if (anterior != null)
            anterior.setEnlace(null);
    }

    public void invertirAux(Nodo nodo) {
        if (nodo != null) {
            this.cabecera = nodo;
            invertirAux(nodo.getEnlace());
            if (nodo.getEnlace() != null)
                nodo.getEnlace().setEnlace(nodo);
        }
    }

    public Lista generarInvertido() {
        Lista invertido = new Lista();
        if (this.cabecera != null) {
            Nodo copia;
            Nodo orig = this.cabecera;
            invertido.cabecera = new Nodo(orig.getElemento(), null);
            orig = orig.getEnlace();
            while (orig != null) {
                copia = invertido.cabecera;
                invertido.cabecera = new Nodo(orig.getElemento(), copia);
                orig = orig.getEnlace();
            }
            invertido.longitud = this.longitud;
        }
        return invertido;
    }

    public void eliminarApariciones(Object x) {
        if (this.cabecera != null) {
            Nodo sig = this.cabecera;
            Nodo ant = null;
            this.cabecera = null;
            Object elemento;
            while (sig != null) {
                elemento = sig.getElemento();
                if (!elemento.equals(x)) {
                    if (this.cabecera == null) {
                        ant = new Nodo(elemento, null);
                        this.cabecera = ant;
                    } else {
                        ant.setEnlace(new Nodo(elemento, null));
                        ant = ant.getEnlace();
                    }
                } else {
                    this.longitud--;
                }
                sig = sig.getEnlace();
            }	
        }
    }

    public Lista intercalar(Lista l2) {
        boolean pase = true;
        Lista l3 = new Lista();
        Nodo inter;
        Nodo orig1 = this.cabecera;
        Nodo orig2 = l2.cabecera;
        l3.cabecera = new Nodo(null, null);
        inter = l3.cabecera;
        while (orig1 != null || orig2 != null) {
            if (orig1 != null && pase) {
                inter.setEnlace(new Nodo(orig1.getElemento(), null));
                orig1 = orig1.getEnlace();
                l3.longitud++;
                pase = orig2 == null;
            } else if (orig2 != null) {
                inter.setEnlace(new Nodo(orig2.getElemento(), null));
                orig2 = orig2.getEnlace();
                l3.longitud++;
                pase = orig1 != null;
            }
            inter = inter.getEnlace();
        }
        l3.cabecera = l3.cabecera.getEnlace();
        return l3;
    }

    public Lista obtenerMultiplos(int num) {
        Lista lista = new Lista();
        Object elemento;
        Nodo sig = this.cabecera;
        Nodo mult = null;
        int i = 1;
        while (sig != null) {
            elemento = sig.getElemento();
            if (elemento.equals(num)) {
                // se ejecuta la primer vez esto
                mult = new Nodo(elemento, null);
                lista.cabecera = mult;
            } else if (i % num == 0) {
                mult.setEnlace(new Nodo(elemento, null));
                mult = mult.getEnlace();
            }
            sig = sig.getEnlace();
            i++;
        }
        return lista;
    }

    public int contarIterativo(Object elemento) {
        int cant = 0;
        Nodo sig = this.cabecera;
        while (sig != null) {
            if (elemento.equals(sig.getElemento()))
                cant++;
            sig = sig.getEnlace();
        }
        return cant;
    }

    public int contarRecursivo(Object elemento) {
        return contarRecursivoAux(this.cabecera, elemento);
    }

    private int contarRecursivoAux(Nodo nodo, Object elemento) {
        return (nodo != null) ?
                (contarRecursivoAux(nodo.getEnlace(), elemento) +
                        (elemento.equals(nodo.getElemento()) ? 1 : 0)) : 0;
    }

    public boolean esCapicua() {
        boolean esCapicua = true;
        Pila pila = new Pila();
        int mitad = this.longitud / 2;
        int i = 0;
        Nodo sig = this.cabecera;
        while (i != mitad) {
            pila.apilar(sig.getElemento());
            sig = sig.getEnlace();
            i++;
        }
        if (this.longitud % 2 != 0)
            sig = sig.getEnlace();
        while (sig != null && esCapicua) {
            esCapicua = sig.getElemento().equals(pila.obtenerTope());
            pila.desapilar();
            sig = sig.getEnlace();
        }
        return esCapicua;
    }

    public Lista slice(int i, int j) {
        int k = 1;
        Lista lista = new Lista();
        Nodo sig = this.cabecera;
        Nodo copia;
        while (k < i) {
            sig = sig.getEnlace();
            k++;
        }
        copia = new Nodo(sig.getElemento(), null);
        lista.cabecera = copia;
        sig = sig.getEnlace();
        k++;
        while (k < j) {
            copia.setEnlace(new Nodo(sig.getElemento(), null));
            copia = copia.getEnlace();
            sig = sig.getEnlace();
            k++;
        }
        return lista;
    }

    public Lista slice(int i) {
        return slice(i, this.longitud + 1);
    }

    public void cut(int i, int j) {
        int k = 1;
        Nodo sig = this.cabecera;
        while (k < i) {
            sig = sig.getEnlace();
            k++;
        }
        this.cabecera = sig;
        k++;
        while (k < j) {
            sig = sig.getEnlace();
            k++;
        }
        sig.setEnlace(null);
    }

    public void cut(int i) {
        cut(i, this.longitud + 1);
    }

    public void agregarElem(Object nuevo, int x) {
        if (this.longitud > 0) {
            Nodo aux = new Nodo(nuevo, this.cabecera);
            this.cabecera = aux;
            this.longitud += this.longitud % x;
            int valor = 0;
            while (aux != null) {
                if (valor == x ) {
                    Nodo aux2 = new Nodo(nuevo, aux.getEnlace());
                    aux.setEnlace(aux2);
                    this.longitud++;
                    valor = 0;
                } else {
                    valor++;
                }
                aux = aux.getEnlace();
            }
        }
    }

}
