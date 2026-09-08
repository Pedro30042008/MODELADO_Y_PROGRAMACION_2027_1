# Práctica 01 — Tabla Hash

## Descripción

En esta práctica implementamos una **tabla hash** en Java para guardar pares de llave y valor.

La tabla permite:
- Insertar elementos;
- Buscar por llave;
- Eliminar elementos;
- Actualizar valores;
- Imprimir la tabla.

La tabla hash implementa dos estrategias para el manejo de colisiones: **Encadenamiento** y **Direccionamiento abierto mediante sondeo lineal**.

Para encadenamiento, la función hash utilizada es:
```text
h(k) = k mod m
```
donde `k` es la llave y `m` es el tamaño de la tabla.

Para Direccionamineto abierto mediante sondeo lineal, la función hash utilizada es:
```text
h(k,i) = (h(k)+i) mod m
```
donde `k` es la llave, `i` es el desplazamiento respecto a la posición inicial calculada por la función hash y `m` es el tamaño de la tabla. Tambien se implementa la etiqueta `DELETED`.

La carpeta `tests` contiene la clase ejecutable que instancia la tabla hash y ejecuta los distintos casos de prueba definidos para verificar su funcionamiento.

## Estructura

```text
practica-01/
|
├── docs/
|   └── Documentacion_practica_01.txt
├── src/
│   ├── Celda.java
│   ├── Etiqueta.java
|   ├── TablaHash.java
|   ├── TablaHashSondeoLineal.java
|   └── Tupla.java
├── tests/
│   └── practica01.java
└── README.md
```

## Ejecución

Desde la carpeta `practica-01`:

```bash
javac -d bin src/*.java tests/*.java
java -cp bin practica01
rm -rf bin
```
Todo en una sola linea

```bash
javac -d bin src/*.java tests/*.java && java -cp bin practica01 && rm -rf bin
```


## Preguntas

1. Utilizamos el lenguaje `Java` con un paradigma imperativo orientado a objetos.

2,3. Las instrucciones para ejecutar el programa y explicación de cómo ejecutar los casos de prueba ya se     mencionario anteriormente.

4. Explicación de la función hash
    Para el **encademaniento**, se ocupó `h(k) = k mod m`. Hacemos modulo con la llave `k` y el tamaño de la tabla `m`, asegurando que no salga de los limites de la tabla y con el encadenamiento tratamos las colisiones.

    Para el **Direccionamiento abierto** se utilizó la función `h(k,i) = (h(k) + i) mod m`,
    donde `k` representa la llave, `m` el tamaño de la tabla e `i` el número de sondeo realizado. En cada intento, el valor de i aumenta para buscar una nueva posición disponible. Las colisiones se resuelven mediante sondeo lineal, recorriendo posiciones sucesivas hasta encontrar una disponible.

5. Explicación del manejo de colisiones;
    Para el **encademaniento**, se tiene un arreglo de listas de `Tuplas`, en caso de una colisión, se agrega otro nodo al final de la lista con la tupla correspondiente. Igualmantenemos un factor de carga >.71 para evitar complejidades altas.

    Para el **Direccionamiento abierto**, se tiene un solo arreglo de `Celdas` donde cada celda almacena una tupla, en caso de una colisión se recorrera el arreglo hasta encontrar un espacio disponible, para esto nos apoyamos con `i` que en cada "intento" aumentara hasta encontrar un lugar disponible o remplazar la etiqueta `DELETED`.

6. Explicación de qué ocurre cuando dos llaves producen el mismo hash;
    Cuando dos llaves distintas producen el mismo valor hash, ambas son asignadas al mismo índice de la tabla, generando una **Colisión**. Dependiendo de la estrategia utilizada, esta colisión puede resolverse mediante encadenamiento o direccionamiento abierto.

7. explicación de qué ocurre cuando varias llaves caen en la misma cubeta;
    El **Factor de Carga** aumenta y esto nos indica que nuestra función hash no esta funcionando de forma efectiva lo que provocaria aumento en la complejidad de nuestras operaciones.

8. factor de carga final obtenido durante sus pruebas.
    No se permitio que sobrepasara de `.71` para mantener las complejidades bajas y nuestras operaciones eficientes.

9. ¿Por qué tener una colisión no significa que la tabla hash esté implementada incorrectamente?
    El que haya colisiones en una tabla no implica que este mal implementada pues, son inevitables las colisiones, para esto nos ayuda una correcta funcion hash y un correcta estrategia para el manejo de las colisiones.

`Pedro Ruiz, Miranda Sánchez, Alan Alvarez <3`
