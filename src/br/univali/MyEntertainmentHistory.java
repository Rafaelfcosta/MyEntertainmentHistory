package br.univali;

import br.univali.bd.GerenciadorConexao;
import br.univali.ui.TelaPrincipal;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.UIManager;

public class MyEntertainmentHistory {
    
    private static Connection conexao = null;
    private static PreparedStatement st = null;
    private static ResultSet rs = null;
    
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception e) {
            System.out.println("Erro ao configurar look and feel");
        }
        
        
            //        TelaPrincipal tela = new TelaPrincipal();
//        tela.setLocationRelativeTo(null);
//        tela.setVisible(true);
        try {
            inserirUsuario();
            verUsuarios();
        } catch (Exception ex) {
            System.out.println("Erro ao executar o comando SQL " + ex.getMessage());
        }
       
        
    }
    
    public static void verUsuarios() throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "SELECT * FROM USUARIOS";
        st = conexao.prepareStatement(SQL);
        rs = st.executeQuery(SQL);
        while(rs.next()){
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            System.out.println(id + " -> " + nome);
        }
    }
    
    public static void inserirUsuario() throws Exception{
        conexao = GerenciadorConexao.getConexao();
        String SQL = "INSERT INTO USUARIOS (nome) VALUES('finish')";
        st = conexao.prepareStatement(SQL);
        st.execute(SQL);
    }
    
}
