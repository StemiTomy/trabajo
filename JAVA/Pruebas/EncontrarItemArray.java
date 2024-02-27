
package JAVA.Pruebas;
/* Test: encontrar el ítem en el array, (Array, item)
int[] ints = {-9, 14, 37, 102};
System.out.println(EncontrarItemArray.exists(ints, 102)); // true
System.out.println(EncontrarItemArray.exists(ints, 36)); // false
*/
import java.util.Arrays;
import java.util.Scanner;

class EncontrarItemArray {

    static boolean exists(int[] ints, int k) {
        int element = Arrays.binarySearch(ints, k);

        if (element >= 0) {
            // System.out.println("El elemento " + k + " se encuentra en el índice " +
            // element);
            return true;
        } else {
            // System.out.println("El elemento " + k + " no se encuentra en el array");
            return false;
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in); // lectura de teclado
        int opcion;

        while (true) {
            System.out.println("Menú:");
            System.out.println("1. Opción 0");
            System.out.println("1. Opción 1");
            System.out.println("2. Opción 2");
            System.out.println("3. Opción 3");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Opción 0.");
                    int[] ints = { -9, 14, 37, 102 };
                    System.out.println(EncontrarItemArray.exists(ints, 102)); // true
                    System.out.println(EncontrarItemArray.exists(ints, 36)); // false
                    scanner.close();
                    break;
                case 1:
                    System.out.println("Ha seleccionado la opción 1.");
                    break;
                case 2:
                    System.out.println("Ha seleccionado la opción 2.");
                    break;
                case 3:
                    System.out.println("Ha seleccionado la opción 3.");
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }
}