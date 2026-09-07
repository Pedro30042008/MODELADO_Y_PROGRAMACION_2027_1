import java.util.Iterator;
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

    public HashTable(int tamaño) {

        // Verificamos que el tamaño sea válido.
        if (tamaño <= 0) {
            throw new IllegalArgumentException("El tamaño debe ser mayor que 0.");
        }

        // Creamos el arreglo de LinkedList.
        hashTable = (LinkedList<Tupla>[]) new LinkedList[tamaño];

        // Creamos una LinkedList vacía en cada posición.
        for (int i = 0; i < tamaño; i++) {
            hashTable[i] = new LinkedList<>();
        }

        // Indicamos a la función de dispersión el tamaño de la tabla.
        FuncionDispersion.setDimension(tamaño);
        numElementos = 0;
    }

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
                break;
            }
        }
        // Si no encontramos la llave.
        if (!existe) {
            lista.add(new Tupla(llave, valor));
            numElementos++;
        }
    }
    
    /**
     * Método para buscar un valor dada una llave.
     * @param llave llave.
     * @return String valor.
     */
    public String buscar(int llave) {
        // indiceArreglo == h(k)
        int indiceArreglo = FuncionDispersion.hash(llave);
        // Lista correspondiente a la cubeta donde puede encontrarse la llave.
        LinkedList<Tupla> lista = hashTable[indiceArreglo];

        // Recorremos la cubeta buscando la llave.
        for (Tupla tupla : lista) {
            if (llave == tupla.getLlave()) {
                return tupla.getValor();
            }
        }

        return "NOT_FOUND";
    }

    /**
     * Método para eliminar una tupla dada una llave.
     * @param llave llave.
     */
    public void eliminar(int llave) {
        // indiceArreglo == h(k)
        int indiceArreglo = FuncionDispersion.hash(llave);

        // Lista correspondiente a la cubeta donde puede encontrarse la llave.
        LinkedList<Tupla> lista = hashTable[indiceArreglo];

        Iterator<Tupla> iterador = lista.iterator();

        // Recorremos la cubeta buscando la llave.
        while (iterador.hasNext()) {
            Tupla tupla = iterador.next();

            if (llave == tupla.getLlave()) {
                iterador.remove();
                numElementos--;
                return;
            }
        }
    }

    /**
     * Imprime el contenido completo de la tabla hash.
     */
    public void imprimirTabla() {

        // Recorremos cada cubeta.
        for (int i = 0; i < hashTable.length; i++) {

            System.out.print(i + " ->");

            boolean primera = true;

            // Recorremos las tuplas dentro de la cubeta.
            for (Tupla tupla : hashTable[i]) {

                if (!primera) {
                    System.out.print(" ->");
                }

                System.out.print(" " + tupla);
                primera = false;
            }

            System.out.println();
        }
    }
    
}
