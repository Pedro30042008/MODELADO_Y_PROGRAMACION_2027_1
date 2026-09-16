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
	if (this.raiz == null)
	    return "";
	return "";
    }
}
