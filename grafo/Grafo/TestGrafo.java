package grafo.Grafo;

public class TestGrafo {

    private static Grafo g = new Grafo();
    private static int[] num = {2, 3, 3, 11, 40};

    public static void main(String[] args) {
        g.llenar(num);
        System.out.println(g);
    }

}
