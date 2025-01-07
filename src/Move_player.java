import java.util.Scanner;

public class Move_player {



    public static void main() {
        char[][] Tableau = Main.limby;

        Scanner scan = new Scanner(System.in);
        int ask;

        // Boucle pour s'assurer que l'utilisateur entre 0 ou 1 uniquement
        do {
            System.out.println("Jouer le Maze ? (0 pour oui, 1 pour non) : ");
            while (!scan.hasNextInt()) {
                System.out.println("Veuillez entrer 0 ou 1.");
                scan.next(); // On ignore l'entrée non valide
            }
            ask = scan.nextInt();
        } while (ask != 0 && ask != 1); // Répéter tant que l'utilisateur n'entre pas 0 ou 1

        if (ask == 0) {
            move(Tableau);  // Démarre le jeu
        } else {
            Main.mainsolveur(); // Résoudre le labyrinthe
        }
    }



    public static void move(char[][] GiveTab) {
        int x = 1; // x et y existent
        int y = 1;
        boolean End = false; // fin du laby
        for (int i = 0; i < GiveTab[0].length; i++) { //permet de trouver l'entree et de poser le pion
            if (GiveTab[0][i] == 'E') {
                x = i;
                y = 1; //permet de poser le pion devant l entree
            }

        }
        GiveTab[x][y] = 'P';  // code de l'emoji
        System.out.println("Ecrit E si tu veux la solution");

        while (!End) {
            Main.displayLimby(Main.limby);
            Scanner sc = new Scanner(System.in);
            String move = sc.nextLine(); //pour la prochaine ligne

            if (move.equals("d")) {
                if (GiveTab[x][y + 1] == ' ' && GiveTab[x][y + 1] != '#') {
                    GiveTab[x][y] = ' '; //enleve l emoji
                    GiveTab[x][y + 1] = 'P';
                    y += 1;
                }
                }
                if (move.equals("q")) {
                    if (GiveTab[x][y - 1] == ' ' && GiveTab[x][y - 1] != '#') {
                        GiveTab[x][y] = ' '; //enleve l emoji
                        GiveTab[x][y - 1] = 'P';
                        y -= 1;
                    }
                }

                    if (move.equals("z")) {
                        if (GiveTab[x - 1][y] == ' ' && GiveTab[x - 1][y] != '#') {
                            GiveTab[x][y] = ' '; //enleve l emoji
                            GiveTab[x - 1][y] = 'P';
                            x -= 1;
                        }
                    }

                        if (move.equals("s")) {
                            if (GiveTab[x + 1][y] == ' ' && GiveTab[x + 1][y] != '#') {
                                GiveTab[x][y] = ' '; //enleve l emoji
                                GiveTab[x + 1][y] = 'P';
                                x += 1;}

                            }

            if (move.equals("E")) {
                GiveTab[x][y] = ' ';
                Main.mainsolveur();
                break;
            }

            if (GiveTab[x + 1][y] == 'E' || GiveTab[x - 1][y] == 'E' || GiveTab[x ][y + 1] == 'E' || GiveTab[x][y - 1] == 'E' ){
                End = true;
                System.out.println("Bien ouej ma gueule");
            }









//    public static deplacement();
//        System.out.println("veullez entrer une direction");
//        Scanner sc1 =new Scanner(System.in);
//        int nb = sc1.next();
//        System.out.println("Vous avez chosi : "+ nb);


        }
    }
}