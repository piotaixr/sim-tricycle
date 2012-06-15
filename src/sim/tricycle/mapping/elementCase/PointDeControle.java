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

    private int tpsCapture = 10;
    private int tpsPopBoule = 30;
    private Team t = null;

    public Team estControle() {
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

    public PointDeControle(Case pos, HashSet<Case> h) {
        this.pos = pos;
        this.liste = h;
        pos.setZone(this);
    }

    public void initTpsCapture() {
        this.tpsCapture = 30;
    }

    /**
     * Analyse la capture par une équipe
     *
     * @param equipe l'équipe offensive
     */
    public Team analyseCapture() {
        Team equipe = null;
        int nballiee = 0, nbennemis = 0;

        for (Case x : liste) {
            if (x.whoIam() == TypeCase.robot) {
                Robot rob = (Robot) x.myObstacle();
                equipe=rob.getTeam();
                if (equipe == this.t) {
                    nballiee++;
                } else {
                    nbennemis++;
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
        
        if (!this.estNeutre()){
            if (this.tpsPopBoule<=0){
                this.pos.setItem(new Boule(pos));
            }
            this.tpsPopBoule-=1;
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
                    this.t = null;
                }
            } else {
                //Si déja capturé il faut qu'il redevienne déja neutre.
                if (this.tpsCapture <= 0) {
                    this.initTpsCapture();
                    this.t = equipe;
                }
            }
        }else{
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
