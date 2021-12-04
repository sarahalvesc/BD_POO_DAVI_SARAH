package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class CompraDB extends Database {
    public boolean insertCompra(Compra compra){
        connect();
        String sql = "INSERT INTO Compra(NUM_COMPRA, idConsumidor, valor) VALUES(?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, (compra.getNum_compra()));
            pst.setInt(2, (compra.getIdConsumidor()));
            pst.setInt(3, (compra.getValor()));
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

    public ArrayList<Compra> researtCompra(int NUM_COMPRA){
        ArrayList<Compra> compra = new ArrayList<>();
        connect();
        String sql = "SELECT Valor FROM Compra WHERE NUM_COMPRA = '" + NUM_COMPRA + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Compra compraTemp = new Compra();
                compraTemp.setValor(result.getInt("Valor"));

                System.out.println("O valor dessa compra é "+ compraTemp.getValor());
                System.out.println();
                System.out.println("------------------------------");
                compra.add(compraTemp);
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
        return compra;
    }
    public boolean updateCompra(int num_compra,int idConsumidor){
        connect();
        String sql = "UPDATE Compra SET idConsumidor = ? WHERE num_compra = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idConsumidor);
            pst.setInt(2, num_compra);
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

