package br.inatel.c207;


import java.sql.SQLException;
import java.util.ArrayList;

public class CartaoDB extends Database {
    public boolean insertCartao(Cartao cartao){
        connect();
        String sql = "INSERT INTO Cartao(n_cartao, limite, data_venc) VALUES(?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cartao.getN_cartao());
            pst.setFloat(2, cartao.getLimite());
            pst.setString(3, cartao.getData_venc());
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
    public boolean deleteCartao(int n_cartao){
        connect();
        String sql = "DELETE FROM cartao WHERE Consumidor(fk_cartao) = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, n_cartao);
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

    public boolean updateFuncionario(int n_cartao, float limite){
        connect();
        String sql = "UPDATE Cartao SET Limite = ? WHERE n_cartao = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setFloat(1, limite);
            pst.setInt(2, n_cartao);
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

    public ArrayList<Cartao> researtCartao(int n_cartao){
        ArrayList<Cartao> cartao = new ArrayList<>();
        connect();
        String sql = "SELECT * FROM Cartao WHERE n_cartao = '" + n_cartao + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Cartao cartaoTemp = new Cartao();
                cartaoTemp.setLimite(result.getInt("limite"));



                System.out.println("limite = "+ cartaoTemp.getLimite());

                cartao.add(cartaoTemp);
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
        return cartao;
    }
}
