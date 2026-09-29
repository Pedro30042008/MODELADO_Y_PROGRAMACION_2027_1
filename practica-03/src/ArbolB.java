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
		 * 
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
	/* Número mínimo de llaves por Nodo. */
	private final static int p = (int) Math.ceil(m / 2.0) - 1;
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
	 * 
	 * @param llave a buscar.
	 * @return llave encontrada,
	 *         <code>null</code> en otro caso.
	 */
	public Integer buscar(Integer llave) {
		// No se permiten llaves null.
		if (llave == null)
			throw new IllegalArgumentException("La llave debe ser un número entero.");
		return buscar(this.raiz, llave);
	}

	/**
	 * Método recursivo para buscar una llave a partir del nodo raiz.
	 * 
	 * @param nodo  en el cual buscamos.
	 * @param llave a buscar.
	 * @return llave encontrada,
	 *         <code>null</code> en otro caso.
	 */
	private Integer buscar(NodoArbolB nodo, Integer llave) {
		// Si llegamos a un nodo null, no encontramos la llave.
		if (nodo == null)
			return null;
		// Buscamos en los intervalos.
		for (Celda celda : nodo.celdas) {
			if (celda.llave.equals(llave))
				return llave;
			if (celda.llave > llave)
				return buscar(celda.intervaloMenor, llave);
		}
		return buscar(nodo.intervaloMayor, llave);
	}

	/**
	 * Inserción de una llave dentro del ArbolB.
	 * 
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
	 * 
	 * @param nodo  donde buscaremos si es hoja para insetar la llave.
	 * @param llave a insertar.
	 */
	private void insertar(NodoArbolB nodo, Integer llave) {
		// Caso base, encontramos una hoja.
		if (nodo.numHijos == 0) {
			ordenar(nodo, new Celda(llave));
			split(nodo);
			return;
		}
		// Caso recursivo, buscamos una hoja.
		for (Celda celda : nodo.celdas) {
			// Si encontramos la llave, terminamos.
			if (celda.llave.equals(llave))
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
	 * 
	 * @param nodo  donde se inserta una celda para ordenar la llave dada.
	 * @param celda a insertar que contiene la llave.
	 */
	private void ordenar(NodoArbolB nodo, Celda celda) {
		ListIterator<Celda> iterator = nodo.celdas.listIterator();
		while (iterator.hasNext()) {
			// Celda tmp recorrida por la lista.
			Celda tmp = iterator.next();
			// Si encontramos la llave, terminamos.
			if (tmp.llave.equals(celda.llave)) {
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
	 * 
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
			// Eliminamos el ultimo de la lista
			Celda tmp1 = nodo.celdas.removeLast();
			if (tmp1.intervaloMenor != null)
				// Actualizamos el padre del nodo intervalo.
				tmp1.intervaloMenor.padre = nodoDos;
			// Añadimos la celda al nodo.
			nodoDos.celdas.addFirst(tmp1);
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
		if (nodoDos.intervaloMayor != null)
			// Actualizamos el padre del instervalo Mayor.
			nodoDos.intervaloMayor.padre = nodoDos;
		// Ordenamos la mitad en el nodo padre.
		actualizarPadre(nodo.padre, tmp, nodoDos);
		// Caso recursivo al padre.
		split(nodo.padre);
	}

	/**
	 * Método para ordenar una celda en el nodo padre y actualizar el intervalo
	 * derecho.
	 * 
	 * @param nodo  donde se inserta una celda para ordenar la llave dada.
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
		} else {
			nodo.intervaloMayor = nodoDos;
		}
		// Actualizamos el numero de hijos del padre.
		nodo.numHijos++;
	}

	/**
	 * Eliminación de una llave dentro del ArbolB, en caso de no encontrarla,
	 * no se lleva a cabo la operación y se ignora.
	 * 
	 * @param llave a eliminar.
	 */
	public void eliminar(Integer llave) {
		// No se permiten llaves null.
		if (llave == null)
			throw new IllegalArgumentException("La llave debe ser un número entero.");

		// Si el árbol está vacío, no hacemos nada.
		if (this.raiz == null)
			return;

		// Buscamos y eliminamos la llave si existe.
		eliminar(this.raiz, llave);
	}

	/**
	 * Método privado para eliminar una llave dado un nodo.
	 * 
	 * @param nodo  Donde comenzamos busqueda
	 * @param llave QUe vamos a eliminar.
	 */
	private void eliminar(NodoArbolB nodo, Integer llave) {

		// Buscamos la llave a partir del nodo dado.
		while (nodo != null) {

			// Encontrar un intervalo menor por donde bajar
			boolean buscarIntervaloMayor = true;

			ListIterator<Celda> iteradorNodo = nodo.celdas.listIterator();

			while (iteradorNodo.hasNext()) {

				Celda celda = iteradorNodo.next();

				// Encontramos la llave.
				if (celda.llave.equals(llave)) {

					// Caso 1: la llave está en una hoja.
					if (nodo.numHijos == 0) {
						eliminarLlaveNodoHoja(nodo, llave, iteradorNodo);
						return;
					}

					// Caso 2: la llave está en un nodo interno.
					eliminarLlaveNodoInterno(nodo, llave, iteradorNodo);
					return;
				}

				// La llave buscada está en el intervalo menor.
				if (celda.llave.compareTo(llave) > 0) {
					nodo = celda.intervaloMenor;
					buscarIntervaloMayor = false;
					break;
				}
			}

			// Si es mayor que todas las llaves del nodo,
			// seguimos por intervaloMayor.
			if (buscarIntervaloMayor)
				nodo = nodo.intervaloMayor;
		}
	}

	/**
	 * Método privado para eliminar una llave de un nodo hoja.
	 * 
	 * @param nodo         donde se encuentra la llave a eliminar.
	 * @param llave        a eliminar.
	 * @param iteradorNodo iterador apuntando a la posición posterior de la celda
	 *                     que contiene la llave.
	 */
	private void eliminarLlaveNodoHoja(NodoArbolB nodo, Integer llave, ListIterator<Celda> iteradorNodo) {

		// Eliminamos la celda que contiene la llave.
		iteradorNodo.remove();

		// Disminuimos el número de llaves.
		nodo.numLlaves--;

		// La raíz puede tener menos de p llaves.
		if (nodo == this.raiz) {

			// Si era la última llave del árbol, queda vacío.
			if (nodo.numLlaves == 0 && nodo.numHijos == 0)
				this.raiz = null;

			return;
		}

		// Revisamos si el nodo quedó subocupado.
		subOcupacion(nodo, llave);
	}

	/**
	 * Metodo privado para eliminar una llave en un nodo interno.
	 * 
	 * @param nodo         donde se encuentra la llave a eliminar.
	 * @param llave        a eliminar.
	 * @param iteradorNodo Iterador apuntando a la posicion psoterior de la celda
	 *                     que contiene la llave.
	 */
	private void eliminarLlaveNodoInterno(NodoArbolB nodo, Integer llave, ListIterator<Celda> iteradorNodo) {

		// El iterador esta despues de la celda que contiene la llava, damos uno para
		// atras, para obtner la celda
		Celda celdaActual = iteradorNodo.previous();

		// Lo regresamos a su posición original, después de celdaActual.
		iteradorNodo.next();

		// Hijo izquierdo de la llave.
		NodoArbolB hijoIzq = celdaActual.intervaloMenor;

		// Caso 1. El hijo izquierdo tiene suficientes llaves para usar el predecesor.

		// Estricto >p por que quitarle una llavae lo dejaria subocupado
		if (hijoIzq.numLlaves > p) {
			// En el hijo izquierdo buscamos su predecesor (la llave mayor del hijoIzq)
			NodoArbolB predecesor = obtenerPredecesor(hijoIzq);
			// La ultima celda de predecesor contiene la mayor llave.
			Celda celdaPredecesora = predecesor.celdas.getLast();
			// Guardamos el valor de la llave predecesora
			int llavePredecesora = celdaPredecesora.llave;
			// Reemplazamos la llave interna.
			celdaActual.llave = llavePredecesora;

			// Eliminamos la original del nodo hoja.
			eliminar(predecesor, llavePredecesora);

			return;
		}

		// Buscamos el hijo derecho, lueggo vemos si puede prestar
		NodoArbolB hijoDer;
		// Si hay otra celda despues de la actual, su intervaloMenor seria el hijo de la
		// derecha
		if (iteradorNodo.hasNext()) {
			// Obtenemos la celda siguiente
			Celda siguiente = iteradorNodo.next();
			// Luego asignamos que nuestro hijo derecho va a ser le intervaloMenor de la
			// celda siguiente
			hijoDer = siguiente.intervaloMenor;

			// Regresamos el iterador.
			iteradorNodo.previous();

		} else { // SI llegamos aca ent estabamos en la ultima celda
			// Por nuestro hijo derecho sera el intervaloMayor del nodo
			hijoDer = nodo.intervaloMayor;
		}

		// Caso 2. El hijo derecho tiene suficientes llaves para usar el sucesor.
		if (hijoDer.numLlaves > p) {
			// Obtenemos al sucesor (la menor llave del hijo derecho)
			NodoArbolB sucesor = obtenerSucesor(hijoDer);
			// Tomamos la primera celda en las celdas del sucesor, por que contiene la menor
			// llave
			Celda celdaSucesora = sucesor.celdas.getFirst();
			// Guardamos la llave sucesora
			Integer llaveSucesora = celdaSucesora.llave;

			// Reemplazamos la llave interna.
			celdaActual.llave = llaveSucesora;

			// Eliminamos la original del nodo hoja.
			eliminar(sucesor, llaveSucesora);

			return;
		}

		// Caso 3. Ningun hijo puede usar sucesor o predecesor -> Fusión
		// Creamos el nodo resultante.
		NodoArbolB nodoFusionado = new NodoArbolB();

		// Agregamos las celdas del hijo izquierdo cuidando el numLlaves
		for (Celda celda : hijoIzq.celdas) {
			nodoFusionado.celdas.add(celda);
			nodoFusionado.numLlaves++;

			// Si tenemos nodos internos, debemos de cambiar la referencia hacia arriba.
			// Asi evitamos que los hijos apunten al nodo viejo
			if (celda.intervaloMenor != null)
				celda.intervaloMenor.padre = nodoFusionado;
		}

		// Bajamos la llave del padre
		Celda celdaPadre = new Celda(llave);
		// La celda debe de apuntar a la que esta antes de ella, que seria el el
		// intervalo mayor del hijo izq
		celdaPadre.intervaloMenor = hijoIzq.intervaloMayor;

		// Actualizamos referencias para que el fusionado sea ahora el padre.
		if (celdaPadre.intervaloMenor != null)
			celdaPadre.intervaloMenor.padre = nodoFusionado;

		// Agregamos al padre y sumamos llaves
		nodoFusionado.celdas.add(celdaPadre);
		nodoFusionado.numLlaves++;

		// Celdas del hijo derecho, cuidando numLlaves
		for (Celda celda : hijoDer.celdas) {
			nodoFusionado.celdas.add(celda);
			nodoFusionado.numLlaves++;

			// Si tenemos nodos internos, debemos de cambiar la referencia hacia arriba.
			// Asi evitamos que los hijos apunten al nodo viejo
			if (celda.intervaloMenor != null)
				celda.intervaloMenor.padre = nodoFusionado;
		}

		// El último intervalo será el intervaloMayor del hijo derecho.
		nodoFusionado.intervaloMayor = hijoDer.intervaloMayor;
		// Actualizamos para referenciar al padre
		if (nodoFusionado.intervaloMayor != null)
			nodoFusionado.intervaloMayor.padre = nodoFusionado;

		// Si estamos fusionando nodo internos
		if (hijoIzq.numHijos > 0 || hijoDer.numHijos > 0) {
			// debemos de actualizar sus numLlaves
			nodoFusionado.numHijos = nodoFusionado.numLlaves + 1;
		}
		// El padre del nuevo nodo fusionado es el nodo interno donde estaba
		// originalmente la llave que estamos eliminando
		nodoFusionado.padre = nodo;

		// EL interdaor sigue en celdaActual, pero debemos de quitar al padre
		iteradorNodo.previous();
		// Quitmaos al padre de la celda, a la llave que acaba de bajar
		iteradorNodo.remove();
		// Cuidamos #llaves y #hijos
		nodo.numLlaves--;
		nodo.numHijos--;

		// Hacemos que el padre apunte al nodo que fusionamos
		// SI tenemos una celda despues de la que eliminamos
		if (iteradorNodo.hasNext()) {
			// Obtenemos esa celda
			Celda siguiente = iteradorNodo.next();
			// Como el nodo fusionado ahora es el menor de la celda siguiente.
			siguiente.intervaloMenor = nodoFusionado;

		} else {
			// FUe la ultima llave del padre
			nodo.intervaloMayor = nodoFusionado;
		}

		// La llave que originalmente queríamos eliminar, ahora se encuentra dentro del
		// nodo fusionado.
		eliminar(nodoFusionado, llave);

		// COmo el nodo perdio una llave puede estar subocupado
		subOcupacion(nodo, llave);
	}

	/**
	 * Método privado para obtener el nodo que contiene
	 * a la llave predecesora.
	 * 
	 * @param nodo hijo izquierdo donde empieza la búsqueda.
	 * @return nodo hoja que contiene al predecesor.
	 */
	private NodoArbolB obtenerPredecesor(NodoArbolB nodo) {
		// Caso Base, llegamos a una hoja
		if (nodo.numHijos == 0)
			return nodo;
		/*
		 * Caso recursio, nos pasan el nodo izquierdo, y nos vamos todo a la derecha
		 * hasta llegar a una hoja, y regresamos el nodo que contiene a la llave menor
		 * (Last)
		 */
		return obtenerPredecesor(nodo.intervaloMayor);
	}

	/**
	 * Método privado para obtener el nodo que contiene
	 * a la llave sucesora.
	 * 
	 * @param nodo hijo derecho donde empieza la búsqueda.
	 * @return nodo hoja que contiene al sucesor.
	 */
	private NodoArbolB obtenerSucesor(NodoArbolB nodo) {
		// Caso base, llegamos a una hoja
		if (nodo.numHijos == 0)
			return nodo;
		/*
		 * Caso recursivo, nos pasand el nodo derecho, y nos vamos todo a la izquierda
		 * hasta llegar a una hoja, y regresamos el nodo que contiene la llave mayor
		 * (First)
		 */
		return obtenerSucesor(
				nodo.celdas.getFirst().intervaloMenor);
	}

	/**
	 * Método privado para arreglar la subocupación de un nodo.
	 * 
	 * @param nodo  donde se encuentra la subocupación.
	 * @param llave llave eliminada.
	 */
	private void subOcupacion(NodoArbolB nodo, Integer llave) {

		// Si todavía cumple con el mínimo de llaves, terminamos.
		if (nodo.numLlaves >= p)
			return;

		// Caso de la raiz
		if (nodo == this.raiz) {
			// SI no tiene llaves pero tiene hijo ent tenemos una raiz vacia
			// reducimos la altura del arbol
			if (nodo.numLlaves == 0 && nodo.numHijos == 1) {
				// Para la nueva raiaz aarramos su unico hijo por que no tiene celdas:
				// intervaloMayor
				NodoArbolB nuevaRaiz = nodo.intervaloMayor;
				// Lo convertimos a la nueva raiz
				this.raiz = nuevaRaiz;

				// SI la raiz queda diferente de null, asiganamos padre null
				if (this.raiz != null)
					this.raiz.padre = null;
			}

			return;
		}

		// Guardamos padre, para luego encontrar hermanos
		NodoArbolB padre = nodo.padre;
		// Iterador para las celdas del padre
		ListIterator<Celda> iteradorPadre = padre.celdas.listIterator();
		// Referencia posible al hermanoIzq
		NodoArbolB hermanoIzq = null;

		// Buscamos qué intervalo del padre corresponde al nodo subocupado.
		while (iteradorPadre.hasNext()) {
			// TOmamos una celda
			Celda actual = iteradorPadre.next();

			// Preguntamos si el nodo del intervaloMenor de la actual es el nodo subocupado
			if (actual.intervaloMenor == nodo) {
				// Referencia a hermao derecho
				NodoArbolB hermanoDer = null;

				// Intentamos encontrar al hermano izquierdo.
				if (iteradorPadre.previousIndex() > 0) { // preguntamos si existe una celda anterior en el apdre
					// Regresamos el iterador a actual
					iteradorPadre.previous();
					// Aqui si obtenemos la celda anterior
					Celda anterior = iteradorPadre.previous();
					// Obenemos hermanoIzq
					hermanoIzq = anterior.intervaloMenor;
					// regresamos el iterador a su lugar
					iteradorPadre.next();
					iteradorPadre.next();
				}

				/*
				 * 1. Intentamos redistribuir con hermano izquierdo
				 */
				// Necesitamos E hermano izquierdo y que tenga mas llaves para que preste una.
				if (hermanoIzq != null && hermanoIzq.numLlaves > p) {
					// Llamamos al metodo que se encarga
					redistribuirHermanoIzquierdo(hermanoIzq, nodo, padre);
					return;
				}

				// Buscamos hermano derecho
				if (iteradorPadre.hasNext()) {
					// vamos a ls siguiente celda
					Celda siguiente = iteradorPadre.next();
					// obtenemos su intervalo menos que corresponde al hermano derecho
					hermanoDer = siguiente.intervaloMenor;

				} else {
					// Si actual es la última celda, el hermano derecho es intervaloMayor.
					hermanoDer = padre.intervaloMayor;
				}

				/*
				 * 2. Intentamos redistribuir con hermano derecho
				 */
				// Necesitamos E hermano derecho y que tenga mas llaves para que preste una.
				if (hermanoDer != null && hermanoDer.numLlaves > p) {
					// Llamamos al encargado
					redistribuirHermanoDerecho(nodo, hermanoDer, padre);
					return;
				}

				/*
				 * 3. Ningún hermano pudo prestar.
				 * Intentamos fusionar.
				 */

				// 3.1 Fusionar con el hermano izquierdo. Necesitamos E hermano Izq
				if (hermanoIzq != null) {
					// Llamamos al encargado
					fusionarNodos(hermanoIzq, nodo, padre);
					return;
				}

				// 3.2 Si no existe hermano izquierdo, fusionamos con el derecho.
				if (hermanoDer != null) {
					// Llamamos al encargado
					fusionarNodos(nodo, hermanoDer, padre);
					return;
				}
			}
		}

		// Si no apareció como intervaloMenor de ninguna celda, entonces nodo es el
		// intervaloMayor del padre.
		if (padre.intervaloMayor == nodo) {
			// VErificamos si el padre tiene celdas
			if (!padre.celdas.isEmpty()) {
				// obtenemos la ultima celda y de ahi su intervalo menor como hermaoIzq
				hermanoIzq = padre.celdas.getLast().intervaloMenor;

				/*
				 * 1. Intentamos redistribuir con hermano izquierdo
				 */
				// Necesitamos E hermano izquierdo y que tenga mas llaves para que preste una.
				if (hermanoIzq != null && hermanoIzq.numLlaves > p) {
					// Llamamos al encargado
					redistribuirHermanoIzquierdo(hermanoIzq, nodo, padre);
					return;
				}

				// NO tenemos hermano derecho, tendremos que fusionar
				// E hermano izq
				if (hermanoIzq != null) {
					// Llamamos al encargado
					fusionarNodos(hermanoIzq, nodo, padre);
					return;
				}
			}
		}
	}

	/**
	 * Metodo privado par distribuir con el hermano Izquierdo
	 * 
	 * @param hermanoIzq     Hermano izquierdo del nodoSubOcupado
	 * @param nodoSubOcupado Nodo que esta subOcupado
	 * @param padre          Padre del nodo con subOcupacion
	 */
	private void redistribuirHermanoIzquierdo(NodoArbolB hermanoIzq, NodoArbolB nodoSubOcupado, NodoArbolB padre) {
		// Esta celda es para separar el hermanoIzq del nodoSubOcupado
		Celda separadora = null;

		// Buscamos la llave del padre que separa hermanoIzq y nodoSubOcupado.
		for (int i = 0; i < padre.celdas.size(); i++) { // Ya no usamos iterador por que no vamos a eliminar ni agregar
														// nada. Y no esta como argumento
			// obtenemos la celda actual
			Celda actual = padre.celdas.get(i);
			// Obtenemos el hijoIzq dependiendo de la celda actual (i)
			NodoArbolB hijoIzq = actual.intervaloMenor;
			// Declaramos hijo derecho
			NodoArbolB hijoDer;
			// Revismaos si hay otra celda despues para tomar su intervalo menor
			if (i + 1 < padre.celdas.size())
				// Agarramos la siguiente celda y tomamos su intervaloMenor que sera hijo dercho
				hijoDer = padre.celdas.get(i + 1).intervaloMenor;
			else
				// SI no hubo ent actual es la ultima celda y hijo der debe de ser el intervalo
				// mayor
				hijoDer = padre.intervaloMayor;

			// como ya tenemos los hijos debemos de ver si la llave del padre está justo
			// entre mi hermano izquierdo y el nodo subocupado
			if (hijoIzq == hermanoIzq && hijoDer == nodoSubOcupado) {
				separadora = actual;
				break;
			}
		}
		/*
		 * Podria pasar que separadora = null pero si llamamos correctamente al método,
		 * la separadora necesariamente debe existir.
		 * Si no aparece, significa que las referencias del árbol están erroneas o que
		 * el método recibió nodos que no son hermanos adyacentes.
		 */
		if (separadora == null)
			throw new IllegalStateException("No se encontró la llave separadora.");

		// Quitamos la ultima llave del hemanoIZq por que tiene la mayor llave que puede
		// subir al padre
		Celda prestada = hermanoIzq.celdas.removeLast();
		// Descontamos llaves del hermano
		hermanoIzq.numLlaves--;

		// La llave actual del padre baja al nodo subocupado
		Celda nueva = new Celda(separadora.llave);

		// El intervaloMayor del hermano izquierdo, se mueve con la llave que baja
		nueva.intervaloMenor = hermanoIzq.intervaloMayor;

		// El nuevo intervaloMayor del hermano izquierdo, será el intervaloMenor de la
		// llave prestada
		hermanoIzq.intervaloMayor = prestada.intervaloMenor;

		//Agregamos al principio del nodo subocupado
		nodoSubOcupado.celdas.addFirst(nueva);
		nodoSubOcupado.numLlaves++;

		//La llave prestada sube al padre
		separadora.llave = prestada.llave;

	
		//Si estamos con nodos internos, debemos actualizar referencias y numHijos
		if (nueva.intervaloMenor != null) {
			//Actualizamos padre del hijo
			nueva.intervaloMenor.padre = nodoSubOcupado;
			//Cuidamos  num de hijos
			hermanoIzq.numHijos--;
			nodoSubOcupado.numHijos++;
		}
	}

	/**
	 * Metodo privado par distribuir con el hermano Izquierdo
	 * 
	 * @param nodoSubOcupado Nodo que esta subOcupado
	 * @param hermanoDer     Hermano derecho del nodoSubOcupado
	 * @param padre          Padre del nodo con subOcupacion
	 */
	private void redistribuirHermanoDerecho(NodoArbolB nodoSubOcupado, NodoArbolB hermanoDer, NodoArbolB padre) {

		// Buscamos la celda separadora
		Celda separadora = null;
		//Recorremos las celdas del padre
		for (Celda celda : padre.celdas) {
			//SI llegamos a encontrar un intervalo igual al nodo con subocupacion
			//ent esa misma celda con la llave separa al hermano dercho
			if (celda.intervaloMenor == nodoSubOcupado) {
				//Asignamos la separadora
				separadora = celda;
				break;
			}
		}
		//Si no encontramos separadora, algo en las referencias del árbol no coincide con lo esperado o se invoco erroneamente
		if (separadora == null)
			throw new IllegalStateException("No se encontró la llave separadora.");

	
		//La primera llave del hermano derecho, será la que suba al padre
		Celda prestada = hermanoDer.celdas.removeFirst();
		//reducimos numLlaves
		hermanoDer.numLlaves--;
	
		//La llave actual del padre baja al final del nodo subocupado.
		Celda nueva = new Celda(separadora.llave);

		//El intervaloMayor actual del nodo, subocupado queda como intervaloMenor de la llave que baja.
		nueva.intervaloMenor = nodoSubOcupado.intervaloMayor;

		//El nuevo intervaloMayor del nodo subocupado será el intervaloMenor de la llave prestada.		
		nodoSubOcupado.intervaloMayor = prestada.intervaloMenor;

		
		//Añadimos la llave que bajó del padre.
		nodoSubOcupado.celdas.addLast(nueva);
		//AUmentamos #laves
		nodoSubOcupado.numLlaves++;

	
		//La llave prestada sube al padre.
		separadora.llave = prestada.llave;

	
		//Si son nodos internos, estamos moviendo también un hijo.
		
		if (nodoSubOcupado.intervaloMayor != null) {
			//Actualizamos padre del hijo
			nodoSubOcupado.intervaloMayor.padre = nodoSubOcupado;
			// Cuidamos # de hijos y llaves
			hermanoDer.numHijos--;
			nodoSubOcupado.numHijos++;
		}
	}

	/**
	 * Método privado para fusionar dos nodos junto con
	 * la llave que los separa en el padre, para hojas o nodos iternos
	 *
	 * @param nodoIzq nodo izquierdo
	 * @param nodoDer nodo derecho
	 * @param padre   padre de ambos nodos
	 */
	private void fusionarNodos(NodoArbolB nodoIzq, NodoArbolB nodoDer, NodoArbolB padre) {
		//Poosicion default para la separoda
		int indiceSeparadora = -1;
		//CElda separadora
		Celda separadora = null;

	
		//Buscamos la llave del padre que separa exactamente a nodoIzq y nodoDer.
		for (int i = 0; i < padre.celdas.size(); i++) {
			//Obtenemos la celda en i
			Celda actual = padre.celdas.get(i);
			//De la celda obtenemos el hijo izq
			NodoArbolB hijoIzq = actual.intervaloMenor;
			//Declaramos hijoDer
			NodoArbolB hijoDer;
			//SI hay otra celda, ent el hijo der es el intervalo menor de la siguiente celda
			if (i + 1 < padre.celdas.size())
				//vamos a la sig celda y agarramso su intervalo menor
				hijoDer = padre.celdas.get(i + 1).intervaloMenor;
			else
				//Sino ent estabamos en la ultima celda y nuestro hijo der es el intervalo mayor del padre
				hijoDer = padre.intervaloMayor;

			//Si la llave del padre está exactamente entre los dos nodos que quiero fusionar
			if (hijoIzq == nodoIzq && hijoDer == nodoDer) {
				//Guradmos celda y poscion
				indiceSeparadora = i;
				separadora = actual;
				break;
			}
		}
		//Las referencias del árbol no corresponden a dos hermanos adyacentes
		if (separadora == null)
			throw new IllegalStateException( "No se encontró la llave separadora.");

		
		//Guardamos la llave antes de quitar la celda del padre. 
		int llaveSeparadora = separadora.llave;
		//Declaramos el nodo que resultara fusionado
		NodoArbolB nodoFusionado = new NodoArbolB();

	
		 //Agregamos con la celdas del nodoIzq
		for (Celda celda : nodoIzq.celdas) {
			//Agregamos y cuidamos numLlaves
			nodoFusionado.celdas.add(celda);
			nodoFusionado.numLlaves++;

			//Si son nodos internos, actualizamos el padre del hijo
			if (celda.intervaloMenor != null)
				celda.intervaloMenor.padre = nodoFusionado;
		}

		
		//Bajamos la llave separadora. Su intervaloMenor será el intervaloMayor del nodo izquierdo
		Celda nueva = new Celda(llaveSeparadora);

		//referencia era el último hijo del nodo izquierdo y ahora queda inmediatamente antes de la llave separadora
		nueva.intervaloMenor = nodoIzq.intervaloMayor;
		//Actualizamos tambien al padre
		if (nueva.intervaloMenor != null)
			nueva.intervaloMenor.padre = nodoFusionado;
		//La agregamos y cuidamos numLlaves
		nodoFusionado.celdas.add(nueva);
		nodoFusionado.numLlaves++;

		//Agregamos
		for (Celda celda : nodoDer.celdas) {
			//Agregamos y cuidamos numLlaves
			nodoFusionado.celdas.add(celda);
			nodoFusionado.numLlaves++;

			//Por si nodo interno, actualizamos al pdare
			if (celda.intervaloMenor != null)
				celda.intervaloMenor.padre = nodoFusionado;
		}

	
		//El último intervalo será el intervaloMayor del nodo derecho.
		nodoFusionado.intervaloMayor = nodoDer.intervaloMayor;
		//Actualizamos padre
		if (nodoFusionado.intervaloMayor != null)
			nodoFusionado.intervaloMayor.padre = nodoFusionado;

	
		//Si estamos fusionando nodos internos, habrá numLlaves + 1 hijos.
		// Si son hojas, numHijos sigue en 0.
		
		if (nodoIzq.numHijos > 0 || nodoDer.numHijos > 0) {
			//Actualizamos numHIjos con las llaves del fusionado + 1
			nodoFusionado.numHijos = nodoFusionado.numLlaves + 1;
		}
		//Tenemos el mismo padre
		nodoFusionado.padre = padre;

		//Quitamos la llave separadora del padre
		padre.celdas.remove(indiceSeparadora);
		//Disminuimos llaves e hijos
		padre.numLlaves--;
		padre.numHijos--;

	
		//Actualizamos la referencia del padre hacia el nuevo nodo fusionado
		if (indiceSeparadora < padre.celdas.size()) {
			//Si después de eliminar la separadora todavía hay una celda en esa posición, ent debe de apuntar al nodo fusionado
			padre.celdas.get(indiceSeparadora).intervaloMenor = nodoFusionado;

		} else {
			//EL fusionado quedo como hijo unico
			padre.intervaloMayor = nodoFusionado;
		}

	
		//Si el padre era la raíz y quedó vacío, el fusionado se convierte en la nueva raíz.
		if (padre == this.raiz && padre.numLlaves == 0) {
			//Actualizamos raiz y su padre como null
			this.raiz = nodoFusionado;
			nodoFusionado.padre = null;

			return;
		}

	
		//La fusión pudo provocar subocupación en el padre
		
		subOcupacion(padre,llaveSeparadora);
	}

	/**
	 * Representación en cadena de texto del ArbolB.
	 * 
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
