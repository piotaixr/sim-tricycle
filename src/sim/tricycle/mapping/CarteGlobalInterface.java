/*
 */
package sim.tricycle.mapping;

import java.awt.Image;
import sim.tricycle.mapping.Carte;

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface CarteGlobalInterface {

    public Carte getCarte();

    public void afficherCarte();

    public void setMat(String[][] mat);

    public void startInit(String[][] mat);

    public Image getImage();

    public Image getVide();

    public void setVide(String s);

    public void setImage(String s);
}
