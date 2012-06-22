package sim.tricycle.team;

import java.awt.Color;
import java.util.*;
import sim.tricycle.mapping.*;
import sim.tricycle.mapping.elementCase.Base;
import sim.tricycle.robot.Model;
import sim.tricycle.robot.Robot;

/**
 * @author Marion Dalle
 * @author AdriA
 */
public class Team {

    private String nomTeam;
    private LinkedList<Robot> armee;
    private LinkedList<Model> models;
    private CarteTeam map;
    private HashMap<String, Integer> ressources;
    private ArrayList<Case> collectables;
    private Color color = Color.cyan;
    private Base base = null;
    private int id = 1;
    protected List<Case> casesObscures;

    public Team(int iden, String nomTeam, AbstractCarte carteObj, Case posBase) {
        this.nomTeam = nomTeam;
        this.map = new CarteTeam((CarteObjective) carteObj);
        this.armee = new LinkedList<Robot>();
        this.models = new LinkedList<Model>();
        this.ressources = new HashMap();
        this.base = new Base();
        this.base.setPosition(posBase);
        this.base.setT(this);
        this.id = iden;
        switch (this.id) {
            case 0:
                this.color = Color.red;
                break;
            case 1:
                this.color = Color.blue;
                break;
            case 2:
                this.color = Color.yellow;
                break;
            default:
                this.color = Color.BLACK;
                break;
        }

    }

    public Team(int iden, String nomTeam, CarteObjective carteObj) {
        this.nomTeam = nomTeam;
        this.id = iden;
        this.map = new CarteTeam(carteObj);
        this.armee = new LinkedList<Robot>();
        this.models = new LinkedList<Model>();
        this.ressources = new HashMap();
        switch (this.id) {
            case 0:
                this.color = Color.red;
                break;
            case 1:
                this.color = Color.blue;
                break;
            case 2:
                this.color = Color.yellow;
                break;
            default:
                this.color = Color.BLACK;
                break;
        }
    }

    private void construireListeCasesObscures() {
        casesObscures = new ArrayList<Case>(map.getHauteur() * map.getLargeur());

        for (int x = 0; x < map.getLargeur(); x++) {
            for (int y = 0; y < map.getHauteur(); y++) {
                casesObscures.add(map.getCase(x, y));
            }
        }
        Collections.sort(casesObscures, new CaseDistanceManhattanComparator(base));
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

    public HashMap<String, Integer> getRessources() {
        return ressources;
    }

    public void setRessources(HashMap<String, Integer> res) {
        this.ressources = res;
    }

    public Integer getQuantityRessource(String res) {
        return this.ressources.get(res);
    }

    public void addRessource(String res, Integer qty) {
        this.ressources.put(res, qty);
    }

    public void addQtyRes(String res, Integer qty) {
        if (!ressources.containsKey(res)) {
            addRessource(res, qty);
        } else {
            this.ressources.put(res, this.ressources.get(res) + qty);
        }
    }

    public boolean consumeRes(String res, Integer qty) {
        if (getQuantityRessource(res) > qty) {
            addQtyRes(res, -qty);
            return true;
        } else {
            return false;
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

    public LinkedList<Model> getModel() {
        return models;
    }

    public void setModel(LinkedList<Model> mod) {
        models = mod;
    }

    public void addModel(Robot rob, String img) {
        models.add(new Model(rob, img));
    }

    public void addModel(Robot rob) {
        models.add(new Model(rob));
    }

    public void removeModel() {
        models.remove();
    }

    public List<Case> getCasesObscures() {
        return casesObscures;
    }
}
