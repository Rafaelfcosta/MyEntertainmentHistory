package br.univali;

import br.univali.bd.ComunicacaoBD;
import javax.swing.UIManager;

public class MyEntertainmentHistory {
        
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
            ComunicacaoBD.verUsuarios();
            
            //inserirEntretenimento("La Casa de Papel", 1, 4*45, 2);
            ComunicacaoBD.verEntretenimentos();
        } catch (Exception ex) {
            System.out.println("Erro ao executar o comando SQL \n" + ex.getMessage());
        }
    }    
}
