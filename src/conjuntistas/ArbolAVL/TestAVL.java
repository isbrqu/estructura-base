package conjuntistas.ArbolAVL;

public class TestAVL {

    public static void main(String[] args) {
        ArbolAVL a = new ArbolAVL();
        // int[] num = {5, 3, 6, 2, 1, 4, 10, 11, 12, 14, 15};
        int[] num = {24, 11, 37, 6, 16, 29, 45, 4, 9, 14, 19, 26, 32, 40, 50, 2, 5, 8, 10, 13, 15, 18, 21, 25, 28, 31, 34, 39, 42, 47, 53, 1, 7, 12, 17, 20, 22, 27, 30, 33, 35, 38, 41, 43, 46, 48, 52, 55, 56, 54, 51, 49, 44, 36, 23, 57};
        a.llenar(num);
        a.imprimir();
        // a.eliminar(24);
        // a.imprimir();
        // a.eliminar(47);
        // a.imprimir();
    }

}

// 50, 30, 75, 20, 40, 60, 85, 10, 23, 35, 45, 55, 65, 80, 95, 5, 11, 22, 24, 32, 36, 43, 47, 51, 57, 62, 70, 79, 83, 87, 97, 1, 12, 21, 25, 31, 38, 41, 46, 48, 56, 59, 61, 63, 68, 71, 81, 84, 86, 88, 96, 98, 49, 64, 67, 69, 72, 89, 99
// 50, 30, 75, 20, 40, 60, 85, 10, 23, 35, 45, 55, 65, 80, 95, 5, 11, 22, 24, 32, 36, 43, 47, 51, 57, 62, 70, 79, 83, 87, 97, 1, 12, 21, 25, 31, 38, 41, 46, 48, 56, 59, 61, 63, 68, 71, 81, 84, 86, 88, 96, 98, 49, 64, 67, 69, 72, 89, 99
// 69, 64, 69, 67, 63, 59


// 50, 30, 75, 20, 40, 60, 85, 10, 23, 35, 45, 55, 65, 80, 95, 5, 11, 22, 24, 32, 36, 43, 47, 51, 57, 62, 70, 79, 83, 87, 97, 1, 21, 31, 41, 46, 48, 56, 61, 68, 71, 84, 86, 88, 96, 98, 49, 72, 89, 99
// 24, 11, 37, 6, 16, 29, 45, 4, 9, 14, 19, 26, 32, 40, 50, 2, 5, 8, 10, 13, 15, 18, 21, 25, 28, 31, 34, 39, 42, 47, 53, 1, 7, 12, 17, 20, 22, 27, 30, 33, 35, 38, 41, 43, 46, 48, 52, 55, 56, 54, 51, 49, 44, 36, 23, 57
