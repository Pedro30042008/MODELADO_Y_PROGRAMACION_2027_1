import java.util.LinkedList;

/**
 * HashTable.
 * 
 * Clase destinada a generar una HashTable.
 */
public class HashTable {

    /* Número de elementos en la TablaHash. */
    private int numElementos;

    /* Arreglo de listas de Tuplas. */
    private LinkedList<Tupla>[] hashTable;

    /**
     * Método para insertar un valor dada una llave.
     * @param llave llave.
     * @param valor valor.
     */
    public void insertar(int llave, String valor) {
        // indiceArreglo == h(k)
	    int indiceArreglo = FuncionDispersion.hash(llave);
        // Lista donde se guardara o cambiara el valor de la llave.
        LinkedList<Tupla> lista = hashTable[indiceArreglo];
        // Variable para verificar si se encontro la llave.
        boolean existe = false;
        // Verificamos si tenemos la llave en la lista de Tupla.
        for (Tupla tupla : lista) {
            // Si encontramos la llave.
            if (tupla.getLlave() == llave) {
                // Asignamos el nuevo valor a la tupla.
                tupla.setValor(valor);
                // Avisamos que si encontramos la llave.
                existe = true;
            }
        }
        // Si no encontramos la llave.
        if (!existe) {
            lista.add(new Tupla(llave, valor));
        }
    }
    
    /**
     * Método para buscar un valor dada una llave.
     * @param int llave.
     * @return String valor.
     */
    public String buscar(int llave) {
    return "Hola";
    }

    /**
     * Método para eliminar una tupla dada una llave.
     * @param int llave.
     */
    public void eliminar(int llave) {

    }
    
}
