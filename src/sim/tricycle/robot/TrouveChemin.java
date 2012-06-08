/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.robot;

import java.util.ArrayList;

/**
 *
 * @author Adri
 */
public class TrouveChemin extends $Action{
    
    Point pDest;
    ArrayList<Noeud> chemin;
            
    public TrouveChemin(Point pDest){
        this.pDest=pDest;
        this.chemin=new ArrayList<Noeud>();
    }
    
    public void Executer($Robot bot){
        
       
    }
    
    private void insereEnOrdre(Noeud n,ArrayList<Noeud> listeNoeuds){
        
      //  listeNoeuds
        
    }
    
    private void PlusCourtChemin(Point pDep){
        
        ArrayList<Noeud> listeOuverte;
        ArrayList<Noeud> listeFermee;

        
        
        
    }
    
}
