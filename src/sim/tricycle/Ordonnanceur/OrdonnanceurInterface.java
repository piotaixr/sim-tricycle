/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.Ordonnanceur;

/**
 *
 * @author Morgan BIDOIS <morganbidois@gmail.com>
 */
public interface OrdonnanceurInterface {
    
    /*
     * Enlève un objet de la liste des objets gérés par l'ordonnanceur
     * param Objet ordonnancable à enlever
     */
    public void remove(OrdonnancableInterface oi);
    /*
     * Ajoute un objet de la liste des objets gérés par l'ordonnanceur
     * param Objet ordonnancable à ajouter
     */
    public void add(OrdonnancableInterface oi);
    /*
     * Permet d'avancer manuellement
     */
    public void next();
    /*
     * Lance l'ordonnanceur
     */
    public void start();
    /* 
     * Stop l'ordonnanceur
     */
    public void stop();
    /*
     * Met un timer pour l'ordonnanceur
     */
    public void setPeriod(long period);
    /*
     * Choisi un timer pour l'ordonnanceur
     */
    public long getPeriod();
    /*
     * Retourne la periode par defaut
     */
    public long getDefaultPeriod();
    
    public long getTime();
    
    public OrdonnancableInterface getActiveTask();
    
}
