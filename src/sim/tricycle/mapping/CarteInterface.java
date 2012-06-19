package sim.tricycle.mapping;

import java.awt.Image;
import java.util.HashSet;
import sim.tricycle.robot.Robot;

/**
 *
 * @author Thomas nds <nds.thomas@gmail.com>
 */
public interface CarteInterface {

    /**
     * Renvoie la case correspondante aux coordonnées x et y.
     *
     * @param x cooddonnée en abscisse.
     * @param y coordonnée en ordonée.
     * @return la case en question.
     */
    public Case getCase(int x, int y);

    /**
     * casesVoisines fournit les cases voisines de pos.
     *
     * @param pos la case de départ.
     * @param liste Les cases déja présentes.
     */
    public void casesVoisines(AbstractCarte source, Case pos, HashSet<Case> liste);

    /**
     * Fournit la hauteur de la carte.
     */
    public int getHauteur();

    /**
     * Fournit la largeur de la carte.
     */
    public int getLargeur();

//    /**
//     * place un élément passé en paramètre sur une case libre de la carte
//     * choisie aléatoirement
//     *
//     * @param e l'elt
//     */
//    public void pop(PossedeCaseInterface e);
//
//    /**
//     * place un élément passé en paramètre sur une case
//     *
//     * @param e l'elt
//     * @param x cooddonnée en abscisse.
//     * @param y coordonnée en ordonée.
//     */
//    public void pop(PossedeCaseInterface e, int x, int y);
//
//    /**
//     * place un élément passé en paramètre sur une case
//     *
//     * @param e l'elt
//     * @param c la case
//     */
//    public void pop(PossedeCaseInterface e, Case c);

    /**
     * Routine d'analyse de l'état de chaque point de controle.
     */
    public void routinePt();

    /**
     * Afiichage de la carte sous forme textuelle
     */
    public void afficherCarte();

    /**
     * Démare l'initialisation de la carte.
     */
    public void startInit(String[][] mat);

    public Image getImage();

    public Image getVide();

    public void setVide(String s);

    public void setImage(String s);

    /**
     * Retourne la case devant.
     *
     * @param bot
     * @return
     */
    public Case getCaseDevant(Robot bot);

    /**
     * Avancer le robot d'une case.
     *
     * @return vrai si réussi.
     */
    public boolean avancer(Robot bot);
}
