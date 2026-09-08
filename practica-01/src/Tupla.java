/**
 * Tupla.
 *
 * Clase destinada a crear elementos(llave, valor).
 */
public class Tupla {

    /* Llave de la Tupla . */
    private final int llave;
    /* Valor de la Tupla. */
    private String valor;

    /**
     * Constructor por parámetros para crear una Tupla.
     * @param llave asociada a la tupla.
     * @param valor asociado a la tupla.
     */
    public Tupla(int llave, String valor) {
        this.llave = llave;
        this.valor = valor;
    }

    /**
     * Regresa el valor asociado a la Tupla.
     * @return valor de la Tupla.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Asigna un nuevo valor a la Tupla.
     * @param nuevo valor de la Tupla.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Regresa la llave asociada a la Tupla.
     * @return llave de la Tupla.
     */
    public int getLlave() {
        return llave;
    }

    /**
     * Método toString de la clase Tupla.
     * @return representación en cadena de texto de una Tupla.
     */
    @Override
    public String toString() {
        return "(" + llave + ", " + valor + ")";
    }
    //Pedro Ruiz, Miranda Sánchez, Alan Alvarez
}
