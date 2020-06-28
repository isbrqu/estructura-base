package conjuntistas.ArbolBB;

public class TestArbolBBExtra extends TestArbolBB {

    public static int[] num = {4, 2, 1, 3, 8, 6, 5, 7, 9};
    public static int[] ord = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static ArbolBBE a = new ArbolBBE();

    public static void main(String[] args) {
        llenar(a, num);
        System.out.println("                           |-----------------------[4]-----------------------|                           ");
        System.out.println("             |------------[2]------------|                     |------------[8]------------|             ");
        System.out.println("     |------[1]------|           |------[3]------|     |------[6]------|           |------[9]------|     ");
        System.out.println("    [-]             [-]         [-]             [-]   [5]             [7]         [-]             [-]    ");
        verificarRango();
    }

    public static void cloneRange() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Clon Rango [" + minimo + ", " + maximo + "]");
                System.out.println(a.cloneRange(minimo, maximo));
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void fronteraMayorYMenor() {
        int n;
        for (int i = 0; i < ord.length; i++) {
            n = ord[i];
            System.out.println("frontera mayor de: " + n);
            System.out.println("lista: " + a.fronteraMayor(n));
            System.out.println();
        }
        System.out.println();
        for (int j = ord.length - 1; j >= 0; j--) {
            n = ord[j];
            System.out.println("frontera menor de: " + n);
            System.out.println("lista: " + a.fronteraMenor(n));
            System.out.println();
        }
    }

    public static void contarNodoRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Contar nodos Rango [" + minimo + ", " + maximo + "]: " + a.contarNodoRango(minimo, maximo));
            }
            System.out.println();
        }
    }

    public static void masNodoRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Más nodo Rango [" + minimo + ", " + maximo + "]");
                System.out.println(a.masNodosRango(minimo, maximo));
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void contarNodoMayor() {
        int minimo;
        for (int i = 0; i < ord.length; i++) {
            minimo = ord[i];
            System.out.println();
            System.out.println("Cantidad de nodos mayores a " + minimo + ": " + a.contarNodoMayor(minimo));
        }
    }

    public static void contarNodoMenor() {
        int maximo;
        for (int i = 0; i < ord.length; i++) {
            maximo = ord[i];
            System.out.println();
            System.out.println("Cantidad de nodos menores a " + maximo + ": " + a.contarNodoMenor(maximo));
        }
    }

    public static void fronteraRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Fronrera Rango [" + minimo + ", " + maximo + "]: " + a.fronteraRango(minimo, maximo));
            }
            System.out.println();
        }
    }

    public static void eliminarFronteraMayor() {
        int minimo;
        for (int i = 0; i < ord.length; i++) {
            minimo = ord[i];
            System.out.println();
            System.out.println("Eliminar frontera mayor a " + minimo + ": " + a.eliminarFronteraMayor(minimo));
            System.out.println(a);
            a = new ArbolBBE();
            llenar(a, num);
        }
    }

    public static void eliminarFronteraMenor() {
        int maximo;
        for (int i = 0; i < ord.length; i++) {
            maximo = ord[i];
            System.out.println();
            System.out.println("Eliminar frontera menor a " + maximo + ": " + a.eliminarFronteraMenor(maximo));
            System.out.println(a);
            a = new ArbolBBE();
            llenar(a, num);
        }
    }

    public static void eliminarFronteraRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Elimnar Frontera Rango [" + minimo + ", " + maximo + "]: " + a.eliminarFronteraRango(minimo, maximo));
                System.out.println(a);
                a = new ArbolBBE();
                llenar(a, num);
            }
            System.out.println();
        }
    }

    public static void obtenerNodo() {
        int valor;
        for (int i = 0; i < ord.length; i++) {
            valor = ord[i];
            System.out.println();
            System.out.println("Obtener Nodo " + valor + ": " + a.obtenerNodo(valor).getElemento());
        }
        System.out.println();
        System.out.println("Obtener Nodo -1: " + a.obtenerNodo(-1));
    }

    public static void cloneMayor() {
        int minimo;
        for (int i = 0; i < ord.length; i++) {
            minimo = ord[i];
            System.out.println();
            System.out.println("Clon mayor de " + minimo);
            System.out.println(a.cloneMayor(minimo));
            System.out.println();
        }
        System.out.println();
        System.out.println("Clon mayor de 10");
        System.out.println(a.cloneMayor(10));
        System.out.println();
    }

    public static void cloneMenor() {
        int maximo;
        for (int i = 0; i < ord.length; i++) {
            maximo = ord[i];
            System.out.println();
            System.out.println("Clon menor de " + maximo);
            System.out.println(a.cloneMenor(maximo));
            System.out.println();
        }
        System.out.println();
        System.out.println("Clon menor de -1");
        System.out.println(a.cloneMenor(-1));
        System.out.println();
    }

    public static void contarHojasMayor() {
        int minimo;
        for (int i = 0; i < ord.length; i++) {
            minimo = ord[i];
            System.out.println();
            System.out.println("Cantidad de hojas mayor a " + minimo + ": " + a.contarHojasMayor(minimo));
        }
        System.out.println();
        System.out.println("Cantidad de hojas mayor a 10: " + a.contarHojasMayor(10));
    }

    public static void contarHojasMenor() {
        int maximo;
        for (int i = 0; i < ord.length; i++) {
            maximo = ord[i];
            System.out.println();
            System.out.println("Cantidad de hojas menor a " + maximo + ": " + a.contarHojasMenor(maximo));
        }
        System.out.println();
        System.out.println("Cantidad de hojas menor a -1: " + a.contarHojasMenor(-1));
    }

    public static void contarHojasRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Contar Frontera Rango [" + minimo + ", " + maximo + "]: " + a.contarHojasRango(minimo, maximo));
            }
            System.out.println();
        }
    }

    public static void verificarRango() {
        int minimo, maximo;
        for (int i = 0; i < ord.length; i++) {
            for (int j = i; j < ord.length; j++) {
                minimo = ord[i];
                maximo = ord[j];
                System.out.println();
                System.out.println("Verificar Rango [" + minimo + ", " + maximo + "]: " + a.verificarRango(minimo, maximo));
            }
            System.out.println();
        }
    }

}
