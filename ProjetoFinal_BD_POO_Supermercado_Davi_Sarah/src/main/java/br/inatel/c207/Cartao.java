package br.inatel.c207;

public class Cartao {
    private int n_cartao;
    private float limite;
    private String data_venc;

    public int getN_cartao() {
        return n_cartao;
    }

    public void setN_cartao(int n_cartao) {
        this.n_cartao = n_cartao;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public String getData_venc() {
        return data_venc;
    }

    public void setData_venc(String data_venc) {
        this.data_venc = data_venc;
    }
}
