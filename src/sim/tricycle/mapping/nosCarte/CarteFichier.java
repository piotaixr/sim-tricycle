/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.mapping.nosCarte;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sim.tricycle.ihm.FilesFinder;
import sim.tricycle.robot.Point;

/**
 *
 * @author Rémi PIOTAIX <remi.piotaix@gmail.com>
 */
public class CarteFichier implements Serializable {

    private String[][] mat;
    private String fond;
    static final long serialVersionUID = 42L;
    public static final String basename = "./Cartes/";
    private Map<Integer,List<Point>> dispositions = new HashMap();
    
    public CarteFichier(String[][] mat, String fond) {
        this.mat = mat;
        this.fond = fond;
    }

    public String getFond() {
        return fond;
    }

    public void setFond(String fond) {
        this.fond = fond;
    }

    public String[][] getMat() {
        return mat;
    }

    public void setMat(String[][] mat) {
        this.mat = mat;
    }

    public static void createFile(String nomFichier, String[][] mat, String imageFond, Map<Integer,List<Point>> dispositions) {
        CarteFichier cf = new CarteFichier(mat, imageFond);
        ObjectOutputStream oos = null;
        try {
            File f = new File(basename + nomFichier + ".stc");
            oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(cf);
        } catch (IOException ex) {
            Logger.getLogger(CarteFichier.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(CarteFichier.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<String> getMapNames() {
         FilesFinder finder = new FilesFinder();
         //findImg renvoie le nom du fichier et son extension
         return finder.findFilesWithExtensions("./Cartes/");
    }

    public static CarteFichier fromFile(String nomFichier) {
        ObjectInputStream ois = null;
        CarteFichier cf = null;
        try {

            ois = new ObjectInputStream(new FileInputStream(nomFichier));
            cf = (CarteFichier) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrossRiver.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CrossRiver.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ois.close();
            } catch (IOException ex) {
                Logger.getLogger(CrossRiver.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cf;
    }
    
    public List<Point> getDispositionBases(int nbTeams){
        
    }
}
