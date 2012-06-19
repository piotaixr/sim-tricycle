package sim.tricycle.robot;

import java.util.HashMap;
import java.util.Map;
import sim.tricycle.utils.tag.Tag;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class Automate {

    private Map<String, Etat> etats = new HashMap();
    private Map<String, Tag> tags = new HashMap();

    public void addEtat(Etat etat) {
        if (!hasEtat(etat.getId())) {
            etats.put(etat.getId(), etat);
        }
    }

    public boolean hasEtat(String id) {
        return etats.containsKey(id);
    }

    public Etat getEtat(String id) {
        return etats.get(id);
    }

    public Tag getTag(String nomTag) {
        return tags.get(nomTag);
    }

    public void addTag(Tag t) {
        if (!tags.containsKey(t.getNom())) {
            tags.put(t.getNom(), t);
        } else {
            throw new RuntimeException("Les noms de tag doivent etre uniques. Doublon: " + t.getNom());
        }
    }
}
