package conjuntistas.ArbolBB;

public class TestArbolBBExtra {

    static String sOk = "OK!", sErr = "ERROR";

    public static void cartel(String titulo) {
        int longitud = titulo.length() + 10;
        String barra = "";
        for (int i = 0; i < longitud; i++)
            barra += "*";
        for (int j = 0; j < 4; j++)
            titulo = " " + titulo + " ";
        titulo = "*" + titulo + "*";
        System.out.println();
        System.out.println(barra);
        System.out.println(titulo);
        System.out.println(barra);
        System.out.println();
    }

    public static void linea() {
        String s = "";
        for (int i = 0; i < 194; i++)
            s += "-";
        System.out.println(s);
        System.out.println();
    }

    public static String comprobar(boolean condicion) {
        return (condicion) ? sOk : sErr;
    }

    public static void llenar(ArbolBB arbol, int[] num) {
        for (int i = 0; i < num.length; i++)
            arbol.insertar(num[i]);
    }

    public static void main(String[] args) {
        ArbolBB a = new ArbolBB();
        // int[] num = {5, 2, 1, 3, 8, 7, 9};
        // cartel("Test de árbol binario de búsqueda");
        // System.out.println(a + "\n");
        // System.out.println("listar mayores: " + a.listarMenores(1));

        int[] num = {4, 1, 0, 2, 8, 6, 5, 7, 9};
        int[] ord = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, -1};
        llenar(a, num);
        System.out.println("                           |-----------------------[4]-----------------------|                           ");
        System.out.println("             |------------[1]------------|                     |------------[8]------------|             ");
        System.out.println("     |------[0]------|           |------[2]------|     |------[6]------|           |------[9]------|     ");
        System.out.println("    [-]             [-]         [-]             [-]   [5]             [7]         [-]             [-]    ");
        System.out.println(a + "\n");
        System.out.println();
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

}
