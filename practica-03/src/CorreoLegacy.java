/**
 * Servicio existente de correo simulado que imprime el destinatario y el mensaje.
 */
class CorreoLegacy {
    /**
     * Simula el envío imprimiendo el destinatario y el cuerpo.
     *
     * @param to destinatario del correo
     * @param body cuerpo del correo
     */
    void send_email(String to, String body) {
        System.out.println("Para: " + to);
        System.out.println(body);
    }
}
