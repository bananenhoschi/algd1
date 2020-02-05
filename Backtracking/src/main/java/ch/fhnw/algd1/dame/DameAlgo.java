package ch.fhnw.algd1.dame;

import ch.fhnw.algd1.BoardChecker;

import java.util.ArrayList;
import java.util.List;

public class DameAlgo {



    public boolean solve(boolean[][] board, int row) {
        if (row == board.length) return BoardChecker.isValid(board);

        int col = 0;
        boolean solved = false;

        while (col < board[row].length && !solved) {
            board[row][col] = true;

            solved = solve(board, row + 1);

            if (!solved)
                board[row][col] = false;
            col++;

        }
        return solved;
    }

}
