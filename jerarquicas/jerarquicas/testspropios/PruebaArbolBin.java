package jerarquicas.testspropios;
import jerarquicas.ArbolBin.ArbolBin;

public class PruebaArbolBin {

    public static void main(String[] args) {
        ArbolBin test = new ArbolBin();
        test.insertar(9, null, 'I');
        System.out.println("Exito: " + test.insertar(2, 9, 'I'));
        System.out.println("Exito: " + test.insertar(4, 9, 'D'));

        System.out.println("Exito: " + test.insertar(7, 2, 'I'));
        System.out.println("Exito: " + test.insertar(8, 2, 'D'));

        System.out.println("Exito: " + test.insertar(2, 4, 'I'));
        System.out.println("Exito: " + test.insertar(7, 4, 'D'));

        System.out.println("Exito: " + test.insertar(6, 2, 'I'));
        System.out.println("Exito: " + test.insertar(3, 2, 'D'));

        System.out.println("Altur: " + test.altura());
        System.out.println("Nivel: " + test.nivel(7));
        System.out.println("Padre: " + test.padre(10));
        System.out.println("Preor: " + test.listarPreorden());
        System.out.println("Inord: " + test.listarInorden());
        System.out.println("Posor: " + test.listarPosorden());
        System.out.println("Nivel: " + test.niveles());
        System.out.println();

        System.out.println("Clooooooooooooooooooooon");
        ArbolBin clon = test.clone();
        System.out.println("Preor: " + clon.listarPreorden());
        System.out.println("Inord: " + clon.listarInorden());
        System.out.println("Posor: " + clon.listarPosorden());
        System.out.println("Nivel: " + clon.niveles());
        clon.insertar(1111, 3, 'I');
        System.out.println("Clonoooasdofaosdfaosdfo");
        System.out.println("Preor: " + clon.listarPreorden());
        System.out.println("Inord: " + clon.listarInorden());
        System.out.println("Posor: " + clon.listarPosorden());
        System.out.println("Nivel: " + clon.niveles());
        System.out.println("Originaaaaaaaaalasdfads");
        System.out.println("Preor: " + test.listarPreorden());
        System.out.println("Inord: " + test.listarInorden());
        System.out.println("Posor: " + test.listarPosorden());
        System.out.println("Nivel: " + test.niveles());
        test.insertar(8, 7, 'D');
        System.out.println("Clonoooasdofaosdfaosdfo");
        System.out.println("Preor: " + clon.listarPreorden());
        System.out.println("Inord: " + clon.listarInorden());
        System.out.println("Posor: " + clon.listarPosorden());
        System.out.println("Nivel: " + clon.niveles());
        System.out.println("Originaaaaaaaaalasdfads");
        System.out.println("Preor: " + test.listarPreorden());
        System.out.println("Inord: " + test.listarInorden());
        System.out.println("Posor: " + test.listarPosorden());
        System.out.println("Nivel: " + test.niveles());
        System.out.println(test);
    }

}
