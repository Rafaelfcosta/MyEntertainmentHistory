package br.univali.bd;

import br.univali.alert.Aviso;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerenciadorConexao {
    public static String URL = "jdbc:mysql://localhost/myentertainmenthistory";
    public static String USER = "root";
    public static String PASSWORD = "";
    public static Connection conexao;
    
    public static Connection getConexao(){
        try {
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException ex) {
            Aviso aviso = new Aviso("Erro ao criar conexão com o banco de dados");
//            System.out.println("Erro ao criar conexão com o banco de dados");
        }
        return conexao;
    }    
}
