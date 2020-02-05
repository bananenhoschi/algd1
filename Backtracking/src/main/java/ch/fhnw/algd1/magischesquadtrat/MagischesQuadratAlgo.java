package ch.fhnw.algd1.magischesquadtrat;

import java.util.Arrays;

public class MagischesQuadratAlgo {

    private int N = 3;
    private int[] board = new int[N * N];


    private int MAGIC_NUMBER = (int) ((Math.pow(N, 3) + N) / 2);
    private int MAX = f(N);

    public int[] getBoard() {
        return board;
    }

    public boolean solve(int[] board, int fieldNum) {
        if (fieldNum == N * N) return isBoardSolved(board); // Goal
        else {
            int[] banned = getBanned(board, fieldNum);

            boolean solved = false;

            for (int i = 0; i < N * N; i++) {

                if (isBanned(banned, i)) continue;
                board[fieldNum] = i;

                solved = solve(board, fieldNum + 1);

                if (!solved)
                    board[fieldNum] = 0;
                else
                    return true;

            }
        }
        return false;
    }

    private boolean isBanned(int[] banned, int i) {
        for (int j = 0; j < banned.length; j++) {
            if (banned[j] == i) {
                return true;
            }
        }
        return false;
    }

    private int[] getBanned(int[] board, int fieldNum) {
        int[] banned = new int[board.length];
        Arrays.fill(banned, -1);
        for (int i = 0; i < fieldNum; i++) {
            banned[i] = board[i];
        }
        return banned;
    }

    private int getNext() {
        return 0;
    }


    private boolean isBoardSolved(int[] board) {

        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            sum += board[i];
        }

        int temp = 0;
        for (int j = 1; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                temp += board[j * i];
            }
            if (temp != sum) return false;
            temp = 0;
        }

        for (int j = 0; j < board.length; j++) {
            for (int i = 0; i < board.length; i++) {
                temp += board[i * j];
            }
            if (temp != sum) return false;
            temp = 0;
        }

        for (int i = 0; i < board.length; i++) {
            temp += board[i];
        }
        if (temp != sum) return false;
        temp = 0;
        for (int i = 0; i < board.length; i++) {
            temp += board[board.length - 1 - i];
        }
        if (temp != sum) return false;

        return true;
    }

    private boolean isRowSumValid(int[] ns) {
        int sum = 0;
        for (int n : ns) {
            sum += n;
        }
        return sum == MAGIC_NUMBER;
    }

    public static int f(final int n) {
        return n == 0 ? 1 : n * f(n - 1);
    }

}
