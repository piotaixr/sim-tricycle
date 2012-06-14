/*
 */

package sim.tricycle.mapping.nosCarte;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sim.tricycle.ihm.ViewCarte;
import sim.tricycle.mapping.Carte;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public abstract class AbstractCarteGlobal implements CarteGlobalInterface{
    protected String[][] matChar;
    protected Carte carte;
    protected Image imgFond=null;
    protected Image imgVide=null;
    
    @Override
    public Carte getCarte() {
        return carte;
    }

    @Override
    public void afficherCarte(Carte map) {
        int i, j;
        System.out.println("");
        for (i = 0; i < map.getLargeur(); i++) {
            for (j = 0; j < map.getHauteur(); j++) {
                System.out.print(map.getCase(i, j).toString());
            }
            System.out.print("\n");
        }
    }

    @Override
    public void setMat(String[][] mat) {
        matChar=mat;
    }

    @Override
    public void startInit(String[][] mat) {
        setMat(mat);
        setVide("vide");
        this.carte= new Carte( mat);
    }

    @Override
    public Image getImage() {
        return this.imgFond;
    }

    @Override
    public Image getVide() {
        return this.imgVide;
    }

    @Override
    public void setVide(String s) {
        try {
            // Initialisation des images:
            imgVide = ImageIO.read(new File("./src/sim/tricycle/ihm/images/"+ s +".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setImage(String s) {
        try {
            // Initialisation des images:
            imgFond = ImageIO.read(new File("./src/sim/tricycle/ihm/images/"+ s +".jpg"));

        } catch (IOException ex) {
            Logger.getLogger(ViewCarte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
