/**
 * Función Dispersión.
 * 
 * Clase destinada a guardar funciones de dispersión para aplicarlas
 * posteriormete.
 *
 */
public class FuncionDispersion {

    // Tamaño de la TablaHash.
    private static int elementos;

    /**
     * Método para modificar el tamaño de la TablaHash.
     * @param int tamaño de la TablaHash
     */
    public void setElementos(int elementos) {
	this.elementos = elementos;
    }
    
    /**
     * Método que aplica la funcion de dispersión h(k) = k mod m.
     * k = llave y m = elementos.
     * @param int llave del objeto.
     * @return int índice en la TablaHash dada una llave.
     */
    public static int hash(int llave) {
	// Regresamos el resultado de h(k).
	return llave % elementos;
    }
    
}
