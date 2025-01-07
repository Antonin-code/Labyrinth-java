import java.util.*;


public class solveur {

    public static boolean solvelybe(int x, int y) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        int[] directions = {0, -1, 0, 1, -1, 0, 1, 0}; // Up, Down, Left, Right

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            x = current[0];
            y = current[1];

            Main.limby[y][x] = 'V';


            for (int i = 0; i < 8; i += 2) {
                int nx = x + directions[i];
                int ny = y + directions[i + 1];

                if (nx >= 0 && ny >= 0 && nx < Main.WIDTH && ny < Main.HEIGHT && Main.limby[ny][nx] == Main.PATH) {
                    stack.push(new int[]{nx, ny});
                }

                if (nx >= 0 && ny >= 0 && nx < Main.WIDTH && ny < Main.HEIGHT && Main.limby[ny][nx] == 'E'){
                    return true;
                }
            }
        }


        return false; // No solution found

    }


}