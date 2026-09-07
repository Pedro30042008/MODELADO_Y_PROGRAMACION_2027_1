/* Importación de paquetes. */
import java.util.Iterator;
import java.util.LinkedList;

/**
 * TablaHash.
 *
 * Clase destinada a generar una TablaHash mediante encadenamiento.
 */
public class TablaHash {

    /**
     * Clase interna privada destinada a contener la función de dispersión.
     */
    private class FuncionDispersion {

        /**
         * Método que aplica la función de dispersión h(k) = k mod m.
         * @param llave de una Tupla.
         * @return índice de una cubeta en la TablaHash.
         */
        public int hash(int llave) {
	    // Aplicamos Math.floorMod() para la función mod.
            return Math.floorMod(llave, cubetas.length);
        }
    }

    /* Función de dispersión utilizada por la tabla. */
    private FuncionDispersion dispersor;

    /* Número de elementos almacenados en la TablaHash. */
    private int elementos;

    /* Arreglo de cubetas. */
    private LinkedList<Tupla>[] cubetas;

    /**
     * Constructor por default.
     * Crea una TablaHash de tamaño 7.
     */
    @SuppressWarnings("unchecked")
    public TablaHash() {
	// Creamos un arreglo de cubetas de tamaño 7.
        cubetas = new LinkedList[7];
    }

    /**
     * Constructor para crear una TablaHash con una dimensión dada.
     * @param dimensión/tamaño de la TablaHash.
     */
    @SuppressWarnings("unchecked")
    public TablaHash(int dimension) {
	// Verificamos una longitud válida.
        if (dimension <= 0) {
            throw new IllegalArgumentException(
                "La dimensión debe ser mayor que 0."
            );
        }
	// Creamos un arreglo de cubetas del tamaño dado.
        cubetas = new LinkedList[dimension];
    }

    /**
     * Inserta una Tupla dada una llave y su valor.
     * Si la llave ya existe, actualiza el valor.
     * @param llave llave de la Tupla.
     * @param valor valor asociado a la llave.
     */
    public void insertar(int llave, String valor) {
	// Si el factor de carga es mayor que 0.71
	if (factorCarga() > 0.71) {
	    // Hacemos rehashing.
	    reHashing();
	}
	// Insertamos la llave con su valor.
	insertarPrivado(llave, valor);
    }

    /**
     * Método para incrementar el tamaño/dimension de la TablaHash y
     * volver a dispersar sus elementos.
     */
    @SuppressWarnings("unchecked") // Advertencia genéricos LinkedList<>[]
    private void reHashing() {
	// Actualizamos el número de elementos.
	elementos = 0;
	// Calculamos el nuevo tamaño de la tabla.
	int nuevoTamanio = cubetas.length * 2;
	// Referenciamos las viejas cubetas.
	LinkedList<Tupla>[] viejasCubetas = this.cubetas;
	// Nuevo arreglo con tamaño/dimension incrementado en la TablaHash.
        this.cubetas = new LinkedList[nuevoTamanio];
	// Recorremos el arreglo de cubetasviejas.
	for (LinkedList<Tupla> cubetaTuplas : viejasCubetas) {
	    // Verificamos si es null la cubeta.
	    if (cubetaTuplas == null) {
		continue;
	    }
	    // Verificamos si es vacia la cubeta.
	    if (cubetaTuplas.isEmpty()) {
		continue;
	    }
	    // En caso contrario, revisamos adentro.
	    for (Tupla t : cubetaTuplas) {
		// Insertamos en la nueva lista de cubetas la tupla.
		insertarPrivado(t.getLlave(), t.getValor());
	    }
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
    private void insertarPrivado(int llave, String valor) {
	// Invocamos a un nuevo dispersor.
	this.dispersor = new FuncionDispersion();
        // Calculamos el índice donde se dirige la llave dada.
	int indiceArreglo = this.dispersor.hash(llave);
        // Lista de elementos(llave, valor).
        LinkedList<Tupla> cubetaTuplas = cubetas[indiceArreglo];
	// Si la cubeta es null.
	if (cubetaTuplas == null) {
	    // Creamos una cubeta de tuplas.
	    cubetas[indiceArreglo] = new LinkedList<>();
	    cubetaTuplas = cubetas[indiceArreglo];
	}
        // Verificamos si tenemos la llave en la cubeta.
        for (Tupla t : cubetaTuplas) {
            // Si encontramos la llave.
            if (t.getLlave() == llave) {
                // Asignamos el nuevo valor a la tupla.
                t.setValor(valor);
                // Terminamos
		return;
            }
        }
        // Si no encontramos la llave, añadimos una Tupla a la cubeta.
	cubetaTuplas.add(new Tupla(llave, valor));
	// Aumentamos el número de elementos contenidos en la TablaHash.
        this.elementos++;
    }
    
    /**
     * Busca el valor asociado a una llave.
     * @param llave llave que se desea buscar.
     * @return valor asociado a la llave, o NOT_FOUND si no existe.
     */
    public String buscar(int llave) {
	// Invocamos a un nuevo dispersor.
	this.dispersor = new FuncionDispersion();
        // Calculamos el índice donde se dirige la llave dada.
	int indiceArreglo = this.dispersor.hash(llave);
        // Lista de elementos(llave, valor).
        LinkedList<Tupla> cubetaTuplas = cubetas[indiceArreglo];
	// Si la cubeta es null.
	if (cubetaTuplas == null) {
	    // No se encontro el elemento(llave, tupla).
	    return "NOT_FOUND";
	}
        // Verificamos si tenemos la llave en la cubeta.
        for (Tupla t : cubetaTuplas) {
            // Si encontramos la llave.
            if (t.getLlave() == llave) {
                // Asignamos el nuevo valor a la tupla.
                return t.getValor();
            }
        }
        // No se encontro el elemento(llave, tupla).
        return "NOT_FOUND";
    }

    /**
     * Elimina la Tupla asociada a una llave.
     *
     * @param llave llave que se desea eliminar.
     */
    public void eliminar(int llave) {
	// Invocamos a un nuevo dispersor.
	this.dispersor = new FuncionDispersion();
        // Calculamos el índice donde se dirige la llave dada.
	int indiceArreglo = this.dispersor.hash(llave);
        // Lista de elementos(llave, valor).
        LinkedList<Tupla> cubetaTuplas = cubetas[indiceArreglo];
	// Si la cubeta es null.
	if (cubetaTuplas == null) {
	    // No se encontró el elemento(llave, valor).
	    return;
	}
	// Creamos un iterador de la cubeta para eliminar el elemento(llave, valor).
        Iterator<Tupla> iterador = cubetaTuplas.iterator();
        // Verificamos si tenemos la llave en la cubeta.
	while (iterador.hasNext()) {
	    // Tupla actual.
            Tupla tupla = iterador.next();
	    // Si coinciden las llaves.
            if (tupla.getLlave() == llave) {
		// Eliminamos el elemento(llave, valor) de la lista.
                iterador.remove();
		// Decrementamos el número de elementos.
                this.elementos--;
		// Terminamos.
                return;
            }
        }
    }

    /**
     * Calcula el factor de carga alpha = n / m.
     * @return factor de carga de la TablaHash.
     */
    public double factorCarga() {
        return (double) elementos / cubetas.length;
    }

    /**
     * Método toString de una TablaHash.
     * @return cadena de texto para representar una Tabla Hash.
     */
    @Override
    public String toString() {
	// String para guardar la cadena.
	StringBuilder tablaHash = new StringBuilder("");
	// Variable para guardar el índice.
	int i = 0;
	// Recorremos el arreglo de cubetas.
	for (LinkedList<Tupla> cubetaTupla : cubetas) {
	    // Verificamos si es null la cubeta.
	    if (cubetaTupla == null) {
		tablaHash.append(i++ + "->" + "[]\n");
		continue;
	    }
	    // Verificamos si es vacia la cubeta.
	    if (cubetaTupla.isEmpty()) {
		tablaHash.append(i++ + "->" + "[]\n");
		continue;
	    }
	    // Preparamos apertura.
	    tablaHash.append(i++ + "->" + "[");
	    // En caso contrario, revisamos adentro.
	    for (Tupla t : cubetaTupla) {
		tablaHash.append(t.toString() + ", ");
	    }
	    // Borramos la ultima coma.
	    tablaHash.setLength(tablaHash.length() - 2);
	    // Preparamos cierre.
	    tablaHash.append("]\n");
	}
	// Quitamos el último salto de línea.
	tablaHash.setLength(tablaHash.length() - 1);
	// Retornamos la cadena final.
	return tablaHash.toString();
    }
}
