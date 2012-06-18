/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sim.tricycle.mapping.nosCarte;

import sim.tricycle.mapping.AbstractCarteGlobal;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFromFile extends AbstractCarteGlobal {

    public CarteFromFile(String nomCarte) {
        CarteFichier cf = CarteFichier.fromFile(nomCarte);
        setImage(cf.getFond());
        startInit(cf.getMat());
    }
    

    
}
