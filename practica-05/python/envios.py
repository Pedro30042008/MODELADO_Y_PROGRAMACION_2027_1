class envios:

    def __init__(self,peso,tipoDeEnvio):
        self.peso = peso
        self.tipoDeEnvio = tipoDeEnvio

def calcular_envio(peso, tipoDeEnvio="estandar"):

    if peso <= 0:
        raise ValueError("Peso Invalido")

    if tipoDeEnvio not in ("estandar", "express"):
        raise ValueError("Envio invalido")

    if peso <= 5:
        precio = 50
    else:
        precio = 50 + 10 * (peso - 5)

    if tipoDeEnvio == "express":
        precio *= 2

    return precio