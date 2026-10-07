/**
 * Adapta el contrato Notificador al método send_email de CorreoLegacy.
 */
public class AdaptadorCorreo implements Notificador {
    /**
     * Servicio existente al que se delega el envío.
     */
    private final CorreoLegacy correo;

    /**
     * Construye el adaptador con el servicio de correo existente.
     *
     * @param correo servicio al que se delegará el envío
     */
    public AdaptadorCorreo(CorreoLegacy correo) {
        this.correo = correo;
    }

    /**
     * Delega el envío en CorreoLegacy conservando ambos argumentos.
     *
     * @param destino destinatario del mensaje
     * @param mensaje contenido que se envía
     */
    @Override
    public void enviar(String destino, String mensaje) {
        correo.send_email(destino, mensaje);
    }
}
//Alan Gael, Pedro Pablo, Miranda Sanchez
