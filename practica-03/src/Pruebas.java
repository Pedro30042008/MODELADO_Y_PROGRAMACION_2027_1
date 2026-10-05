import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Comprueba tamaños, tipos de archivos y la salida del ejemplo sin bibliotecas externas.
 */
public class Pruebas {
    /**
     * Compara el resultado obtenido con el esperado y muestra el caso exitoso.
     *
     * @param nombre descripción del caso
     * @param esperado valor que debe devolver la operación
     * @param obtenido valor devuelto por la operación
     * @throws AssertionError si los valores no coinciden
     */
    static void comprobar(String nombre, int esperado, int obtenido) {
        if (esperado != obtenido) {
            throw new AssertionError(nombre + " | esperado=" + esperado
                    + " | obtenido=" + obtenido);
        }
        System.out.println("OK: " + nombre + " | esperado=" + esperado
                + " | obtenido=" + obtenido);
    }

    /**
     * Ejecuta las cinco pruebas de tamaño y las verificaciones de creación y envío.
     *
     * @param args argumentos de ejecución, no utilizados
     * @throws Exception si falla la captura de salida
     * @throws AssertionError si alguna comprobación falla
     */
    public static void main(String[] args) throws Exception {
        CreadorArchivo pdf = new CreadorPDF();
        CreadorArchivo texto = new CreadorTexto();
        Carpeta vacia = new Carpeta("Vacia");
        comprobar("Carpeta vacia", 0, vacia.obtenerTamanio());
        Carpeta uno = new Carpeta("Un PDF");
        uno.agregar(pdf.crearArchivo("practica.pdf", 120));
        comprobar("Un PDF", 120, uno.obtenerTamanio());
        Carpeta dos = new Carpeta("PDF y texto");
        dos.agregar(pdf.crearArchivo("practica.pdf", 120));
        dos.agregar(texto.crearArchivo("notas.txt", 80));
        comprobar("PDF y texto", 200, dos.obtenerTamanio());
        Carpeta ejemplos = new Carpeta("Ejemplos");
        ejemplos.agregar(texto.crearArchivo("ejemplo.txt", 50));
        dos.agregar(ejemplos);
        comprobar("Ejemplo completo", 250, dos.obtenerTamanio());
        Carpeta cero = new Carpeta("Archivo de cero");
        cero.agregar(texto.crearArchivo("vacio.txt", 0));
        comprobar("Archivo de cero", 0, cero.obtenerTamanio());

        if (!(pdf.crearArchivo("a.pdf", 1) instanceof ArchivoPDF)
                || !(texto.crearArchivo("a.txt", 1) instanceof ArchivoTexto)) {
            throw new AssertionError("Los creadores devuelven el tipo incorrecto");
        }
        System.out.println("OK: tipos de Factory Method");
        final String[] recibido = new String[2];
        Main.enviarResultado(dos, "destino", (destino, mensaje) -> {
            recibido[0] = destino;
            recibido[1] = mensaje;
        });
        if (!"destino".equals(recibido[0])
                || !"Tamanio total: 250".equals(recibido[1])) {
            throw new AssertionError("enviarResultado no conserva los datos");
        }
        PrintStream original = System.out;
        ByteArrayOutputStream salida = new ByteArrayOutputStream();
        try (PrintStream captura = new PrintStream(salida, true, "UTF-8")) {
            System.setOut(captura);
            Main.main(new String[0]);
        } finally {
            System.setOut(original);
        }
        String nl = System.lineSeparator();
        String esperado = "250" + nl + "Para: profesor@universidad.edu" + nl
                + "Tamanio total: 250" + nl;
        if (!esperado.equals(salida.toString("UTF-8"))) {
            throw new AssertionError("La salida de Main cambio");
        }
        System.out.println("OK: notificador y salida exacta de Main");
    }
}
