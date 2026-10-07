
public class practica03 {

    /**
     * Compara el valor esperado con el obtenido.
     *
     * @param nombre descripción de la prueba
     * @param esperado tamaño que debería obtenerse
     * @param obtenido tamaño calculado por el programa
     */
    static void comprobar(String nombre, int esperado, int obtenido) {
        if (esperado == obtenido) {
            System.out.println("OK: " + nombre
                    + " | esperado=" + esperado
                    + " | obtenido=" + obtenido);
        } else {
            System.out.println("FALLO: " + nombre
                    + " | esperado=" + esperado
                    + " | obtenido=" + obtenido);
        }
    }

    /**
     * Prepara los datos y ejecuta las cinco pruebas de tamaño.
     *
     * @param args argumentos de ejecución, no utilizados
     */
    public static void main(String[] args) {
        CreadorArchivo pdf = new CreadorPDF();
        CreadorArchivo texto = new CreadorTexto();

        // 1. Carpeta vacía: debe medir 0.
        Carpeta vacia = new Carpeta("Vacia");
        comprobar("Carpeta vacia", 0, vacia.obtenerTamanio());

        // 2. Carpeta con un PDF de 120: debe medir 120.
        Carpeta uno = new Carpeta("Un PDF");
        uno.agregar(pdf.crearArchivo("practica.pdf", 120));
        comprobar("Un PDF", 120, uno.obtenerTamanio());

        // 3. PDF de 120 y texto de 80: debe medir 200.
        Carpeta dos = new Carpeta("PDF y texto");
        dos.agregar(pdf.crearArchivo("practica.pdf", 120));
        dos.agregar(texto.crearArchivo("notas.txt", 80));
        comprobar("PDF y texto", 200, dos.obtenerTamanio());

        // 4. Agregamos una subcarpeta con un texto de 50.
        // El total debe ser 120 + 80 + 50 = 250.
        Carpeta ejemplos = new Carpeta("Ejemplos");
        ejemplos.agregar(texto.crearArchivo("ejemplo.txt", 50));
        dos.agregar(ejemplos);
        comprobar("Ejemplo completo", 250, dos.obtenerTamanio());

        // 5. Carpeta con un archivo de tamaño 0: debe medir 0.
        Carpeta cero = new Carpeta("Archivo de cero");
        cero.agregar(texto.crearArchivo("vacio.txt", 0));
        comprobar("Archivo de cero", 0, cero.obtenerTamanio());
    }
}