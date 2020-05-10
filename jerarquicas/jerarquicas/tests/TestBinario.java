/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas.tests;
import jerarquicas.ArbolBin.ArbolBin;
/**
 *
 * @author Agus
 */
public class TestBinario {

    static String sOk = "OK!", sErr = "ERROR";
    public static final String NEGRO = "";
    public static final String ROJO = "";
    public static final String VERDE = "";
    public static final String AMARILLO = "";
    public static final String AZUL = "";
    public static final String PURPLE = "";
    public static final String CYAN = "";
    public static final String BLANCO = "";   


    public static final String ANSI_RED_BACKGROUND = "";
    public static final String ANSI_GREEN_BACKGROUND = "";
    public static final String ANSI_YELLOW_BACKGROUND = "";
    public static final String ANSI_BLUE_BACKGROUND = "";
    public static final String ANSI_PURPLE_BACKGROUND = "";
    public static final String ANSI_CYAN_BACKGROUND = "";
    public static final String ANSI_WHITE_BACKGROUND = "";

    public static final String RESET = "";

    public static void main(String args[]){

        System.out.println( ANSI_CYAN_BACKGROUND  + ROJO +  "**************************************************************");
        System.out.println( ANSI_CYAN_BACKGROUND + ROJO + "*                  Test Arbol Binario                        *");
        System.out.println( ANSI_CYAN_BACKGROUND + ROJO + "**************************************************************"+"\n\n"+ RESET);

        ArbolBin a = new ArbolBin();
        ArbolBin b = new ArbolBin();

        System.out.println(ANSI_YELLOW_BACKGROUND+"--------------------------------------------------------------------------------------------------------"
                + "------------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n");

        System.out.println("********************************");
        System.out.println("*      Insercion basica        *");
        System.out.println("********************************");

        System.out.println("Checkeo si es vacio " + ((  a.esVacio()) ? sOk : sErr));  
        System.out.println("Intento vaciar arbol vacio ");
        a.vaciar();
        System.out.println("Altura de arbol vacio:  "+a.altura());
        System.out.println("Inserto el 10 en raiz " + ((  a.insertar(10, 1, 'I')) ? sOk : sErr));
        System.out.println("Altura de arbol solo con raiz:  "+a.altura());
        System.out.println("Busco el nivel de raiz. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(10) == 0) ? sOk : sErr));
        System.out.println("Inserto el 9 como hijo I de 10 " + ((  a.insertar(9, 10, 'I')) ? sOk : sErr));
        System.out.println("Busco el nivel de 9. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(9) == 1) ? sOk : sErr));
        System.out.println("Inserto el 7 como hijo I de 9 " + ((  a.insertar(7, 9, 'I')) ? sOk : sErr));
        System.out.println("Inserto el 3 como hijo D de 9 " + ((  a.insertar(3, 9, 'D')) ? sOk : sErr));
        System.out.println("Altura de arbol deberia dar 2:  "+a.altura());
        System.out.println("Busco el nivel de 3. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(3) == 2) ? sOk : sErr));
        System.out.println("Inserto el 15 como hijo D de 10 " + ((  a.insertar(15, 10, 'D')) ? sOk : sErr));
        System.out.println("Inserto el 12 como hijo I de 15 " + ((  a.insertar(12, 15, 'I')) ? sOk : sErr));
        System.out.println("Inserto el 20 como hijo D de 15 " + ((  a.insertar(20, 15, 'D')) ? sOk : sErr));
        System.out.println("\n toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 9 \t \t \t 15"
                + " \n \t 7 \t \t 3 \t 12 \t \t 20"
                +"\t \t --> \t \t"+ a.toString());
        System.out.println("\n");
        System.out.println("Inserto hijo en pos llena. Tiene que dar " + sErr+" --> " + ((  a.insertar(5, 10, 'I')) ? sOk : sErr));
        System.out.println("Inserto con padre inexistente. Tiene que dar " + sErr+" --> "  + ((  a.insertar(5, 50, 'I')) ? sOk : sErr));
        System.out.println("Inserto sin el caracter de hijo. Tiene que dar " + sErr+" --> "  + ((  a.insertar(5, 3, ' ')) ? sOk : sErr));
        System.out.println("Inserto en la raiz. Tiene que dar " + sErr+" --> "  + ((  a.insertar(5, 10, 'D')) ? sOk : sErr));
        System.out.println("Inserto elemento duplicado en pos valida 10 como hijo I de 3. Tiene que dar " + sOk+" --> "  + ((  a.insertar(10, 3, 'I')) ? sOk : sErr));
        System.out.println("Checkeo si es vacio. Tiene que dar" + sErr+" --> "  +((  a.esVacio()) ? sOk : sErr));  


        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"-------------------------------------------------------------------------------------------------------"
                + "-------------------------------------------------------------------------------------------"+RESET);



        System.out.println("\n\n********************************");
        System.out.println("*      Test de clona    do         *");
        System.out.println("********************************\n");

        b = a.clone();
        System.out.println("Altura de arbol clon:  "+b.altura());
        System.out.println("\n clon toString()  deberia dar: \n\n \t \t \t      10"
                + " \n \t \t 9 \t \t \t 15"
                + " \n \t 7 \t \t 3 \t 12 \t \t 20"
                + " \n \t \t 10 \t \t \t"
                +"\t \t --> \t \t"+ b.toString());
        System.out.println("\n");
        System.out.println("Inserto el 25 como hijo D de 20 en CLON" + ((  b.insertar(25, 20, 'D')) ? sOk : sErr));
        System.out.println("Inserto el 35 como hijo I de 20 en CLON" + ((  b.insertar(35, 20, 'I')) ? sOk : sErr));
        System.out.println("\n"+AZUL+"CLON toString() \t\t\t"+b.toString()+"\n\n");
        System.out.println(VERDE+"ORIGINAL toString()\t\t\t "+a.toString()+"\n\n");

        System.out.println("Vacio el CLON");
        b.vaciar();
        System.out.println("Busco al padre 20 en Arbol vacio. Tiene que dar " + sOk+" --> "  + (( b.padre(20)==null ) ? sOk : sErr));


        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n********************************");
        System.out.println("*      Test de Busqueda         *");
        System.out.println("********************************\n");
        System.out.println(a);
        System.out.println("Busco al padre de 3. Tiene que dar " + sOk+" --> "  + (((int) a.padre(3) == 9) ? sOk : sErr));
        System.out.println("Busco al padre de 20. Tiene que dar " + sOk+" --> "  + (((int) a.padre(20) == 15) ? sOk : sErr));
        System.out.println("Busco al padre de raiz. Tiene que dar " + sOk+" --> "  + ((a.padre(10) == null) ? sOk : sErr));
        System.out.println("padre 10 dio: " + a.padre(10));
        System.out.println("Busco al padre de elemento inexistente. Tiene que dar " + sErr+" --> "  + ((a.padre(1011) != null) ? sOk : sErr));


        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n**********************************");
        System.out.println("*        Test de Niveles         *");
        System.out.println("**********************************\n");

        System.out.println("Busco el nivel de raiz. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(10) == 0) ? sOk : sErr));
        System.out.println("Busco el nivel 3. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(3) == 2) ? sOk : sErr));
        System.out.println("Busco el nivel 20. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(20) == 2) ? sOk : sErr));
        System.out.println("Busco el nivel 9. Tiene que dar " + sOk+" --> "  + (((int) a.nivel(9) == 1) ? sOk : sErr));
        System.out.println("Busco nivel de elemento inexistente: " + a.nivel(1000));



        System.out.println("\n\n");
        System.out.println(ANSI_YELLOW_BACKGROUND+"----------------------------------------------------------------------------------------------------------"
                + "----------------------------------------------------------------------------------------"+RESET);
        System.out.println("\n\n**********************************");
        System.out.println("*      Test de Recorridos        *");
        System.out.println("**********************************\n");

        System.out.println("Recorrido en preOrden.\n Tiene que dar: [ 10 - 9 - 7 - 3 - 10 - 15 - 12 - 20 ]  " + a.listarPreorden().toString());
        System.out.println("\n");
        System.out.println("Recorrido en posOrden.\n Tiene que dar: [ 7 - 10 - 3 - 9 - 12 - 20 - 15 - 10 ]  " + a.listarPosorden().toString());
        System.out.println("\n");
        System.out.println("Recorrido en InOrden.\n Tiene que dar: [ 7 - 9 - 10 - 3 - 10 - 12 - 15 - 20 ]  " + a.listarInorden().toString());

    }

}