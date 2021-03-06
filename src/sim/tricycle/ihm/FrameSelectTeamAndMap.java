/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.util.ArrayList;
import sim.tricycle.AbstractJeu;
import sim.tricycle.Jeu;
import sim.tricycle.mapping.nosCarte.CarteFichier;
import sim.tricycle.mapping.nosCarte.CarteFromFile;

/**
 *
 * @author morgan
 */
public class FrameSelectTeamAndMap extends javax.swing.JFrame {

    /**
     * Creates new form FrameSelectTeamAndMap
     */
    private ArrayList<String> maps = new ArrayList();
    private AbstractJeu jeu = new Jeu();
    private CarteFromFile cff = null;
    private FrameTeamMaker ftm = null;

    public FrameSelectTeamAndMap(AbstractJeu jeu) {
        initComponents();
        this.jeu = jeu;
        FilesFinder finder = new FilesFinder();
        // maps = finder.findFiles("./src/sim/tricycle/mapping/nosCarte");
        maps = CarteFichier.getMapNames();
        mappingCbxMap(maps);
    }

    private void mappingCbxMap(ArrayList<String> arrayMap) {
        for (String s : arrayMap) {
            cbxMap.addItem(s);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panHeader = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        cbxNumberTeam = new javax.swing.JComboBox();
        cbxMap = new javax.swing.JComboBox();
        lblMap = new javax.swing.JLabel();
        lblTeam = new javax.swing.JLabel();
        btnValid = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panHeader.setBackground(new java.awt.Color(85, 81, 78));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(254, 254, 254));
        lblTitle.setText("Create game");

        javax.swing.GroupLayout panHeaderLayout = new javax.swing.GroupLayout(panHeader);
        panHeader.setLayout(panHeaderLayout);
        panHeaderLayout.setHorizontalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panHeaderLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panHeaderLayout.setVerticalGroup(
            panHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbxNumberTeam.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2", "3", "4" }));

        lblMap.setText("Select the map :");

        lblTeam.setText("Select the number of teams :");

        btnValid.setText("Validate");
        btnValid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panHeader, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMap)
                    .addComponent(cbxNumberTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTeam)
                    .addComponent(cbxMap, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(btnValid, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(lblTeam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNumberTeam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblMap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxMap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnValid)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidMouseClicked
        // TODO add your handling code here:
        cff = new CarteFromFile(CarteFichier.basename + cbxMap.getSelectedItem(),Integer.parseInt(cbxNumberTeam.getSelectedItem().toString()));

        jeu.setCarte(cff);
        jeu.setTeamNumber(Integer.parseInt(cbxNumberTeam.getSelectedItem().toString()));

        if (ftm == null) {
            ftm = new FrameTeamMaker(jeu);
            ftm.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnValidMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameSelectTeamAndMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSelectTeamAndMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSelectTeamAndMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSelectTeamAndMap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                Jeu jeu = new Jeu();
                new FrameSelectTeamAndMap(jeu).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValid;
    private javax.swing.JComboBox cbxMap;
    private javax.swing.JComboBox cbxNumberTeam;
    private javax.swing.JLabel lblMap;
    private javax.swing.JLabel lblTeam;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panHeader;
    // End of variables declaration//GEN-END:variables
}
