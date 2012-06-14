/*
 */

package sim.tricycle.mapping.nosCarte;

import java.awt.Image;
import sim.tricycle.mapping.Carte;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class AbstractCarteGlobal implements CarteGlobalInterface{
    protected String[][] matChar;
    protected Carte carte;
    protected Image ImgFond=null;
    
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
        this.carte= new Carte( mat);
    }


}
