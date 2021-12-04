package br.inatel.c207;

public class Compra {
    private int num_compra;
    private int idConsumidor;
    private int fk_consumidor;
    private int valor;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNum_compra() {
        return num_compra;
    }

    public void setNum_compra(int num_compra) {
        this.num_compra = num_compra;
    }

    public int getIdConsumidor() {
        return idConsumidor;
    }

    public void setIdConsumidor(int idConsumidor) {
        this.idConsumidor = idConsumidor;
    }

    public int getFk_consumidor() {
        return fk_consumidor;
    }

    public void setFk_consumidor(int fk_consumidor) {
        this.fk_consumidor = fk_consumidor;
    }
}
