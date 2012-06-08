package sim.tricycle.mapping;

import java.util.HashSet;
import java.util.Set;

/*
 */
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

    public HashSet<Case> casesVoisines(Case pos, HashSet<Case> liste);

    public int getHauteur();

    public int getLargeur();
}
