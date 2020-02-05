package ch.fhnw.algd1.magischesquadtrat;

import ch.fhnw.algd1.BoardPrinter;

public class MagischesQuadrat {


    public static void main(String[] args) {

        MagischesQuadratAlgo algo = new MagischesQuadratAlgo();
        int[] board = algo.getBoard();
        algo.solve(board, 0);
        // BoardPrinter.print(board);
    }


}
