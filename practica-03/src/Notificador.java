/**
 * Contrato de envío que utiliza el programa sin depender de un proveedor concreto.
 */
public interface Notificador {
    /**
     * Envía un mensaje al destinatario indicado.
     *
     * @param destino destinatario del mensaje
     * @param mensaje contenido que se envía
     */
    void enviar(String destino, String mensaje);
}
