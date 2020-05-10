package jerarquicas.testspropios;

import jerarquicas.ArbolHeap.ArbolHeap;

public class PruebaArbolHeap {

    public static void main(String[] args) {

        ArbolHeap a = new ArbolHeap();

        a.insertar(2);
        a.insertar(1);
        a.insertar(1);
        a.insertar(4);
        a.insertar(9);
        a.insertar(8);
        a.insertar(7);
        a.insertar(1);
        a.insertar(1);
        System.out.println(a);

    }

}
