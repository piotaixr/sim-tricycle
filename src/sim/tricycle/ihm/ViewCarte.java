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
    private Image imgPiece, img, imgVide, imgRobot, imgBonus, imgBoule, imgMap, imgPT;
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
            imgBonus = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/bonus.png"));
            imgBoule = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/boule.png"));
            imgPiece = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/piece.png"));
            imgPT = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/A5.png"));
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
        } else {//initialisation avec des cases vide partout
            for (int i = 0; i < carte.getHauteur(); i++) {
                for (int j = 0; j < carte.getLargeur(); j++) {
                    paintInit(g, carte.getCase(i, j), tailleCase);
                }
            }
        }//dessin de la map.
        g.drawImage(imgMap, 0, 0, d.width, d.height, this);
        //affichage des autres cases.
        for (int i = 0; i < carte.getHauteur(); i++) {
            for (int j = 0; j < carte.getLargeur(); j++) {
                paintCase(g, carte.getCase(i, j), tailleCase, true, affFond);
            }
        }
    }

    /**
     * init une case.
     */
    private void paintInit(Graphics2D g, Case c, int width) {
        //On recupere les coordonéees.
        int y = (c.getX() * width) + decalageY;
        int x = (c.getY() * width) + decalageX;
        g.drawImage(imgVide, x, y, width, width, this);
    }

    /**
     * paint une case.
     */
    private void paintCase(Graphics2D g, Case c, int width, boolean quadri, boolean aff) {
        //On recupere les coordonéees.
        int y = (c.getX() * width) + decalageY;
        int x = (c.getY() * width) + decalageX;
        Color coul = null;

        if (quadri) {
            g.setColor(Color.BLACK);
            g.drawRect(x, y, width, width);
        }
        if (c.whoIam() == TypeCase.mur) {                             //MUR
            // SI pas de map de fond => on affiche les murs.
            if (aff) {
                try {
                    img = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/" + c.getId() + ".jpg"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(img, x, y, width, width, this);
            }

        } else {                                                   //VIDE
            char ch=c.getId().charAt(0);
            if (ch == 'A'||ch == 'C') {
                //Si case à motif 
                try {
                    // on recupere l'image corespondante à l'id.
                    g.drawImage(imgVide, x, y, width, width, this);
                    img = ImageIO.read(new File("./src/sim/tricycle/ihm/images/cases/" + c.getId() + ".png"));
                } catch (IOException ex) {
                    Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
                }
                g.drawImage(img, x, y, width, width, this);
            } else {
                g.drawImage(imgVide, x, y, width, width, this);
            }
        }
        if (c.hasZone()) {             //-------------------Pt de controle

            if (c.getZone().whoIam() == TypeCase.ptDeControle) {
                PointDeControle pt = (PointDeControle) c.getZone();
//System.out.print(pt.getTpspop());
                if (pt.estNeutre()) {
                    coul = Color.lightGray;// Couleur de base si neutre.
                } else {
                    coul = pt.getTeam().getColor();// Couleur de la team qui possède
                    //le point de controle.
                }

                g.setColor(Color.DARK_GRAY);//Rond de fond/
                g.fillOval(x, y, width, width);
                int coeff = width;
                if (pt.getTpsCapture() < 5) {// selon l'avancement de la capture.
                    coeff = width / 8;// la taille du cercle s'agrandit.
                } else if (pt.getTpsCapture() < 10) {
                    coeff = width / 6;
                } else if (pt.getTpsCapture() < 20) {
                    coeff = width / 4;
                } else if (pt.getTpsCapture() < 30) {
                    coeff = width / 2;
                } else if (pt.getTpsCapture() < 40) {
                    coeff = 3 * width / 4;
                } else if (pt.getTpsCapture() < 50) {
                    coeff = width;
                }
                g.setColor(coul);// on le desine de la couleur de la team et on le centre.
                g.fillOval(x + (width - coeff) / 2, y + (width - coeff) / 2, coeff, coeff);
                g.drawImage(imgPT, x, y, width, width, this);
            }
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

     //   System.out.println("click position : " + px + " " + py);
       // System.out.println("POSITION dans le composant : X " + this.getMousePosition().x + " Y " + this.getMousePosition().y);
    }//GEN-LAST:event_formMousePressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
