/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sim.tricycle.ihm;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author morgan
 * http://www.commentcamarche.net/forum/affich-2307306-java-connaitre-les-fichiers-d-un-dossier
 * + modification pour retourner dans un tableau ...
 */
public class FilesFinder {

    public FilesFinder() {
        super();
    }

    public ArrayList<String> findFiles(String directoryPath) {
        File directory = new File(directoryPath);
        File[] subfiles = null;
        ArrayList<String> filesName = new ArrayList();
        if (!directory.exists()) {
            System.out.println("Le fichier/répertoire '" + directoryPath + "' n'existe pas");
        } else if (!directory.isDirectory()) {
            System.out.println("Le chemin '" + directoryPath + "' correspond à un fichier et non à un répertoire");
        } else {
            subfiles = directory.listFiles();
            //String message = "Le répertoire '" + directoryPath + "' contient " + subfiles.length + " fichier" + (subfiles.length > 1 ? "s" : "");
            //System.out.println(message);
            for (int i = 0; i < subfiles.length; i++) {
                //System.out.println(subfiles[i].getName());
                filesName.add(subfiles[i].getName().substring(0, subfiles[i].getName().lastIndexOf(".")));
            }
        }
        return filesName;
    }
    
        public ArrayList<String> findImg(String directoryPath) {
        File directory = new File(directoryPath);
        File[] subfiles = null;
        ArrayList<String> filesName = new ArrayList();
        if (!directory.exists()) {
            System.out.println("Le fichier/répertoire '" + directoryPath + "' n'existe pas");
        } else if (!directory.isDirectory()) {
            System.out.println("Le chemin '" + directoryPath + "' correspond à un fichier et non à un répertoire");
        } else {
            subfiles = directory.listFiles();
            //String message = "Le répertoire '" + directoryPath + "' contient " + subfiles.length + " fichier" + (subfiles.length > 1 ? "s" : "");
            //System.out.println(message);
            for (int i = 0; i < subfiles.length; i++) {
                //System.out.println(subfiles[i].getName());
                filesName.add(subfiles[i].getName());
            }
        }
        return filesName;
    }
    
}
