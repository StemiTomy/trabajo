package series;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.logging.Logger;

    public class Main {

    //private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Selecciona programa: \n1. Carga datos.\n2. Listar series.\n3. BBDD\n4. Salir");
            int opcion = scanner.nextInt();

            // CARGA DATOS
            if (opcion == 1) {
                Test1.cargarDatos();
                scanner.close();
                break;
            } else if (opcion == 2) {
                System.out.println("Selecciona tipo de listado: \n1. Listar series, capítulos y personajes" + 
                " asociados, indicando qué actor interpreta cada personaje.\n2. Listar series, capítulos y" + 
                " personajes asociados, listado de forma alfabética por personajes.");
                opcion = scanner.nextInt();
                if (opcion == 1) {
                    ArrayList<SerieDTO> series = Test1.cargarDatos();
                    Test2.listarDatos(series);
                    scanner.close();
                    break;
                } else if (opcion == 2){
                    ArrayList<SerieDTO> series = Test1.cargarDatos();
                    Test2.listarPersonajesOrdenAlfabetico(series);
                    scanner.close();
                    break;
                }

            } else if (opcion == 3) {
                System.out.println("Selecciona tipo de listado: \n1. Insert nueva serie.\n2. Listar series.\n3. Update serie.\n4. Eliminar serie.\n5. Salir");
                opcion = scanner.nextInt();

                SerieDAO serieDAO = new SerieDAO();

                if (opcion == 1) {
                    long milisegundos = 1614556800000L; // 2021-03-01
                    Date date = new Date(milisegundos);

                    //SerieDTO serieDTO = new SerieDTO(1, "titulo", date, "Hola que haces, sinopsis larga ejemplo para ver si la bbdd funciona y la serie se crea y todo eso.");
                    SerieDTO serieDTO = new SerieDTO();
                    serieDTO.setTitulo("Titulo_17");
                    serieDTO.setAnoInicio(date);
                    serieDTO.setSinopsis("Hola que haces, sinopsis larga ejemplo para ver si la bbdd funciona y la serie se crea y todo eso.");
                    System.out.println("Serie tiene: " + serieDTO.toString());

                    int resultado = serieDAO.add(serieDTO);

                    if (resultado == 0) {
                        System.out.println("Error");
                        break;
                    }
                    System.out.println("Serie insertada correctamente: " + serieDTO.toString() + "\n");
                } else if (opcion == 2) {
                    ArrayList<SerieDTO> series = serieDAO.getSeries(); // esto retorna un array de series
                    for (SerieDTO serie : series) {
                        System.out.println("Serie: " + serie.toString());
                    }
                    System.out.println("Listado de series mostrado correctamente.\n");
                } else if (opcion == 3) {
                    System.out.println("Selecciona el id de la serie a modificar:");
                    ArrayList<SerieDTO> series = serieDAO.getSeries(); // esto retorna un array de series
                    for (SerieDTO serie : series) {
                        System.out.println(serie.toString());
                    }
                    int serieID = scanner.nextInt();
                    for (SerieDTO serie : series) {
                        if (serie.getId() == serieID) {
                            SerieDTO serieDTO = serie;
                            serieDTO.setSinopsis("La sinopsis nueva");
                            int resultado = serieDAO.update(serieDTO);
                            if (resultado == 0) {
                                System.out.println("Error");
                                break;
                            }
                            System.out.println("Serie modificada correctamente: " + serieDTO.toString() + "\n");
                        }
                    }
                } else if (opcion == 4) {
                    System.out.println("Selecciona el id de la serie a eliminar:");
                    ArrayList<SerieDTO> series = serieDAO.getSeries(); // esto retorna un array de series
                    for (SerieDTO serie : series) {
                        System.out.println(serie.toString());
                    }
                    int serieID = scanner.nextInt();
                    for (SerieDTO serie : series) {
                        if (serie.getId() == serieID) {
                            SerieDTO serieDTO = serie;
                            serieDTO.setSinopsis("La sinopsis nueva");
                            int resultado = serieDAO.delete(serieDTO);
                            if (resultado == 0) {
                                System.out.println("Error");
                                break;
                            }
                            System.out.println("Serie eliminada.\n");
                        }
                    }
                } else if (opcion == 5) {
                    break;
                }
            } else if (opcion == 4) {
                break;
            }
        }
    }
}