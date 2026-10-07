import java.util.ArrayList;
import java.util.List;

/**
 * Agrupa elementos de Composite y suma sus tamaños, incluidas las subcarpetas.
 */
public class Carpeta implements Elemento {
    /**
     * Nombre de la carpeta.
     */
    String nombre;
    /**
     * Elementos contenidos en esta carpeta.
     */
    private List<Elemento> elementos;

    /**
     * Construye una carpeta inicialmente vacía.
     *
     * @param nombre nombre de la carpeta
     */
    public Carpeta(String nombre) {
        this.elementos = new ArrayList<>();
        this.nombre = nombre;
    }

    /**
     * Añade un archivo o subcarpeta a la colección de elementos.
     *
     * @param elemento elemento que se agrega
     */
    void agregar(Elemento elemento) {
        elementos.add(elemento);
    }

    /**
     * Suma recursivamente los tamaños de los elementos contenidos.
     *
     * @return tamaño total del elemento
     */
    @Override
    public int obtenerTamanio() {
        int total = 0;
        for (Elemento elemento : elementos) {
            total += elemento.obtenerTamanio();
            }
        return total;
        }
}
//Alan Gael, Pedro Pablo, Miranda Sanchez