package learn.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    Queen queen = new Queen();

    @Test
    void shouldMoveToFourCorners() {
        assertTrue(queen.move(7, 0)); // top left;
        assertEquals(7, queen.getRow());
        assertEquals(0, queen.getColumn());

        assertTrue(queen.move(7, 7)); // top right;
        assertEquals(7, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 7)); // bottom right;
        assertEquals(0, queen.getRow());
        assertEquals(7, queen.getColumn());

        assertTrue(queen.move(0, 0)); // bottom left;
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    @Test
    void shouldNotGoOffTheBoard(){
        assertFalse(queen.move(-1, 8));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
        assertFalse(queen.move(8,-1));
        assertEquals(0, queen.getRow());
        assertEquals(0, queen.getColumn());
    }

    @Test
    void shouldNotMoveToCurrentLocation(){
        assertTrue(queen.move(1,1));
        assertEquals(1, queen.getRow());
        assertEquals(1, queen.getColumn());
        assertFalse(queen.move(1,1));
        assertEquals(1, queen.getRow());
        assertEquals(1, queen.getColumn());
    }

    // 1. Add tests to validate Queen movement.
    // Required tests:
    // - anything off the board is invalid, should return false and leave field values alone.
    // - moving to the current location should return false and leave field values alone.
    // - should still be able to move after an invalid move.
    // - can move diagonally in various ways
    // Always confirm that fields have been properly updated using getters.
}