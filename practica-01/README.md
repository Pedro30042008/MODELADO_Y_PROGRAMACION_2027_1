# Práctica 01 — Tabla Hash

## Descripción

En esta práctica implementamos una tabla hash en Java para guardar pares de llave y valor.

La tabla permite:
- insertar elementos;
- buscar por llave;
- eliminar elementos;
- actualizar valores;
- imprimir la tabla.

Las colisiones se manejan mediante encadenamiento, por lo que varias llaves pueden quedar en la misma cubeta.

La función hash utilizada es:

```text
h(k) = k mod m
```

donde `k` es la llave y `m` es el tamaño de la tabla.

## Estructura

```text
practica-01/
├── src/
│   ├── TablaHash.java
│   └── Tupla.java
├── tests/
│   └── practica01.java
└── README.md
```

## Ejecución

Desde la carpeta `practica-01`:

```bash
mkdir -p out
javac -d out src/TablaHash.java src/Tupla.java tests/practica01.java
java -cp out practica01
```

El archivo `practica01.java` contiene los casos de prueba para inserción, búsqueda, colisiones, eliminación y actualización de llaves.
