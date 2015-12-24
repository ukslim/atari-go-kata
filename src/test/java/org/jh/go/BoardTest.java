package org.jh.go;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BoardTest {
    @Test
    public void alive_when_alone() {
        assertOutcome(
                "...",
                ".O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_below() {
        assertOutcome(
                "...",
                ".O.",
                ".@.");
    }
    
    @Test
    public void alive_when_one_neighbour_left() {
        assertOutcome(
                "...",
                "@O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_above() {
        assertOutcome(
                ".@.",
                ".O.",
                "...");
    }
    
    @Test
    public void alive_when_one_neighbour_right() {
        assertOutcome(
                "...",
                ".O@",
                "...");
    }
    
    @Test
    public void alive_when_three_neighbours() {
        assertOutcome(
                "...",
                "@O@",
                ".@.");
    }
    
    @Test
    public void dying_when_surrounded() {
        assertOutcome(
                ".....",
                "..@..",
                ".@X@.",
                "..@..",
                ".....");
    }
    
    @Test public void dying_when_surrounded_on_top_edge() {
        assertOutcome(
                ".@X@.",
                "..@..",
                ".....");
    }
    
    @Test public void dying_when_surrounded_on_left_edge() {
        assertOutcome(
                "...",
                "@..",
                "X@.",
                "@..",
                "...");
    }
    
    @Test public void dying_when_surrounded_on_bottom() {
        assertOutcome(
                "...",
                ".@.",
                "@X@");
    }
    
    @Test public void dying_when_surrounded_on_right() {
        assertOutcome(
                "..@",
                ".@X",
                "..@");
    }
    
    @Test public void dying_when_surrounded_on_top_left_corner() {
        assertOutcome(
                "X@.",
                "@..",
                "...");
    }
    
     @Test public void dying_when_surrounded_on_top_right_corner() {
        assertOutcome(
                ".@X",
                "..@",
                "...");
    }
     
     @Test public void dying_when_surrounded_on_bottom_right_corner() {
        assertOutcome(
                "...",
                "..@",
                ".@X");
    }   
   
     @Test public void dying_when_surrounded_on_bottom_left_corner() {
        assertOutcome(
                "...",
                "@..",
                "X@.");
    }   
   
     
    @Test
    public void dying_when_in_island() {
        assertOutcome(
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
        assertOutcome(
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
        assertOutcome(
                "..........",
                ".....@....",
                "...@@O@...",
                "...O@O@...",
                "..@OOO@...",
                "...@@@...."
        );
    }
    
    private void assertOutcome(String... lines) {
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
