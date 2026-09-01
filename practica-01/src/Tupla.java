
/**
 * Tupla
 * 
 * Clase destinada al mapeo de una llave a un valor
 */
public class Tupla {
    //ATRIBUTOS
    String valor;
    int llave;

    /**
     * Constructor basico para la crear una Tupla
     * @param valor
     * @param llave
     */
    public Tupla(String valor, int llave) {
        this.valor = valor;
        this.llave = llave;
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
     * Asignamos llave
     * @param llave
     */
    public void setLlave(int llave) {
        this.llave = llave;
    }

    /**
     * Representacion visula del objeto tupla
     */
    @Override
    public String toString (){
        return "("+llave+", "+valor+")";
    }


}
