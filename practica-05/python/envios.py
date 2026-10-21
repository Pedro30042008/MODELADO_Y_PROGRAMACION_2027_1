class envios:

    def __init__(self,peso,tipoDeEnvio):
        self.peso = peso
        self.tipoDeEnvio = tipoDeEnvio

def calcular_envio(peso, tipoDeEnvio):
    precio = 0

    if peso <= 5:
        precio+= 50
    else: 
        pesoExtra = peso - 5
        precio += (50) + 10 * pesoExtra
    
    if tipoDeEnvio == "estandar":
        precio+= 0
    elif tipoDeEnvio == "express":
        precio = 2*precio
    
    return precio