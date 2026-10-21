import pytest
from python.envios import calcular_envio

def test_calcular_envio():
    assert calcular_envio(3, "estandar") == 50

def test_calcular_envio_peso_extra():
    assert calcular_envio(10, "estandar") == 100

def test_calcular_envio_liviano_express():
    assert calcular_envio(3, "express") == 100
    assert calcular_envio(2, "express") == 100


def test_calcular_envio_pesado_express():
    assert calcular_envio(7, "express") == 140
    assert calcular_envio(10, "express") == 200
