package br.inatel.c207;

import java.sql.SQLException;
import java.util.ArrayList;

public class SetorDB extends Database{

    public boolean insertSetor(Setor setor){
        connect();
        String sql = "INSERT INTO Setor(codigo, nome, localidade) VALUES(?, ?, ?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, setor.getCodigo());
            pst.setString(2, setor.getNome());
            pst.setString(3, setor.getLocalidade());
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

    public ArrayList<Setor> researtSetor(int codigo){
        ArrayList<Setor> setor = new ArrayList<>();
        connect();
        String sql = "SELECT * FROM setor WHERE codigo = '" + codigo + "'";
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while (result.next()){
                Setor setorTemp = new Setor();
                setorTemp.setCodigo(result.getInt("codigo"));
                setorTemp.setNome(result.getString("nome"));
                setorTemp.setLocalidade(result.getString("localidade"));

                System.out.println("Nome = " + setorTemp.getNome());
                System.out.println("codigo = "+ setorTemp.getLocalidade());
                System.out.println();
                System.out.println("------------------------------");
                setor.add(setorTemp);
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
        return setor;
    }

    public boolean deleteSetor(int codigo){
        connect();
        String sql = "DELETE FROM Setor WHERE codigo = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, codigo);
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
