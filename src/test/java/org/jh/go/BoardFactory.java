package org.jh.go;

import org.jh.go.Board.State;

class BoardFactory {

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
                return State.WHITE;
            case '@':
                return State.BLACK;
            default:
                throw new RuntimeException("Bad state");
        }
    }
    
}
