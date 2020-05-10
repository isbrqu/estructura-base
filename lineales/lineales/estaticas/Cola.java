package lineales.estaticas;

public class Cola {
    private static final int TAMANIO = 10;
    private Object[] arreglo;
    private int frente;
    private int finall;

    public Cola() {
        this.arreglo = new Object[TAMANIO];
        this.frente = 0;
        this.finall = 0;
    }

    public boolean esVacia() {
        return this.finall == this.frente;
    }

    public Object obtenerFrente() {
        return this.arreglo[frente];
    }

    public boolean poner(Object elemento) {
        boolean exito = false;
        if ((this.finall + 1) % TAMANIO != this.frente) {
            this.arreglo[finall] = elemento;
            this.finall = (this.finall + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = false;
        if (this.frente != this.finall) {
            this.arreglo[frente] = null;
            this.frente = (this.frente + 1) % TAMANIO;
            exito = true;
        }
        return exito;
    }

    public void vaciar() {
        this.arreglo = new Object[TAMANIO];
        this.frente = this.finall;
    }

    public Cola clone() {
        Cola clon = new Cola();
        clon.frente = this.frente;
        clon.finall = this.finall;
        clon.arreglo = this.arreglo.clone();
        return clon;
    }

    public String toString() {
        String texto = "Cola Vacia";
        if (this.frente != this.finall) {
            texto = "[";
            for (int i = this.frente; i != this.finall; i = (i + 1) % TAMANIO) {
                texto += this.arreglo[i].toString();
                if ((i + 1) % TAMANIO != this.finall) 
                    texto += ", ";
            }
            texto += "]";
        }
        return texto;
    }
}
