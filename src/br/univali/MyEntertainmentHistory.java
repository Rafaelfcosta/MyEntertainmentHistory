package br.univali;

import br.univali.bd.GerenciadorConexao;
import br.univali.ui.TelaPrincipal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.UIManager;

public class MyEntertainmentHistory {
    
    private Connection conexao = null;
    private Statement st = null;
    private ResultSet rs = null;
    
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
        
        
    }
    
    public void testar(){
        conexao = GerenciadorConexao.getConexao();
    }
    
}
