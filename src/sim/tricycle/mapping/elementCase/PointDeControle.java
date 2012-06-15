/*

 */
package sim.tricycle.mapping.elementCase;

import java.awt.Robot;
import java.util.HashSet;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class PointDeControle extends AbstractObjet {

    private int tpsCapture = 10;
    private int tpsPopBoule = 30;
    private Team t = null;
    private HashSet<Case> liste;

    public Team estControle() {
        return t;
    }
/**
 * Si un point est neutre
 * @return 1 si neutre
 * @ensure estNeutre() && t ==null
 */
    public boolean estNeutre() {
        return (t == null);
    }

    public PointDeControle(Case pos, HashSet<Case> h) {
        this.pos = pos;
        this.liste = h;
        pos.setItem(this);
    }

    /**
     * Tentative de capture de ce point par une équipe.
     *
     * @param equipe l'équipe.
     */
    public void capture(Team equipe) {
        if (equipe != null) {
            if (this.estNeutre()) {
                // Si neutre il peut être capturé par une équipe.
                this.analyseCapture(equipe);
                if (this.tpsCapture <= 0) {
                    this.initTpsCapture();
                    this.t = null;
                }
            } else {
                //Si déja capturé il faut qu'il redevienne déja neutre.
                this.analyseCapture(equipe);
                if (this.tpsCapture <= 0) {
                    this.initTpsCapture();
                    this.t = equipe;
                }
            }
        }
    }

    public void initTpsCapture() {
        this.tpsCapture = 30;
    }
/**
 * Analyse la capture par une équipe
 * @param equipe l'équipe offensive
 */
    public void analyseCapture(Team equipe) {
        int nballiee = 0, nbennemis = 0;
        for (Case x : liste) {
            if (x.whoIam() == TypeCase.robot) {
//                Robot rob = (Robot) x.myObstacle();
//                if (rob.getTeam == t) {
//                    nballiee++;
//                } else {
//                    nbennemis++;
//                }
            }
        }
        if (nbennemis > 0) {
            //Si combat pour le pt, rien ne se passe.
        } else {
            // sinon capture selon le nombre de robot présent.
            this.tpsCapture-=nballiee;
        }
    }

    @Override
    public TypeCase whoIam() {
        return (TypeCase.ptDeControle);
    }

    @Override
    public String toString() {
        return " @ ";
    }
}
