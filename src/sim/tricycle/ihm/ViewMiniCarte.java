/*
 */
package sim.tricycle.ihm;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.mapping.Carte;
import sim.tricycle.mapping.CarteInterface;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.AbstractCarteGlobal;

/**
 *
 * @author tomtom et morganou
 */
public class ViewMiniCarte extends javax.swing.JPanel {

    private CarteInterface carte;
    private int tailleCase;
    private int tailleCaseBase = 50;
    private int tailleOpti;
    private Image imgMap = null, imgMur, imgVide;
    private int px, py, tLmini, tHmini; //pour faire la difference lors du drag
    private ViewCarte vuc;

    /**
     * Crée minicarte
     */
    public ViewMiniCarte(AbstractCarteGlobal cont, ViewCarte vc) {
        initComponents();
        this.carte = cont.getCarte();
        this.tailleCase = this.tailleCaseBase;
        vuc = vc;
        imgMap = cont.getImage();
        initialiserImage(cont);
    }

    public void initialiserImage(AbstractCarteGlobal cont) {
        // Initialisation des images:
        imgVide = cont.getVide();
    }

    @Override
    public void paint(Graphics graphic) {
        super.paint(graphic);
        Graphics2D g = (Graphics2D) graphic;

        tailleOpti = Math.min(this.getWidth() / carte.getLargeur(), this.getHeight() / carte.getHauteur());
        tailleCase = tailleOpti;

        tLmini = tailleOpti * carte.getLargeur();
        tHmini = tailleOpti * carte.getHauteur();
        //afficher image de fond.
        boolean affFond = false;
        if (imgMap == null) {
            affFond = true;
        }
        g.drawImage(imgMap, 0, 0, tLmini, tHmini, this);
        //On dessine les cases.
        for (int i = 0; i < carte.getHauteur(); i++) {
            for (int j = 0; j < carte.getLargeur(); j++) {
                paintCase(g, carte.getCase(i, j), tailleOpti, affFond);
            }
        }
    }

    private void paintCase(Graphics2D g, Case c, int width, boolean aff) {
        //On calcule les coordonées de la case.
        int y = (c.getX() * width);
        int x = (c.getY() * width);

        if (c.whoIam() == TypeCase.mur) {                             //MUR
            // SI pas de map de fond donc pas besoin de tout afficher
            // ou si obstacle redesinnable:
            if (aff || c.getId().charAt(0) == 'X') {
                try {
                    imgMur = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/" + c.getId() + ".jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(imgMur, x, y, width, width, this);
            }
        } else {                                                    //VIDE
            g.drawImage(imgVide, x, y, width, width, this);
        }
      if (c.hasZone()) {                                    //Pt de controle
            g.setColor(Color.orange);
            g.fillOval(x, y, width, width);

        }
        if (c.whoIam() == TypeCase.piece) {                          //PIECE
            g.setColor(Color.yellow);
            g.fillOval(x, y, width, width);

        } else if (c.whoIam() == TypeCase.bonus) {                    //BONUS
            g.setColor(Color.WHITE);
            g.fillOval(x, y, width, width);

        } else if (c.whoIam() == TypeCase.robot) {                    //ROBOT
            g.setColor(Color.PINK);
            g.fillRect(x, y, width, width);

        } else if (c.whoIam() == TypeCase.boule) {                    //BOULE
            g.setColor(Color.RED);
            g.fillOval(x, y, width, width);
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

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // Si clic sur la miniMap:
        px = evt.getLocationOnScreen().x - this.getX();
        py = evt.getLocationOnScreen().y - this.getY();

        //Si carte suffisament grande (plus grande que le conteneur jScroll).
        if (vuc.getHeight() > vuc.getParent().getHeight()) {

            //coeficient de différence entre la vraie carte et la mini.
            int diff = vuc.getHeight() / this.getHeight();
            //On recupère la position
            int tX = this.getMousePosition().x * diff * (-1);
            int tY = this.getMousePosition().y * diff * (-1);
            tX = tX + tLmini / 2; //On centre les nouvelles cordonnées.
            tY = tY + tHmini / 2;
            vuc.moveMap(tX, tY);  //On déplace la carte.
        }

        System.out.println("click position : " + px + " " + py);
        System.out.println("POSITION dans le composant : X " + this.getMousePosition().x + " Y " + this.getMousePosition().y);
    }//GEN-LAST:event_formMousePressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
