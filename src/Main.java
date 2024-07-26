import models.Hashtable;
import models.Business;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, Business> hashTable;
        hashTable = new Hashtable<>();

        Scanner scanner = new Scanner(System.in);
        boolean encendido = true;
        do {
            String answer;
            System.out.println("Elige el metodo hash:");
            System.out.println("|1| Simple hash.");
            System.out.println("|2| Hash code.");
            System.out.println("|3| Salir.");
            answer = scanner.next();
            switch (answer){
                case "1":
                    metodosSimpleHash(scanner, hashTable);
                    break;
                case "2":
                    metodosHashCode(scanner, hashTable);
                    break;
                case  "3":
                    System.out.println("Terminando programa...");
                    encendido = false;
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        }while (encendido);
    }
    public static void metodosSimpleHash(Scanner scanner, Hashtable<String, Business> hashTable){
        boolean encendido = true;
        String option;
        do {
            String line;
            System.out.println("FUNCIONES CON EL METODO SIMPLE HASH");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Imprimir todos los datos");
            System.out.println("2. Guardar todos los datos a la tabla hash");
            System.out.println("3. Agregar un nuevo par de datos");
            System.out.println("4. Encontrar un par de datos por ID");
            System.out.println("5. Salir");
            option = scanner.next();

            switch (option) {
                case "1":
                    for (String key : hashTable.keySet()) {
                        Business business = hashTable.getFirstHash(key);
                        System.out.println("ID: " + business.getId() + ", Nombre: " + business.getName() + ", Dirección: " + business.getAddress() + ", Ciudad: " + business.getCity() + ", Estado: " + business.getState());
                    }
                    break;
                case "2":

                    long startTime = System.nanoTime();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
                        while ((line = br.readLine()) != null) {
                            String[] businessData = line.split(",");
                            Business business1 = new Business(businessData[0], businessData[1], businessData[2], businessData[3], businessData[4]);
                            hashTable.putFirstHash(business1.getId(), business1);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    long endTime = System.nanoTime();
                    System.out.println("Tiempo transcurrido para insertar todos los datos: " + (endTime - startTime)/1000000 + " milisegundos");

                    break;
                case "3":
                    System.out.println("Ingrese ID:");
                    String id = scanner.next();
                    System.out.println("Ingrese Nombre:");
                    String name = scanner.next();
                    System.out.println("Ingrese Dirección:");
                    String address = scanner.next();
                    System.out.println("Ingrese Ciudad:");
                    String city = scanner.next();
                    System.out.println("Ingrese Estado:");
                    String state = scanner.next();

                    long startTimeAdd = System.nanoTime();

                    Business business = new Business(id, name, address, city, state);

                    long endTimeAdd = System.nanoTime();

                    System.out.println("Tiempo transcurrido para insertar un nuevo dato: " + (endTimeAdd - startTimeAdd) + " nanosegundos");

                    int hashIndex = hashTable.putFirstHash(id, business);
                    System.out.println("Agregado con éxito!");
                    System.out.println("Se agrego el indice: " + hashIndex);
                    break;
                case "4":

                    System.out.println("Ingrese ID para buscar:");
                    String idToFind = scanner.next();
                    long startTimeFind = System.nanoTime();
                    Business businessToFind = hashTable.getFirstHash(idToFind);
                    long endTimeFind = System.nanoTime();
                    System.out.println("Tiempo transcurrido para encontrar datos: " + (endTimeFind - startTimeFind) + " nanosegundos");
                    if (businessToFind != null) {
                        System.out.println("ID: " + businessToFind.getId() + ", Nombre: " + businessToFind.getName() + ", Dirección: " + businessToFind.getAddress() + ", Ciudad: " + businessToFind.getCity() + ", Estado: " + businessToFind.getState());
                    } else {
                        System.out.println("Par de datos no encontrado!");
                    }
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    hashTable.clear();
                    encendido = false;
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        } while (encendido);
    }
    public static void metodosHashCode(Scanner scanner, Hashtable<String, Business> hashTable){
        boolean encendido = true;
        String option;
        do {
            String line;
            System.out.println("FUNCIONES CON EL METODO HASH CODE");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Imprimir todos los datos");
            System.out.println("2. Guardar todos los datos a la tabla hash");
            System.out.println("3. Agregar un nuevo par de datos");
            System.out.println("4. Encontrar un par de datos por ID");
            System.out.println("5. Salir");
            option = scanner.next();

            switch (option) {
                case "1":
                    for (String key : hashTable.keySet()) {
                        Business business = hashTable.getFirstHash(key);
                        System.out.println("ID: " + business.getId() + ", Nombre: " + business.getName() + ", Dirección: " + business.getAddress() + ", Ciudad: " + business.getCity() + ", Estado: " + business.getState());
                    }
                    break;
                case "2":
                    long startTime = System.nanoTime();
                    try {
                        BufferedReader br = new BufferedReader(new FileReader("bussines.csv"));
                        while ((line = br.readLine()) != null) {
                            String[] businessData = line.split(",");
                            Business business1 = new Business(businessData[0], businessData[1], businessData[2], businessData[3], businessData[4]);
                            hashTable.putSecondHash(business1.getId(), business1);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    long endTime = System.nanoTime();
                    System.out.println("Tiempo transcurrido para insertar todos los datos: " + (endTime - startTime)/1000000 + " milisegundos");

                    break;
                case "3":
                    System.out.println("Ingrese ID:");
                    String id = scanner.next();
                    System.out.println("Ingrese Nombre:");
                    String name = scanner.next();
                    System.out.println("Ingrese Dirección:");
                    String address = scanner.next();
                    System.out.println("Ingrese Ciudad:");
                    String city = scanner.next();
                    System.out.println("Ingrese Estado:");
                    String state = scanner.next();

                    long startTimeAdd = System.nanoTime();

                    Business business = new Business(id, name, address, city, state);

                    long endTimeAdd = System.nanoTime();

                    System.out.println("Tiempo transcurrido para insertar un nuevo dato: " + (endTimeAdd - startTimeAdd) + " nanosegundos");

                    hashTable.putSecondHash(id, business);
                    System.out.println("Agregado con éxito!");
                    break;
                case "4":

                    System.out.println("Ingrese ID para buscar:");
                    String idToFind = scanner.next();
                    long startTimeFind = System.nanoTime();
                    Business businessToFind = hashTable.getSecondHash(idToFind);
                    long endTimeFind = System.nanoTime();
                    System.out.println("Tiempo transcurrido para encontrar datos: " + (endTimeFind - startTimeFind) + " nanosegundos");
                    if (businessToFind != null) {
                        System.out.println("ID: " + businessToFind.getId() + ", Nombre: " + businessToFind.getName() + ", Dirección: " + businessToFind.getAddress() + ", Ciudad: " + businessToFind.getCity() + ", Estado: " + businessToFind.getState());
                    } else {
                        System.out.println("Par de datos no encontrado!");
                    }
                    break;
                case "5":
                    System.out.println("Saliendo...");
                    hashTable.clear();
                    encendido = false;
                    break;
                default:
                    System.out.println("Opción inválida, inténtelo de nuevo.");
            }
        } while (encendido);
    }
}