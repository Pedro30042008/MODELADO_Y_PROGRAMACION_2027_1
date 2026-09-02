/**
 * Función Dispersión.
 * 
 * Clase destinada a guardar funciones de dispersión para aplicarlas
 * posteriormete.
 */
public class FuncionDispersion {

    // Tamaño de la TablaHash.
    private static int dimension;

    /**
     * Método para modificar el tamaño de la TablaHash.
     * @param m tamaño de la TablaHash
     */
    public static void setElementos(int m) {
	    dimension = m;
    }
    
    /**
     * Método que aplica la funcion de dispersión h(k) = k mod m.
     * k = llave y m = tamaño de la HashTable.
     * @param llave llave del objeto.
     * @return int índice en la TablaHash dada una llave.
     */
    public static int hash(int llave) {
        // Regresamos el resultado de h(k).
        return llave % dimension;
    }
}
