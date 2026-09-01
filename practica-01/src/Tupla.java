
//clase tupla para asignar una llave a un valor
public class Tupla {
    //ATRIBUTOS
    String valor;
    int llave;

    //Constructor
    public Tupla(String valor, int llave) {
        this.valor = valor;
        this.llave = llave;
    }

    //Getters and setters
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    @Override
    public String toString (){
        return "("+llave+", "+valor+")";
    }


}
