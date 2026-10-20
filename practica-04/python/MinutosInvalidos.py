# Excepción lanzada cuando no se da R2 o se da R11.
class MinutosInvalidos(Exception):
    def __init__(self, mensaje):
        super().__init__(mensaje)
        self.mensaje = mensaje
