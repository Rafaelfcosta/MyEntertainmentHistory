package br.univali.ui;

import br.univali.ui.paineis.painelVerMidias;
import br.univali.alert.Aviso;
import br.univali.bd.ComunicacaoBD;
import br.univali.ui.paineis.painelAddMidia;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class TelaPrincipal extends javax.swing.JFrame {
    
    private JPanel midias = new painelVerMidias();
    private JPanel addMidia = new painelAddMidia();
    
    public TelaPrincipal() throws Exception {
        initComponents();
        ConfigurarPaineis();
        this.labelNomeUsuario.setText(ComunicacaoBD.getUsuario(1));
        painelConteudo.add(midias);
        atualizarPainel();
    }  
    
    public void ConfigurarPaineis(){
        MouseListener listener = new MouseAdapter() {
            
            @Override
            public void mouseClicked(MouseEvent me) {
                JPanel painel = (JPanel) me.getSource();
                String nomeAcao = painel.getName();
                
                //Action acao = getActionMap().get(nomeAcao);
            }
            
            @Override
            public void mouseEntered(MouseEvent me) {
                JPanel painel = (JPanel) me.getSource();
                painel.setBackground(Color.GRAY);
                painel.setOpaque(true);
            }
            
            @Override
            public void mouseExited(MouseEvent me) {
                JPanel painel = (JPanel) me.getSource();
                painel.setBackground(Color.darkGray);
                painel.setOpaque(false);
            }
            
        };
        
        painelInicio.addMouseListener(listener);
        painelInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        painelAddMidia.addMouseListener(listener);
        painelAddMidia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        painelFechar.addMouseListener(listener);
        painelFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDireita = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        painelConteudo = new javax.swing.JPanel();
        painelMenu = new javax.swing.JPanel();
        painelPerfil = new javax.swing.JPanel();
        labelNomeUsuario = new javax.swing.JLabel();
        labelImgUsuario = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        painelInicio = new javax.swing.JPanel();
        labelIconInicio = new javax.swing.JLabel();
        labelInicio = new javax.swing.JLabel();
        painelAddMidia = new javax.swing.JPanel();
        labelIconAddMidia = new javax.swing.JLabel();
        labelAddMidia = new javax.swing.JLabel();
        painelFechar = new javax.swing.JPanel();
        labelIconFechar = new javax.swing.JLabel();
        labelFechar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelDireita.setLayout(new java.awt.BorderLayout());

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        painelDireita.add(jSeparator1, java.awt.BorderLayout.WEST);

        painelConteudo.setBackground(new java.awt.Color(102, 102, 102));
        painelConteudo.setPreferredSize(new java.awt.Dimension(800, 600));
        painelConteudo.setLayout(new java.awt.BorderLayout());
        painelDireita.add(painelConteudo, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelDireita, java.awt.BorderLayout.CENTER);

        painelMenu.setBackground(new java.awt.Color(51, 51, 51));
        painelMenu.setLayout(new java.awt.GridLayout(5, 0, 5, 0));

        painelPerfil.setBackground(new java.awt.Color(153, 153, 153));
        painelPerfil.setLayout(new java.awt.BorderLayout());

        labelNomeUsuario.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        labelNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomeUsuario.setText("nome");
        labelNomeUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelPerfil.add(labelNomeUsuario, java.awt.BorderLayout.CENTER);

        labelImgUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/ressources/user.png"))); // NOI18N
        labelImgUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelPerfil.add(labelImgUsuario, java.awt.BorderLayout.WEST);
        painelPerfil.add(jSeparator2, java.awt.BorderLayout.SOUTH);

        painelMenu.add(painelPerfil);

        painelInicio.setBackground(new java.awt.Color(51, 51, 51));
        painelInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelInicioMouseClicked(evt);
            }
        });
        painelInicio.setLayout(new java.awt.BorderLayout());

        labelIconInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelIconInicio.setForeground(new java.awt.Color(255, 255, 255));
        labelIconInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/ressources/home.png"))); // NOI18N
        labelIconInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelInicio.add(labelIconInicio, java.awt.BorderLayout.WEST);

        labelInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelInicio.setForeground(new java.awt.Color(255, 255, 255));
        labelInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelInicio.setText("Início");
        labelInicio.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelInicio.add(labelInicio, java.awt.BorderLayout.CENTER);

        painelMenu.add(painelInicio);

        painelAddMidia.setBackground(new java.awt.Color(51, 51, 51));
        painelAddMidia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelAddMidiaMouseClicked(evt);
            }
        });
        painelAddMidia.setLayout(new java.awt.BorderLayout());

        labelIconAddMidia.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelIconAddMidia.setForeground(new java.awt.Color(255, 255, 255));
        labelIconAddMidia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconAddMidia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/ressources/plus.png"))); // NOI18N
        labelIconAddMidia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelAddMidia.add(labelIconAddMidia, java.awt.BorderLayout.WEST);

        labelAddMidia.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelAddMidia.setForeground(new java.awt.Color(255, 255, 255));
        labelAddMidia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelAddMidia.setText("Adicionar Midia");
        labelAddMidia.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelAddMidia.add(labelAddMidia, java.awt.BorderLayout.CENTER);

        painelMenu.add(painelAddMidia);

        painelFechar.setBackground(new java.awt.Color(51, 51, 51));
        painelFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelFecharMouseClicked(evt);
            }
        });
        painelFechar.setLayout(new java.awt.BorderLayout());

        labelIconFechar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelIconFechar.setForeground(new java.awt.Color(255, 255, 255));
        labelIconFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelIconFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/univali/ressources/exit.png"))); // NOI18N
        labelIconFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelFechar.add(labelIconFechar, java.awt.BorderLayout.WEST);

        labelFechar.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        labelFechar.setForeground(new java.awt.Color(255, 255, 255));
        labelFechar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelFechar.setText("Fechar");
        labelFechar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        painelFechar.add(labelFechar, java.awt.BorderLayout.CENTER);

        painelMenu.add(painelFechar);

        getContentPane().add(painelMenu, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void painelInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelInicioMouseClicked
        painelConteudo.removeAll();
        painelConteudo.add(midias);
        atualizarPainel();
    }//GEN-LAST:event_painelInicioMouseClicked

    private void painelAddMidiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelAddMidiaMouseClicked
        painelConteudo.removeAll();
        painelConteudo.add(addMidia);
        atualizarPainel();
    }//GEN-LAST:event_painelAddMidiaMouseClicked

    private void painelFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelFecharMouseClicked
        System.exit(0);
    }//GEN-LAST:event_painelFecharMouseClicked

    private void atualizarPainel(){
        painelConteudo.repaint();
        painelConteudo.revalidate();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TelaPrincipal().setVisible(true);
                } catch (Exception ex) {
                    Aviso aviso = new Aviso("Ocorreu um Erro");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelAddMidia;
    private javax.swing.JLabel labelFechar;
    private javax.swing.JLabel labelIconAddMidia;
    private javax.swing.JLabel labelIconFechar;
    private javax.swing.JLabel labelIconInicio;
    private javax.swing.JLabel labelImgUsuario;
    private javax.swing.JLabel labelInicio;
    private javax.swing.JLabel labelNomeUsuario;
    private javax.swing.JPanel painelAddMidia;
    private javax.swing.JPanel painelConteudo;
    private javax.swing.JPanel painelDireita;
    private javax.swing.JPanel painelFechar;
    private javax.swing.JPanel painelInicio;
    private javax.swing.JPanel painelMenu;
    private javax.swing.JPanel painelPerfil;
    // End of variables declaration//GEN-END:variables
}
