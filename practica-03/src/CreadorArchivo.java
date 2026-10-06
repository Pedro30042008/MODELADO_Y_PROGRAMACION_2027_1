/**
 * Define el Factory Method que implementan los creadores de archivos.
 */
abstract class CreadorArchivo {
    /**
     * Construye un archivo del tipo que decide el creador concreto.
     *
     * @param nombre nombre del archivo
     * @param tamanio tamaño del archivo
     * @return archivo creado
     */
    abstract Archivo crearArchivo(String nombre, int tamanio);
}
