package lineales.testspropios;

import lineales.dinamicas.Lista;

public class TestLista {

    public static void print(Object s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Lista orig = new Lista();
        boolean primero = false;
        boolean segundo = false;
        print((primero) ? "hola" : ((segundo) ? "buenaas" : "chau!"));

        for (int i = 0; i < 20; i++) {
            print("inserta: " + orig.insertar(i * 4 + 1, i));			
        }
        print("insertar: " + orig.insertar(29, 599));
        print(orig);
        print("elimina: " + orig.eliminar(1));
        print("elimina: " + orig.eliminar(1));
        print(orig);
        print("localizar 45: " + orig.localizar(13));
        print("localizar 17: " + orig.localizar(17));
        print("localizar 21: " + orig.localizar(21));
        print("localizar 49: " + orig.localizar(45));
        print("localizar 77: " + orig.localizar(77));
        print("localizar 0: " + orig.localizar(0));
        orig = new Lista();
        print("locanlizar en null: " + orig.localizar(1));
        for (int i = 0; i < 3; i++) {
            print("inserta: " + orig.insertar(i * 2 + 3, i));			
        }
        print(orig);
        print("longitud :" + orig.longitud());
        orig.eliminar(1);
        print("longiud-1: " + orig.longitud());
        print(orig);
        orig.eliminar(1);
        print(orig);
        orig.insertar(3, 1);
        print("recupera 1: " + orig.recuperar(1));
        orig.insertar(5, 1);
        print("recupera 2: " + orig.recuperar(1));
        Lista clon = orig.clone();
        print("orig: " + orig);
        print("clon: " + clon);
        orig.insertar(123, 3);
        print("orig: " + orig);
        print("clon: " + clon);
        clon.eliminar(1);
        print("orig: " + orig);
        print("clon: " + clon);
    }

}
