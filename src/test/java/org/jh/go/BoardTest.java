package org.jh.go;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/*
The check() method takes a board description consisting of a varargs array
of Strings describing a board. Acceptable characters are:
   . - an empty cell
   @ - a black stone
   O - a white stone, expected to remain alive
   X - a white stone, expected to die
*/
public class BoardTest {
    @Test
    public void alive_when_alone() {
        check(
                "...",
                ".O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_below() {
        check(
                "...",
                ".O.",
                ".@.");
    }
    
    @Test
    public void alive_when_one_neighbour_left() {
        check(
                "...",
                "@O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_above() {
        check(
                ".@.",
                ".O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_right() {
        check(
                "...",
                ".O@",
                "...");
    }
    
    @Test
    public void alive_when_three_neighbours() {
        check(
                "...",
                "@O@",
                ".@.");
    }
    
    @Test
    public void dying_when_surrounded() {
        check(
                ".....",
                "..@..",
                ".@X@.",
                "..@..",
                ".....");
    }
    
    @Test public void dying_when_surrounded_on_top_edge() {
        check(
                ".@X@.",
                "..@..",
                ".....");
    }
    
    @Test public void dying_when_surrounded_on_left_edge() {
        check(
                "...",
                "@..",
                "X@.",
                "@..",
                "...");
    }
    
    @Test public void dying_when_surrounded_on_bottom() {
        check(
                "...",
                ".@.",
                "@X@");
    }
    
    @Test public void dying_when_surrounded_on_right() {
        check(
                "..@",
                ".@X",
                "..@");
    }
    
    @Test public void dying_when_surrounded_on_top_left_corner() {
        check(
                "X@.",
                "@..",
                "...");
    }
    
     @Test public void dying_when_surrounded_on_top_right_corner() {
        check(
                ".@X",
                "..@",
                "...");
    }
     
     @Test public void dying_when_surrounded_on_bottom_right_corner() {
        check(
                "...",
                "..@",
                ".@X");
    }   
   
     @Test public void dying_when_surrounded_on_bottom_left_corner() {
        check(
                "...",
                "@..",
                "X@.");
    }   
   
     
    @Test
    public void dying_when_in_island() {
        check(
                ".....",
                "..@..",
                ".@X@.",
                ".@X@.",
                "..@..",
                "....."
        );
    }
    
    @Test
    public void dying_when_in_complex_island() {
        check(
                "..........",
                ".....@....",
                "...@@X@...",
                "..@X@X@...",
                "..@XXX@...",
                "...@@@...."
        );
    }
    
    @Test
    public void alive_when_complex_route_to_freedom() {
        check(
                "..........",
                ".....@....",
                "...@@O@...",
                "...O@O@...",
                "..@OOO@...",
                "...@@@...."
        );
    }
    
    private void check(String... lines) {
         Board board = BoardFactory.create(lines);
         for (int y = 0; y < lines.length; y++) {
             char[] cells = lines[y].toCharArray();
             for (int x = 0; x < cells.length; x++) {
                 char cell = cells[x];
                assertCell(cell, board, x, y);
             }
        }
    }

    private void assertCell(char expectedState, Board board, int x, int y) {
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
