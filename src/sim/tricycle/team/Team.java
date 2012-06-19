package sim.tricycle.team;

import java.awt.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import sim.tricycle.mapping.AbstractCarte;
import sim.tricycle.mapping.CarteObjective;
import sim.tricycle.mapping.CarteTeam;
import sim.tricycle.mapping.Case;
import sim.tricycle.mapping.elementCase.AbstractObjet;
import sim.tricycle.mapping.elementCase.Base;
import sim.tricycle.robot.Point;
import sim.tricycle.robot.Robot;

/**
 * @author Marion Dalle
 * @author AdriA
 */
public class Team {

    private String nomTeam;
    private LinkedList<Robot> armee;
    private LinkedList<Robot> models;
    private CarteTeam map;
    private ArrayList<Ressource> ressources;
    private ArrayList<Case> collectables;
    private Color color = Color.cyan;
    private Base base = null;
    private int id = 0;

    public Team(int iden, String nomTeam, AbstractCarte carteObj, Case posBase) {
        this.nomTeam = nomTeam;
        this.map = new CarteTeam((CarteObjective) carteObj);
        this.armee = new LinkedList<Robot>();
        this.models = new LinkedList<Robot>();
        this.ressources = new ArrayList<Ressource>();
        this.base = new Base();
        this.base.setCase(posBase);
        this.base.setT(this);
        this.id = iden;
    }

    public Team(int iden, String nomTeam, CarteObjective carteObj) {
        this.nomTeam = nomTeam;
        this.id = iden;
        this.map = new CarteTeam(carteObj);
        this.armee = new LinkedList<Robot>();
        this.ressources = new ArrayList<Ressource>();
    }

    public int getId() {
        return id;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public void setMap(CarteTeam map) {
        this.map = map;
    }

    public Base getBase() {
        return base;
    }

    public void addRobot(Robot bot) {
        this.armee.add(bot);
    }

    public CarteTeam getMap() {
        return this.map;
    }

    public String getNomTeam() {
        return this.nomTeam;
    }

    public ArrayList<Ressource> getRessources() {
        return ressources;
    }

    public void setRessources(ArrayList<Ressource> ressources) {
        this.ressources = ressources;
    }

    /*
     * Au secours j'y comprend rien
     */
    public Ressource trouveRessourceParItem(AbstractObjet item) {
        return ressources.get(ressources.indexOf(new Ressource(item, 0)));
    }

    public void ajouterRessource(AbstractObjet item) {

        Ressource r = new Ressource(item, 1);

        if (this.ressources.contains(r)) {
            r = trouveRessourceParItem(item);
            r.setQuantite(r.getQuantite() + 1);
        } else {
            this.ressources.add(r);
        }
    }

    public void supprimerRessource(AbstractObjet item, int q) {
        Ressource r = new Ressource(item, 0);

        if (this.ressources.contains(r)) {
            r = trouveRessourceParItem(item);
            if (r.getQuantite() >= q) {
                r.setQuantite(r.getQuantite() - q);
            } else {
                throw new RuntimeException("quantité insuffisante");
            }
        } else {
            throw new RuntimeException("quantité insuffisante");
        }
    }

    public LinkedList<Robot> getArmee() {
        return armee;
    }

    public void setArmee(LinkedList<Robot> armee) {
        this.armee = armee;
    }

    public ArrayList<Case> getCollectables() {
        return collectables;
    }

    public void setCollectables(ArrayList<Case> collectables) {
        this.collectables = collectables;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Case getCollectableCiblable() {

        int i = 0;

        while (i < this.collectables.size() && !this.collectables.get(i).isCiblable()) {
            i++;
        }

        if (i >= this.collectables.size()) {
            return null;
        } else {
            return this.collectables.get(i);
        }
    }

    public LinkedList<Robot> getModel() {
        return models;
    }

    public void setModel(LinkedList<Robot> mod) {
        models = mod;
    }

    public void addModel(Robot rob) {
        models.add(rob);
    }

    public void removeModel() {
        models.remove();
    }
}
