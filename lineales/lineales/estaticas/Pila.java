package lineales.estaticas;

public class Pila {
    private Object[] arreglo;
    private int tope;
    private static final int TAMANIO = 10;

    public Pila() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public boolean apilar(Object elemento) {
        boolean exito = false;
        if (this.tope + 1 < TAMANIO) {
            this.tope++;
            this.arreglo[this.tope] = elemento;
            exito = true;
        }
        return exito;
    }

    public boolean esVacia() {
        return this.tope == -1;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (this.tope != -1) {
            this.arreglo[this.tope] = null;
            this.tope--;
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        Object elemento = null;
        if (this.tope != -1)
            elemento = this.arreglo[this.tope];
        return elemento;
    }

    public void vaciar() {
        this.arreglo = new Object[TAMANIO];
        this.tope = -1;
    }

    public Pila clone() {
        Pila clon = new Pila();
        if (this.tope != -1) {
            clon.arreglo = this.arreglo.clone();
            clon.tope = this.tope;
        }
        return clon;
    }

    public String toString() {
        String texto = "La pila esta vacia";
        if (this.tope != -1) {
            texto = "[";
            for (int i = this.tope; i >= 0; i--) {
                texto += this.arreglo[i];
                if (i > 0)
                    texto += ",";
            }
            texto += "]";
        }
        return texto;
    }

    public void mostrar() {
        System.out.println(this);
    }
}
