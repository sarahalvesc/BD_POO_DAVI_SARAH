package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class FuncionarioDB extends Database{

    public boolean insertFuncionario(Funcionario funcionario){
        connect();
        String sql = "INSERT INTO Funcionario(cpf, nome, endereco, telefone, data_nasc, salario) VALUES(?, ?, ?, ?, ?, ? )";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Integer.toString(funcionario.getCpf()));
            pst.setString(2, funcionario.getNome());
            pst.setString(3, funcionario.getEndereco());
            pst.setString(4, Integer.toString(funcionario.getTelefone()));
            pst.setString(5, funcionario.getData_nasc());
            pst.setString(6, Float.toString(funcionario.getSalario()));
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Falha de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Falha ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public ArrayList<Funcionario> researtFuncionario(int matricula){
        ArrayList<Funcionario> users = new ArrayList<>();
        connect();
        String sql = "SELECT * FROM Funcionario WHERE matricula = '" + matricula + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Funcionario funcionarioTemp = new Funcionario();
                funcionarioTemp.setCpf(result.getInt("cpf"));
                funcionarioTemp.setNome(result.getString("nome"));
                funcionarioTemp.setEndereco(result.getString("endereco"));
                funcionarioTemp.setTelefone(result.getInt("telefone"));
                funcionarioTemp.setData_nasc(result.getString("data_nasc"));
                funcionarioTemp.setMatricula(result.getInt("matricula"));
                funcionarioTemp.setSalario(result.getFloat("salario"));

                System.out.println("CPF = "+ funcionarioTemp.getCpf());
                System.out.println("Nome = " + funcionarioTemp.getNome());
                System.out.println("Endereco = " + funcionarioTemp.getEndereco());
                System.out.println("Telefone = " + funcionarioTemp.getTelefone());
                System.out.println("Data de Nascimento = " + funcionarioTemp.getData_nasc());
                System.out.println("Matricula = " + funcionarioTemp.getMatricula());
                System.out.println("Salario = " + funcionarioTemp.getSalario());
                System.out.println();
                System.out.println("------------------------------");
                users.add(funcionarioTemp);
            }
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }finally {
            try {
                connection.close();
                statement.close();
                result.close();
            }catch (SQLException e){
                System.out.println("Falha ao fechar conexão: " + e.getMessage());
            }
        }
        return  users;
    }
    public boolean updateFuncionario(int matricula, float salario){
        connect();
        String sql = "UPDATE Funcionario SET salario = ? WHERE matricula = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, salario);
            pst.setInt(2, matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Falha de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Falha ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public boolean deleteFuncionario(int matricula){
        connect();
        String sql = "DELETE FROM Funcionario WHERE matricula = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, matricula);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Falha de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Falha ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }
    public boolean insertFuncionarioSetor(int funcionario, int setor){
        connect();
        String sql = "INSERT INTO Setor_Funcionario(funcionarioMAT, setorCodigo) VALUES(?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1,funcionario);
            pst.setInt(2, setor);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Falha de operação: " + e.getMessage());
            check = false;
        }finally {
            try {
                connection.close();
                pst.close();
            }catch (SQLException e){
                System.out.println("Falha ao fechar conexão: " + e.getMessage());
            }
        }
        return check;
    }
}

