package barberosdormilones;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class interfaz extends javax.swing.JFrame {

    private static int clientesEspera = 0;              // cantidad de sillas en espera ocupadas
    private Crear c = new Crear();                      // Instancia del hilo para crear clientes
    public boolean[] arrayBarberos = new boolean[1];    // Array para verificar los barberos disponibles
    public boolean[] arrayEspera = new boolean[20];      // Array para verificar las sillas disponibles
    public DefaultListModel modelo = new DefaultListModel();

    public interfaz() {
        this.setResizable(false);
        initComponents();
        this.setLocationRelativeTo(null);
        c.start();
        jLabelEspera1.setVisible(false);
        jLabelEspera2.setVisible(false);
        jLabelEspera3.setVisible(false);
        jLabelEspera4.setVisible(false);
        jLabelEspera5.setVisible(false);
        jLabelEspera6.setVisible(false);
        jLabelEspera7.setVisible(false);
        jLabelEspera8.setVisible(false);
        jLabelEspera9.setVisible(false);
        jLabelEspera10.setVisible(false);
        jLabelEspera11.setVisible(false);
        jLabelEspera12.setVisible(false);
        jLabelEspera13.setVisible(false);
        jLabelEspera14.setVisible(false);
        jLabelEspera15.setVisible(false);
        jLabelEspera16.setVisible(false);
        jLabelEspera17.setVisible(false);
        jLabelEspera18.setVisible(false);
        jLabelEspera19.setVisible(false);
        jLabelEspera20.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelBarberoA = new javax.swing.JLabel();
        jLabelBarberoS = new javax.swing.JLabel();
        jLabelEspera1 = new javax.swing.JLabel();
        jLabelEspera2 = new javax.swing.JLabel();
        jLabelEspera3 = new javax.swing.JLabel();
        jLabelEspera4 = new javax.swing.JLabel();
        jButtonAgregarProceso = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabeltotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelestado1 = new javax.swing.JLabel();
        jLabeLacum1 = new javax.swing.JLabel();
        jLabelEspera5 = new javax.swing.JLabel();
        jLabelEspera6 = new javax.swing.JLabel();
        jLabelEspera7 = new javax.swing.JLabel();
        jLabelEspera8 = new javax.swing.JLabel();
        jLabelEspera9 = new javax.swing.JLabel();
        jLabelEspera10 = new javax.swing.JLabel();
        jLabelEspera11 = new javax.swing.JLabel();
        jLabelEspera12 = new javax.swing.JLabel();
        jLabelEspera13 = new javax.swing.JLabel();
        jLabelEspera14 = new javax.swing.JLabel();
        jLabelEspera15 = new javax.swing.JLabel();
        jLabelEspera16 = new javax.swing.JLabel();
        jLabelEspera17 = new javax.swing.JLabel();
        jLabelEspera18 = new javax.swing.JLabel();
        jLabelEspera19 = new javax.swing.JLabel();
        jLabelEspera20 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBarberoA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/barber_1.png"))); // NOI18N
        jPanel1.add(jLabelBarberoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 70, -1));

        jLabelBarberoS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/durmiendo.png"))); // NOI18N
        jPanel1.add(jLabelBarberoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, -1, -1));

        jLabelEspera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 50, 70));

        jLabelEspera2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 50, 70));

        jLabelEspera3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 50, -1));

        jLabelEspera4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 50, -1));

        jButtonAgregarProceso.setBackground(new java.awt.Color(153, 255, 102));
        jButtonAgregarProceso.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonAgregarProceso.setText("AÑADIR CLIENTE");
        jButtonAgregarProceso.setBorderPainted(false);
        jButtonAgregarProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProcesoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarProceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 140, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel3.setText("GRUPO 8");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 120, 30));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("ESTADO:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 60, -1));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabeltotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabeltotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabeltotal);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 80, 30));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("CLIENTES ATENDIDOS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 140, -1));

        jLabelestado1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(jLabelestado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 100, 30));

        jLabeLacum1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabeLacum1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabeLacum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 70, 20));

        jLabelEspera5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 50, -1));

        jLabelEspera6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 50, -1));

        jLabelEspera7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 50, -1));

        jLabelEspera8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 50, -1));

        jLabelEspera9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera9, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 50, -1));

        jLabelEspera10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 50, -1));

        jLabelEspera11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 50, -1));

        jLabelEspera12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 50, -1));

        jLabelEspera13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 50, -1));

        jLabelEspera14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera14, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 50, -1));

        jLabelEspera15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera15, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 50, -1));

        jLabelEspera16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, 50, -1));

        jLabelEspera17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera17, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 50, -1));

        jLabelEspera18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 50, -1));

        jLabelEspera19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera19, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 50, -1));

        jLabelEspera20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imágenes/client.png"))); // NOI18N
        jPanel1.add(jLabelEspera20, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 50, -1));

        jTextField1.setText("10");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 30, 30));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("VELOCIDAD ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-90, 0, 680, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProcesoActionPerformed
        // TODO add your handling code here:
        c.nuevoProceso();
    }//GEN-LAST:event_jButtonAgregarProcesoActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public int disminuir(int semaforo) {
        semaforo--;
        return semaforo;
    }

    //Crea un proceso(Cliente)
    private class Crear extends Thread {

        public void run() {
            while (true) {
                // Inicio semáforo
                if (!jLabelestado1.getText().equals("Cobrando")) {
                    jLabelestado1.setForeground(new Color(60, 63, 65));
                }
                for (int x = 0; x < arrayBarberos.length; x++) {
                    if (!arrayBarberos[x]) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dormir(x + 1);
                    } else {
                        activar(x + 1);
                    }
                }

                for (int x = 0; x < arrayEspera.length; x++) {
                    if (!arrayEspera[x]) {
                        desocuparSillaEspera(x + 1);
                        if (!modelo.isEmpty()) {
                            ocuparSilla(indexSillaVacia() + 1);
                            modelo.remove(0);
                            arrayEspera[x] = true;
                        }

                    }
                }
            }
        }

        private void ocuparSilla(int silla) {
            switch (silla) {
                case 1:
                    jLabelEspera1.setVisible(true);
                    break;
                case 2:
                    jLabelEspera2.setVisible(true);
                    break;
                case 3:
                    jLabelEspera3.setVisible(true);
                    break;
                case 4:
                    jLabelEspera4.setVisible(true);
                    break;
                case 5:
                    jLabelEspera5.setVisible(true);
                    break;
                case 6:
                    jLabelEspera6.setVisible(true);
                    break;
                case 7:
                    jLabelEspera7.setVisible(true);
                    break;
                case 8:
                    jLabelEspera8.setVisible(true);
                    break;
                case 9:
                    jLabelEspera9.setVisible(true);
                    break;
                case 10:
                    jLabelEspera10.setVisible(true);
                    break;
                case 11:
                    jLabelEspera11.setVisible(true);
                    break;
                case 12:
                    jLabelEspera12.setVisible(true);
                    break;
                case 13:
                    jLabelEspera13.setVisible(true);
                    break;
                case 14:
                    jLabelEspera14.setVisible(true);
                    break;
                case 15:
                    jLabelEspera15.setVisible(true);
                    break;
                case 16:
                    jLabelEspera16.setVisible(true);
                    break;
                case 17:
                    jLabelEspera17.setVisible(true);
                    break;
                case 18:
                    jLabelEspera18.setVisible(true);
                    break;
                case 19:
                    jLabelEspera19.setVisible(true);
                    break;
                case 20:
                    jLabelEspera20.setVisible(true);
                    break;

            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void nuevoProceso() {
            int contador = -1;
            boolean bandera = false;
            for (int x = 0; x < arrayBarberos.length; x++) {
                if (!arrayBarberos[x]) {
                    arrayBarberos[x] = true;
                    contador = x + 1;
                    bandera = true;
                    break;
                }
            }
            if (bandera) {
                despertar(contador);
            } else {
                //Si todos los barberos están ocupados, examina las sillas
                for (int x = 0; x < arrayEspera.length; x++) {
                    if (!arrayEspera[x]) {
                        arrayEspera[x] = true;
                        contador = x + 1;
                        bandera = true;
                        break;
                    }
                }
                if (bandera) {
                    // Asignar silla
                    ocuparSilla(contador);
                }
            }
        }
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
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz().setVisible(true);
            }
        });
    }

    public class atenderCliente extends Thread {

        private int contador = -1;

        public void run() {
            String velocidad = jTextField1.getText();

            try {
                Thread.sleep(Integer.parseInt(velocidad) * 100);
            } catch (InterruptedException ex) {
                Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                clienteSatisfecho();
            } catch (InterruptedException ex) {
                Logger.getLogger(interfaz.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        private void clienteSatisfecho() throws InterruptedException {
            arrayBarberos[contador - 1] = false;

            if (contador == 1) {
                actualizarcobro(1);

            }
            verificarEspera();
        }

        private void verificarEspera() {
            if (arrayEspera[0] == true) {
                if (arrayEspera[1] == true) {
                    if (arrayEspera[2] == true) {
                        if (arrayEspera[3] == true) {
                            if (arrayEspera[4] == true) {
                                if (arrayEspera[5] == true) {
                                    if (arrayEspera[6] == true) {
                                        if (arrayEspera[7] == true) {
                                            if (arrayEspera[8] == true) {
                                                if (arrayEspera[9] == true) {
                                                    if (arrayEspera[10] == true) {
                                                        if (arrayEspera[11] == true) {
                                                            if (arrayEspera[12] == true) {
                                                                if (arrayEspera[13] == true) {
                                                                    if (arrayEspera[14] == true) {
                                                                        if (arrayEspera[15] == true) {
                                                                            if (arrayEspera[16] == true) {
                                                                                if (arrayEspera[17] == true) {
                                                                                    if (arrayEspera[18] == true) {
                                                                                        if (arrayEspera[19] == true) {
                                                                                            arrayEspera[19] = false;
                                                                                            desocuparSillaEspera(20);
                                                                                        } else {
                                                                                            arrayEspera[18] = false;
                                                                                            desocuparSillaEspera(19);
                                                                                        }
                                                                                    } else {
                                                                                        arrayEspera[17] = false;
                                                                                        desocuparSillaEspera(18);
                                                                                    }
                                                                                } else {
                                                                                    arrayEspera[16] = false;
                                                                                    desocuparSillaEspera(17);
                                                                                }
                                                                            } else {
                                                                                arrayEspera[15] = false;
                                                                                desocuparSillaEspera(16);
                                                                            }
                                                                        } else {
                                                                            arrayEspera[14] = false;
                                                                            desocuparSillaEspera(15);
                                                                        }
                                                                    } else {
                                                                        arrayEspera[13] = false;
                                                                        desocuparSillaEspera(14);
                                                                    }
                                                                } else {
                                                                    arrayEspera[12] = false;
                                                                    desocuparSillaEspera(13);
                                                                }
                                                            } else {
                                                                arrayEspera[11] = false;
                                                                desocuparSillaEspera(12);
                                                            }
                                                        } else {
                                                            arrayEspera[10] = false;
                                                            desocuparSillaEspera(11);
                                                        }
                                                    } else {
                                                        arrayEspera[9] = false;
                                                        desocuparSillaEspera(10);
                                                    }
                                                } else {
                                                    arrayEspera[8] = false;
                                                    desocuparSillaEspera(9);
                                                }
                                            } else {
                                                arrayEspera[7] = false;
                                                desocuparSillaEspera(8);
                                            }
                                        } else {
                                            arrayEspera[6] = false;
                                            desocuparSillaEspera(7);
                                        }
                                    } else {
                                        arrayEspera[5] = false;
                                        desocuparSillaEspera(6);
                                    }
                                } else {
                                    arrayEspera[4] = false;
                                    desocuparSillaEspera(5);
                                }
                            } else {
                                arrayEspera[3] = false;
                                desocuparSillaEspera(4);
                            }

                        } else {
                            arrayEspera[2] = false;
                            desocuparSillaEspera(3);
                        }
                    } else {
                        arrayEspera[1] = false;
                        desocuparSillaEspera(2);
                    }
                } else {
                    arrayEspera[0] = false;
                    desocuparSillaEspera(1);
                }
                arrayBarberos[contador - 1] = true;
                despertar(contador);
            }
        }
    }

    public int indexSillaVacia() {
        if (!jLabelEspera1.isVisible()) {
            return 0;
        }
        if (!jLabelEspera2.isVisible()) {
            return 1;
        }
        if (!jLabelEspera3.isVisible()) {
            return 2;
        }
        if (!jLabelEspera4.isVisible()) {
            return 3;
        }
        if (!jLabelEspera5.isVisible()) {
            return 4;
        }
        if (!jLabelEspera6.isVisible()) {
            return 5;
        }
        if (!jLabelEspera7.isVisible()) {
            return 6;
        }
        if (!jLabelEspera8.isVisible()) {
            return 7;
        }
        if (!jLabelEspera9.isVisible()) {
            return 8;
        }
        if (!jLabelEspera10.isVisible()) {
            return 9;
        }
        if (!jLabelEspera11.isVisible()) {
            return 10;
        }
        if (!jLabelEspera12.isVisible()) {
            return 11;
        }
        if (!jLabelEspera13.isVisible()) {
            return 12;
        }
        if (!jLabelEspera14.isVisible()) {
            return 13;
        }
        if (!jLabelEspera15.isVisible()) {
            return 14;
        }
        if (!jLabelEspera16.isVisible()) {
            return 15;
        }
        if (!jLabelEspera17.isVisible()) {
            return 16;
        }
        if (!jLabelEspera18.isVisible()) {
            return 17;
        }
        if (!jLabelEspera19.isVisible()) {
            return 18;
        }
        if (!jLabelEspera20.isVisible()) {
            return 19;
        }
        if (!jLabelEspera20.isVisible()) {
            return 21;
        }

        return -1;
    }

    public void desocuparSillaEspera(int silla) {
        switch (silla) {
            case 1:
                jLabelEspera1.setVisible(false);
                break;
            case 2:
                jLabelEspera2.setVisible(false);
                break;
            case 3:
                jLabelEspera3.setVisible(false);
                break;
            case 4:
                jLabelEspera4.setVisible(false);
                break;
            case 5:
                jLabelEspera5.setVisible(false);
                break;
            case 6:
                jLabelEspera6.setVisible(false);
                break;
            case 7:
                jLabelEspera7.setVisible(false);
                break;
            case 8:
                jLabelEspera8.setVisible(false);
                break;
            case 9:
                jLabelEspera9.setVisible(false);
                break;
            case 10:
                jLabelEspera10.setVisible(false);
                break;
            case 11:
                jLabelEspera11.setVisible(false);
                break;
            case 12:
                jLabelEspera12.setVisible(false);
                break;
            case 13:
                jLabelEspera13.setVisible(false);
                break;
            case 14:
                jLabelEspera14.setVisible(false);
                break;
            case 15:
                jLabelEspera15.setVisible(false);
                break;
            case 16:
                jLabelEspera16.setVisible(false);
                break;
            case 17:
                jLabelEspera17.setVisible(false);
                break;
            case 18:
                jLabelEspera18.setVisible(false);
                break;
            case 19:
                jLabelEspera19.setVisible(false);
                break;
            case 20:
                jLabelEspera20.setVisible(false);
                break;
            default:
                break;
        }
    }

    int b1 = 1;   //monto acumulado para barbero 1,2,3
    int total = 0;        // monto acumulado total

    public void actualizarcobro(int silla1) {
        if (silla1 == 1) {
            jLabeLacum1.setText(String.valueOf(b1));
            b1 += silla1;
            total += silla1;
            jLabeltotal.setText(String.valueOf(total));
        }
    }

    public void actualizarcobro() {
        int preciocorte = 1;
        int b1 = 0;    //monto acumulado para barbero 1,2,3
        int total = 0;        // monto acumulado total
        jLabeltotal.setText(String.valueOf(total));
        jLabeLacum1.setText(String.valueOf(b1));
    }

    public void activar(int barbero) {
        switch (barbero) {
            case 1: {
                jLabelBarberoA.setVisible(true);
                jLabelestado1.setText("Atendiendo");
                break;
            }
        }
    }

    public int despertar(int barbero) {
        switch (barbero) {
            case 1: {
                jLabelBarberoA.setVisible(true);
                atenderCliente atender = new atenderCliente();
                atender.contador = barbero;
                atender.start();
                break;
            }
        }
        return 1;
    }

    public int dormir(int barbero) {
        switch (barbero) {
            case 1:
                jLabelBarberoA.setVisible(false);
                jLabelestado1.setText("Durmiendo");
                break;
        }
        return 1;
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProceso;
    private javax.swing.JLabel jLabeLacum1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelBarberoA;
    private javax.swing.JLabel jLabelBarberoS;
    private javax.swing.JLabel jLabelEspera1;
    private javax.swing.JLabel jLabelEspera10;
    private javax.swing.JLabel jLabelEspera11;
    private javax.swing.JLabel jLabelEspera12;
    private javax.swing.JLabel jLabelEspera13;
    private javax.swing.JLabel jLabelEspera14;
    private javax.swing.JLabel jLabelEspera15;
    private javax.swing.JLabel jLabelEspera16;
    private javax.swing.JLabel jLabelEspera17;
    private javax.swing.JLabel jLabelEspera18;
    private javax.swing.JLabel jLabelEspera19;
    private javax.swing.JLabel jLabelEspera2;
    private javax.swing.JLabel jLabelEspera20;
    private javax.swing.JLabel jLabelEspera3;
    private javax.swing.JLabel jLabelEspera4;
    private javax.swing.JLabel jLabelEspera5;
    private javax.swing.JLabel jLabelEspera6;
    private javax.swing.JLabel jLabelEspera7;
    private javax.swing.JLabel jLabelEspera8;
    private javax.swing.JLabel jLabelEspera9;
    private javax.swing.JLabel jLabelestado1;
    private javax.swing.JLabel jLabeltotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
