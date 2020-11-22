package grafo.Grafo;

public class TestGrafo {

    private static Grafo g = new Grafo();
    // private static char[] vertice = {'a', 'b', 'e', 'b', 'f', 'g', 'd'};
    private static char[] vertice = {'e', 'a', 'b', 'n', 'm', 'i', 'j', 'q', 'w', 'y', 'l', 'g', 'h'};

    public static void main(String[] args) {
        insertarVertice();
        insertarArco();
        System.out.println(g);
        // eliminarArco();
        // System.out.println(g);
        // eliminarVertice();
        // System.out.println(g);
    }

    public static void cartel(String tema) {
        System.out.println();
        System.out.println(("test de " + tema).toUpperCase());
        System.out.println("=================================================");
    }

    public static void insertarVertice() {
        cartel("insertar vertice");
        for (char v : vertice) {
            v = Character.toUpperCase(v);
            System.out.println("insertar vertice " + v + ": " + g.insertarVertice(v));
        }
    }

    public static void insertarArco() {
        cartel("insertar arco");
        String[] arco = {
            "a-0-b",
            "n-1-m", "n-2-m",
            "i-3-j", "i-3-j",
            "q-4-w", "q-4-y", "w-4-y",
            "l-5-l",
            "g-6-g", "g-7-g",
            "h-8-h", "h-8-h"
        };
        char origen, destino;
        int etiqueta;
        String[] t;
        for (String a : arco) {
            t = a.split("-");
            origen = t[0].toUpperCase().charAt(0);
            etiqueta = Integer.parseInt(t[1]);
            destino = t[2].toUpperCase().charAt(0);
            System.out.println("insertar arco " + origen + "-" + etiqueta + "-" + destino + ": " + g.insertarArco(origen, destino, etiqueta));
        }
        System.out.println();
    }

    public static void eliminarArco() {
        cartel("eliminar arco");
        String[] arco = {};
        char origen, destino;
        int etiqueta;
        String[] t;
        for (String a : arco) {
            t = a.split("-");
            origen = t[0].toUpperCase().charAt(0);
            etiqueta = Integer.parseInt(t[1]);
            destino = t[2].toUpperCase().charAt(0);
            System.out.println("eliminar arco " + origen + "-" + etiqueta + "-" + destino + ": " + g.eliminarArco(origen, destino, etiqueta));
        }
        System.out.println();
    }

    public static void eliminarVertice() {
        cartel("eliminar vertice");
        // char[] vertice = {'g', 'b', 'e'};
        char[] vertice = {'d'};
        for (char v : vertice) {
            v = Character.toUpperCase(v);
            System.out.println("eliminar vertice " + v + ": " + g.eliminarVertice(v));
        }
    }

}
