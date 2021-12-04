package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class ConsumidorDB extends Database {

    public boolean insertConsumidor(Consumidor consumidor){
        connect();
        String sql = "INSERT INTO Consumidor(cpf, nome, endereco, telefone, data_nasc, cartaoID) VALUES(?, ?, ?, ?, ?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, Integer.toString(consumidor.getCpf()));
            pst.setString(2, consumidor.getNome());
            pst.setString(3, consumidor.getEndereco());
            pst.setString(4, Integer.toString(consumidor.getTelefone()));
            pst.setString(5, consumidor.getData_nasc());
            pst.setInt(6, consumidor.getFk_cartao());
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

    public ArrayList<Consumidor> researtConsumidor(int mat_consumidor){
        ArrayList<Consumidor> consumidor = new ArrayList<>();
        connect();
        String sql = "SELECT * FROM consumidor WHERE mat_consumidor = '" + mat_consumidor + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Consumidor consumidorTemp = new Consumidor();
                consumidorTemp.setCpf(result.getInt("cpf"));
                consumidorTemp.setNome(result.getString("nome"));
                consumidorTemp.setEndereco(result.getString("endereco"));
                consumidorTemp.setTelefone(result.getInt("telefone"));
                consumidorTemp.setData_nasc(result.getString("data_nasc"));
                consumidorTemp.setMat_consumidor(result.getInt("mat_consumidor"));



                System.out.println("CPF = "+ consumidorTemp.getCpf());
                System.out.println("Nome = " + consumidorTemp.getNome());
                System.out.println("Endereco = " + consumidorTemp.getEndereco());
                System.out.println("Telefone = " + consumidorTemp.getTelefone());
                System.out.println("Data de Nascimento = " + consumidorTemp.getData_nasc());
                System.out.println("Matricula = " + consumidorTemp.getMat_consumidor());
                System.out.println();
                System.out.println("------------------------------");
                consumidor.add(consumidorTemp);
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
        return  consumidor;
    }


    public boolean deleteConsumidor(int mat_consumidor){
        connect();
        String sql = "DELETE FROM consumidor WHERE mat_consumidor = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, mat_consumidor);
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
