/*
 * Created on 03.12.2013
 */
package ch.fhnw.algd1.sudoku.solver;

import ch.fhnw.algd1.sudoku.framework.SudokuChecker;
import ch.fhnw.algd1.sudoku.framework.SudokuModel;
import ch.fhnw.algd1.sudoku.framework.SudokuSolver;

/**
 * @author
 */
public final class SudokuSolverImpl implements SudokuSolver {
    private final SudokuChecker checker;

    /**
     * Create a new solver based on a checker
     *
     * @param checker the SudokuChecker this solver will be using to determine the
     *                validity of partial solutions
     */
    public SudokuSolverImpl(SudokuChecker checker) {
        this.checker = checker;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * ch.fhnw.algd1.sudoku.SudokuSolver#solved(ch.fhnw.algd1.sudoku.SudokuModel)
     */
    @Override
    public boolean solved(SudokuModel model) {
//        if (model.get(i, j) == model.size() * model.size()) {
//            return checker.allOK(model);
//        } else {
//            final int i = fieldNr / model.size(), j = fieldNr % model.size();
//            if (model.get(i, j) != 0) {
//                return solved(model);
//            } else {
//                boolean found = false;
//                for (int val = 1; val < model.size() && !found; val++) {
//                    model.set(i, j, val);
//                    found = solved(model, fieldNr + 1);
//                    if (!found) {
//                        model.clear(i, j);
//                    }
//                }
//                return found;
//            }
//
//        }
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see ch.fhnw.algd1.sudoku.SudokuSolver#nofSolutions(ch.fhnw.algd1.sudoku.
     * SudokuModel )
     */
    @Override
    public int nofSolutions(SudokuModel model) {
        // TODO start recursive enumeration of solutions, beginning at square 0 or
        // (0,0) resp.
        return 0;
    }
}
