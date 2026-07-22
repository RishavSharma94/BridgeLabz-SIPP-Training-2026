import java.util.*;

public class WordSearch {

    public static void main(String[] args) {

        char[][] grid = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };

        String word = "ABCCED";

        System.out.println(exists(grid, word));
    }

    static boolean exists(char[][] grid, String word) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (search(grid, word, 0, i, j, visited))
                    return true;
            }
        }

        return false;
    }

    static boolean search(char[][] grid, String word, int index, int r, int c, boolean[][] visited) {

        if (index == word.length())
            return true;

        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length)
            return false;

        if (visited[r][c] || grid[r][c] != word.charAt(index))
            return false;

        visited[r][c] = true;

        boolean found =
                search(grid, word, index + 1, r + 1, c, visited) ||
                        search(grid, word, index + 1, r - 1, c, visited) ||
                        search(grid, word, index + 1, r, c + 1, visited) ||
                        search(grid, word, index + 1, r, c - 1, visited);

        visited[r][c] = false;

        return found;
    }
}