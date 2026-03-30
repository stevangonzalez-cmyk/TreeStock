/**
 * Clase ArbolInventario - Contiene la lógica del Árbol Binario de Búsqueda (ABB).
 *
 * Un ABB tiene una regla fundamental:
 *   - Todo nodo del subárbol IZQUIERDO tiene un ID MENOR al nodo raíz.
 *   - Todo nodo del subárbol DERECHO  tiene un ID MAYOR al nodo raíz.
 *
 * Esta propiedad permite buscar, insertar y listar productos de forma eficiente.
 *
 * Los métodos públicos reciben/devuelven sin parámetros de nodo (interfaz limpia),
 * y delegan el trabajo real a métodos privados recursivos.
 */
public class ArbolInventario {

    // ── Raíz del árbol ──────────────────────────────────────────────────────
    // La raíz es el punto de entrada. Al inicio el árbol está vacío (null).
    private Producto raiz;

    /**
     * Constructor: crea un árbol vacío.
     */
    public ArbolInventario() {
        raiz = null;
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MÉTODO PÚBLICO: insertar
    //  Punto de entrada para registrar un nuevo producto en el árbol.
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Registra un producto en el árbol a partir de su ID y nombre.
     * Delega la inserción recursiva al método privado insertarRecursivo.
     *
     * @param id     ID único del producto
     * @param nombre Nombre del producto
     */
    public void insertar(int id, String nombre) {
        Producto nuevoProducto = new Producto(id, nombre);
        raiz = insertarRecursivo(raiz, nuevoProducto);
    }

    // ── Método privado recursivo de inserción ───────────────────────────────

    /**
     * Inserta un nodo en el subárbol con raíz "actual" y devuelve la nueva raíz
     * de ese subárbol (puede ser el mismo nodo o uno nuevo si el subárbol estaba vacío).
     *
     * Casos:
     *   1. actual == null  → Llegamos a una posición libre: colocamos el nuevo nodo aquí.
     *   2. nuevo.id < actual.id → El nuevo producto va al subárbol IZQUIERDO.
     *   3. nuevo.id > actual.id → El nuevo producto va al subárbol DERECHO.
     *   4. nuevo.id == actual.id → ID duplicado, no se inserta (avisamos al usuario).
     *
     * @param actual El nodo raíz del subárbol que estamos analizando
     * @param nuevo  El producto que queremos insertar
     * @return       La raíz actualizada del subárbol
     */
    private Producto insertarRecursivo(Producto actual, Producto nuevo) {

        // CASO BASE: posición libre encontrada → el nuevo nodo va aquí
        if (actual == null) {
            return nuevo;
        }

        // CASO RECURSIVO: comparamos IDs para decidir la dirección
        if (nuevo.id < actual.id) {
            // El nuevo ID es menor → baja al subárbol izquierdo
            actual.izquierdo = insertarRecursivo(actual.izquierdo, nuevo);

        } else if (nuevo.id > actual.id) {
            // El nuevo ID es mayor → baja al subárbol derecho
            actual.derecho = insertarRecursivo(actual.derecho, nuevo);

        } else {
            // ID duplicado → el árbol no permite IDs repetidos
            System.out.println("  [!] Ya existe un producto con ID " + nuevo.id + ". No se insertó.");
        }

        // Devolvemos el nodo actual (sin cambios en su posición)
        return actual;
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MÉTODO PÚBLICO: mostrarInorden
    //  Lista todos los productos ordenados de menor a mayor ID.
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Muestra el inventario completo recorriendo el árbol en INORDEN:
     *   izquierdo → raíz → derecho
     *
     * Gracias a la propiedad del ABB, esto produce la lista ordenada por ID.
     */
    public void mostrarInorden() {
        if (raiz == null) {
            System.out.println("  El inventario está vacío.");
            return;
        }
        System.out.println("  ID    | Nombre del Producto");
        System.out.println("  ------+----------------------");
        recorridoInorden(raiz);
    }

    // ── Método privado recursivo de recorrido inorden ───────────────────────

    /**
     * Recorre el subárbol en orden: izquierdo → nodo actual → derecho.
     *
     * @param actual Nodo raíz del subárbol que se está recorriendo
     */
    private void recorridoInorden(Producto actual) {
        if (actual == null) {
            return; // Caso base: subárbol vacío, no hay nada que visitar
        }

        // 1. Visitar primero el subárbol izquierdo (IDs menores)
        recorridoInorden(actual.izquierdo);

        // 2. Procesar el nodo actual (imprimirlo)
        System.out.printf("  %-6d| %s%n", actual.id, actual.nombre);

        // 3. Visitar el subárbol derecho (IDs mayores)
        recorridoInorden(actual.derecho);
    }

    // ════════════════════════════════════════════════════════════════════════
    //  MÉTODO PÚBLICO: buscar
    //  Busca un producto por su ID y reporta si existe.
    // ════════════════════════════════════════════════════════════════════════

    /**
     * Busca un producto por ID e imprime el resultado.
     * Usa búsqueda recursiva aprovechando la propiedad del ABB,
     * lo que hace la búsqueda muy eficiente (similar a búsqueda binaria).
     *
     * @param id ID del producto a buscar
     */
    public void buscar(int id) {
        Producto encontrado = buscarRecursivo(raiz, id);
        if (encontrado != null) {
            System.out.println("  ✔ Producto encontrado → ID: " + encontrado.id
                    + " | Nombre: " + encontrado.nombre);
        } else {
            System.out.println("  ✘ No existe ningún producto con ID " + id + " en el inventario.");
        }
    }

    // ── Método privado recursivo de búsqueda ────────────────────────────────

    /**
     * Busca el nodo con el ID indicado dentro del subárbol con raíz "actual".
     *
     * Casos:
     *   1. actual == null        → No se encontró (llegamos a una hoja vacía).
     *   2. id == actual.id       → ¡Encontrado! Devolvemos el nodo.
     *   3. id < actual.id        → El ID buscado está en el subárbol izquierdo.
     *   4. id > actual.id        → El ID buscado está en el subárbol derecho.
     *
     * @param actual Nodo raíz del subárbol que se está inspeccionando
     * @param id     ID a buscar
     * @return       El nodo encontrado, o null si no existe
     */
    private Producto buscarRecursivo(Producto actual, int id) {
        // Caso base 1: subárbol vacío → el ID no está en el árbol
        if (actual == null) {
            return null;
        }

        // Caso base 2: encontramos el nodo
        if (id == actual.id) {
            return actual;
        }

        // Casos recursivos: decidimos en qué dirección continuar
        if (id < actual.id) {
            // El ID buscado es menor → solo puede estar a la izquierda
            return buscarRecursivo(actual.izquierdo, id);
        } else {
            // El ID buscado es mayor → solo puede estar a la derecha
            return buscarRecursivo(actual.derecho, id);
        }
    }
}
