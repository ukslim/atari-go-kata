package org.jh.go;

import org.jh.go.Board.State;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class BoardTestUtil {
    
    static Board create(String... lines) {
        State[][] cells = new State[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            cells[i] = asRow(lines[i]);
        }
        return new Board(cells);
    }
    
    private static State[] asRow(String line) {
        State[] row = new State[line.length()];
        for (int i = 0; i < row.length; i++) {
            row[i] = toState(line.charAt(i));
        }
        return row;
    }
    
    private static State toState(char c) {
        switch(c) {
            case '.':
            case ' ':
                return State.EMPTY;
            case 'O':
            case 'X':
                return State.WHITE;
            case '@':
                return State.BLACK;
            default:
                throw new RuntimeException("Bad state");
        }
    }
    
    /**
     * Create a board and test it.
     * 
     * Acceptable cell characters are:
     *    . - an empty cell
     *    @ - a black stone
     *    O - a white stone, expected to remain alive
     *    X - a white stone, expected to die
     * 
     */
    public static void check(String... lines) {
        Board board = BoardTestUtil.create(lines);
        for (int y = 0; y < lines.length; y++) {
            char[] cells = lines[y].toCharArray();
            for (int x = 0; x < cells.length; x++) {
                char cell = cells[x];
                assertCell(cell, board, x, y);
            }
        }
    }
    
    private static void assertCell(char expectedState, Board board, int x, int y) {
        switch(expectedState) {
            case 'O':
                assertFalse(String.format("Cell %d,%d is dying",x,y),board.isDying(x, y));
                break;
            case 'X':
                assertTrue(String.format("Cell %d,%d is alive",x,y),board.isDying(x, y));
                break;
            default:
                // nothing
        }
    }
    
}
