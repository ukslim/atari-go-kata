package org.jh.go;

import java.util.Set;
import java.util.TreeSet;

class Board {

    State[][] cells;
    
    Board(State[][] cells) {
        this.cells = cells;
    }
    
    public int xSize() {
        return cells[0].length;
    }
    
    public int ySize() {
        return cells.length;
    }
    
    public State stateAt(int x, int y) {
        if(y<0 || x<0 || y>= ySize() || x>=xSize()) {
            return State.BLACK;
        }
        return cells[y][x];
    }

    boolean isDying(int x, int y) {
       return !canEscape(x,y, new TreeSet<Integer>());               
    }
    
    boolean canEscape(int x, int y, Set<Integer> checked) {

        int id = x * ySize() + y;
        
        if(checked.contains(id)) {
            return false;
        }

        if(stateAt(x,y) == State.BLACK) {
            return false;
        } 
        if(stateAt(x,y) == State.EMPTY) {
            return true;
        }
        
        checked.add(id);
            
        return
                canEscape(x-1,y, checked) ||
                canEscape(x,y-1, checked) ||
                canEscape(x+1,y, checked) ||
                canEscape(x,y+1, checked);
    }
    
    public enum State { 
        EMPTY, WHITE, BLACK;
    }
}
