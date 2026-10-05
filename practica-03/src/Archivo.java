abstract class Archivo implements Elemento {
// Conserven nombre, tamanio y el constructor.
    protected int tamanio;
    protected String nombre;

    public Archivo(int tamanio, String nombre) {
        this.tamanio = tamanio;
        this.nombre = nombre;
    }
         // Completen aqui obtenerTamanio():
         // debe devolver el tamanio de ESTE archivo.

    @Override
    public int obtenerTamanio() {
        return tamanio;
    }
}