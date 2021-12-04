package br.inatel.c207;

public class Consumidor extends Pessoa{
    private int mat_consumidor;
    private int fk_cartao;


    public int getMat_consumidor() {
        return mat_consumidor;
    }

    public void setMat_consumidor(int mat_consumidor) {
        this.mat_consumidor = mat_consumidor;
    }

    public int getFk_cartao() {
        return fk_cartao;
    }

    public void setFk_cartao(int fk_cartao) {
        this.fk_cartao = fk_cartao;
    }
}
