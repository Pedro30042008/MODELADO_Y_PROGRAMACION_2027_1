# Práctica 3

Requiere JDK 8 o posterior. Desde esta carpeta:

```bash
mkdir -p build
javac -d build src/*.java
java -cp build Main
java -cp build Pruebas
```

Salida de Main:

```text
250
Para: profesor@universidad.edu
Tamanio total: 250
```

Reemplaza los archivos de `practica-03/src` con estos. Elimina la copia antigua de Main para evitar clases duplicadas; el archivo debe llamarse `Main.java`, no `Main(1).java`. CorreoLegacy está ahora en su propio archivo, con el mismo cuerpo.

Las pruebas se ejecutan aparte para conservar exactamente la salida de Main. Lanzan AssertionError si fallan, sin depender de activar assertions ni de bibliotecas externas.

La entrega también pide código inicial y pruebas antes del cambio. Conserva tu commit de la versión inicial. Los archivos adjuntos ya contenían una refactorización parcial que no compilaba; no se presentan como pruebas iniciales exitosas.
