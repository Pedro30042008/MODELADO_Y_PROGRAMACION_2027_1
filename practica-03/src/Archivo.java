/**
 * Representa una hoja de Composite y almacena el nombre y tamaño de un archivo.
 */
abstract class Archivo implements Elemento {
    /**
     * Tamaño del archivo en las unidades usadas por el ejemplo.
     */
    protected int tamanio;
    /**
     * Nombre del archivo.
     */
    protected String nombre;

    /**
     * Construye el archivo con su nombre y tamaño.
     *
     * @param nombre nombre del archivo
     * @param tamanio tamaño del archivo
     */
    public Archivo(String nombre, int tamanio) {
        this.nombre = nombre;
        this.tamanio = tamanio;
    }

    /**
     * Devuelve el tamaño de este archivo.
     *
     * @return tamaño total del elemento
     */
    @Override
    public int obtenerTamanio() {
        return tamanio;
    }
}
