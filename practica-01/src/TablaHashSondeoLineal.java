/**
 * TablaSondeoLineal
 * 
 * Clase destinada a la implementacion de una TablaHash utilizando 
 * Direccionamiento Abierto con Sondeo lineal.
 */

public class TablaHashSondeoLineal {
    

    /**
     * Clase interna privada destinada a calcular la función de dispersión.
     */
    private class FuncionDispersion {

	/**
         * Método que aplica la función de dispersión h(k) = k mod m.
         * @param llave de una Tupla.
         * @return índice de una cubeta en la TablaHash.
         */
        public int hash(int llave) {
	    // Aplicamos Math.floorMod() para la función mod.
            return Math.floorMod(llave, celdas.length);
        }
	
        /**
         * Método que aplica la función de dispersión h(k,i) = (h(k)+i) mod m.
         * @param llave de una Tupla.
         * @return índice de una celda en la TablaHash.
         */
        public int hash(int llave, int indice) {
	    return Math.floorMod((hash(llave) + indice), celdas.length);
        }
    }

    /* Función de dispersión utilizada por la tabla. */
    private FuncionDispersion dispersor;

    /* Número de elementos almacenados en la TablaHash. */
    private int elementos;

    /* Arreglo de celdas. */
    private Celda[] celdas;

    /**
     * Constructor por default.
     * Crea una TablaHash de tamaño 7.
     */
    public TablaHashSondeoLineal() {
	// Creamos un arreglo de cubetas de tamaño 7.
       celdas = new Celda[7];
    }

    /**
     * Constructor para crear una TablaHash con una dimensión dada.
     * @param dimensión/tamaño de la TablaHash.
     */
    public TablaHashSondeoLineal(int dimension) {
	// Verificamos una longitud válida.
        if (dimension <= 0) {
            throw new IllegalArgumentException(
                "La dimensión debe ser mayor que 0."
            );
        }
	// Creamos un arreglo de cubetas del tamaño dado.
        celdas = new Celda[dimension];
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
	// Actualizamos el numero de elementos.
	elementos = 0;
	// Calculamos el nuevo tamaño de la tabla.
	int nuevoTamanio = celdas.length * 2;
	// Referenciamos las viejas celdas.
        Celda[] viejasCeldas = this.celdas;
	// Nuevo arreglo con tamaño/dimension incrementado en la TablaHash.
        this.celdas = new Celda[nuevoTamanio];
	// Recorremos el arreglo de viejasCeldas.
	for (Celda celda : viejasCeldas) {
	    // Verificamos si es null la cubeta.
	    if (celda == null) {
		continue;
	    }
	    // Verificamos si es vacia la cubeta.
	    if (celda.getEtiqueta() == Etiqueta.DELETED) {
		continue;
	    }
	    // En caso contrario, insertamos la tupla la nueva tabla de celdas.
	    insertarPrivado(celda.getTupla().getLlave(), celda.getTupla().getValor());
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
	// Referenciamos a un posible candidato.
	int candidato = -1;
	// Referenciamos un contador.
	int contador = 0;
	// Referenciamos el índice de la función hash().
	int indiceArreglo;
	// Mientras no encontremos un espacio diponible.
	while (true) {
	    // Actualizamos el indiceArreglo.
	    indiceArreglo = this.dispersor.hash(llave, contador);	    
	    // Si la celda no existe.
	    if (this.celdas[indiceArreglo] == null) {
		// Si ya tenemos a un candiddato posible.
		if (candidato != -1) {
		    // Asignamos la nueva tupla en el candidato.
		    this.celdas[candidato] = new Celda(null, new Tupla(llave, valor));
		    // Incrementamos el número de elementos.
		    elementos++;
		    return;
		} else {
		    // En caso contrario, creamos una nueva celda con la nueva tupla.
		    this.celdas[indiceArreglo] = new Celda(null, new Tupla(llave, valor));
		    // Incrementamos el número de elementos.
		    elementos++;
		    return;
		}
	    }
	    // Si la celda ha sido eliminada y marcada como DELETED.
	    if (this.celdas[indiceArreglo].getEtiqueta() == Etiqueta.DELETED) {
		// Si el candidato no ha sido elegido.
		if (candidato == -1) {
		    // Asignamos el primer candidato posible.
		    candidato = indiceArreglo;
		}
	    }
	    // Si hay una Tupla, verificamos si tiene la misma llave.
	    if (this.celdas[indiceArreglo].getTupla().getLlave() == llave) {
		// En ese caso, sólo modificamos el valor de la Tupla.
		this.celdas[indiceArreglo].getTupla().setValor(valor);
	        return;
	    }
	    // Aumentamos el contador en uno.
	    contador++;
	}	
    }
    
    /**
     * Busca el valor asociado a una llave.
     * @param llave llave que se desea buscar.
     * @return valor asociado a la llave, o NOT_FOUND si no existe.
     */
    public String buscar(int llave) {
	// Invocamos a un nuevo dispersor.
	this.dispersor = new FuncionDispersion();
	// Referenciamos un contador.
	int contador = 0;
	// Referenciamos el índice de la función hash().
	int indiceArreglo;
	// Mientras no encontremos un espacio diponible.
	while (true) {
	    // Actualizamos el indiceArreglo.
	    indiceArreglo = this.dispersor.hash(llave, contador);	    
	    // Si la celda no existe.
	    if (this.celdas[indiceArreglo] == null) {
		// No se encontraron coincidencias.
		return "NOT_FOUND";
	    }
	    // Si la celda ha sido eliminada y marcada como DELETED.
	    if (this.celdas[indiceArreglo].getEtiqueta() == Etiqueta.DELETED) {
		// Incrementamo el índice.
		contador++;
		// Continuamos con la búsqueda.
		continue;
	    }
	    // Si hay una Tupla, verificamos si tiene la misma llave.
	    if (this.celdas[indiceArreglo].getTupla().getLlave() == llave) {
		// Regresamos el valor de la Tupla.
		return this.celdas[indiceArreglo].getTupla().getValor();
	    }
	    // Aumentamos el contador en uno para continuar la búsqueda.
	    contador++;
	}
	// Por invariante tendremos siempre espacios null al hacer reHashing.
    }

    /**
     * Elimina la Tupla asociada a una llave.
     * @param llave llave que se desea eliminar.
     */
    public void eliminar(int llave) {
	// Invocamos a un nuevo dispersor.
	this.dispersor = new FuncionDispersion();
	// Referenciamos un contador.
	int contador = 0;
	// Referenciamos el índice de la función hash().
	int indiceArreglo;
	// Mientras no encontremos un espacio diponible.
	while (true) {
	    // Actualizamos el indiceArreglo.
	    indiceArreglo = this.dispersor.hash(llave, contador);	    
	    // Si la celda no existe.
	    if (this.celdas[indiceArreglo] == null) {
	        // No se encuentra la llave en la TablaHash.
		return;
	    }
	    // Si la celda ha sido eliminada y marcada como DELETED.
	    if (this.celdas[indiceArreglo].getEtiqueta() == Etiqueta.DELETED) {
	        // Incrementamo el índice.
		contador++;
		// Continuamos con la búsqueda.
		continue;
	    }
	    // Si hay una Tupla, verificamos si tiene la misma llave.
	    if (this.celdas[indiceArreglo].getTupla().getLlave() == llave) {
		// En ese caso, etiquetamos DELETED.
		this.celdas[indiceArreglo].setEtiqueta(Etiqueta.DELETED);
		this.celdas[indiceArreglo].setTupla(null);
		// Decrementamos el número de elementos.
		elementos--;
	        return;
	    }
	    // Aumentamos el contador en uno.
	    contador++;
	}
    }

    /**
     * Calcula el factor de carga alpha = n / m.
     * @return factor de carga de la TablaHash.
     */
    public double factorCarga() {
        return (double) elementos / celdas.length;
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
	// Recorremos el arreglo de celdas.
	for (Celda celda : this.celdas) {
	    // Verificamos si es null la celda.
	    if (celda == null) {
		tablaHash.append(i++ + "->" + "[]\n");
		continue;
	    }
	    // Verificamos si es DELETED la celda.
	    if (celda.getEtiqueta() == Etiqueta.DELETED) {
		tablaHash.append(i++ + "->" + "[]\n");
		continue;
	    }
	    // Preparamos apertura.
	    tablaHash.append(i++ + "->" + "[");
	    // En caso contrario, agregamos la Tupla.
	    tablaHash.append(celda.getTupla().toString() + ", ");
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
