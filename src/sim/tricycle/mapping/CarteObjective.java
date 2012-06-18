/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping;

import java.util.HashSet;
import sim.tricycle.mapping.elementCase.PointDeControle;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class CarteObjective extends AbstractCarte implements CarteInterface {

    /**
     * Création d'une carte à partir d'une matrice d'entier. @ensure la carte
     * correspond aux informations fournit. ' ': case vide. 'O': case avec une
     * boule. 'B': case avec un bonus. 'P': case avec une pièce. 'X' ou 'A':case
     * obstacle. 'T': case avec une tour. '@': case avec un point de controle.
     * '>': case avec une base.
     */
    public CarteObjective(String[][] tab) {

        this.setMat(tab);
        this.tailleX = tab.length;
        this.tailleY = tab[0].length;
        carte = new Case[this.tailleX][this.tailleY];
        initAllCases();
        PlacerPoint();
    }



}
