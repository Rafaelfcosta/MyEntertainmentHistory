package br.univali;

import br.univali.alert.Aviso;
import br.univali.ui.*;
import com.alee.laf.WebLookAndFeel;
import javax.swing.UIManager;

public class MyEntertainmentHistory {
        
    public static void main(String[] args){
        
        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
              WebLookAndFeel.install();
        } 
        catch (Exception e) {
            System.out.println("Erro ao configurar look and feel");
        }
        
        
        //TelaNovaMidia tela;
//        TelaInicial tela;
        TelaPrincipal tela;
        try {
//            tela = new TelaInicial();
            tela = new TelaPrincipal();
            tela.setLocationRelativeTo(null);
            tela.setVisible(true);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            Aviso aviso = new Aviso("Um erro ocorreu");
        }
        
        try {
            //ComunicacaoBD.verUsuarios();
            
            //inserirEntretenimento("La Casa de Papel", 1, 4*45, 2);
            
            //ComunicacaoBD.inserirEntretenimento("Homem de ferro", 2, 80, 1);
            //ComunicacaoBD.verEntretenimentos(1);
        } catch (Exception ex) {
            Aviso aviso = new Aviso("Erro ao executar o comando SQL \n");
            System.out.println("Erro ao executar o comando SQL \n" + ex.getMessage());
        }
    }    
}
