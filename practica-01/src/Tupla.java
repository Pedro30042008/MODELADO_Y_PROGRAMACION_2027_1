
/**
 * Tupla
 * 
 * Clase destinada al mapeo de una llave a un valor
 */
public class Tupla {
    //ATRIBUTOS
    private final int llave;
    private String valor;

    /**
     * Constructor basico para crear una Tupla
     * @param llave llave asociada al valor.
     * @param valor valor asociado a la llave.
     */
    public Tupla(int llave, String valor) {
        this.llave = llave;
        this.valor = valor;
    }

    /**
     * Regresa el valor.
     * @return valor
     */
    public String getValor() {
        return valor;
    }

    /**
     * Asiganamos un valor
     * @param valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Regresa la llave asociada al valor
     * @return
     */
    public int getLlave() {
        return llave;
    }

    /**
     * Representacion visula del objeto tupla
     */
    @Override
    public String toString (){
        return "("+llave+", "+valor+")";
    }
}
