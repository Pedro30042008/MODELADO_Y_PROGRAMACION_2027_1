/**
 * Clase Tupla.
 *
 * Clase destinada a formar pares ordenados de (llave, valor).
 */
public class Tupla {
    
    // ATRIBUTOS
    
    /* Llave de la Tupla */
    int llave;
    /* Valor de la Tupla */
    String valor;

    // MÉTODOS
    
    /**
     * Método constructor por parámetros (llave, valor).
     * @param valor ; valor de la Tupla.
     * @param llave ; llave de la Tupla.
     */
    public Tupla(int llave, String valor) {
        this.llave = llave;
        this.valor = valor;
    }

    /**
     * Método getter para obtener la llave de la tupla.
     * @return llave de la Tupla.
     */
    public int getLlave() {
        return llave;
    }

    /**
     * Método setter para asignar la llave de la tupla.
     * @param llave ; llave de la Tupla.
     */
    public void setLlave(int llave) {
        this.llave = llave;
    }

    /**
     * Método getter para obtener el valor de la tupla.
     * @return valor de la Tupla.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Método setter para asignar el valor de la tupla.
     * @param valor ; valor de la Tupla.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
    
    /**
     * Método toString para representar a la Tupla.
     * @return representación en cadena de texto de la Tupla.
     */
    @Override
    public String toString (){
        return "(" + llave + ", " + valor + ")";
    }
}
