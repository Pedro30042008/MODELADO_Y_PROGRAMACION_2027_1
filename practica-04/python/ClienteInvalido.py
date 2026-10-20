# Excepción lanzada cuando no se da R1 o se da R10.
class ClienteInvalido(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)
        self.mensaje = mensaje
