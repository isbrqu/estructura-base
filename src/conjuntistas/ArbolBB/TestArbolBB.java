package conjuntistas.ArbolBB;

public class TestArbolBB {
    public static void main(String[] args) {
        ArbolBB a = new ArbolBB();
        a.insertar(15);
        a.insertar(9);
        a.insertar(20);
        a.insertar(6);
        a.insertar(14);
        a.insertar(13);
        // a.insertar(20);
        a.insertar(17);
        a.insertar(64);
        a.insertar(26);
        a.insertar(72);
        // a.insertar(3);
        // a.insertar(1);
        System.out.println(a);
        System.out.println("listar: " + a.listar());
        System.out.println("pertenece: " + a.pertenece(3));
        System.out.println("elemento minimo: " + a.minimoElem());
        System.out.println("elemento maximo: " + a.maximoElem());
        System.out.println("listar rango: " + a.listarRango(2, 9));
    }
}
