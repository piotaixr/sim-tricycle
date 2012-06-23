/*
 */
package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class GenerateurCarte {

    String[][] mat;

    public static void main(String[] args) {
        int tX = 20;
        int tY = 20;
        GenerateurCarte gen = new GenerateurCarte();
        gen.mat = gen.creerCarte(tX, tY);
//------------------------------------------------------------------------
//        for (int i = 0; i < tX; i++) {
//            for (int j = 19; j < 22; j++) {
//                gen.set("X", j, i);
//            }
//        }
        gen.setPt(9,9);
//------------------------------------------------------------------------
        gen.afficherMat(gen.mat);


    }

    public void set(String s, int tx, int ty) {
        mat[tx][ty] = s;
    }

    /**
     * Pose une zone de controle. @require une zone 3x3 est disponible autour
     * des coordonées!
     *
     * @param tx
     * @param ty
     */
    public void setPt(int tx, int ty) {
        mat[tx][ty] = "@";
        mat[tx - 1][ty - 1] = "@1";
        mat[tx][ty - 1] = "@2";
        mat[tx + 1][ty - 1] = "@3";
        mat[tx - 1][ty] = "@4";
        mat[tx][ty - 1] = "@5";
        mat[tx][ty + 1] = "@6";
        mat[tx + 1][ty - 1] = "@7";
        mat[tx + 1][ty] = "@8";
        mat[tx + 1][ty + 1] = "@9";
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
