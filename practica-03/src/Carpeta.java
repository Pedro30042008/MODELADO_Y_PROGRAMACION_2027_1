import java.util.ArrayList;
import java.util.List;

public class Carpeta implements Elemento {
    String nombre;
    private List<Elemento> elementos;

    public Carpeta(String nombre) {
        this.elementos = new ArrayList<>();
        this.nombre = nombre;
    }

    void agregar(Elemento elemento) {
        elementos.add(elemento);
    }

    @Override
    public int obtenerTamanio() {
        int total = 0;
        for (Elemento elemento : elementos) {
            total += elemento.obtenerTamanio();
            }
        return total;
        }
}