/**
 * practica01.
 *
 * Clase main donde se ejecutan los casos de prueba de la tabla hash.
 */
public class practica01 {

    public static void main(String[] cositasLindas) {

        TablaHash tabla = new TablaHash(7);

        System.out.println("--------------------TESTS PARA TABLASHASH--------------------\n\n");

        System.out.println("--------------------ENCADENAMIENTO--------------------");
        /*
         * PRUEBA 1: TABLA VACÍA
         */
        System.out.println("===== PRUEBA 1: TABLA VACÍA =====");
        System.out.println("Buscar llave 10:");
        System.out.println("Resultado: " + tabla.buscar(10));

        /*
         * PRUEBA 2: INSERCIÓN BÁSICA
         */
        System.out.println("\n===== PRUEBA 2: INSERCIÓN BÁSICA =====");

        tabla.insertar(18, "Ana");
        tabla.insertar(10, "Luis");
        tabla.insertar(23, "Elena");

        System.out.println("Se insertaron (18,Ana) , (10,Luis) y (23,Elena) ");
        System.out.println("Buscar 18");
        System.out.println("Resultado: " + tabla.buscar(18));

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 23");
        System.out.println("Resultado: " + tabla.buscar(23));


        /*
         * PRUEBA 3: COLISIONES
         */
        System.out.println("\n===== PRUEBA 3: COLISIONES =====");

        System.out.println("Se insertaron (24,Maria) , (31,Carlos) provocando colisiones");
        tabla.insertar(24, "Maria");
        tabla.insertar(31, "Carlos");

        System.out.println("Tabla después de provocar colisiones:");
        System.out.println(tabla+"\n");

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 24");
        System.out.println("Resultado: " + tabla.buscar(24));

        System.out.println("Buscar 31");
        System.out.println("Resultado: " + tabla.buscar(31)+"\n");

        /*
         * PRUEBA 4: ELIMINACIÓN CON COLISIÓN
         */
        System.out.println("===== PRUEBA 4: ELIMINACIÓN =====");

        tabla.eliminar(24);

        System.out.println("Tabla después de eliminar 24:");
	System.out.println(tabla+"\n");

        System.out.println("Buscar 24");
        System.out.println("Resultado: " + tabla.buscar(24));

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tabla.buscar(10));

        System.out.println("Buscar 31");
        System.out.println("Resultado: " + tabla.buscar(31));
        System.out.println();

        /*
         * PRUEBA 5: LLAVE INEXISTENTE
         */
        System.out.println("===== PRUEBA 5: LLAVE INEXISTENTE =====");
        System.out.println("Intentando eliminar la llave 999...");
        tabla.eliminar(999);
        System.out.println("Llave inexistente, el programa continúa correctamente.\n");
        

        /*
         * PRUEBA 6: ACTUALIZACIÓN DE LLAVE EXISTENTE
         */
        System.out.println("===== PRUEBA 6: ACTUALIZACIÓN =====");

        tabla.insertar(18, "Ana Maria");
        System.out.println("Se inserto (18,Maria)");
        System.out.println("Buscar 18");
        System.out.println("Resultado: " + tabla.buscar(18)+"\n");
        

        /*
         * FACTOR DE CARGA
         */
        System.out.println("===== FACTOR DE CARGA =====");
        System.out.println("Factor de carga final: " + tabla.factorCarga());
        

        System.out.println("\n===== TABLA FINAL =====");
        System.out.println(tabla);



        System.out.println("\n\n--------------Direccionamiento abierto con sondeo lineal--------------");
	// IMPLEMENTACION CON SONDEO LINEAL
	TablaHashSondeoLineal tablaSondeoLineal = new TablaHashSondeoLineal();

        /*
         * PRUEBA 1: TABLA VACÍA
         */
        System.out.println("===== PRUEBA 1: TABLA VACÍA =====");
        System.out.println("Buscar llave 10:");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(10));

        /*
         * PRUEBA 2: INSERCIÓN BÁSICA
         */
        System.out.println("\n===== PRUEBA 2: INSERCIÓN BÁSICA =====");

        tablaSondeoLineal.insertar(18, "Ana");
        tablaSondeoLineal.insertar(10, "Luis");
        tablaSondeoLineal.insertar(23, "Elena");

        System.out.println("Se insertaron (18,Ana) , (10,Luis) y (23,Elena) ");
        System.out.println("Buscar 18");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(18));

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(10));

        System.out.println("Buscar 23");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(23));


        /*
         * PRUEBA 3: COLISIONES
         */
        System.out.println("\n===== PRUEBA 3: COLISIONES =====");

        System.out.println("Se insertaron (24,Maria) , (31,Carlos) provocando colisiones");
        tablaSondeoLineal.insertar(24, "Maria");
        tablaSondeoLineal.insertar(31, "Carlos");

        System.out.println("tabla después de provocar colisiones:");
        System.out.println(tablaSondeoLineal+"\n");

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(10));

        System.out.println("Buscar 24");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(24));

        System.out.println("Buscar 31");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(31)+"\n");

        /*
         * PRUEBA 4: ELIMINACIÓN CON COLISIÓN
         */
        System.out.println("===== PRUEBA 4: ELIMINACIÓN =====");

        tablaSondeoLineal.eliminar(24);

        System.out.println("Tabla después de eliminar 24:");
	System.out.println(tablaSondeoLineal+"\n");

        System.out.println("Buscar 24");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(24));

        System.out.println("Buscar 10");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(10));

        System.out.println("Buscar 31");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(31));
        System.out.println();

        /*
         * PRUEBA 5: LLAVE INEXISTENTE
         */
        System.out.println("===== PRUEBA 5: LLAVE INEXISTENTE =====");
        System.out.println("Intentando eliminar la llave 999...");
        tablaSondeoLineal.eliminar(999);
        System.out.println("Llave inexistente, el programa continúa correctamente.\n");
        

        /*
         * PRUEBA 6: ACTUALIZACIÓN DE LLAVE EXISTENTE
         */
        System.out.println("===== PRUEBA 6: ACTUALIZACIÓN =====");

        tablaSondeoLineal.insertar(18, "Ana Maria");
        System.out.println("Se inserto (18,Maria)");
        System.out.println("Buscar 18");
        System.out.println("Resultado: " + tablaSondeoLineal.buscar(18)+"\n");
        

        /*
         * FACTOR DE CARGA
         */
        System.out.println("===== FACTOR DE CARGA =====");
        System.out.println("Factor de carga final: " + tablaSondeoLineal.factorCarga());
        

        System.out.println("\n===== TABLA FINAL =====");
        System.out.println(tablaSondeoLineal);
        }

        //Pedro Ruiz, Miranda Sánchez, Alan Alvarez
}
