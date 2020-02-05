package ch.fhnw.algd1.springer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringerAlgo {


    private final int size = 5;

    private final int[][] board = new int[size][size];

    private final List<Move> moves = List.of(
            new Move(-2, 1),
            new Move(-2, -1),
            new Move(-1, 2),
            new Move(-1, -2),
            new Move(1, 2),
            new Move(1, -2),
            new Move(2, -1),
            new Move(2, 1));

    public boolean move(int x, int y, int step) {
        visit(x, y, step);
        if (step == size * size) return true;

        List<Move> nextMoves = calcNextMoves(x, y);
        warnsdorffRule(nextMoves);

        for (Move move : nextMoves) {
            boolean solved = move(move.getX(), move.getY(), step + 1);
            if (solved) return true;

        }
        unvisit(x, y);
        return false;
    }

    private void unvisit(int x, int y) {
        board[x][y] = 0;
    }

    private void visit(int x, int y, int step) {
        board[x][y] = step;
    }

    private void warnsdorffRule(List<Move> moves) {
        Map<Move, Integer> targetCounters = new HashMap<>();
        for (Move move : moves) {
            List<Move> nextTargets = calcNextMoves(move.getX(), move.getY());
            targetCounters.put(move, nextTargets.size());
        }
        moves.sort((p0, p1) -> {
            Integer c0 = targetCounters.get(p0);
            Integer c1 = targetCounters.get(p1);
            return Integer.compare(c0, c1);
        });
    }

    private boolean isOnBoard(int x, int y) {
        return (x > -1 && x < size) && (y > -1 && y < size);
    }

    private boolean isNotVisited(int x, int y) {
        return board[x][y] == 0;
    }

    private List<Move> calcNextMoves(int x, int y) {
        List<Move> targets = new ArrayList<>();
        for (Move m : moves) {
            int tx = x + m.getX();
            int ty = y + m.getY();
            if (isOnBoard(tx, ty) && isNotVisited(tx, ty)) {
                targets.add(new Move(tx, ty));
            }
        }
        return targets;
    }


}
