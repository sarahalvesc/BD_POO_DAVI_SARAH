package br.inatel.c207;

public class Funcionario extends Pessoa {
    private int matricula;
    private float salario;
    private int fk_setor;


    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public float getSalario() {
        return salario;
    }



    public void setSalario(float salario) {
        this.salario = salario;
    }

    public int getFk_setor() {
        return fk_setor;
    }

    public void setFk_setor(int fk_setor) {
        this.fk_setor = fk_setor;
    }
}
