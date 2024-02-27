package series;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

    public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona programa: \n1. Carga datos.\n2. Listar series.\n3. Salir");
            int opcion = scanner.nextInt();

            // CARGA DATOS
            if (opcion == 1) {
                Test1.cargarDatos();
                break;
            } else if (opcion == 2) {
                System.out.println("Selecciona tipo de listado: \n1. Listar series, capítulos y personajes" + 
                " asociados, indicando qué actor interpreta cada personaje.\n2. Listar series, capítulos y" + 
                " personajes asociados, listado de forma alfabética por personajes.");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    ArrayList<Serie> series = Test1.cargarDatos();
                    Test2.listarDatos(series);
                    break;
                } else if (opcion == 2){
                    ArrayList<Serie> series = Test1.cargarDatos();
                    Test2.listarPersonajesOrdenAlfabetico(series);
                    break;
                }

            }
        }
    }
}