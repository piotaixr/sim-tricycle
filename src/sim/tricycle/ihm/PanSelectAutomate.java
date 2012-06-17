/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author morgan
 */
public final class PanSelectAutomate extends javax.swing.JPanel {

    private MyObs obs = new MyObs();
    private boolean valid = false;
    private ArrayList<String> bots = new ArrayList();
    private ArrayList<String> automates = new ArrayList();
    private FilesFinder finder = new FilesFinder();
    private Image imgBot;

    /**
     * Creates new form PanSelectAutomate
     */
    public PanSelectAutomate(FrameTeamMaker ftm) {
        initComponents();

        bots = finder.findFiles("./src/sim/tricycle/ihm/images/robots");
        automates = finder.findFiles("./src/sim/tricycle/mapping/nosCarte");

        mappingCbxAutoImage(bots);
        mappingCbxAutomate(automates);

//        ImageBot testim = new ImageBot();
//        this.add(testim);

    }

    public boolean isValidPanAuto() {
//        return (cbxAutoImage.getSelectedItem() != null && cbxAutomate.getSelectedItem() != null);
        return valid;
    }

    public Observable getObs() {
        return obs;
    }

    public void mappingCbxAutoImage(ArrayList<String> bot) {
        for (String s : bot) {
            cbxAutoImage.addItem(s);
        }
    }

    public void mappingCbxAutomate(ArrayList<String> auto) {
        for (String s : auto) {
            cbxAutomate.addItem(s);
        }
    }

    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);
        Graphics2D g = (Graphics2D) graphic;

        try {
            imgBot = ImageIO.read(new File("./src/sim/tricycle/ihm/images/robots/" + cbxAutoImage.getSelectedItem()));
        } catch (IOException ex) {
            Logger.getLogger(PanSelectAutomate.class.getName()).log(Level.SEVERE, null, ex);
        }

        g.drawImage(imgBot, 30, 20, 60, 60, this);
        System.out.println("TOTO");
    }

    private class MyObs extends Observable {

        public void doAction() {
            setChanged();
            notifyObservers();
//            System.out.println("coucou");
        }
    }

//    private class ImageBot extends javax.swing.JPanel {
//
//        public ImageBot() {
//            try {
//                imgBot = ImageIO.read(new File("./src/sim/tricycle/ihm/images/robots/" + cbxAutoImage.getSelectedItem()));
//            } catch (IOException ex) {
//                Logger.getLogger(PanSelectAutomate.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        @Override
//        public void paint(Graphics graphic) {
//            super.paint(graphic);
//            Graphics2D g = (Graphics2D) graphic;
//            g.drawImage(imgBot, 0, 0, this.getWidth(), this.getHeight(), this);
//            System.out.println("TOTO");
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panSelectModel = new javax.swing.JPanel();
        panImageAuto = new javax.swing.JPanel();
        cbxAutoImage = new javax.swing.JComboBox();
        cbxAutomate = new javax.swing.JComboBox();
        lblAutomate = new javax.swing.JLabel();
        btnValid = new javax.swing.JButton();

        panSelectModel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout panImageAutoLayout = new javax.swing.GroupLayout(panImageAuto);
        panImageAuto.setLayout(panImageAutoLayout);
        panImageAutoLayout.setHorizontalGroup(
            panImageAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );
        panImageAutoLayout.setVerticalGroup(
            panImageAutoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 79, Short.MAX_VALUE)
        );

        cbxAutoImage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAutoImageItemStateChanged(evt);
            }
        });

        lblAutomate.setText("Automate :");

        btnValid.setText("Ok");
        btnValid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnValidMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panSelectModelLayout = new javax.swing.GroupLayout(panSelectModel);
        panSelectModel.setLayout(panSelectModelLayout);
        panSelectModelLayout.setHorizontalGroup(
            panSelectModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelectModelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(panImageAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cbxAutoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lblAutomate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxAutomate, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(btnValid)
                .addGap(23, 23, 23))
        );
        panSelectModelLayout.setVerticalGroup(
            panSelectModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelectModelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panSelectModelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxAutoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxAutomate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAutomate)
                    .addComponent(btnValid))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSelectModelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panImageAuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panSelectModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panSelectModel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnValidMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnValidMouseClicked
        // TODO add your handling code here:
        valid = true;
        obs.doAction();
        cbxAutoImage.setEnabled(false);
        cbxAutomate.setEnabled(false);
//        System.out.println("click");
    }//GEN-LAST:event_btnValidMouseClicked

    private void cbxAutoImageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAutoImageItemStateChanged
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_cbxAutoImageItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnValid;
    private javax.swing.JComboBox cbxAutoImage;
    private javax.swing.JComboBox cbxAutomate;
    private javax.swing.JLabel lblAutomate;
    private javax.swing.JPanel panImageAuto;
    private javax.swing.JPanel panSelectModel;
    // End of variables declaration//GEN-END:variables
}
