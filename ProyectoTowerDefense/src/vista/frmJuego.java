
package vista;

import controlador.Hilo;



/**
 *
 * @author Angelo
 */
public class frmJuego extends javax.swing.JFrame {

    /**
     * Creates new form frmJuego
     */
    
    
    public frmJuego() {
        //Preparacion.lblNumRondaP.setText(lblNumRonda.getText());
        initComponents();
        setSize(1920, 1080); //Tamaño del frame
        setResizable(false); //Para no poder extender al frame
        setLocationRelativeTo(null); //Para que se muestre centrado
        //Hilo hilo = new Hilo(this); //Se hace la instancia con la clase hilo y se le pasa un this
        //hilo.start(); //Es un metodo que pertenece a la clase Thread de la cual hilo esta heredando y se usa para llamar al metodo ejecutar de la clase hilo e iniciar el hilo

        //PreparacionJuego prepJuego = new PreparacionJuego(this); //Se hace la instancia con la clase hilo y se le pasa un this
        
        
        
        
    
    }

    
    
    
    public void moverTropas(){
        //Lo que me permite es que cada vez que se llame en el hilo toma las posiciones de las tropas y las mueve
      //  lblTropa1CPU.setLocation(lblTropa1CPU.getX() + 5, lblTropa1CPU.getY());
        lblTropaPlayer1.setLocation(lblTropaPlayer1.getX() - 5, lblTropaPlayer1.getY());

//          lblTropa2CPU.setLocation(lblTropa2CPU.getX() + 5, lblTropa2CPU.getY());
//         lblTropaPlayer2.setLocation(lblTropaPlayer2.getX() -5, lblTropaPlayer2.getY());    
//    
    }

    public int verificaDuelo() {
        //Choque entre camino 1
        if (lblTropaPlayer1.getX() <= (lblTropa1CPU.getX() + 134)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Chocaron");
            return 1;

        }

        // Choque entre camino 2
        if (lblTropaPlayer1.getX() < (lblTropa2CPU.getX() + 61)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
        {
            System.out.println("Chocaron");
            return 2;

        }
        return 0;

    }

    public void interaccionTropas() {

        if (verificaDuelo() == 1) {

            lblTropa1CPU.setLocation(390, 390);
            lblTropaPlayer1.setLocation(1450, 440);
        } else if (verificaDuelo() == 2) {
            lblTropaPlayer1.setLocation(1460, 560);
        }

    }
//    
//        public int verificaDueloCastillo() {
//        //Choque castillo Player en camino 1 
//        if (lblTropa1CPU.getX() >= lblCastilloPlayer.getX() - 40) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
//        {
//            System.out.println("Choco Castillo Player Camino 1");
//            return 1; //Retorna 1 si hubo un choque en el castillo del Player en el camino 1
//        }
//        // Choque entre camino 1 castillo CPU
//        else if (lblTropaPlayer1.getX() <= (lblCastilloCPU.getX() + 40)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
//        {
//            System.out.println("Choco Castillo CPU Camino 1");
//            return 2; //Retorna 2 si hubo un choque en el castillo del CPU en el camino 1
//        }
//            //Choque castillo Player en camino 2
//        if (lblTropa2CPU.getX() >= lblCastilloPlayer.getX() - 40) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
//        {
//            System.out.println("Choco Castillo Player Camino 2");
//            return 3; //Retorna 3 si hubo un choque en el castillo del Player en el camino 2
//        }
//        // Choque entre camino 2 castillo CPU
//        else if (lblTropaPlayer2.getX() <= (lblCastilloCPU.getX() + 40)) // && (lblTropaPlayer1.getX() + 188) > lblTropa1CPU.getX())
//        {
//            System.out.println("Choco Castillo CPU Camino 2");
//            return 4;  //Retorna 2 si hubo un choque en el castillo del CPU en el camino 2
//        }
//        
//        return 0;
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNRonda = new javax.swing.JLabel();
        lblNumRonda = new javax.swing.JLabel();
        lblCastilloCPU = new javax.swing.JLabel();
        lblCastilloPlayer = new javax.swing.JLabel();
        lblTropa1CPU = new javax.swing.JLabel();
        lblTropa2CPU = new javax.swing.JLabel();
        lblTropaPlayer1 = new javax.swing.JLabel();
        lblTropaPlayer2 = new javax.swing.JLabel();
        lblVidasCpu = new javax.swing.JLabel();
        lblVidasPlayer = new javax.swing.JLabel();
        lblCorazonCpu = new javax.swing.JLabel();
        lblCorazonPlayer = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNRonda.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNRonda.setText("N° Ronda");
        getContentPane().add(lblNRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 170, 30));

        lblNumRonda.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblNumRonda.setText("1");
        getContentPane().add(lblNumRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 0, 40, 40));

        lblCastilloCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Castillo-rojo-x307.png"))); // NOI18N
        getContentPane().add(lblCastilloCPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, -1, -1));

        lblCastilloPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Castillo-verde-x307.png"))); // NOI18N
        getContentPane().add(lblCastilloPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 360, -1, -1));
        getContentPane().add(lblTropa1CPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));
        getContentPane().add(lblTropa2CPU, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 560, -1, -1));
        getContentPane().add(lblTropaPlayer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 440, -1, -1));
        getContentPane().add(lblTropaPlayer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1460, 570, -1, -1));

        lblVidasCpu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblVidasCpu.setForeground(new java.awt.Color(255, 255, 255));
        lblVidasCpu.setText("10");
        getContentPane().add(lblVidasCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(206, 314, -1, -1));

        lblVidasPlayer.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblVidasPlayer.setForeground(new java.awt.Color(255, 255, 255));
        lblVidasPlayer.setText("10");
        getContentPane().add(lblVidasPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1695, 314, -1, -1));

        lblCorazonCpu.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblCorazonCpu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Corazon.png"))); // NOI18N
        lblCorazonCpu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(lblCorazonCpu, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 300, -1, -1));

        lblCorazonPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Corazon.png"))); // NOI18N
        getContentPane().add(lblCorazonPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(1674, 300, -1, -1));

        lblMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/TowerDefence.jpg"))); // NOI18N
        getContentPane().add(lblMapa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmJuego().setVisible(true);
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel lblCastilloCPU;
    public static javax.swing.JLabel lblCastilloPlayer;
    private javax.swing.JLabel lblCorazonCpu;
    private javax.swing.JLabel lblCorazonPlayer;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblNRonda;
    public static javax.swing.JLabel lblNumRonda;
    public static javax.swing.JLabel lblTropa1CPU;
    public static javax.swing.JLabel lblTropa2CPU;
    public static javax.swing.JLabel lblTropaPlayer1;
    public static javax.swing.JLabel lblTropaPlayer2;
    public static javax.swing.JLabel lblVidasCpu;
    public static javax.swing.JLabel lblVidasPlayer;
    // End of variables declaration//GEN-END:variables
}
