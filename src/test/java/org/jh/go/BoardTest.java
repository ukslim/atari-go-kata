package org.jh.go;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class BoardTest {
    @Test
    public void alive_when_alone() {
        Board board = BoardFactory.create(
                "...",
                ".O.",
                "...");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void alive_when_one_neighbour_below() {
        Board board = BoardFactory.create(
                "...",
                ".O.",
                ".@.");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void alive_when_one_neighbour_left() {
        Board board = BoardFactory.create(
                "...",
                "@O.",
                "...");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void alive_when_one_neighbour_above() {
        Board board = BoardFactory.create(
                ".@.",
                ".O.",
                "...");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void alive_when_one_neighbour_right() {
        Board board = BoardFactory.create(
                "...",
                ".O@",
                "...");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void alive_when_three_neighbours() {
        Board board = BoardFactory.create(
                "...",
                "@O@",
                ".@.");
        assertFalse(board.isDying(1,1));
    }
    
    @Test
    public void dying_when_surrounded() {
        Board board = BoardFactory.create(
                ".....",
                "..@..",
                ".@O@.",
                "..@..",
                ".....");
        assertTrue(board.isDying(2, 2));
    }
    
    @Test public void dying_when_surrounded_on_top_edge() {
        Board board = BoardFactory.create(
                ".@O@.",
                "..@..",
                ".....");
        assertTrue(board.isDying(2, 0));
    }
    
    @Test public void dying_when_surrounded_on_left_edge() {
        Board board = BoardFactory.create(
                "...",
                "@..",
                "O@.",
                "@..",
                "...");
        assertTrue(board.isDying(0, 2));
    }
    
    @Test public void dying_when_surrounded_on_bottom() {
        Board board = BoardFactory.create(
                "...",
                ".@.",
                "@O@");
        assertTrue(board.isDying(1, 2));
    }
    
    @Test public void dying_when_surrounded_on_right() {
        Board board = BoardFactory.create(
                "..@",
                ".@O",
                "..@");
        assertTrue(board.isDying(2, 1));
    }
    
    @Test public void dying_when_surrounded_on_top_left_corner() {
        Board board = BoardFactory.create(
                "O@.",
                "@..",
                "...");
        assertTrue(board.isDying(0, 0));
    }
    
     @Test public void dying_when_surrounded_on_top_right_corner() {
        Board board = BoardFactory.create(
                ".@O",
                "..@",
                "...");
        assertTrue(board.isDying(2, 0));
    }
     
     @Test public void dying_when_surrounded_on_bottom_right_corner() {
        Board board = BoardFactory.create(
                "...",
                "..@",
                ".@O");
        assertTrue(board.isDying(2, 2));
    }   
   
     @Test public void dying_when_surrounded_on_bottom_left_corner() {
        Board board = BoardFactory.create(
                "...",
                "@..",
                "O@.");
        assertTrue(board.isDying(0, 2));
    }   
   
     
    @Test
    public void dying_when_in_island() {
        Board board = BoardFactory.create(
                ".....",
                "..@..",
                ".@O@.",
                ".@O@.",
                "..@..",
                "....."
        );
        assertTrue(board.isDying(2, 2));
    }
    
    @Test
    public void dying_when_in_complex_island() {
        Board board = BoardFactory.create(
                "..........",
                ".....@....",
                "...@@O@...",
                "..@O@O@...",
                "..@OOO@...",
                "...@@@...."
        );
        assertTrue(board.isDying(5, 2));
    }
    
    @Test
    public void alive_when_complex_route_to_freedom() {
        Board board = BoardFactory.create(
                "..........",
                ".....@....",
                "...@@O@...",
                "...O@O@...",
                "..@OOO@...",
                "...@@@...."
        );
        assertFalse(board.isDying(5, 2));
    }
}
