/**
 * Creador concreto que construye archivos de texto mediante Factory Method.
 */
public class CreadorTexto extends CreadorArchivo {
    /**
     * Construye un archivo de texto.
     *
     * @param nombre nombre del archivo
     * @param tamanio tamaño del archivo
     * @return archivo creado
     */
    @Override
    Archivo crearArchivo(String nombre, int tamanio) {
        return new ArchivoTexto(nombre, tamanio);
    }
}
