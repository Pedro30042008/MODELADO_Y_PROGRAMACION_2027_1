import java.util.Iterator;
import java.util.LinkedList;

/**
 * TablaHash.
 *
 * Clase destinada a generar una tabla hash mediante encadenamiento.
 */
public class TablaHash {

    /**
     * Clase interna privada destinada a calcular la función de dispersión.
     */
    private class FuncionDispersion {

        /**
         * Método que aplica la función de dispersión h(k) = k mod m.
         *
         * @param llave llave de una Tupla.
         * @return índice de una cubeta en la TablaHash.
         */
        public int hash(int llave) {
            return Math.floorMod(llave, tablaHash.length);
        }
    }

    /* Función de dispersión utilizada por la tabla. */
    private final FuncionDispersion dispersor = new FuncionDispersion();

    /* Número de elementos almacenados en la TablaHash. */
    private int numElementos;

    /* Arreglo de cubetas. */
    private LinkedList<Tupla>[] tablaHash;

    /**
     * Constructor por default. Crea una tabla hash de tamaño 7.
     */
    @SuppressWarnings("unchecked")
    public TablaHash() {
        tablaHash = new LinkedList[7];

        for (int i = 0; i < tablaHash.length; i++) {
            tablaHash[i] = new LinkedList<>();
        }

        numElementos = 0;
    }

    /**
     * Constructor para crear una tabla hash con una dimensión dada.
     *
     * @param dimension dimensión/tamaño de la TablaHash.
     */
    @SuppressWarnings("unchecked")
    public TablaHash(int dimension) {

        if (dimension <= 0) {
            throw new IllegalArgumentException(
                "La dimensión debe ser mayor que 0."
            );
        }

        tablaHash = new LinkedList[dimension];

        for (int i = 0; i < tablaHash.length; i++) {
            tablaHash[i] = new LinkedList<>();
        }

        numElementos = 0;
    }

    /**
     * Inserta una Tupla dada una llave y su valor.
     * Si la llave ya existe, actualiza el valor.
     *
     * @param llave llave de la Tupla.
     * @param valor valor asociado a la llave.
     */
    public void insertar(int llave, String valor) {

        int indiceTabla = dispersor.hash(llave);
        LinkedList<Tupla> cubeta = tablaHash[indiceTabla];

        for (Tupla tupla : cubeta) {
            if (tupla.getLlave() == llave) {
                tupla.setValor(valor);
                return;
            }
        }

        cubeta.add(new Tupla(llave, valor));
        numElementos++;
    }

    /**
     * Busca el valor asociado a una llave.
     *
     * @param llave llave que se desea buscar.
     * @return valor asociado a la llave, o NOT_FOUND si no existe.
     */
    public String buscar(int llave) {

        int indiceTabla = dispersor.hash(llave);
        LinkedList<Tupla> cubeta = tablaHash[indiceTabla];

        for (Tupla tupla : cubeta) {
            if (tupla.getLlave() == llave) {
                return tupla.getValor();
            }
        }

        return "NOT_FOUND";
    }

    /**
     * Elimina la Tupla asociada a una llave.
     *
     * @param llave llave que se desea eliminar.
     */
    public void eliminar(int llave) {

        int indiceTabla = dispersor.hash(llave);
        LinkedList<Tupla> cubeta = tablaHash[indiceTabla];

        Iterator<Tupla> iterador = cubeta.iterator();

        while (iterador.hasNext()) {
            Tupla tupla = iterador.next();

            if (tupla.getLlave() == llave) {
                iterador.remove();
                numElementos--;
                return;
            }
        }
    }

    /**
     * Calcula el factor de carga alpha = n / m.
     *
     * @return factor de carga de la TablaHash.
     */
    public double factorCarga() {
        return (double) numElementos / tablaHash.length;
    }

    /**
     * Imprime el contenido completo de la TablaHash.
     */
    public void imprimirTabla() {

        for (int i = 0; i < tablaHash.length; i++) {

            System.out.print(i + " ->");

            boolean primera = true;

            for (Tupla tupla : tablaHash[i]) {

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
