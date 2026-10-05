class CorreoLegacy {
    void send_email(String to, String body) {
        System.out.println("Para: " + to);
        System.out.println(body);
    }
}

public class Main {
    static void agregarArchivo(Carpeta carpeta,
                               String tipo, String nombre, int tamanio) {
        if (tipo.equals("pdf")) {
            carpeta.archivos.add(new ArchivoPDF(nombre, tamanio));
        } else if (tipo.equals("txt")) {
            carpeta.archivos.add(new ArchivoTexto(nombre, tamanio));
        }
    }

    static int obtenerTamanio(Carpeta carpeta) {
        int total = 0;
        for (Archivo archivo : carpeta.archivos) {
            total += archivo.tamanio;
        }
        for (Carpeta subcarpeta : carpeta.subcarpetas) {
            total += obtenerTamanio(subcarpeta);
        }
        return total;
    }

    static void enviarResultado(Carpeta carpeta, String destino) {
        CorreoLegacy correo = new CorreoLegacy();
        correo.send_email(destino,
                "Tamanio total: " + obtenerTamanio(carpeta));
    }

    // Mis modificaciones empiezan aqui
    static void comprobar(String nombre, int esperado, int obtenido) {
        if (esperado == obtenido) {
            System.out.println("OK: " + nombre);
        } else {
            System.out.println("FALLO: " + nombre
                     + " | esperado=" + esperado
                     + " | obtenido=" + obtenido);
        }
    }

    public static void main(String[] args) {
        Carpeta clase = new Carpeta("MyP");
        agregarArchivo(clase, "pdf", "practica.pdf", 120);
        agregarArchivo(clase, "txt", "notas.txt", 80);

        Carpeta ejemplos = new Carpeta("Ejemplos");
        agregarArchivo(ejemplos, "txt", "ejemplo.txt", 50);
        clase.agregar(ejemplos);

        System.out.println(obtenerTamanio(clase));
        enviarResultado(clase, "profesor@universidad.edu");

        //Prueba de carpeta vacia
        Carpeta vacia = new Carpeta("Vacia");
        int total = obtenerTamanio(vacia);
        comprobar("Carpeta vacia", 0, total);


        //pruebas restantes
        /**
         *
         * Datos que deben preparar Tamaño esperado
         * Carpeta sin archivos ni subcarpetas 0
         * Carpeta con un PDF de 120 120
         * Carpeta con PDF de 120 y texto de 80 200
         * Ejemplo completo con subcarpeta de 50 250
         * Carpeta con un archivo de tamaño 0 0
         *
         * **/
    }
}

