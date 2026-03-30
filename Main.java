import java.util.Scanner;

/**
 * Clase Main - Interfaz de usuario del Sistema de Inventario "Tree-Stock".
 *
 * Presenta un menú interactivo en consola que permite al usuario:
 *   1. Registrar productos en el árbol binario de búsqueda.
 *   2. Mostrar el inventario ordenado (recorrido inorden).
 *   3. Buscar un producto por su ID.
 *   0. Salir del sistema.
 *
 * Toda la lógica del árbol está encapsulada en ArbolInventario.
 */
public class Main {

    public static void main(String[] args) {

        // Inicialización
        Scanner scanner = new Scanner(System.in);
        ArbolInventario inventario = new ArbolInventario();
        int opcion;

        // Bucle principal del menú
        do {
            mostrarMenu();
            System.out.print("Seleccione una opción: ");
            opcion = leerEntero(scanner);

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");
                    System.out.print("Ingrese el ID del producto: ");
                    int id = leerEntero(scanner);

                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine().trim();

                    if (nombre.isEmpty()) {
                        System.out.println("[!] El nombre no puede estar vacío.");
                    } else {
                        inventario.insertar(id, nombre);
                        System.out.println("[OK] Producto registrado correctamente.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- INVENTARIO ORDENADO (Inorden) ---");
                    inventario.mostrarInorden();
                    break;

                case 3:
                    System.out.println("\n--- BUSCAR PRODUCTO ---");
                    System.out.print("Ingrese el ID a buscar: ");
                    int idBuscar = leerEntero(scanner);
                    inventario.buscar(idBuscar);
                    break;

                case 0:
                    System.out.println("\nHasta luego. Cerrando Tree-Stock...");
                    break;

                default:
                    System.out.println("[!] Opción no válida. Intente de nuevo.");
                    break;
            }

            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }

    /**
     * Muestra el menú principal en consola.
     */
    private static void mostrarMenu() {
        System.out.println("======================================");
        System.out.println("   TREE-STOCK - Sistema Inventario");
        System.out.println("======================================");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Mostrar Inventario (Inorden)");
        System.out.println("3. Buscar Producto por ID");
        System.out.println("0. Salir");
        System.out.println("======================================");
    }

    /**
     * Lee un número entero desde la consola, manejando entradas inválidas.
     *
     * @param scanner El Scanner activo
     * @return El entero ingresado por el usuario, o -1 si la entrada es inválida
     */
    private static int leerEntero(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[!] Entrada inválida. Debe ingresar un número entero.");
            return -1;
        }
    }
}