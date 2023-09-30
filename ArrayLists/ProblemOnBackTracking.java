Question 1:

Implement a Java program to solve the N-Queens problem using backtracking. The N-Queens problem involves placing N queens on an N×N chessboard in such a way that
no two queens threaten each other.

Code:
public class NQueens {

    static int N = 8;

    public static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueensUtil(int[][] board, int col) {
        if (col >= N) {
            printSolution(board);
            return true;
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                res = solveNQueensUtil(board, col + 1) || res;

                // Backtrack
                board[i][col] = 0;
            }
        }

        return res;
    }

    public static void solveNQueens() {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }

    public static void main(String[] args) {
        // Example usage
        solveNQueens();
    }
}


Question 2:

Write a Java program to find all possible combinations of k numbers out of 1...n. The solution set should not contain duplicate combinations.

Code:
import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        combineHelper(n, k, 1, current, result);
        return result;
    }

    private static void combineHelper(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            combineHelper(n, k - 1, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Example usage
        int n = 4;
        int k = 2;
        List<List<Integer>> combinations = combine(n, k);

        System.out.println("Combinations of " + k + " numbers out of 1..." + n + ":");
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
