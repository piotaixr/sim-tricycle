package sim.tricycle.mapping;

import java.util.HashSet;

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface CarteInterface {

    /*
     * Renvoie la case correspondante aux coordonnées x et y. @param x
     * cooddonnée x. @param y coordonnée y. @return la case en question.
     */
    public Case getCase(int x, int y);

    /*
     * Actualise les cases dans un rayon particulier. @param source La carte
     * source. @param rayon le rayon d'actualisation de la carte.
     */
    public void actualiserCarte(Carte source, int rayon, Case pos);

    /*
     * casesVoisines fournit les cases voisines de pos. @param pos la case de
     * départ. @param liste Les cases déja présentes.
     */
    public void casesVoisines(Carte source,Case pos, HashSet<Case> liste);

    /*
     * Fournit la hauteur de la carte.
     */
    public int getHauteur();

    /*
     * Fournit la largeur de la carte.
     */
    public int getLargeur();
}
