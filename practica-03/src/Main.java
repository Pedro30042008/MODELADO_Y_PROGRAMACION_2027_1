/**
 * Organiza el ejemplo de la práctica y muestra y notifica su tamaño total.
 */
public class Main {
    /**
     * Envía el tamaño de la carpeta mediante el notificador recibido.
     *
     * @param carpeta carpeta cuyo tamaño se informa
     * @param destino destinatario del resultado
     * @param notificador componente encargado del envío
     */
    static void enviarResultado(Carpeta carpeta, String destino,
                                Notificador notificador) {
        notificador.enviar(destino,
                "Tamanio total: " + carpeta.obtenerTamanio());
    }

    /**
     * Construye el ejemplo MyP, imprime su tamaño y envía el correo simulado.
     *
     * @param args argumentos de ejecución, no utilizados
     */
    public static void main(String[] args) {
        CreadorArchivo creadorPDF = new CreadorPDF();
        CreadorArchivo creadorTexto = new CreadorTexto();

        Carpeta clase = new Carpeta("MyP");
        clase.agregar(creadorPDF.crearArchivo("practica.pdf", 120));
        clase.agregar(creadorTexto.crearArchivo("notas.txt", 80));

        Carpeta ejemplos = new Carpeta("Ejemplos");
        ejemplos.agregar(creadorTexto.crearArchivo("ejemplo.txt", 50));
        clase.agregar(ejemplos);

        System.out.println(clase.obtenerTamanio());
        Notificador notificador = new AdaptadorCorreo(new CorreoLegacy());
        enviarResultado(clase, "profesor@universidad.edu", notificador);
    }
}
