package sim.tricycle.mapping;

/**
 *
 * @author Thomas Nds nds.thomas@gmail.com
 */
public class TestMap {

    private Carte carte;
    final char[][] matChar = new char[][]{
        {'P', 'P', 'P', ' ', ' ', ' ', ' ', ' ', 'X', ' ', ' ', ' ', 'P'},
        {'B', '#', 'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {' ', 'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'B', ' ', ' ', ' ', ' '},
        {' ', 'B', 'B', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
        {' ', ' ', 'B', ' ', ' ', ' ', ' ', ' ', 'O', ' ', ' ', ' ', 'O'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'O'},
        {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X'},};

    public void afficherCarte(Carte map) {
        int i, j;
        System.out.println("");
        for (i = 0; i < map.getLargeur(); i++) {
            for (j = 0; j < map.getHauteur(); j++) {
                System.out.print(map.getCase(i, j).toString());
            }
            System.out.print("\n");
        }
    }

    public void startTest() {
        this.carte = new Carte(matChar);
      //  Carte ctest = new Carte(carte.getLargeur(), carte.getHauteur());

       // ctest.actualiserCarte(carte, 3, ctest.getCase(0, 0));
        afficherCarte(carte);
    //    afficherCarte(ctest);
    }

    public Carte getCarte() {
        return carte;
    }
}
