
package org.jh.go;

import static org.hamcrest.CoreMatchers.is;
import static org.jh.go.Board.State.WHITE;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class BoardFactoryTest {
    
    @Test
    public void factory_creates_9x9_board_for_9x9_input() {
        Board board = BoardFactory.create(
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                "........."
        );
        assertThat(board.xSize(), is(9));
        assertThat(board.ySize(), is(8));
    }
    
    @Test
    public void factory_places_white_cell() {
        Board board = BoardFactory.create(
                ".........",
                "..O......",
                ".........",
                ".........",
                "........."
        );
        assertThat(board.stateAt(2,1), is(WHITE));
    }
}
