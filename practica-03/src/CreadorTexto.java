public class CreadorTexto extends CreadorArchivo {
    @Override
    Archivo crearArchivo(String nombre, int tamanio) {
        return new ArchivoPDF(nombre, tamanio);
    }
}
