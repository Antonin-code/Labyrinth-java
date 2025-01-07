public class Colors {

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static String colors(char element) {
        switch (element) {
            case ' ':
                return ANSI_CYAN_BACKGROUND + ANSI_CYAN + element + ANSI_RESET;//couleur des cases vides
            case '#':
                return ANSI_BLACK_BACKGROUND + ANSI_BLACK + element + ANSI_RESET;//couleur des murs
            case 'E':
                return ANSI_RED_BACKGROUND + ANSI_RED + element + ANSI_RESET;//couleur d entree
            case 'S':
                return ANSI_CYAN_BACKGROUND + ANSI_CYAN + element + ANSI_RESET; //ccouleur de sortie
            case 'V':
                return ANSI_GREEN_BACKGROUND + ANSI_GREEN + element + ANSI_RESET; //ccouleur du solveur
            case 'P':
                return ANSI_WHITE_BACKGROUND + ANSI_WHITE + element + ANSI_RESET; //ccouleur du player
        }
        return ANSI_BLACK + ANSI_BLACK + element + ANSI_RESET;
    }
    public static String emoji(char element) {
        switch (element) {
            case ' ':
                return ANSI_WHITE_BACKGROUND + "\uD83C\uDFD9\uFE0F" + ANSI_RESET;//couleur des cases vides
            case '#':
                return ANSI_BLUE_BACKGROUND + "\u2601\uFE0F" + ANSI_RESET;//couleur des murs
            case 'E':
                return ANSI_BLUE_BACKGROUND + "\uD83C\uDFE2" + "\uD83C\uDFE2" + ANSI_RESET;//couleur d entree
            case 'S':
                return ANSI_BLUE_BACKGROUND + "\uD83D\uDEEB" + ANSI_RESET; //ccouleur de sortie
            case 'V':
                return ANSI_RED_BACKGROUND + "\uD83D\uDCA5" + ANSI_RESET; //ccouleur du solveur
            case 'P':
                return ANSI_BLUE_BACKGROUND + "\u2708\uFE0F" + ANSI_RESET; //ccouleur du player
        }
        return ANSI_BLACK + ANSI_BLACK + element + ANSI_RESET;
    }
}