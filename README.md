# 🌳 Tree-Stock - Sistema de Inventario con Árbol Binario de Búsqueda

## 📌 Descripción del proyecto
Tree-Stock es una aplicación de consola desarrollada en Java para gestionar un inventario de productos mediante un **Árbol Binario de Búsqueda (ABB)**. El sistema permite registrar productos, mostrarlos ordenados por ID y buscarlos por su identificador.

Este proyecto fue realizado como actividad académica de **Estructura de Datos**, aplicando nodos, punteros y recursividad de forma manual, sin utilizar librerías automáticas de colecciones.

---

## 🎯 Objetivo
Comprender el concepto de **árbol binario de búsqueda** y su estructura lógica, aplicándolo en un sistema de inventario implementado en Java.

---

## 📚 Explicación teórica

### ¿Qué es un Árbol Binario de Búsqueda?
Un Árbol Binario de Búsqueda es una estructura de datos formada por nodos. Cada nodo contiene un dato principal y dos referencias: una hacia el hijo izquierdo y otra hacia el hijo derecho.

En este proyecto, cada nodo representa un producto y contiene:

- `id`
- `nombre`
- `izquierdo`
- `derecho`

La regla principal del ABB es:

- Los IDs menores se ubican en el subárbol izquierdo.
- Los IDs mayores se ubican en el subárbol derecho.

Gracias a esta organización, la inserción, búsqueda y recorrido de datos se realiza de manera ordenada y eficiente.

### ¿Cómo se aplica la recursividad?
La recursividad se utiliza en las operaciones principales del árbol:

- **Insertar:** compara el ID nuevo con el nodo actual y decide si debe avanzar a la izquierda o a la derecha hasta encontrar una posición vacía.
- **Buscar:** compara el ID solicitado con el nodo actual y continúa por el subárbol correspondiente.
- **Recorrido inorden:** visita primero el subárbol izquierdo, luego la raíz y finalmente el subárbol derecho, mostrando los productos ordenados de menor a mayor por ID.


## 🎥 Video de sustentación
**Enlace del video:** `Pegar aquí el enlace de YouTube o Google Drive`

---

## 👤 Datos del estudiante

**Nombre completo:** Stevan David Gonzalez Guevara  
**Asignatura:** Estructura de Datos  
**Actividad:** EA3 - Árboles  
**Repositorio:** TreeStock



---

## 👥 Integrantes
- Stevan David Gonzalez Guevara
---

## 🗂️ Estructura del proyecto

```text
TreeStock/
├── Producto.java
├── ArbolInventario.java
├── Main.java
└── README.md
