# Práctica 3: Refactorización y diseño modular

## Descripción

El programa representa archivos PDF, archivos de texto y carpetas. Calcula el tamaño total de una carpeta, incluyendo sus subcarpetas, muestra el resultado y lo envía mediante un correo simulado en consola. No crea archivos reales ni envía correos por internet.

Se utilizan tres patrones:

- **Composite:** archivos y carpetas implementan `Elemento` y responden a `obtenerTamanio()`.
- **Factory Method:** `CreadorPDF` y `CreadorTexto` construyen sus respectivos archivos.
- **Adapter:** `AdaptadorCorreo` conecta `Notificador.enviar()` con `CorreoLegacy.send_email()`.

## Estructura

```text
practica-03/
|
├── docs/
|   └── Documentacion_practica_03.txt
├── src/ 
|   ├── ArbolB.java
|   ├── AdaptadorCorreo.java
|   ├── Archivo.java
|   ├── ArchivoPDF.java
|   ├── ArchivoTexto.java
|   ├── Carpeta.java
|   ├── CorreoLegacy.java
|   ├── CreadorArchivo.java
|   ├── CreadorPDF.java
|   ├── CreadorTexto.java
|   ├── Elemento.java
|   ├── Main.java
|   └── Notificador.java
├── tests/
│   └── practica03.java
└── README.md
```
## Compilación

Desde la carpeta `practica-03`:

```bash
mkdir -p build && javac -encoding UTF-8 -d build src/*.java
```

## Ejecutar el ejemplo

Compila, ejecuta el programa y elimina los archivos generados al finalizar:

```bash
mkdir -p build && javac -encoding UTF-8 -d build src/*.java && java -cp build Main; rm -rf build
```

El ejemplo contiene un PDF de 120, un texto de 80 y una subcarpeta con un texto de 50. La salida debe ser:

```text
250
Para: profesor@universidad.edu
Tamanio total: 250
```

## Ejecutar las pruebas

Compila el código fuente y las pruebas, ejecuta las pruebas y elimina los archivos generados al finalizar:

```bash
mkdir -p build && javac -encoding UTF-8 -d build src/*.java && javac -encoding UTF-8 -cp build -d build tests/*.java && java -cp build practica03; rm -rf build
```

Al finalizar la ejecución, la carpeta `build/` se elimina para evitar dejar archivos `.class` generados durante la compilación.

`practica03` tiene su propio método `main`. Prepara cada caso, calcula el tamaño y compara el resultado obtenido con el esperado mediante `comprobar`. Imprime `OK` cuando coinciden y `FALLO` cuando no coinciden.

| Caso | Tamaño esperado |
| --- | ---: |
| Carpeta vacía | 0 |
| Carpeta con un PDF de 120 | 120 |
| Carpeta con PDF de 120 y texto de 80 | 200 |
| Ejemplo completo con subcarpeta de 50 | 250 |
| Carpeta con un archivo de tamaño 0 | 0 |

La salida del correo se revisa ejecutando `Main` y comparándola con las tres líneas anteriores.

`Pedro Ruiz, Miranda Sánchez, Alan Alvarez <3`
