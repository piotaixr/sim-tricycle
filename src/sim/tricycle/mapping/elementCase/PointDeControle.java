/*

 */
package sim.tricycle.mapping.elementCase;

import java.util.HashSet;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.TypeCase;
import sim.tricycle.mapping.mapException.CaptureParEquipeNullException;
import sim.tricycle.robot.Robot;
import sim.tricycle.team.Team;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class PointDeControle extends AbstractZone {

    private int tpsCapture = 100;
    private int tpsPopBoule = 300;
    private Team t = null;

    public PointDeControle(HashSet<Case> h) {
        this.liste = h;
    }

    public Team getTeam() {
        return t;
    }

    /**
     * Si un point est neutre
     *
     * @return 1 si neutre @ensure estNeutre() && t ==null
     */
    public boolean estNeutre() {
        return (t == null);
    }

    public int getTpsCapture() {
        return this.tpsCapture;
    }

    public int getTpspop() {
        return this.tpsPopBoule;
    }

    public void initTpsCapture() {
        this.tpsCapture = 60;
    }

    public void initTpspop() {
        this.tpsPopBoule = 100;
    }

    /**
     * Analyse la capture par une équipe
     *
     * @param equipe l'équipe offensive
     */
    public Team analyseCapture() {
        Team equipe = null;
        int nballiee = 0, nbennemis = 0;
        liste.add(pos);
        // Analyse des robots présent.
        for (Case x : liste) {
            if (x != null) {
                if (x.whoIam() == TypeCase.robot) {
                    Robot rob = (Robot) x.getObstacle();
                    equipe = rob.getTeam();
                    if (equipe == this.t) {
                        nballiee++;
                    } else {
                        nbennemis++;
                    }
                }
            }
        }
        if (nbennemis > 0 && nballiee == 0) {
            //Capture par l'ennemis!
            this.tpsCapture -= nbennemis;
            this.capture(equipe);
        } else {
            // sinon rien ne se passe. Cad si absence de robot ennemis, 
            // combat pour le point.
        }

        if (!this.estNeutre()) {
            if (this.tpsPopBoule <= 0) {
                Boule b= new Boule();
                this.getTeam().getMap().pop(b, pos.getX()-1,pos.getY());
                b.setPosition(pos);
                initTpspop();
            }
            this.tpsPopBoule -= 1;
        }
        return equipe;
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
                if (this.tpsCapture <= 0) {
                    this.initTpsCapture();
                    this.t = equipe;
                }
            } else {
                //Si déja capturé il faut qu'il redevienne déja neutre.
                if (this.tpsCapture <= 0) {
                    this.initTpsCapture();
                    this.t = null;
                }
            }
        } else {
            throw new CaptureParEquipeNullException("Capture par une équipe nul?.");
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
