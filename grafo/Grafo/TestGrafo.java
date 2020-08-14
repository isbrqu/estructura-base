package grafo.Grafo;

public class TestGrafo {

    private static Grafo g = new Grafo();
    private static char[] vertice = {'a', 'b', 'e', 'b', 'f', 'g', 'd'};

    public static void main(String[] args) {
        insertarVertice();
        insertarArco();
        System.out.println(g);
        eliminarArco();
        System.out.println(g);
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
        String[] arco = {"a-5-b", "a-9-f", "a-6-g", "a-1-g", "b-6-f", "b-2-f", "f-2-f", "g-3-d", "g-3-d", "d-1-d", "x-1-d", "d-1-x", "x-1-x"};
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
        String[] arco = {"a-5-b", "a-1-g", "g-3-d", "f-2-f", "e-2-e", "d-0-g", "g-0-d", "x-0-e", "a-0-x", "a-0-e"};
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

}
