package br.univali;

import br.univali.ui.*;
import javax.swing.UIManager;

public class MyEntertainmentHistory {
        
    public static void main(String[] args){
        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } 
        catch (Exception e) {
            System.out.println("Erro ao configurar look and feel");
        }
        
        
        //TelaNovaMidia tela;
        TelaInserirEntretenimento tela;
        try {
            tela = new TelaInserirEntretenimento();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            //ComunicacaoBD.verUsuarios();
            
            //inserirEntretenimento("La Casa de Papel", 1, 4*45, 2);
            
            //ComunicacaoBD.inserirEntretenimento("Homem de ferro", 2, 80, 1);
            //ComunicacaoBD.verEntretenimentos(1);
        } catch (Exception ex) {
            System.out.println("Erro ao executar o comando SQL \n" + ex.getMessage());
        }
    }    
}
