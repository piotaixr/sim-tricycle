/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.mapping.CarteInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;

/**
 *
 * @author nell
 */
public class ViewCarte extends javax.swing.JPanel {

    private CarteInterface carte;
    private int tailleCase;
    private int tailleCaseBase = 50;
    //private int decalageX;    //pour plus tard essayer de centrer la carte dans le JScrollPane
    //private int decalageY;
    private int tailleOpti;
    private Image imgPiece, imgMur, imgVide, imgRobot, imgBonus, imgBoule;
    private int px, py; //pour faire la difference lors du drag

    /**
     * Creates new form ViewCarte
     */
    public ViewCarte(CarteInterface carte) {
        initComponents();
        this.carte = carte;
        this.tailleCase = this.tailleCaseBase;
        //this.setBackground(Color.red);

//        tailleOpti = Math.max((int)this.getParent().getWidth()/carte.getLargeur(),(int)this.getParent().getHeight()/carte.getHauteur());
//        tailleCase = tailleOpti;
        //this.setPreferredSize(this.getSize());

        try {

            // Initialisation des images:
            imgMur = ImageIO.read(new File("./src/sim/tricycle/ihm/mur.jpg"));
            imgVide = ImageIO.read(new File("./src/sim/tricycle/ihm/vide.jpg"));
            imgRobot = ImageIO.read(new File("./src/sim/tricycle/ihm/robot.jpg"));
            imgBonus = ImageIO.read(new File("./src/sim/tricycle/ihm/bonus.jpg"));
            imgBoule = ImageIO.read(new File("./src/sim/tricycle/ihm/boule.jpg"));
            imgPiece = ImageIO.read(new File("./src/sim/tricycle/ihm/piece.jpg"));

        } catch (IOException ex) {
            Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);
        Graphics2D g = (Graphics2D) graphic;

        // tailleOpti = Math.min(this.getWidth()/carte.getLargeur(),this.getHeight()/carte.getHauteur());
        //tailleCase = tailleOpti;
        Dimension d = new Dimension(carte.getLargeur() * tailleCase, carte.getHauteur() * tailleCase);

        //this.setPreferredSize(this.getSize());
        this.setPreferredSize(d);

//        int maxWidth = this.getWidth() / carte.getLargeur();
//        int maxHeight = this.getHeight() / carte.getHauteur();
//        int maxSize = Math.min(maxHeight, maxWidth);

        System.out.println("widht " + this.getWidth() + " nbcase : " + carte.getLargeur()
                + " height " + this.getHeight() + " nbcase  " + carte.getHauteur());
        System.out.println("PreferedSize :" + this.getPreferredSize());
        System.out.println("Size :" + this.getSize());

        //maxSize = 50;

        for (int i = 0; i < carte.getHauteur(); i++) {
            for (int j = 0; j < carte.getLargeur(); j++) {
                //paintCase(g, carte.getCase(i, j), maxSize);
                paintCase(g, carte.getCase(i, j), tailleCase);
            }
        }
    }

    private void paintCase(Graphics2D g, Case c, int width) {
        // System.out.println("Paint case " +width + "/" + c.getX() + " " + c.getY());

        int y = c.getX() * width;
        int x = c.getY() * width;

        if (c.whoIam() == TypeCase.mur) {                             //MUR
            g.drawImage(imgMur, x, y, width, width, this);
            g.drawRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.vide) {                     //VIDE
            g.drawImage(imgVide, x, y, width, width, this);
            g.drawRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.piece) {                    //PIECE
            g.drawImage(imgPiece, x, y, width, width, this);
            g.drawRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.bonus) {                    //BONUS
            g.drawImage(imgBonus, x, y, width, width, this);
            g.drawRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.robot) {                    //ROBOT
            g.drawImage(imgRobot, x, y, width, width, this);
            g.drawRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.boule) {                    //BOULE
            g.drawImage(imgBoule, x, y, width, width, this);
            g.drawRect(x, y, width, width);
        } else {
            g.drawImage(imgVide, x, y, width, width, this);
            g.drawRect(x, y, width, width);
        }
    }

    public void setTaille(int txZoom) {
        tailleCase = tailleCaseBase * txZoom / 100;
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        System.out.println("dragged");
        //final Component t = evt.getComponent();
        //evt.translatePoint(getLocation().x + t.getLocation().x - px, getLocation().y + t.getLocation().y - py);
        this.setLocation(evt.getLocationOnScreen().x - px, evt.getLocationOnScreen().y - py);
        px = evt.getLocationOnScreen().x - this.getX();
        py = evt.getLocationOnScreen().y - this.getY();
        this.getParent().validate(); //A mettre en commentaire si on veut bouger la map comme on veut mais avec les pb de dessin...
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        //evt.translatePoint(evt.getComponent().getLocation().x, evt.getComponent().getLocation().y);
        px = evt.getLocationOnScreen().x - this.getX();
        py = evt.getLocationOnScreen().y - this.getY();

        System.out.println("click position : " + px + " " + py);
    }//GEN-LAST:event_formMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
