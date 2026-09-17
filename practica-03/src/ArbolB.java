import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Clase Pública ArbolB.
 * Clase destinada a crear árboles B.
 */
public class ArbolB {

    /**
     * Clase Privada NodoArbolB.
     * Clase destinada a crear nodos de árboles B.
     */
    private class NodoArbolB {

	// Atributos: NodoArbolB.

	/* Llaves con intervalos menores. */
        LinkedList<Celda> celdas;
	/* Nodo padre del nodo. */
        NodoArbolB padre;
	/* Intervalo de llaves mayores a la llave. */
	NodoArbolB intervaloMayor;
	/* Numero de Hijos. */
	int numHijos;
	/* Número de Llaves. */
	int numLlaves;

	// Métodos: NodoArbolB.

	/**
	 * Método Constructor vacío de un NodoArbolB.
	 */
	public NodoArbolB() {
	    this.celdas = new LinkedList<>();
	    this.padre = null;
	    this.intervaloMayor = null;
	    this.numHijos = 0;
	    this.numLlaves = 0;
	}
    }

    /**
     * Clase Privada Celda.
     * Clase destinada a crear celdas contenidas en nodos de árboles B.
     */
    private class Celda {

	// Atributos: Celda.

	/* Llave */
        Integer llave;
	/* Intervalo de llaves menores a la llave. */
	NodoArbolB intervaloMenor;

	// Métodos: Celda.

	/**
	 * Método Constructor vacío de una Celda.
	 */
	public Celda() {
	    this.llave = null;
	    this.intervaloMenor = null;
	}

	/**
	 * Método Constructor de una Celda dado un número.
	 * @param llave.
	 */
	public Celda(Integer llave) {
	    this.llave = llave;
	    this.intervaloMenor = null;
	}
    }

    // Atributos: ArbolB.
    
    /* Orden */
    private final static int m = 4;
    /* Número mínimo de hijos por Nodo. */
    private final static int p = (int) Math.ceil(m/2) - 1;
    /* Raiz. */
    private NodoArbolB raiz;

    // Métodos: ArbolB.

    /**
     * Método constructor vacío de un ArbolB.
     */
    public ArbolB() {
        this.raiz = null;
	/*
	  Probar el toString con Arbol Ficticio
	this.raiz = new NodoArbolB();
	int j = 0;
	for (int i = 0; i < m; i++) {
	    j =  j + 10;
	    this.raiz.celdas.add(new Celda(j));
	}
	for (Celda celda : this.raiz.celdas) {
	    celda.intervaloMenor = new NodoArbolB();
	    for (int i = 0; i < m; i++) {
		j =  j + 10;
	        celda.intervaloMenor.celdas.add(new Celda(j));
	    }
	}
	*/
    }
    
    /**
     * Búsqueda de una llave dentro del ArbolB.
     * @param llave a buscar.
     * @return llave encontrada,
     *         <code>null</code> en otro caso.
     */
    public Integer buscar(Integer llave) {
	return null;
    }

    /**
     * Inserción de una llave dentro del ArbolB.
     * @param llave a insertar.
     */
    public void insertar(Integer llave) {
	
    }

    /**
     * Eliminación de una llave dentro del ArbolB, en caso de no encontrarla,
     * no se lleva a cabo la operación y se ignora.
     * @param llave a eliminar.
     */
    public void eliminar(Integer llave) {
	
    }

    /**
     * Representación en cadena de texto del ArbolB.
     * @return cadena de texto que representa al ArbolB actual.
     */
    @Override
    public String toString() {
	StringBuilder arbolB = new StringBuilder();
	// ArbolB vacío.
	if (this.raiz == null)
	    return arbolB.toString();
	if (this.raiz.celdas.size() == 0)
	    return arbolB.toString();
	// ArbolB con al menos una llave.
	// Listas para guardas los nodos de un mismo nivel y sus hijos.
	LinkedList<NodoArbolB> nodosActuales = new LinkedList<>();
	LinkedList<NodoArbolB> nodosHijos = new LinkedList<>();
	// Empezamos por la raiz.
	nodosActuales.add(this.raiz);
	int nivel = 0;
	while (nodosActuales.size() != 0) {
	    arbolB.append("Nivel ").append(String.format("%02d", nivel)).append(" : ");
	    for (NodoArbolB nodo : nodosActuales) {
		arbolB.append("[");
		for (Celda celda : nodo.celdas) {
		    arbolB.append(celda.llave + " | ");
		    if (celda.intervaloMenor != null)
			nodosHijos.add(celda.intervaloMenor);
		}
		arbolB.delete(arbolB.length() - 3, arbolB.length());
		arbolB.append("] ");
		if (nodo.intervaloMayor != null)
		    nodosHijos.add(nodo.intervaloMayor);
	    }
	    arbolB.setLength(arbolB.length() - 1);
	    arbolB.append("\n");
	    nodosActuales = nodosHijos;
	    nodosHijos = new LinkedList<>();
	    nivel++;
	}
	arbolB.setLength(arbolB.length() - 1);
	return arbolB.toString();
    }
}
