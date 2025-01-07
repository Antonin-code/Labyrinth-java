import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class WriteToFile {

    public static void main(char[][] limby) {
            String baseName = "lab";  // Le préfixe du nom des fichiers de sauvegarde
            String saveFileName;
            int counter = 1;  // Démarrer à "lab1"
            File file;

            // Boucle pour trouver le premier fichier qui n'existe pas encore
            do {
                saveFileName = baseName + counter + ".labgen";  // Générer "lab1.labgen", "lab2.labgen", etc.
                file = new File(saveFileName);
                counter++;  // Incrémenter le compteur
            } while (file.exists() && file.isFile());  // Continuer tant que le fichier existe

            // Le premier fichier non existant a été trouvé, on peut l'utiliser
            String name = baseName + (counter - 1);  // Récupérer le nom sans l'extension


            // Ici, tu peux continuer avec ta logique de sauvegarde, en utilisant `saveFileName`
            // Exemple de création de fichier ou de traitement avec `saveFileName`



            try {


            FileWriter writer = new FileWriter(name+".labgen");
            for (int i = 0; i < limby.length; i++) {
                for (int j = 0; j < limby[i].length; j++) {
                    writer.write(limby[i][j]);
                }
                writer.write("\n"); // Retour à la ligne après chaque ligne du labyrinthe
            }
            writer.close();
            System.out.println("Le labyrinthe a été sauvegardé dans "+name+".labgen");
        } catch (IOException e) {
            System.out.println("Une erreur est survenue lors de l'écriture du fichier.");
            e.printStackTrace();
        }
    }

    /**
     * Charge et affiche le contenu du fichier .labgen
     */
    public static char[][] loadFromFile(String numberFile) {
        char[][] limby = new char[19][19];
        Main.WIDTH = 19;
        Main.HEIGHT= 19;
        try {
            File file = new File(numberFile);
            Scanner reader = new Scanner(file);

            System.out.println("Le labyrinthe chargé est :");
            int ligne = 0;
            while (reader.hasNextLine()) {
                String line =  reader.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    limby[ligne][i] = c;
                }
                ligne += 1;

            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier lab1.labgen n'a pas été trouvé.");
            e.printStackTrace();
        }
        return limby;
    }
}
