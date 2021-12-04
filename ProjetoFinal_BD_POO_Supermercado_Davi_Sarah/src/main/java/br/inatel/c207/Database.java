package br.inatel.c207;

import java.sql.*;

public abstract class Database {
    Connection connection; // faz a conexao com o BD
    Statement statement; // prepara as querys SELECT
    ResultSet result; // executa as querys SELECT
    PreparedStatement pst; // prepara e executa INSERT UPADDATE DELETE


    static final String user = "SARAH";
    static final String password = "1234";
    static final String database = "Supermercado";

    static final String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    public boolean check = false;

    public void connect(){

        try{
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("conexao feita com sucesso" + connection);
        }
        catch (SQLException e){
            System.out.println("falha de conexao" + e.getMessage());

        }
    }

}
