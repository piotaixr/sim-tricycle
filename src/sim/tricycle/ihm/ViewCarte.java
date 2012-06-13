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
    private int decalageX, decalageY;    //pour plus tard essayer de centrer la carte dans le JScrollPane
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
            imgMur = ImageIO.read(new File("./src/sim/tricycle/ihm/images/mur.jpg"));
            imgVide = ImageIO.read(new File("./src/sim/tricycle/ihm/images/vide.jpg"));
            imgRobot = ImageIO.read(new File("./src/sim/tricycle/ihm/images/robot.png"));
            imgBonus = ImageIO.read(new File("./src/sim/tricycle/ihm/images/bonus.png"));
            imgBoule = ImageIO.read(new File("./src/sim/tricycle/ihm/images/boule.png"));
            imgPiece = ImageIO.read(new File("./src/sim/tricycle/ihm/images/piece.png"));

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

//        System.out.println("widht " + this.getWidth() + " nbcase : " + carte.getLargeur()
//                + " height " + this.getHeight() + " nbcase  " + carte.getHauteur());
//        System.out.println("PreferedSize :" + this.getPreferredSize());
//        System.out.println("Size :" + this.getSize());

        decalageX = 0;
        decalageY = 0;
        /*
         * Centrage de la map
         */
        if (carte.getLargeur() * tailleCase < this.getParent().getWidth()) {
            decalageX = (this.getParent().getWidth() - carte.getLargeur() * tailleCase) / 2;
        }
        if (carte.getHauteur() * tailleCase < this.getParent().getHeight()) {
            decalageY = (this.getParent().getHeight() - carte.getHauteur() * tailleCase) / 2;
        }
//        System.out.println("decX :" + this.decalageX + " decY: " + this.decalageY);
//        System.out.println("X parent :" + this.getParent().getWidth() + " Y parent: " + this.getParent().getHeight());

        for (int i = 0; i < carte.getHauteur(); i++) {
            for (int j = 0; j < carte.getLargeur(); j++) {
                paintCase(g, carte.getCase(i, j), tailleCase, false);
            }
        }
    }

    private void paintCase(Graphics2D g, Case c, int width, boolean quadri) {
        // System.out.println("Paint case " +width + "/" + c.getX() + " " + c.getY());

        int y = (c.getX() * width) + decalageY;
        int x = (c.getY() * width) + decalageX;
        
        if (quadri) {
            g.drawRect(x, y, width, width);
        }

        if (c.whoIam() == TypeCase.mur) {                             //MUR
            g.drawImage(imgMur, x, y, width, width, this);

        } else if (c.whoIam() == TypeCase.vide) {                     //VIDE
            g.drawImage(imgVide, x, y, width, width, this);

        } else if (c.whoIam() == TypeCase.piece) {                    //PIECE
            g.drawImage(imgPiece, x, y, width, width, this);

        } else if (c.whoIam() == TypeCase.bonus) {                    //BONUS
            g.drawImage(imgBonus, x, y, width, width, this);

        } else if (c.whoIam() == TypeCase.robot) {                    //ROBOT
            g.drawImage(imgRobot, x, y, width, width, this);

        } else if (c.whoIam() == TypeCase.boule) {                    //BOULE
            g.drawImage(imgBoule, x, y, width, width, this);
        } else {
            g.drawImage(imgVide, x, y, width, width, this);

        }
    }

    public void setTaille(int txZoom) {
        tailleCase = tailleCaseBase * txZoom / 100;
        this.repaint();
    }

    public void moveMap(int x, int y) {
        this.setLocation(x, y);
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
        System.out.println("POSITION dans le composant : X " + this.getMousePosition().x + " Y " + this.getMousePosition().y);
    }//GEN-LAST:event_formMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
