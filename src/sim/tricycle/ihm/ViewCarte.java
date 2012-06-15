/*
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
import sim.tricycle.mapping.elementCase.PointDeControle;
import sim.tricycle.mapping.nosCarte.AbstractCarteGlobal;

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
    private Image imgPiece, img, imgVide, imgRobot, imgBonus, imgBoule, imgMap;
    private int px, py; //pour faire la difference lors du drag

    /**
     * Constructeur de carte implémentées
     */
    public ViewCarte(AbstractCarteGlobal cont) {
        initComponents();
        
        this.carte = cont.getCarte();
        this.tailleCase = this.tailleCaseBase;
        imgMap = cont.getImage();
        initialiserImage(cont);
    }

    /*
     * Initialise toutes les images néccéssaires.
     */
    public void initialiserImage(AbstractCarteGlobal cont) {
        imgVide = cont.getVide();
        try {
            // Initialisation des images:
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
        
        Dimension d = new Dimension(carte.getLargeur() * tailleCase, carte.getHauteur() * tailleCase);

        //this.setPreferredSize(this.getSize());
        this.setPreferredSize(d);
        
        decalageX = 0;
        decalageY = 0;

        // Centrage de la map
        if (carte.getLargeur() * tailleCase < this.getParent().getWidth()) {
            decalageX = (this.getParent().getWidth() - carte.getLargeur() * tailleCase) / 2;
        }
        if (carte.getHauteur() * tailleCase < this.getParent().getHeight()) {
            decalageY = (this.getParent().getHeight() - carte.getHauteur() * tailleCase) / 2;
        }
        
        boolean affFond = false;
        if (imgMap == null) {
            affFond = true;
        }
        //affichage de chaque case.
        for (int i = 0; i < carte.getHauteur(); i++) {
            for (int j = 0; j < carte.getLargeur(); j++) {
                paintCase(g, carte.getCase(i, j), tailleCase, false, affFond);
            }
        }
    }

    /**
     * paint une case.
     */
    private void paintCase(Graphics2D g, Case c, int width, boolean quadri, boolean aff) {
        //On recupere les coordonéees.
        int y = (c.getX() * width) + decalageY;
        int x = (c.getY() * width) + decalageX;
        
        if (quadri) {
            g.drawRect(x, y, width, width);
        }
        if (c.whoIam() == TypeCase.mur) {                             //MUR
            // SI pas de map de fond => on affiche les murs.
            if (aff) {
                try {
                    img = ImageIO.read(new File("./src/sim/tricycle/ihm/images/" + c.getId() + ".jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(img, x, y, width, width, this);
            }
        } else {                                                   //VIDE

            if (c.getId().indexOf(0) == 'A') {
                //Si case à motif 
                try {
                    // on recupere l'image corespondante à l'id.
                    img = ImageIO.read(new File("./src/sim/tricycle/ihm/images/" + c.getId() + ".jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(img, x, y, width, width, this);
            } else {
                g.drawImage(imgVide, x, y, width, width, this);
            }
        }
         if (c.hasZone()) {                                    //Pt de controle
             
             if (c.getZone().whoIam()==TypeCase.ptDeControle)
              PointDeControle pt;
             =  (PointtDeControle) c.getZone();
             
            g.setColor(Color.orange);
            g.fillOval(x, y, width, width);

        }
         
        if (c.whoIam() == TypeCase.piece) {                          //PIECE
            g.drawImage(imgPiece, x, y, width, width, this);
            
        } else if (c.whoIam() == TypeCase.bonus) {                    //BONUS
            g.drawImage(imgBonus, x, y, width, width, this);
            
        } else if (c.whoIam() == TypeCase.boule) {                    //BOULE
            g.drawImage(imgBoule, x, y, width, width, this);
        }
        // possible superposition de robot sur objet:
        if (c.robotPresent()) {                                       //ROBOT
            g.drawImage(imgRobot, x, y, width, width, this);
            
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
