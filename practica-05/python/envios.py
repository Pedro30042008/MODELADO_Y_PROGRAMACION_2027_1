
class envios:

    def __init__(self,peso,tipoDeEnvio):
        self.peso = peso
        self.tipoDeEnvio = tipoDeEnvio

def calcular_envio(peso, tipoDeEnvio):

    precio = 0

    if peso > 5:
        raise ValueError("Peso mayor a 5")
    
    precio +=0

    if tipoDeEnvio != "estandar":
        raise ValueError("Envio no estandar")
    
    precio += 50

    return precio

