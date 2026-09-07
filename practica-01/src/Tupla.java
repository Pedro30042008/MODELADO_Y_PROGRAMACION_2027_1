/**
 * Tupla.
 *
 * Clase destinada al mapeo de una llave a un valor.
 */
public class Tupla {

    public static final Tupla DELETED = new Tupla(-1, "-1"); 
    private final int llave;
    private String valor;

    /**
     * Constructor básico para crear una Tupla.
     *
     * @param llave llave asociada al valor.
     * @param valor valor asociado a la llave.
     */
    public Tupla(int llave, String valor) {
        this.llave = llave;
        this.valor = valor;
    }

    /**
     * Regresa el valor.
     *
     * @return valor asociado a la llave.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Asigna un nuevo valor.
     *
     * @param valor nuevo valor.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Regresa la llave asociada al valor.
     *
     * @return llave.
     */
    public int getLlave() {
        return llave;
    }

    /**
     * Representación visual del objeto Tupla.
     */
    @Override
    public String toString() {
        return "(" + llave + ", " + valor + ")";
    }

    /**
     * Equals para determinar si una tupla es igual a otra.
     * Comparando entrada a entrada la igualdad.
     * @param a Tupla con la cual comparar
     * @return true si ambas entradas son iguales, false en otro caso
     */
    public boolean equals (Tupla a){
        return llave == a.llave && valor.equals(a.valor);
    }
}
