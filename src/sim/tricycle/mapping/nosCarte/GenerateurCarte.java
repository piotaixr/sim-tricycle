/*
 */
package sim.tricycle.mapping.nosCarte;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class GenerateurCarte {
    
    String[][] mat;
    
    public static void main(String[] args) {
        int tX = 15;
        int tY = 15;
        GenerateurCarte gen = new GenerateurCarte();
        gen.mat = gen.creerCarte(tX, tY);
        
        gen.afficherMat(gen.mat);
    }
    
    public String[][] creerCarte(int tx, int ty) {
        String[][] matrice = new String[tx][ty];
        
        for (int i = 0; i < matrice.length; i++) {            
            for (int j = 0; j < matrice[0].length; j++) {                
                matrice[i][j] = "V";
            }
        }
        return matrice;
    }
    
    public void afficherMat(String[][] matrice) {
        System.out.println("La carte: \n String[][] mat = new String[][]{");
        
        for (int i = 0; i < matrice.length; i++) {
            System.out.print("{");
            for (int j = 0; j < matrice[0].length; j++) {
                if (j < matrice[0].length - 1) {
                    System.out.print("\"" + matrice[i][j] + "\",");
                } else {
                    System.out.print("\"" + matrice[i][j] + "\"");
                }
                
            }
            System.out.print("},\n");
        }
        System.out.println("};");
    }
}
