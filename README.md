# Proyecto StockX ASCII

## Descripción

StockX ASCII es una implementación en línea de comandos (CLI) de la plataforma StockX, que permite a los usuarios gestionar ofertas de compra y venta de zapatillas de manera similar a como se haría en la web oficial de StockX. Este proyecto está desarrollado en Java.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes y clases que se encargan de diferentes aspectos de la funcionalidad:

### Paquete `edu.estatuas`

- **Stockx.java**: Clase principal que contiene el método `main` y la lógica principal del programa.
- **criteria**: Contiene las clases que implementan diferentes criterios para filtrar y gestionar las ofertas.
  - **AndCriteria.java**: Implementa el criterio de "AND" para combinar múltiples criterios. Devuelve una lista de varios elementos.
  - **Asks.java**: Filtra las ofertas de venta (asks). Devuelve una lista de varios elementos.
  - **Bids.java**: Filtra las ofertas de compra (bids). Devuelve una lista de varios elementos.
  - **Criteria.java**: Interfaz para definir criterios.
  - **LastSale.java**: Filtra la última venta realizada. Devuelve una lista con un solo elemento.
  - **Max.java**: Filtra la oferta con el precio máximo. Devuelve una lista con un solo elemento.
  - **MaxBid.java**: Filtra la oferta de compra con el precio máximo. Devuelve una lista con un solo elemento.
  - **Min.java**: Filtra la oferta con el precio mínimo. Devuelve una lista con un solo elemento.
  - **MinAsk.java**: Filtra la oferta de venta con el precio mínimo. Devuelve una lista con un solo elemento.
  - **Sales.java**: Filtra todas las ventas realizadas. Devuelve una lista de varios elementos.
  - **Size.java**: Filtra las ofertas por tamaño. Devuelve una lista de varios elementos.
- **item**: Contiene las clases que representan los diferentes tipos de ofertas y artículos.
  - **Ask.java**: Representa una oferta de venta.
  - **Bid.java**: Representa una oferta de compra.
  - **Item.java**: Interfaz para definir un artículo.
  - **Offer.java**: Clase base para las ofertas.
  - **Sale.java**: Representa una venta realizada.
  - **Sneaker.java**: Representa una zapatilla y sus ofertas asociadas.

### Paquete `edu.estatuas.test`

- **criteria**: Contiene las clases de prueba para los diferentes criterios.
  - **AndCriteriaTest.java**
  - **AsksTest.java**
  - **BidsTest.java**
  - **LastSaleTest.java**
  - **MaxBidTest.java**
  - **MaxTest.java**
  - **MinAskTest.java**
  - **MinTest.java**
  - **SalesTest.java**
  - **SizeTest.java**
- **item**: Contiene las clases de prueba para los diferentes tipos de ofertas y artículos.

## Dependencias

El proyecto utiliza Maven para la gestión de dependencias. Las dependencias principales incluyen:

- **JUnit**: Para la realización de pruebas unitarias.
- **Maven Compiler Plugin**: Para la compilación del código fuente.
- **Maven Surefire Plugin**: Para la ejecución de pruebas.

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio desde GitHub.
2. Navega al directorio del proyecto.
3. Ejecuta el comando `mvn clean install` para compilar el proyecto y ejecutar las pruebas.
4. Ejecuta el archivo JAR generado en el directorio `target` con el comando `java -jar target/stockx-1.0.0.jar`.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.

## Enlaces

- [Repositorio en GitHub](https://github.com/GabrielgsdCIUwU/stockx-ascii)
- [StockX Oficial](https://stockx.com)