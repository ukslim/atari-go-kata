package org.jh.go;

import org.junit.Test;
import static org.jh.go.BoardTestUtil.check;

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
}
