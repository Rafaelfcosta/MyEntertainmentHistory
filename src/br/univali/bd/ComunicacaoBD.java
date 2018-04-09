package br.univali.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Rafael F
 */
public class ComunicacaoBD {
    
    private static Connection conexao = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;
    
    private static final int SERIE = 1;
    private static final int FILME = 2;
    private static final int ANIME = 3;
    private static final int GAME  = 4;
    
    public static void inserirTestUsers() throws Exception{
        for(int i=0; i<10; i++){
                String a = (i < 10) ? "0" : "";
                inserirUsuario("Test User " + a + i);   
        }
    }
    
    public static void deletar() throws Exception{
        comandoSQL("DELETE FROM USUARIOS");
    }
    
    public static void verUsuarios() throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while(rs.next()){
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            System.out.println(id + " -> " + nome);
        }
    }
    public static void verEntretenimentos() throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS";
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while(rs.next()){
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");
            System.out.println(id + " -> " + titulo + " | " + getCategoria(categoria) + " | " + (int)duracao/60 + " horas consumidas");
        }
    }
    
    public static void verEntretenimentos(int id_usuario) throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM ENTRETENIMENTOS WHERE id_usuario = " + id_usuario;
        pst = conexao.prepareStatement(SQL);
        rs = pst.executeQuery(SQL);
        while(rs.next()){
            int id = rs.getInt("id_entretenimento");
            String titulo = rs.getString("titulo");
            double duracao = rs.getDouble("duracao_sessao");
            int categoria = rs.getInt("categoria");
            System.out.println(id + " -> " + titulo + " | " + getCategoria(categoria) + " | " + (int)duracao/60 + " horas consumidas");
        }
    }
    
    public static String getCategoria(int categoria){
        switch (categoria){
            case SERIE:
                return "Série";
            case FILME:
                return "Filme";
            case ANIME:
                return "Anime";
            case GAME:
                return "Game";
            default:
                return "";
        }
    }
    
    public static void inserirUsuario(String nomeUsuario) throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "INSERT INTO USUARIOS "
                   + "(nome) VALUES"
                   + "(?)";
        pst = conexao.prepareStatement(SQL);
        pst.setString(1, nomeUsuario);
        pst.executeUpdate();
    }
    public static void inserirEntretenimento(String titulo, int categoria, double duracao_sessao, int id_usuario) throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "INSERT INTO ENTRETENIMENTOS "
                   + "(titulo, categoria, duracao_sessao, id_usuario) VALUES"
                   + "(?,?,?,?)";
        pst = conexao.prepareStatement(SQL);
        pst.setString(1, titulo);
        pst.setInt(2, categoria);
        pst.setDouble(3, duracao_sessao);
        pst.setInt(4, id_usuario);
        pst.executeUpdate();
    }
    
    
    
    public static void comandoSQL(String SQL) throws Exception{
        conexao = GerenciadorConexao.getConexao();
        pst = conexao.prepareStatement(SQL);
        pst.executeUpdate();
    }
}
