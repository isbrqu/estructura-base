package test;

import lineales.dinamicas.Cola;
import lineales.dinamicas.Lista;
import lineales.ejercicios.MixLineales;
import test.Utils;

public class Test {
    
    public static void print(String s) {
        System.out.println(s);
    }

    public static void casoGenerarCola(Cola cola, String texto) {
        Utils.llenar(cola, texto);
        print("texto: " + texto);
        print("cola: " + cola);
        Cola mix = MixLineales.generarColaTriple(cola);
        print("mixCola: " + mix + "\n");
    }

    public static void casoBalance(Cola cola, String texto) {
        Utils.llenar(cola, texto);
        print("texto: " + texto);
        print("cola:  " + cola);
        print("hay?   " + MixLineales.verificarBalanceo(cola) + "\n");
    }
    
    public static void main(String[] args) {
        Cola cola = new Cola();
        Lista lista = new Lista();
        Utils.llenar(lista, "abcdefgh");
        int t = 2;
        print("test");
        print(MixLineales.listaToCola(lista, t) + "\n");
        print("asdfads");
//        print("test generarOtraCola");
        casoGenerarCola(cola, "");
//        casoGenerarCola(cola, "A");
//        casoGenerarCola(cola, "A$B");
//        casoGenerarCola(cola, "A$BA$B");
//        casoGenerarCola(cola, "A$B$C$D$E$F");
//        casoGenerarCola(cola, "AB$C$DEF");
//
//        print("test verificarBalance");
//        casoBalance(cola, "");
//        casoBalance(cola, "[()]");
//        casoBalance(cola, "{5+[8*9-(4/2)+7]-1}");
//        casoBalance(cola, "{5+[8*9-(4/2+7]-1}");
//        casoBalance(cola, "{5+[8*9-(4/2+7])-1}");
//        casoBalance(cola, "){5+[8*9-(4/2)+7]-1}");
//        casoBalance(cola, "{5}+[8*9-(4/2)+7]-1}");
//
//        Utils.llenar(cola, "123456789");
//        print(cola + "\n");
//        for (int i = 1; i < 10; i++) {
//            print("valor: " + i);
//            print("lista: " + MixLineales.generarSecuencia(cola, i));
//            print("expre: " + MixLineales.generarSecuenciaExpress(cola, i));  
//            print("");
//        }
//        
//        // Test de PruebaLista
//        Lista l1 = new Lista(); 
//        Lista l2 = new Lista();
//        int[] arr1 = {3, 3, 0, 3, 3};
//        int[] arr2 = {};
//        Utils.llenar(l1, arr1);
//        Utils.llenar(l2, arr2);
//        print("Lista 1: " + l1);
//        print("Lista 2: " + l2);
//        print("Interca: " + l1.intercalar(l2));
//        print("capicua? " + PruebaLista.esCapicua(l1));
//        print("capicua? " + l1.esCapicua());
//        print("ContIte: " + l1.contarIterativo(3));
//        print("ContRec: " + l1.contarRecursivo(3));
//        print("Slice1 : " + l1.slice(2));
//        print("Slice2 : " + l1.slice(2, 4));
//        l1.cut(2);
//        print("Cut 1  : " + l1);
//        l1.vaciar();
//        Utils.llenar(l1, arr1);
//        l1.cut(2, 4);
//        print("Cut 2  : " + l1);
    }

}
