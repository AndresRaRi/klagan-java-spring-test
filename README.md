# Proyecto de Consulta de Precios - E-Commerce

Este proyecto de Spring Boot proporciona un servicio REST para consultar los precios de productos en una base de datos de comercio electrónico. Los precios se gestionan en función de la fecha de aplicación, el identificador de producto y el identificador de cadena (marca).

## Tabla de Contenidos

- [Requisitos](#requisitos)
- [Configuración](#configuración)
- [Uso](#uso)
- [Pruebas Unitarias](#pruebas-unitarias)
- [Ejemplos de Solicitud](#ejemplos-de-solicitud)
- [Contribuciones](#contribuciones)
- [Licencia](#licencia)

## Requisitos

- Java 8 o superior
- Spring Boot
- Maven (para compilar y ejecutar el proyecto)
- IDE (por ejemplo, IntelliJ IDEA o Eclipse)
- Dependencias definidas en el archivo `pom.xml`

## Configuración

1. Clona este repositorio o descarga el código fuente.
2. Abre el proyecto en tu IDE.
3. Configura las dependencias y la base de datos H2, como se describe en el archivo `pom.xml` y `application.properties`.
4. Ejecuta la aplicación.

## Uso

La aplicación proporciona un servicio REST para consultar precios de productos. Puedes enviar solicitudes GET a la siguiente URL:

http://localhost:8080/prices?date={fecha}&productId={idDelProducto}&brandId={idDeLaCadena}

- `date`: Fecha de aplicación.
- `productId`: Identificador del producto.
- `brandId`: Identificador de la cadena (marca).

La aplicación buscará el precio aplicable según los parámetros proporcionados y devolverá los datos del precio correspondiente.

## Pruebas Unitarias

El proyecto incluye pruebas unitarias para verificar el funcionamiento correcto del servicio. Puedes ejecutar estas pruebas usando tu entorno de desarrollo o ejecutando `mvn test` en la línea de comandos.
