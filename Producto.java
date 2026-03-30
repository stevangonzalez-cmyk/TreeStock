/**
 * Clase Producto - Representa un nodo dentro del Árbol Binario de Búsqueda.
 *
 * Cada Producto actúa como un nodo que contiene:
 *   - Sus datos propios (id y nombre del producto)
 *   - Dos punteros (referencias) hacia sus hijos: izquierdo y derecho
 *
 * Lógica de los punteros:
 *   - "izquierdo" apunta al hijo cuyo ID es MENOR que el nodo actual.
 *   - "derecho"   apunta al hijo cuyo ID es MAYOR que el nodo actual.
 *   - Si no tiene hijo en alguna dirección, ese puntero vale null.
 *
 * Ejemplo visual:
 *
 *         [10 - Mouse]
 *        /             \
 *   [5 - Teclado]   [15 - Monitor]
 *
 * Aquí, Mouse.izquierdo → Teclado  (5 < 10)
 *        Mouse.derecho  → Monitor  (15 > 10)
 */
public class Producto {

    // ── Datos del producto ──────────────────────────────────────────────────
    int id;       // Identificador único — es la CLAVE del árbol binario de búsqueda
    String nombre; // Nombre descriptivo del producto

    // ── Punteros hacia los nodos hijos ──────────────────────────────────────
    Producto izquierdo; // Hijo izquierdo  → ID menor que el nodo actual
    Producto derecho;   // Hijo derecho    → ID mayor que el nodo actual

    /**
     * Constructor: crea un nuevo nodo-producto con sus datos.
     * Los punteros izquierdo y derecho se inicializan en null automáticamente
     * (el nodo nace como hoja, sin hijos).
     *
     * @param id     Identificador único del producto
     * @param nombre Nombre del producto
     */
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        // izquierdo y derecho son null por defecto en Java
    }
}
