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
	// No se permiten llaves null.
	if (llave == null)
	    throw new IllegalArgumentException("La llave debe ser un número entero.");
	// Si el arbol esta vacío creamos un nuevo nodo.
	if (this.raiz == null)
	    this.raiz = new NodoArbolB();
	// Empezamos a buscar el nodo donde insertaremos la llave.
	insertar(this.raiz, llave);
    }

    /**
     * Recursión para buscar la hoja donde se inserta la nueva llave.
     * @param nodo donde buscaremos si es hoja para insetar la llave.
     * @param llave a insertar.
     */
    private void insertar(NodoArbolB nodo, Integer llave) {
	// Caso base, encontramos una hoja.
	if (nodo.numHijos == 0){
	    ordenar(nodo, new Celda(llave));
	    split(nodo);
	    return;
	}
	// Caso recursivo, buscamos una hoja.
	for (Celda celda : nodo.celdas) {
	    // Si encontramos la llave, terminamos.
	    if (celda.llave == llave)
		return;
	    // Buscamos en el nodo correspondiente.
	    if (celda.llave > llave) {
		insertar(celda.intervaloMenor, llave);
		return;
	    }
	}
	// Buscamos en el ultimo intervalo dissponible.
	insertar(nodo.intervaloMayor, llave);
    }

    /**
     * Método para ordenar una celda en un nodo dado.
     * @param nodo donde se inserta una celda para ordenar la llave dada.
     * @param celda a insertar que contiene la llave.
     */
    private void ordenar(NodoArbolB nodo, Celda celda) {
	ListIterator<Celda> iterator = nodo.celdas.listIterator();
	while (iterator.hasNext()) {
	    // Celda tmp recorrida por la lista.
	    Celda tmp = iterator.next();
	    // Si encontramos la llave, terminamos.
	    if (tmp.llave == celda.llave) {
		return;
	    }
	    // Si encontramos en medio de la lista la posición, insertamos la celda.
	    if (tmp.llave > celda.llave) {
		iterator.previous();
		break;
	    }
	}
	// La posición final es donde va la celda.
        iterator.add(celda);
	nodo.numLlaves++;
    }

    /**
     * Método para arreglar el desbordamiento de un nodo.
     * @param nodo donde se encuentra el desbordamiento.
     */
    private void split(NodoArbolB nodo) {
	// Si arreglamos el problema, terminamos.
	if (nodo.numLlaves <= 3)
	    return;
	// Preparamos un nuevo nodo para agregar.
	NodoArbolB nodoDos = new NodoArbolB();
	// Actualizamos el intervalo final del nodoDos.
	nodoDos.intervaloMayor = nodo.intervaloMayor;
	// Actualizamos el padre.
	nodoDos.padre = nodo.padre;
	// Mitad del nodo.
	int j = (nodo.numLlaves / 2) + 1;
	// Iteramos hasta llegar a la mitad del nodo.
	while (nodo.numLlaves > j) {
	    nodoDos.celdas.addFirst(nodo.celdas.removeLast());
	    nodoDos.numLlaves++;
	    nodo.numLlaves--;
	}
	// Celda que contiene la mitad del nodo.
	Celda tmp = nodo.celdas.removeLast();
	nodo.numLlaves--;
	// Actualizamos el intevaloMayor del nodo.
	nodo.intervaloMayor = tmp.intervaloMenor;
	tmp.intervaloMenor = nodo;
	// Actualizamos el número de Hijos.
	if (nodo.numHijos > 0) {
	    nodoDos.numHijos = nodoDos.numLlaves + 1;
	    nodo.numHijos = nodo.numLlaves + 1;
	}
	// Si el nodo es la raíz.
	if (nodo.padre == null) {
	    NodoArbolB nuevaRaiz = new NodoArbolB();
	    this.raiz = nuevaRaiz;
	    nodo.padre = this.raiz;
	    nodoDos.padre = this.raiz;
	    this.raiz.numHijos++;
	}
	// Ordenamos la mitad en el nodo padre.
	actualizarPadre(nodo.padre, tmp, nodoDos);
	// Caso recursivo al padre.
	split(nodo.padre);
    }

    /**
     * Método para ordenar una celda en el nodo padre y actualizar el intervalo derecho.
     * @param nodo donde se inserta una celda para ordenar la llave dada.
     * @param celda a insertar que contiene la llave.
     */
    private void actualizarPadre(NodoArbolB nodo, Celda celda, NodoArbolB nodoDos) {
	ListIterator<Celda> iterator = nodo.celdas.listIterator();
	while (iterator.hasNext()) {
	    // Celda tmp recorrida por la lista.
	    Celda tmp = iterator.next();
	    // Si encontramos en medio de la lista la posición, insertamos la celda.
	    if (tmp.llave > celda.llave) {
		iterator.previous();
		break;
	    }
	}
	// La posición final es donde va la celda.
        iterator.add(celda);
	nodo.numLlaves++;
	// Actualizamos el siguiente intervalo.
	if (iterator.hasNext()) {
	    Celda nueva = iterator.next();
	    nueva.intervaloMenor = nodoDos;
	    iterator.set(nueva);
	} else {
	    nodo.intervaloMayor = nodoDos;
	}
	// Actualizamos el numero de hijos del padre.
	nodo.numHijos++;
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
	int nivel = 0;
	StringBuilder arbolB = new StringBuilder();
	// ArbolB vacío.
	if (this.raiz == null)
	    return arbolB.append("Nivel ").append(String.format("%02d", nivel)).append(" : []").toString();
	if (this.raiz.celdas.size() == 0)
	    return arbolB.append("Nivel ").append(String.format("%02d", nivel)).append(" : []").toString();
	// ArbolB con al menos una llave.
	// Listas para guardas los nodos de un mismo nivel y sus hijos.
	LinkedList<NodoArbolB> nodosActuales = new LinkedList<>();
	LinkedList<NodoArbolB> nodosHijos = new LinkedList<>();
	// Empezamos por la raiz.
	nodosActuales.add(this.raiz);
	while (nodosActuales.size() != 0) {
	    // Impresión por nivel.
	    arbolB.append("Nivel ").append(String.format("%02d", nivel)).append(" : ");
	    // Impresión de los nodos en un nivel.
	    for (NodoArbolB nodo : nodosActuales) {
		arbolB.append("[");
		// Impresion de las llaves de cada nodo.
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
