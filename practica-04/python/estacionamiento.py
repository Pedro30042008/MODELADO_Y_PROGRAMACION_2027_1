import math

from MinutosInvalidos import MinutosInvalidos
from ClienteInvalido import ClienteInvalido

class Estacionamiento:

    # Tarifa del boleto perdido.
    TARIFA_BOLETO_PERDIDO = 300.0

    def calcular_total(self, minutos: int, tipo_cliente: str = "normal",
                       boleto_perdido: bool = False) -> float:
        """
        Calcula el total a pagar de acuerdo con el modelo de la práctica.

        Nota para el alumno:
        trate esta implementación como un sistema que debe verificarse.
        No asuma que todo lo que hace el código es correcto.
        """
        # Entrada Invalida: Minutos Negativos.
        if minutos < 0:
            raise MinutosInvalidos("Los minutos no pueden ser negativos")

        # Entrada Invalida: Minutos Decimales.
        if isinstance(minutos, float):
            raise MinutosInvalidos("Los minutos no pueden ser en decimal")
        
        # Entrada Inválida: Tipo de cliente no reconocido.
        if tipo_cliente not in ("normal", "frecuente"):
            raise ClienteInvalido("Tipo de cliente no válido")

        # Si el boleto está perdido -> $300.00
        if boleto_perdido:
            return self.TARIFA_BOLETO_PERDIDO
            
        # Si permanece 15 minutos o menos -> $0.00
        elif minutos <= 15:
            total = 0.0
            
        # Si permanece 60 minutos o menos -> $20.00
        elif minutos <= 60:
            total = 20.0
            
        # Si permanece mas de 60 minutos:
        # -> $20.00 la primera hora.
        # -> $15.00 cada hora iniciada.
        else:
            horas_adicionales = math.ceil((minutos - 60) / 60)
            total = 20.0 + (horas_adicionales * 15.0)

        # Si el cliente es "frecuente" aplicar el 10% de descuento.
        if tipo_cliente == "frecuente":
            total *= 0.90

        # Devolver el total redondeado con dos decimales.
        return round(total, 2)
