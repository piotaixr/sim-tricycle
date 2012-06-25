/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.AbstractJeu;
import sim.tricycle.Ordonnanceur.OrdonnanceurInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.robot.Model;
import sim.tricycle.robot.Robot;
import sim.tricycle.robot.Sens;
import sim.tricycle.team.Team;

/**
 *
 * @author morgan
 */
public class PanSelectModel extends javax.swing.JPanel {

    private Model model;
    private Team t;
    private int price = 0;
    private OrdonnanceurInterface oi = null;
    private Image imgBot = null;
    private AbstractJeu jeu;
    private MyObs obs = new MyObs();

    /**
     * Creates new form PanSelectModel
     */
    public PanSelectModel(Model mod, Team t, OrdonnanceurInterface oi, AbstractJeu jeu) {
        initComponents();
        this.model = mod;
        this.t = t;
        this.price = model.getRob().getPrix();
        this.oi = oi;
        this.jeu = jeu;
        try {
            imgBot = ImageIO.read(new File("./src/sim/tricycle/ihm/images/robots/" + model.getImg()));
        } catch (IOException ex) {
            Logger.getLogger(PanSelectAutomate.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblNameauto.setText(model.getImg());
        lblGoldValue.setText(price + "g");
    }

    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);
        Graphics2D g = (Graphics2D) graphic;

        g.drawImage(imgBot, 20, 20, 60, 60, this);
    }

//    public void mapsRepaint() {
//        for (Component c : this.getParent().getParent().getComponents()) {
//            if (c.getClass().getSimpleName() == "");
//        }
//    }
    public Observable getObs() {
        return obs;
    }

    private class MyObs extends Observable {

        public void sendMessage() {
            setChanged();
            notifyObservers();
//            System.out.println("coucou");
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

        lblNameauto = new javax.swing.JLabel();
        lblGold = new javax.swing.JLabel();
        lblGoldValue = new javax.swing.JLabel();
        btnCreateBot = new javax.swing.JButton();

        setBackground(java.awt.Color.lightGray);
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        setMaximumSize(new java.awt.Dimension(262, 113));

        lblNameauto.setText("jLabel1");

        lblGold.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblGold.setText("Gold :");

        lblGoldValue.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        lblGoldValue.setText("jLabel3");

        btnCreateBot.setText("Create");
        btnCreateBot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateBotMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblNameauto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblGold)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGoldValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCreateBot, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGold)
                    .addComponent(lblGoldValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateBot)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNameauto)
                        .addGap(7, 7, 7)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateBotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateBotMouseClicked
        // TODO add your handling code here:
        if (t.getRessources().containsKey("Piece")
            && t.getQuantityRessource("Piece") >= 1) {
            if (!jeu.getCarte().getCase(t.getBase().getPosition().getX(), t.getBase().getPosition().getY()).hasObstacle()) {//        if (!t.getBase().getPosition().hasObstacle()) {

                //On recupere le nom du modele et on enleve l'extension pour pouvoir afficher plus tard l'image dans les positions qu'on veut
                String nameBot = model.getRob().getImgBase();
                nameBot = nameBot.substring(0, nameBot.lastIndexOf("."));
                System.out.println(nameBot);

                Robot rob = new Robot(model.getRob().getAutomate(), t, nameBot);
                rob.setPosition(t.getBase().getPosition());
                rob.setDirection(Sens.SUD);
                

                Case casePop = t.getMap().getCase(t.getBase().getPosition().getX(), t.getBase().getPosition().getY());
                t.getMap().pop(rob, casePop);

                t.addRobot(rob);
                t.setQuantityRessource("Piece", (t.getQuantityRessource("Piece")-1));
                oi.add(rob);

                //t.getRessources().get(0).setQuantite(t.getRessources().get(0).getQuantite()- price); Enleve le cout du robot

                obs.sendMessage();

            } else {
                System.out.println("Y deja un truc sur la case ducon");
            }


        }
    }//GEN-LAST:event_btnCreateBotMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateBot;
    private javax.swing.JLabel lblGold;
    private javax.swing.JLabel lblGoldValue;
    private javax.swing.JLabel lblNameauto;
    // End of variables declaration//GEN-END:variables
}
