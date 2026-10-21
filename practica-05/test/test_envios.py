import pytest
from python.envios import calcular_envio

def test_calcular_envio():
    assert calcular_envio(3, "estandar") == 50

def test_calcular_envio_peso_extra():
    assert calcular_envio(10, "estandar") == 100