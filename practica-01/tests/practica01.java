/**
 * practica01.
 *
 * Clase main donde se ejecutan los casos de prueba de la tabla hash.
 */
public class practica01 {

    public static void main(String[] cositasLindas) {

        TablaHash tabla = new TablaHash(7);

        /*
         * PRUEBA 1: TABLA VACÍA
         */
        System.out.println("===== PRUEBA 1: TABLA VACÍA =====");
        System.out.println("Buscar llave 10:");
        System.out.println("Resultado: " + tabla.buscar(10));
        System.out.println();

        /*
         * PRUEBA 2: INSERCIÓN BÁSICA
         */
        System.out.println("===== PRUEBA 2: INSERCIÓN BÁSICA =====");

        tabla.insertar(18, "Ana");
        tabla.insertar(10, "Luis");
        tabla.insertar(23, "Elena");

        System.out.println("Buscar 18:");
        System.out.println("Resultado: " + tabla.buscar(18));

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 23:");
        System.out.println("Resultado: " + tabla.buscar(23));
        System.out.println();

        /*
         * PRUEBA 3: COLISIONES
         */
        System.out.println("===== PRUEBA 3: COLISIONES =====");

        tabla.insertar(24, "Maria");
        tabla.insertar(31, "Carlos");

        System.out.println("Tabla después de provocar colisiones:");
        System.out.println(tabla);
        System.out.println();

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 24:");
        System.out.println("Resultado: " + tabla.buscar(24));

        System.out.println("Buscar 31:");
        System.out.println("Resultado: " + tabla.buscar(31));
        System.out.println();

        /*
         * PRUEBA 4: ELIMINACIÓN CON COLISIÓN
         */
        System.out.println("===== PRUEBA 4: ELIMINACIÓN =====");

        tabla.eliminar(24);

        System.out.println("Tabla después de eliminar 24:");
	System.out.println(tabla);
        System.out.println();

        System.out.println("Buscar 24:");
        System.out.println("Resultado: " + tabla.buscar(24));

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 31:");
        System.out.println("Resultado: " + tabla.buscar(31));
        System.out.println();

        /*
         * PRUEBA 5: LLAVE INEXISTENTE
         */
        System.out.println("===== PRUEBA 5: LLAVE INEXISTENTE =====");
        System.out.println("Intentando eliminar la llave 999...");
        tabla.eliminar(999);
        System.out.println("El programa continúa correctamente.");
        System.out.println();

        /*
         * PRUEBA 6: ACTUALIZACIÓN DE LLAVE EXISTENTE
         */
        System.out.println("===== PRUEBA 6: ACTUALIZACIÓN =====");

        tabla.insertar(18, "Ana Maria");

        System.out.println("Buscar 18:");
        System.out.println("Resultado: " + tabla.buscar(18));
        System.out.println();

        /*
         * FACTOR DE CARGA
         */
        System.out.println("===== FACTOR DE CARGA =====");
        System.out.println("Factor de carga final: " + tabla.factorCarga());
        System.out.println();

        System.out.println("===== TABLA FINAL =====");
        System.out.println(tabla);

	// IMPLEMENTACION CON SONDEO LINEAL
	TablaHashSondeoLineal tabla2 = new TablaHashSondeoLineal();

        /*
         * PRUEBA 1: TABLA VACÍA
         */
        System.out.println("===== PRUEBA 1: TABLA VACÍA =====");
        System.out.println("Buscar llave 10:");
        System.out.println("Resultado: " + tabla2.buscar(10));
        System.out.println();

        /*
         * PRUEBA 2: INSERCIÓN BÁSICA
         */
        System.out.println("===== PRUEBA 2: INSERCIÓN BÁSICA =====");

        tabla2.insertar(18, "Ana");
        tabla2.insertar(10, "Luis");
        tabla2.insertar(23, "Elena");

        System.out.println("Buscar 18:");
        System.out.println("Resultado: " + tabla2.buscar(18));

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla2.buscar(10));

        System.out.println("Buscar 23:");
        System.out.println("Resultado: " + tabla2.buscar(23));
        System.out.println();

        /*
         * PRUEBA 3: COLISIONES
         */
        System.out.println("===== PRUEBA 3: COLISIONES =====");

        tabla2.insertar(24, "Maria");
        tabla2.insertar(31, "Carlos");

        System.out.println("Tabla después de provocar colisiones:");
        System.out.println(tabla2);
        System.out.println();

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla2.buscar(10));

        System.out.println("Buscar 24:");
        System.out.println("Resultado: " + tabla2.buscar(24));

        System.out.println("Buscar 31:");
        System.out.println("Resultado: " + tabla2.buscar(31));
        System.out.println();

        /*
         * PRUEBA 4: ELIMINACIÓN CON COLISIÓN
         */
        System.out.println("===== PRUEBA 4: ELIMINACIÓN =====");

        tabla2.eliminar(24);

        System.out.println("Tabla después de eliminar 24:");
	System.out.println(tabla2);
        System.out.println();

        System.out.println("Buscar 24:");
        System.out.println("Resultado: " + tabla2.buscar(24));

        System.out.println("Buscar 10:");
        System.out.println("Resultado: " + tabla2.buscar(10));

        System.out.println("Buscar 31:");
        System.out.println("Resultado: " + tabla2.buscar(31));
        System.out.println();

        /*
         * PRUEBA 5: LLAVE INEXISTENTE
         */
        System.out.println("===== PRUEBA 5: LLAVE INEXISTENTE =====");
        System.out.println("Intentando eliminar la llave 999...");
        tabla2.eliminar(999);
        System.out.println("El programa continúa correctamente.");
        System.out.println();

        /*
         * PRUEBA 6: ACTUALIZACIÓN DE LLAVE EXISTENTE
         */
        System.out.println("===== PRUEBA 6: ACTUALIZACIÓN =====");

        tabla2.insertar(18, "Ana Maria");

        System.out.println("Buscar 18:");
        System.out.println("Resultado: " + tabla2.buscar(18));
        System.out.println();

        /*
         * FACTOR DE CARGA
         */
        System.out.println("===== FACTOR DE CARGA =====");
        System.out.println("Factor de carga final: " + tabla2.factorCarga());
        System.out.println();

        System.out.println("===== TABLA FINAL =====");
        System.out.println(tabla2);
    }
}
