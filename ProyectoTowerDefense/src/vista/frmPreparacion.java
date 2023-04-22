/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Hilo;
import controlador.PreparacionJuego;
import javax.swing.JOptionPane;

/**
 *
 * @author araya
 */
public class frmPreparacion extends javax.swing.JFrame {

    frmJuego frmJuego;
    Hilo hilo;
    PreparacionJuego prepjuego = new PreparacionJuego();

    public frmPreparacion() {
        initComponents();
        setLocationRelativeTo(null); //Para que se muestre centrado
        lblNumRondaP.setText(frmJuego.lblNumRonda.getText());
        lblCantidadTropas.setText(String.valueOf(Integer.parseInt(lblNumRondaP.getText()) + 4));
        prepjuego.RandomCPU(Integer.valueOf(lblNumRondaP.getText()));
        prepjuego.lista();
        btnIniciar.setEnabled(lblCantidadTropas.getText().equals("0"));
        frmJuego = new frmJuego();
        hilo = new Hilo(frmJuego);

    }
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMago = new javax.swing.JLabel();
        lblArquera = new javax.swing.JLabel();
        lblCaballero = new javax.swing.JLabel();
        btnAgregarM = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCantidadTropas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgregarA = new javax.swing.JButton();
        btnAgregarC = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNumRondaP = new javax.swing.JLabel();
        cmbCamino = new javax.swing.JComboBox<>();
        lblTropa2 = new javax.swing.JLabel();
        lblTropa1 = new javax.swing.JLabel();
        lblTropa3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        lblTropasCPU = new javax.swing.JButton();
        btnOcultarTropas = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Mago-Verde-x54.png"))); // NOI18N
        getContentPane().add(lblMago, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        lblArquera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Arquera-Verde-x59.png"))); // NOI18N
        lblArquera.setAlignmentX(0.5F);
        getContentPane().add(lblArquera, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, -1, -1));

        lblCaballero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caballero-Verde-85x90.png"))); // NOI18N
        getContentPane().add(lblCaballero, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, -1, -1));

        btnAgregarM.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarM.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarM.setText("Agregar");
        btnAgregarM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Elija la tropa que desea agregar");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tropas restantes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(392, 31, -1, -1));

        lblCantidadTropas.setForeground(new java.awt.Color(255, 255, 255));
        lblCantidadTropas.setText("1");
        lblCantidadTropas.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                lblCantidadTropasInputMethodTextChanged(evt);
            }
        });
        lblCantidadTropas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblCantidadTropasPropertyChange(evt);
            }
        });
        getContentPane().add(lblCantidadTropas, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 53, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Preparación");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 10, -1, -1));

        btnAgregarA.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarA.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarA.setText("Agregar");
        btnAgregarA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarA, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        btnAgregarC.setBackground(new java.awt.Color(0, 0, 0));
        btnAgregarC.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarC.setText("Agregar");
        btnAgregarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregarC, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Elija el camino");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Número Ronda");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 31, -1, -1));

        lblNumRondaP.setForeground(new java.awt.Color(255, 255, 255));
        lblNumRondaP.setText("1");
        getContentPane().add(lblNumRondaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        cmbCamino.setBackground(new java.awt.Color(0, 0, 0));
        cmbCamino.setForeground(new java.awt.Color(255, 255, 255));
        cmbCamino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));
        getContentPane().add(cmbCamino, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 163, -1));
        getContentPane().add(lblTropa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, -1, -1));
        getContentPane().add(lblTropa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, -1, -1));
        getContentPane().add(lblTropa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PRIMERAS TROPAS ENEMIGAS");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        btnIniciar.setBackground(new java.awt.Color(0, 102, 0));
        btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("INICIAR");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 110, 50));

        lblTropasCPU.setBackground(new java.awt.Color(51, 0, 0));
        lblTropasCPU.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTropasCPU.setForeground(new java.awt.Color(255, 255, 255));
        lblTropasCPU.setText("Mostrar");
        lblTropasCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblTropasCPUActionPerformed(evt);
            }
        });
        getContentPane().add(lblTropasCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, 30));

        btnOcultarTropas.setBackground(new java.awt.Color(51, 0, 0));
        btnOcultarTropas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOcultarTropas.setForeground(new java.awt.Color(255, 255, 255));
        btnOcultarTropas.setText("Ocultar");
        btnOcultarTropas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcultarTropasActionPerformed(evt);
            }
        });
        getContentPane().add(btnOcultarTropas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, 30));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/FondoPreparacion.png"))); // NOI18N
        lblFondo.setMaximumSize(new java.awt.Dimension(500, 420));
        lblFondo.setMinimumSize(new java.awt.Dimension(500, 420));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCActionPerformed
        // TODO add your handling code here:

        if (!lblCantidadTropas.getText().equals("0"))
            prepjuego.AgregarTropaUI(Integer.valueOf(lblCantidadTropas.getText()),
                    Integer.valueOf(lblNumRondaP.getText()),
                    String.valueOf(cmbCamino.getSelectedItem()), 3, 2.0, "/img/caballero-Verde-85x90.png");
        else {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de tropas por ronda", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarCActionPerformed

    private void btnAgregarAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAActionPerformed
        // TODO add your handling code here:
        if (!lblCantidadTropas.getText().equals("0")) {
            prepjuego.AgregarTropaUI(Integer.valueOf(lblCantidadTropas.getText()),
                    Integer.valueOf(lblNumRondaP.getText()),
                    String.valueOf(cmbCamino.getSelectedItem()), 2, 1.0, "/img/Arquera-Verde-x59.png");

        } else {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de tropas por ronda", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarAActionPerformed

    private void btnAgregarMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMActionPerformed
        // TODO add your handling code here:
        if (!lblCantidadTropas.getText().equals("0")) {
            prepjuego.AgregarTropaUI(Integer.valueOf(lblCantidadTropas.getText()),
                    Integer.valueOf(lblNumRondaP.getText()),
                    String.valueOf(cmbCamino.getSelectedItem()), 1, 1.5, "/img/Mago-Verde-x54.png");
        } else {
            JOptionPane.showMessageDialog(null, "Ha alcanzado el máximo de tropas por ronda", "ALERTA", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnAgregarMActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:

        //prepjuego.ActualizarIconoCam1();//Actualiza inconos iniciales
        // prepjuego.IniciaJuego(); //Incia Juego
        hilo.start();
        frmJuego.setVisible(true);
        prepjuego.ActualizarIconoCam(); //Actualiza inconos iniciales
        this.dispose();


    }//GEN-LAST:event_btnIniciarActionPerformed

    public void apagaHilo(){
        
        hilo.detieneHilo();        
}
    
    private void lblTropasCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblTropasCPUActionPerformed
        // TODO add your handling code here:
        prepjuego.MostrarTropasCPU();
        //   prepjuego.lista();
        lblTropasCPU.setVisible(false);
        btnOcultarTropas.setVisible(true);
        lblTropa1.setVisible(true);
        lblTropa2.setVisible(true);
        lblTropa3.setVisible(true);
    }//GEN-LAST:event_lblTropasCPUActionPerformed

    private void lblCantidadTropasInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_lblCantidadTropasInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_lblCantidadTropasInputMethodTextChanged

    private void lblCantidadTropasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblCantidadTropasPropertyChange
        // TODO add your handling code here:
        if (lblCantidadTropas.getText().equals("0")) {
            btnIniciar.setEnabled(true);
        }
    }//GEN-LAST:event_lblCantidadTropasPropertyChange

    private void btnOcultarTropasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcultarTropasActionPerformed
        // TODO add your handling code here:
        btnOcultarTropas.setVisible(false);
        lblTropa1.setVisible(false);
        lblTropa2.setVisible(false);
        lblTropa3.setVisible(false);
        lblTropasCPU.setVisible(true);
    }//GEN-LAST:event_btnOcultarTropasActionPerformed

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
            java.util.logging.Logger.getLogger(frmPreparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPreparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPreparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPreparacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPreparacion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarA;
    private javax.swing.JButton btnAgregarC;
    private javax.swing.JButton btnAgregarM;
    public static javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnOcultarTropas;
    private javax.swing.JComboBox<String> cmbCamino;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblArquera;
    private javax.swing.JLabel lblCaballero;
    public static javax.swing.JLabel lblCantidadTropas;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblMago;
    public static javax.swing.JLabel lblNumRondaP;
    public static javax.swing.JLabel lblTropa1;
    public static javax.swing.JLabel lblTropa2;
    public static javax.swing.JLabel lblTropa3;
    private javax.swing.JButton lblTropasCPU;
    // End of variables declaration//GEN-END:variables
}
