import java.util.*;

/**
 * classe Main
 */
public class Main {

    public static int WIDTH = 5;  //
    public static int HEIGHT = 5; //
    public static final char WALL = '#'; //
    public static final char PATH = ' ';
    public static boolean censuré = false ;

    public static char[][] limby = new char[HEIGHT][WIDTH];

    public Main() {
        limby = new char[HEIGHT][WIDTH];
        GenereLimby();
    }

    /**
     * Genere le labyrinthe a partir de Height et Width
     * @return
     */
    static char[][] GenereLimby() {
        initWall();
        carvePath(1, 1, limby);

        // Placer les points de départ et de sortie
        limby[1][1] = 'S'; // Point de départ
        limby[HEIGHT - 2][WIDTH - 2] = 'E'; // Point de sortie

        return new char[0][];
    }

    static void initWall() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                limby[i][j] = WALL;
            }
        }
    }

    /**
     * Creation de chemins aleatoires pour le labyrinthe
     * @param x
     * @param y
     * @param limby
     */
    public static void carvePath(int x, int y, char[][] limby) {
        limby[y][x] = PATH; // Créer un chemin

        // Générer un ordre aléatoire pour les directions
        int[][] directions = {
                {0, -2}, // Haut
                {0, 2},  // Bas
                {-2, 0}, // Gauche
                {2, 0}   // Droite
        };

        // Mélanger les directions de manière aléatoire
        for (int i = 0; i < 4; i++) {
            int randomIndex = (int) (Math.random() * 4);
            int[] temp = directions[i];
            directions[i] = directions[randomIndex];
            directions[randomIndex] = temp;
        }

        // Essayer chaque direction
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            // Vérifier si la cellule voisine est dans les limites du labyrinthe et est un mur
            if (nx > 0 && ny > 0 && nx < WIDTH - 1 && ny < HEIGHT - 1 && limby[ny][nx] == WALL) {
                // Creuser un chemin entre la cellule actuelle et la voisine
                limby[ny - dir[1] / 2][nx - dir[0] / 2] = PATH;
                carvePath(nx, ny, limby);
            }
        }
    }

    /**
     * Afficher le labyrinthe
     */
    public static void displayLimby(char[][] limby) {
        for (int i = 0; i < Main.limby.length; i++) {
            System.out.println();
            for (int j = 0; j < Main.limby[i].length; j++) {
                if (censuré == true){

                    System.out.print(Colors.colors(limby[i][j])+Colors.colors(limby[i][j]));

                }
                else{
                    System.out.print(Colors.emoji(limby[i][j]));
                }
            }
        }
        System.out.println();
    }

    /**
     * Demande au joueur de choisir la taille/la difficulté du labyrinthe
     */
    public static void dimension() {
        Scanner scan = new Scanner(System.in);
        int dimension;
        do {
            System.out.println("Entrez la taille du labyrinthe (hauteur et largeur doivent être égales et positives) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scan.next(); // Clear invalid input
            }
            dimension = scan.nextInt();
        } while (dimension <= 0);

        HEIGHT = dimension;
        WIDTH = dimension;
    }

    public static void difficullty() {
        Scanner scan = new Scanner(System.in);
        int diff;

        do {
            System.out.println("Entrez la difficulté (1 pour facile, 2 pour moyen, 3 pour difficile, 4 pour personnalisé) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer un nombre valide.");
                scan.next(); // Clear invalid input
            }
            diff = scan.nextInt();
        } while (diff < 1 || diff > 4); // Validation : doit être 1, 2, 3 ou 4

        switch (diff) {
            case 1:
                HEIGHT = 9;
                WIDTH = 9;
                break;
            case 2:
                HEIGHT = 19;
                WIDTH = 19;
                break;
            case 3:
                HEIGHT = 39;
                WIDTH = 39;
                break;
            case 4:
                dimension();
                break;
        }
    }

    public static void Charge() {
        Scanner scan = new Scanner(System.in);
        int ask;

        do {
            System.out.println("Charger un labyrinthe ? (0 pour oui, 1 pour non) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer 0 ou 1.");
                scan.next(); // Clear invalid input
            }
            ask = scan.nextInt();
        } while (ask != 0 && ask != 1); // Validation : doit être 0 ou 1

        if (ask == 0) {
            System.out.println("Votre labyrinthe est chargé");
            System.out.println("Entrez le nom du fichier : ");
            Scanner scan2 = new Scanner(System.in);
            String load = scan2.nextLine();
            limby = WriteToFile.loadFromFile(load);
            displayLimby(limby);
        } else {
            difficullty();
            Main generator = new Main();
            generator.displayLimby(Main.limby);

            int save;
            do {
                System.out.println("Sauvegarder le labyrinthe ? (0 pour oui, 1 pour non) : ");
                while (!scan.hasNextInt()) {
                    System.out.println("Veuillez entrer 0 ou 1.");
                    scan.next(); // Clear invalid input
                }
                save = scan.nextInt();
            } while (save != 0 && save != 1); // Validation : doit être 0 ou 1

            if (save == 0) {
                WriteToFile.main(limby);
            }
        }
    }

    public static void mainsolveur() {
        Scanner scan = new Scanner(System.in);
        int ask;

        do {
            System.out.println("Voulez-vous voir la solution ? (0 pour oui, 1 pour non) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer 0 ou 1.");
                scan.next(); // Clear invalid input
            }
            ask = scan.nextInt();
        } while (ask != 0 && ask != 1); // Validation : doit être 0 ou 1

        if (ask == 0) {
            if (solveur.solvelybe(1, 1)) {
                displayLimby(Main.limby);
                System.out.println("Labyrinthe résolu !");
            } else {
                displayLimby(Main.limby);
                System.out.println("Aucune solution trouvée.");
            }
        }
    }

    public static void censuré () {
        Scanner scan = new Scanner(System.in);
        int ask;

        do {
            System.out.println("Voulez-vous le mod censuré ? (0 pour oui, 1 pour non) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer 0 ou 1.");
                scan.next(); // Clear invalid input
            }
            ask = scan.nextInt();
        } while (ask != 0 && ask != 1); // Validation : doit être 0 ou 1

        if (ask == 0) {
        censuré  = true ;
        }

    }

    /**
     * Main function
     * @param args
     */
    public static void main(String[] args) {
        censuré();
        Charge();
        Move_player.main();
    }
}
