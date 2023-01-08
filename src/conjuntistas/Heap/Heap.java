package conjuntistas.Heap;

public class Heap {

    private static final int TAMANIO = 10;
    @SuppressWarnings("rawtypes")
    private Comparable[] heap;
    private int ultimo;

    public Heap() {
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0;
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0 ) {
            exito = false;
        } else {
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;
        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                // temp tiene al menos un hijo (izq) y lo considera menor
                if (posH < this.ultimo) {
                    // hijo menor tiene hermano derecho
                    // el hijo derecho es menor que los dos
                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0)
                        posH++;
                }
                // compara al hijo menor con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    // el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    // el padre es menor que sus hijos, está bien ubicado
                    salir = true;
                }
            } else {
                salir = true;
            }
        }
    }

    @SuppressWarnings("rawtypes")
    public boolean insertar(Comparable elemento){
        boolean exito = false;
        if (this.ultimo + 1 < TAMANIO) {
            this.ultimo++;
            this.heap[this.ultimo] = elemento;
            hacerSubir(this.ultimo);
            exito = true;
        }
        return exito;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void hacerSubir(int posHijo) {
        int posP;
        Comparable temp = this.heap[posHijo];
        boolean seguir = true;
        while (seguir) {
            posP = posHijo / 2;
            if (posP >= 1) {
                if (this.heap[posP].compareTo(temp) > 0) {
                    this.heap[posHijo] = this.heap[posP];
                    this.heap[posP] = temp;
                    posHijo = posP;
                } else {
                    seguir = false;
                }
            } else {
                seguir = false;
            }

        }
    }

    @SuppressWarnings("rawtypes")
    public Comparable recuperarCima() {
        return this.heap[1];
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public void vaciar() {
        this.heap = new Comparable[TAMANIO];
        this.ultimo = 0;
    }

    public Heap clone() {
        Heap clon = new Heap();
        clon.heap = this.heap.clone();
        clon.ultimo = this.ultimo;
        return clon;
    }

    public String toString() {
        String s = "";
        int izq, der;
        for (int i = 1; i <= this.ultimo; i++) {
            s += "Nodo: " + this.heap[i] + " ";
            izq = i * 2;
            der = izq + 1;
            if (izq <= this.ultimo && this.heap[izq] != null) {
                s += "HI: " + this.heap[izq] + "\t";
            } else {
                s += "HI: -\t";
            }
            if (der <= this.ultimo && this.heap[der] != null) {
                s += "HD: " + this.heap[der] + "\n";
            } else {
                s += "HD: -\n";
            }
        }
        return s;
    }

}
