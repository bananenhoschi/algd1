package ch.fhnw.algd1;

public final class BoardPrinter {


    public static void print(boolean[][] board){
        if (board.length < 1 || board.length != board[0].length){
            throw new IllegalArgumentException("Invalid board");
        }
        String separator = createSeparator(board.length);
        System.out.println(separator);
        for (int i =0; i < board.length; i++){
            printLine(board, i);
            System.out.println(separator);
        }
    }

    private static void printLine(boolean[][] board, int row) {
        System.out.printf("%s", "|");
        for (int col=0; col < board[row].length; col++){
            if (board[row][col] == true){
                System.out.printf("%2s", "D");
            } else {
                System.out.printf("%2s", " ");
            }
            System.out.printf("%2s", "|");
        }
        System.out.println();
    }


    public static void print(int[][] board) {
        if (board.length < 1 || board.length != board[0].length) {
            throw new IllegalArgumentException("Invalid board");
        }
        String separator = createSeparator(board.length);
        System.out.println(separator);
        for (int i = 0; i < board.length; i++) {
            printLine(board, i);
            System.out.println(separator);
        }
    }

    private static String createSeparator(int length) {
        String separatorPerColumn = "----";
        StringBuilder sb = new StringBuilder("-");
        for (int i = 0; i < length; i++) {
            sb.append(separatorPerColumn);
        }
        return sb.toString();
    }

    private static void printLine(int[][] board, int row) {
        System.out.printf("%s", "|");
        for (int col = 0; col < board[row].length; col++) {
            System.out.printf("%2s", board[row][col]);
            System.out.printf("%2s", "|");
        }
        System.out.println();
    }

}
