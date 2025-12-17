# Proyecto Final – E-commerce de Pastelería (Spring Boot)

## 📌 Descripción
Proyecto backend desarrollado con **Spring Boot**, que implementa un sistema de gestión para un e-commerce de pastelería.

Incluye un **CRUD de productos** y un **CRUD de pedidos**.

El sistema cuenta con dos entidades principales:
- Producto  
- Pedido  

Debido a la relación **muchos a muchos (N:N)** entre productos y pedidos, se implementó la entidad intermedia **PedidoProducto**, donde se almacena la cantidad de cada producto dentro de un pedido y la relación entre ambas entidades.

##  Características principales
- CRUD completo de **Productos**
- CRUD completo de **Pedidos**
- Entidad intermedia **PedidoProducto** para manejar la relación N:N
- Arquitectura en capas: **Controllers, Services y Repositories**
- Uso de **DTOs** para desacoplar las entidades y manejar datos de entrada y salida
- Conversión entre DTOs y entidades utilizando el **patrón Builder**
- Manejo centralizado de excepciones con mensajes personalizados
- Base de datos **H2 en memoria**, utilizada para pruebas y desarrollo
- Colección de requests de **Insomnia** incluida en la carpeta `docs/`

##  Tecnologías utilizadas
- Java
- Spring Boot
- Maven
- H2 Database
- Programación Orientada a Objetos

- ##  Notas
Este proyecto fue realizado como trabajo final del curso de **Java Backend**, con el objetivo de aplicar conceptos fundamentales del desarrollo backend y buenas prácticas.
