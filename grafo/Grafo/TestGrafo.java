package grafo.Grafo;

public class TestGrafo {

    private static Grafo g = new Grafo();
    private static Object[] vertice = {'A', 'B', 'E', 'B', 'F', 'G', 'D'};

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
        for (Object v : vertice) {
            System.out.println("insertar vertice " + v + ": " + g.insertarVertice(v));
        }
    }

    public static void insertarArco() {
        cartel("insertar arco");
        Object[] origen = {'A', 'A', 'A', 'A', 'B', 'B', 'F', 'G', 'G', 'D', 'X', 'D', 'X'};
        Object[] destino = {'B', 'F', 'G', 'G', 'F', 'F', 'F', 'D', 'D', 'D', 'D', 'X', 'X'};
        int[] arco = {5, 9, 6, 1, 6, 2, 2, 3, 3, 1, 1, 1, 1};
        Object origeni, destinoi;
        int arcoi;
        for (int i = 0; i < origen.length; i++) {
            origeni = origen[i];
            destinoi = destino[i];
            arcoi = arco[i];
            System.out.println("insertar arco " + origeni + "-" + arcoi + "-" + destinoi + ": " + g.insertarArco(origeni, destinoi, arcoi));
        }
        System.out.println();
    }

    public static void eliminarArco() {
        cartel("eliminar arco");
        Object[] origen = {'A', 'A', 'G', 'F'};
        Object[] destino = {'B', 'G', 'D', 'F'};
        int[] arco = {5, 1, 3, 2};
        Object origeni, destinoi;
        int arcoi;
        for (int i = 0; i < origen.length; i++) {
            origeni = origen[i];
            destinoi = destino[i];
            arcoi = arco[i];
            System.out.println("eliminar arco " + origeni + "-" + arcoi + "-" + destinoi + ": " + g.eliminarArco(origeni, destinoi, arcoi));
        }
        System.out.println();
    }

}
