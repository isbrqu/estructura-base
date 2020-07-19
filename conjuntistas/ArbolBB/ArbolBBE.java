package conjuntistas.ArbolBB;
import lineales.dinamicas.Lista;
import java.lang.Math;

public class ArbolBBE extends ArbolBB {

    public ArbolBBE() {
        super();
    }

    public Comparable mejorCandidato(Comparable elem) {
        Comparable candidato = 0;
        NodoABB nodo = obtenerNodo(elem);
        if (nodo != null) {
            if (nodo.getIzquierdo() != null || nodo.getDerecho() != null) {
                Comparable izquierdo = mejorCandidatoAux(nodo.getIzquierdo(), elem);
                Comparable derecho = mejorCandidato(nodo.getDerecho(), elem);
                if (!izquierdo.equals(valor) && !derecho.equals(valor)) {
                    if (-1 * izquierdo.compareTo(valor) < derecho.compareTo(valor))  {
                        candidato = izquierdo;
                    } else {
                        candidato = derecho;
                    }
                } else if (izquierdo.equals(valor)) {
                    candidato = derecho;
                } else {
                    candidato = izquierdo;
                }
            } else {
                candidato = -1;
            }
        }
        return candidato;
    }

    public Comparable mejorCandidatoAux(NodoABB nodo, Comparable valor) {
        Comparable candidato = valor;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            // negativo
            Comparable izquierdo = mejorCandidatoAux(nodo.getIzquierdo(), valor);
            // positivo
            Comparable derecho = mejorCandidatoAux(nodo.getDerecho(), valor);
            if (!izquierdo.equals(valor) && !derecho.equals(valor)) {
                if (-1 * izquierdo.compareTo(valor) < derecho.compareTo(valor))  {
                    candidato = izquierdo;
                } else {
                    candidato = derecho;
                }
            } else if (izquierdo.equals(valor)) {
                candidato = derecho;
            } else {
                candidato = izquierdo;
            }
            if (candidato.equals(valor) || elemento.compareTo(valor) < Math.abs(candidato.compareTo(valor))) {
                candidato = elemento;
            }
        }
        return candidato;
    }

    // obtencion de datos

    public NodoABB obtenerNodo(Comparable x) {
        Comparable elemento;
        NodoABB nodo = this.raiz;
        NodoABB resultado = null;
        while (resultado == null && nodo != null) {
            elemento = nodo.getElemento();
            if (elemento.equals(x)) {
                resultado = nodo;
            } else if (elemento.compareTo(x) < 0) {
                nodo = nodo.getDerecho();
            } else {
                nodo = nodo.getIzquierdo();
            }
        }
        return nodo;
    }

    public int masNodosRango(Comparable minimo, Comparable maximo) {
        int cantidadNodoIzquierdo = 0;
        int cantidadNodoDerecho = 0;
        if (this.raiz != null) {
            cantidadNodoIzquierdo = contarNodoRangoAux(this.raiz.getIzquierdo(), minimo, maximo);
            cantidadNodoDerecho = contarNodoRangoAux(this.raiz.getDerecho(), minimo, maximo);
        }
        return Math.max(cantidadNodoIzquierdo, cantidadNodoDerecho);
    }

    public int contarNodoMayor(Comparable minimo) {
        return contarNodoMayorAux(this.raiz, minimo);
    }

    private int contarNodoMayorAux(NodoABB nodo, Comparable minimo) {
        int cantidad = 0;
        if (nodo != null) {
            cantidad = contarNodoMayorAux(nodo.getDerecho(), minimo);
            if (nodo.getElemento().compareTo(minimo) >= 0) {
                cantidad += 1 + contarNodoMayorAux(nodo.getIzquierdo(), minimo);
            }
        }
        return cantidad;
    }

    public int contarNodoMenor(Comparable maximo) {
        return contarNodoMenorAux(this.raiz, maximo);
    }

    private int contarNodoMenorAux(NodoABB nodo, Comparable maximo) {
        int cantidad = 0;
        if (nodo != null) {
            cantidad = contarNodoMenorAux(nodo.getIzquierdo(), maximo);
            if (nodo.getElemento().compareTo(maximo) <= 0) {
                cantidad += 1 + contarNodoMenorAux(nodo.getDerecho(), maximo);
            }
        }
        return cantidad;
    }

    public int contarNodoRango(Comparable minimo, Comparable maximo) {
        return contarNodoRangoAux(this.raiz, minimo, maximo);
    }

    private int contarNodoRangoAux(NodoABB nodo, Comparable minimo, Comparable maximo) {
        int cantidad = 0;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(minimo) > 0) {
                cantidad += contarNodoRangoAux(nodo.getIzquierdo(), minimo, maximo);
            }
            if (elemento.compareTo(maximo) < 0) {
                cantidad += contarNodoRangoAux(nodo.getDerecho(), minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public int contarHojasMayor(Comparable minimo) {
        return contarHojasMayorAux(this.raiz, minimo);
    }

    private int contarHojasMayorAux(NodoABB nodo, Comparable minimo) {
        int cantidad = 0;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            cantidad = contarHojasMayorAux(nodo.getDerecho(), minimo);
            if (elemento.compareTo(minimo) >= 0) {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    cantidad++;
                } else {
                    cantidad += contarHojasMayorAux(nodo.getIzquierdo(), minimo);
                }
            }
        }
        return cantidad;
    }

    public int contarHojasMenor(Comparable minimo) {
        return contarHojasMenorAux(this.raiz, minimo);
    }

    private int contarHojasMenorAux(NodoABB nodo, Comparable minimo) {
        int cantidad = 0;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            cantidad = contarHojasMenorAux(nodo.getIzquierdo(), minimo);
            if (elemento.compareTo(minimo) <= 0) {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    cantidad++;
                } else {
                    cantidad += contarHojasMenorAux(nodo.getDerecho(), minimo);
                }
            }
        }
        return cantidad;
    }

    public int contarHojasRango(Comparable minimo, Comparable maximo) {
        return contarHojasRangoAux(this.raiz, minimo, maximo);
    }

    public int contarHojasRangoAux(NodoABB nodo, Comparable minimo, Comparable maximo) {
        int cantidad = 0;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(minimo) > 0) {
                cantidad = contarHojasRangoAux(nodo.getIzquierdo(), minimo, maximo);
            }
            if (elemento.compareTo(maximo) < 0) {
                cantidad += contarHojasRangoAux(nodo.getDerecho(), minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0 && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                cantidad++;
            }
        }
        return cantidad;
    }

    public boolean verificarRango(Comparable minimo, Comparable maximo) {
        int max = (int) maximo;
        int max2 = (verificarRangoAux(this.raiz, (int) minimo, minimo, maximo)) - 1;
        return max == max2;
    }

    private int verificarRangoAux(NodoABB nodo, int indice, Comparable minimo, Comparable maximo) {
        Comparable elemento = nodo.getElemento();
        NodoABB izquierdo = nodo.getIzquierdo();
        NodoABB derecho = nodo.getDerecho();
        if (elemento.compareTo(minimo) > 0 && izquierdo != null) {
            indice = verificarRangoAux(izquierdo, indice, minimo, maximo);
        }
        if (indice != -1 && elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
            if (elemento.equals(indice)) {
                indice++;
            } else {
                indice = -1;
            }
        }
        if (indice != -1 && elemento.compareTo(maximo) < 0 && derecho != null) {
            indice = verificarRangoAux(derecho, indice, minimo, maximo);
        }
        return indice;
    }

    // listar

    public Lista listarMayor(Comparable x) {
        Lista lista = new Lista();
        listarMayorAux(this.raiz, lista, x);
        return lista;
    }

    private void listarMayorAux(NodoABB nodo, Lista lista, Comparable x) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            listarMayorAux(nodo.getDerecho(), lista, x);
            if (x.compareTo(elemento) < 0) {
                lista.insertar(elemento, 1);
                listarMayorAux(nodo.getIzquierdo(), lista, x);
            }
        }
    }

    public Lista listarMenor(Comparable x) {
        Lista lista = new Lista();
        listarMenorAux(this.raiz, lista, x);
        return lista;
    }

    private void listarMenorAux(NodoABB nodo, Lista lista, Comparable x) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            listarMenorAux(nodo.getIzquierdo(), lista, x);
            if (x.compareTo(elemento) > 0) {
                lista.insertar(elemento, 1);
                listarMenorAux(nodo.getDerecho(), lista, x);
            }
        }
    }

    // listar frontera

    public Lista fronteraMayor(Comparable x) {
        Lista lista = new Lista();
        fronteraMayorAux(this.raiz, lista, x);
        return lista;
    }

    private void fronteraMayorAux(NodoABB nodo, Lista lista, Comparable x) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            fronteraMayorAux(derecho, lista, x);
            if (elemento.compareTo(x) > 0) {
                if (izquierdo == null && derecho == null) {
                    lista.insertar(elemento, 1);
                } else {
                    fronteraMayorAux(izquierdo, lista, x);
                }
            }
        }
    }

    public Lista fronteraMenor(Comparable x) {
        Lista lista = new Lista();
        fronteraMenor(this.raiz, lista, x);
        return lista;
    }

    private void fronteraMenor(NodoABB nodo, Lista lista, Comparable x) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            if (elemento.compareTo(x) < 0) {
                if (izquierdo == null && derecho == null) {
                    lista.insertar(elemento, 1);
                } else {
                    fronteraMenor(derecho, lista, x);
                }
            }
            fronteraMenor(izquierdo, lista, x);
        }
    }

    public Lista fronteraRango(Comparable minimo, Comparable maximo) {
        Lista lista = new Lista();
        fronteraRangoAux(this.raiz, lista, minimo, maximo);
        return lista;
    }

    private void fronteraRangoAux(NodoABB nodo, Lista lista, Comparable minimo, Comparable maximo) {
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(maximo) < 0) {
                fronteraRangoAux(nodo.getDerecho(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) > 0) {
                fronteraRangoAux(nodo.getIzquierdo(), lista, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0 && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                lista.insertar(elemento, 1);
            }
        }
    }

    // eliminar

    public boolean eliminarMayores(Comparable x) {
        return eliminarMayoresAux(this.raiz, null, x);
    }

    private boolean eliminarMayoresAux(NodoABB nodo, NodoABB padre, Comparable x) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(x) > 0) {
                exito = true;
                // bajo por la izquierda
                NodoABB izquierdo = nodo.getIzquierdo();
                if (padre == null) {
                    // caso especial
                    this.raiz = izquierdo;
                    eliminarMayoresAux(izquierdo, null, x);
                } else {
                    // caso normal, todo lo que este a la derecha de nodo tambien es mayor a x
                    padre.setDerecho(izquierdo);
                    eliminarMayoresAux(izquierdo, padre, x);
                }
            } else {
                // bajo por el derecho
                exito = eliminarMayoresAux(nodo.getDerecho(), nodo, x);
            }
        }
        return exito;
    }

    public boolean eliminarMenores(Comparable x) {
        return eliminarMenoresAux(this.raiz, null, x);
    }

    private boolean eliminarMenoresAux(NodoABB nodo, NodoABB padre, Comparable x) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(x) < 0) {
                exito = true;
                // bajo por la izquierda
                NodoABB derecho = nodo.getDerecho();
                if (padre == null) {
                    // caso especial
                    this.raiz = derecho;
                    eliminarMayoresAux(derecho, null, x);
                } else {
                    // caso normal, todo lo que este a la derecha de nodo tambien es mayor a x
                    padre.setIzquierdo(derecho);
                    eliminarMayoresAux(derecho, padre, x);
                }
            } else {
                // bajo por el derecho
                exito = eliminarMayoresAux(nodo.getIzquierdo(), nodo, x);
            }
        }
        return exito;
    }

    public boolean eliminarRango(Comparable minimo, Comparable maximo) {
        return eliminarRangoAux(this.raiz, null, minimo, maximo);
    }

    private boolean eliminarRangoAux(NodoABB nodo, NodoABB padre, Comparable minimo, Comparable maximo) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(minimo) > 0 && nodo.getIzquierdo() != null) {
                exito = eliminarRangoAux(nodo.getIzquierdo(), nodo, minimo, maximo);
            }
            if (elemento.compareTo(maximo) < 0 && nodo.getDerecho() != null) {
                exito = eliminarRangoAux(nodo.getDerecho(), nodo, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                exito = eliminarNodo(nodo, padre);
            }
        }
        return exito;
    }

    public boolean eliminarFronteraMayor(Comparable minimo) {
        return eliminarFronteraMayorAux(this.raiz, null, minimo);
    }

    private boolean eliminarFronteraMayorAux(NodoABB nodo, NodoABB padre, Comparable minimo) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            exito = eliminarFronteraMayorAux(nodo.getDerecho(), nodo, minimo);
            if (elemento.compareTo(minimo) >= 0) {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    eliminarHoja(nodo, padre);
                    exito = true;
                } else {
                    exito = eliminarFronteraMayorAux(nodo.getIzquierdo(), nodo, minimo) || exito;
                }
            }
        }
        return exito;
    }

    public boolean eliminarFronteraMenor(Comparable maximo) {
        return eliminarFronteraMenorAux(this.raiz, null, maximo);
    }

    private boolean eliminarFronteraMenorAux(NodoABB nodo, NodoABB padre, Comparable maximo) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            exito = eliminarFronteraMenorAux(nodo.getIzquierdo(), nodo, maximo);
            if (elemento.compareTo(maximo) <= 0) {
                if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                    eliminarHoja(nodo, padre);
                    exito = true;
                } else {
                    exito = eliminarFronteraMenorAux(nodo.getDerecho(), nodo, maximo) || exito;
                }
            }
        }
        return exito;
    }

    public boolean eliminarFronteraRango(Comparable minimo, Comparable maximo) {
        return eliminarFronteraRangoAux(this.raiz, null, minimo, maximo);
    }

    private boolean eliminarFronteraRangoAux(NodoABB nodo, NodoABB padre, Comparable minimo, Comparable maximo) {
        boolean exito = false;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0 && nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                eliminarHoja(nodo, padre);
                exito = true;
            } else {
                if (elemento.compareTo(minimo) > 0) {
                    exito = eliminarFronteraRangoAux(nodo.getIzquierdo(), nodo, minimo, maximo);
                }
                if (elemento.compareTo(maximo) < 0) {
                    exito = eliminarFronteraRangoAux(nodo.getDerecho(), nodo, minimo, maximo) || exito;
                }
            }
        }
        return exito;
    }

    // clonado

    public ArbolBB cloneMayor(Comparable minimo) {
        ArbolBB arbol = new ArbolBB();
        arbol.raiz = cloneMayorAux(this.raiz, minimo);
        return arbol;
    }

    private NodoABB cloneMayorAux(NodoABB nodo, Comparable minimo) {
        NodoABB clon = null;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(minimo) >= 0) {
                NodoABB izquierdo = cloneMayorAux(nodo.getIzquierdo(), minimo);
                NodoABB derecho = cloneMayorAux(nodo.getDerecho(), minimo);
                clon = new NodoABB(elemento, izquierdo, derecho);
            } else {
                clon = cloneMayorAux(nodo.getDerecho(), minimo);
            }
        }
        return clon;
    }

    public ArbolBB cloneMenor(Comparable maximo) {
        ArbolBB arbol = new ArbolBB();
        arbol.raiz = cloneMenorAux(this.raiz, maximo);
        return arbol;
    }

    private NodoABB cloneMenorAux(NodoABB nodo, Comparable maximo) {
        NodoABB clon = null;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            if (elemento.compareTo(maximo) <= 0) {
                NodoABB izquierdo = cloneMenorAux(nodo.getIzquierdo(), maximo);
                NodoABB derecho = cloneMenorAux(nodo.getDerecho(), maximo);
                clon = new NodoABB(elemento, izquierdo, derecho);
            } else {
                clon = cloneMenorAux(nodo.getIzquierdo(), maximo);
            }
        }
        return clon;
    }

    public ArbolBB cloneRange(Comparable minimo, Comparable maximo) {
        ArbolBB arbol = new ArbolBB();
        arbol.raiz = cloneRangeAux(this.raiz, minimo, maximo);
        return arbol;
    }

    private NodoABB cloneRangeAux(NodoABB nodo, Comparable minimo, Comparable maximo) {
        NodoABB clon = null;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            NodoABB clonIzquierdo = null;
            NodoABB clonDerecho = null;
            if (elemento.compareTo(minimo) > 0) {
                clonIzquierdo = cloneRangeAux(izquierdo, minimo, maximo);
            }
            if (elemento.compareTo(maximo) < 0) {
                clonDerecho = cloneRangeAux(derecho, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                clon = new NodoABB(elemento, clonIzquierdo, clonDerecho);
            } else if (clonIzquierdo != null) {
                clon = clonIzquierdo;
            } else {
                clon = clonDerecho;
            }
        }
        return clon;
    }

    public ArbolBB cloneInvertedRange(Comparable minimo, Comparable maximo) {
        ArbolBB arbol = new ArbolBB();
        arbol.raiz = cloneInvertedRangeAux(this.raiz, minimo, maximo);
        return arbol;
    }

    private NodoABB cloneInvertedRangeAux(NodoABB nodo, Comparable minimo, Comparable maximo) {
        NodoABB clon = null;
        if (nodo != null) {
            Comparable elemento = nodo.getElemento();
            NodoABB izquierdo = nodo.getIzquierdo();
            NodoABB derecho = nodo.getDerecho();
            NodoABB clonIzquierdo = null;
            NodoABB clonDerecho = null;
            if (elemento.compareTo(minimo) > 0) {
                clonIzquierdo = cloneInvertedRangeAux(izquierdo, minimo, maximo);
            }
            if (elemento.compareTo(maximo) < 0) {
                clonDerecho = cloneInvertedRangeAux(derecho, minimo, maximo);
            }
            if (elemento.compareTo(minimo) >= 0 && elemento.compareTo(maximo) <= 0) {
                clon = new NodoABB(elemento, clonDerecho, clonIzquierdo);
            } else if (clonIzquierdo != null) {
                clon = clonIzquierdo;
            } else {
                clon = clonDerecho;
            }
        }
        return clon;
    }

}
