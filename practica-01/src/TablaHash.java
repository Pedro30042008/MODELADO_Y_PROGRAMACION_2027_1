import java.util.LinkedList;

/**
 * HashTable.
 * 
 * Clase destinada a generar una HashTable.
 */
public class TablaHash {

    /**
     * Clase Interna Privada Función Dispersión.
     *
     * Clase destinada a guardar funciones de dispersión.
     */
    private class FuncionDispersion {
	
	// MÉTODOS

	/**
	 * Método constructor vacío por completitud.
	 */
	public FuncionDispersion() {
	}
	
	/**
	 * Método que aplica la funcioó de dispersión h(k) = k mod m.
	 * k = llave y m = dimensión/tamaño de la TablaHash.
	 * @param llave ; llave de una Tupla.
	 * @return índice de una cubeta en la TablaHash.
	 */
	public int hash(int llave) {
	    // Regresamos el resultado de h(k).
	    return llave % tablaHash.length;
	}
    }
    
    // ATRIBUTOS: TablaHash

    /* Clase de Funcion de dispersión. */
    private FuncionDispersion dispersor = new FuncionDispersion();
    /* Número de elementos en la TablaHash. */
    private int numElementos;
    /* Arreglo de cubetas. */
    private LinkedList<Tupla>[] tablaHash;

    // METODOS: TablaHash

    /**
     * Método constructor por default para crear una tabla hash.
     */
    @SuppressWarnings("unchecked") // Advertencia genéricos
    public TablaHash() {
	// Colocamos el valor por default de la dimension/tamaño de la tablaHash.
	tablaHash = new LinkedList[7];
        // Inicializamos las cubetas de la tablaHash.
	for (int i = 0; i < tablaHash.length; i++) {
	    tablaHash[i] = new LinkedList<>();
	}
    }

    /**
     * Método constructor para crear una tabla hash dado una dimension/tamaño.
     */
    @SuppressWarnings("unchecked") // Advertencia genéricos
    public TablaHash(int dimension) {
	// Colocamos el valor por default de la dimension/tamaño de la tablaHash.
	tablaHash = new LinkedList[dimension];
        // Inicializamos las cubetas de la tablaHash.
	for (int i = 0; i < tablaHash.length; i++) {
	    tablaHash[i] = new LinkedList<>();
	}
    }
    
    /**
     * Método para insertar en la TablaHash una Tupla dada una llave y su valor.
     * Si no existe la llave en la cubeta señalada, se añade la nueva Tupla.
     * Si ya se encuentra la llave en la cubeta señalada, se cambia su valor
     * por el nuevo.
     * @param llave ; llave de la Tupla.
     * @param valor ; valor de la Tupla.
     */
    public void insertar(int llave, String valor) {
        // Calculamos el índice donde se dirige la llave dada.
	int indiceTabla = dispersor.hash(llave);
        // Cubetas de Tuplas (llave, valor).
        LinkedList<Tupla> cubetas = tablaHash[indiceTabla];
        // Variable para verificar si se encontro la llave.
        boolean existeLlave = false;
        // Verificamos si tenemos la llave en la cubeta.
        for (Tupla tupla : cubetas) {
            // Si encontramos la llave.
            if (tupla.getLlave() == llave) {
                // Asignamos el nuevo valor a la tupla.
                tupla.setValor(valor);
                // Avisamos que si encontramos la llave.
                existeLlave = true;
            }
        }
        // Si no encontramos la llave.
        if (!existeLlave) {
	    // Añadimos una Tupla a la cubeta.
            cubetas.add(new Tupla(llave, valor));
        }
    }
    
    /**
     * Método para buscar un valor dada una llave.
     * @param llave ; llave asociada a un posible valor.
     * @return valor ; valor asociado a la llave.
     */
    public String buscar(int llave) {
	return "Hola";
    }

    /**
     * Método para eliminar una tupla dada una llave.
     * @param llave ; llave asociada a un posible valor.
     */
    public void eliminar(int llave) {
	
    }
    
}
