# Proyecto Final - E-commerce de Pastelería (Spring Boot)

## 📌 Descripción

Proyecto backend desarrollado con **Spring Boot**, que implementa un **CRUD de productos de pastelería** y un **CRUD de pedidos**.

El sistema incluye dos entidades principales:

* **Producto**
* **Pedido**

Debido a la relación **muchos a muchos (N:N)** entre productos y pedidos, arme la entidad intermedia **`PedidoProducto`**, donde se almacena la cantidad y la relación entre ambos.

---

## ⭐ Características principales

* ✔️ **CRUD completo para Productos**
* ✔️ **CRUD completo para Pedidos**
* ✔️ **Entidad intermedia `PedidoProducto`** para manejar la relación N:N
* ✔️ **Arquitectura por capas**: Controllers, Services, Repositories
* ✔️ **DTOs** para desacoplar entidades y manejar datos de entrada/salida
* ✔️ **Conversión entre DTOs y entidades usando el patrón Builder**
* ✔️ **Manejo centralizado de excepciones** con mensajes personalizados
* ✔️ **Base de datos H2 en memoria** para pruebas y desarrollo
* ✔️ **Colección de requests de Insomnia** incluida en carpeta `docs/`

---
