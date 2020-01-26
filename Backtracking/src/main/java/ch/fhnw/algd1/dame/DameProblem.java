package ch.fhnw.algd1.dame;

import ch.fhnw.algd1.BoardPrinter;

public class DameProblem {

    public static void main(String[] args) {
        DameAlgo dameAlgo = new DameAlgo();
        final int N = 8;
        boolean[][] board = new boolean[N][N];
        if (dameAlgo.solve(board, 0)) {
            BoardPrinter.print(board);
        } else {
            System.err.println("No solution found for N = " + N);
        }
    }
}
