/**
 * Creador concreto que construye archivos PDF mediante Factory Method.
 */
public class CreadorPDF extends CreadorArchivo {
    /**
     * Construye un archivo PDF.
     *
     * @param nombre nombre del archivo
     * @param tamanio tamaño del archivo
     * @return archivo creado
     */
    @Override
    Archivo crearArchivo(String nombre, int tamanio) {
        return new ArchivoPDF(nombre, tamanio);
    }
}
//Alan Gael, Pedro Pablo, Miranda Sanchez