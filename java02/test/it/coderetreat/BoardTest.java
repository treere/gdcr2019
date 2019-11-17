package it.coderetreat;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BoardTest {

    private Board board;

    @BeforeEach
    public void createBoad() {
        board = new Board(10,10);
    }

    @Test
    public void createABoard() {
        boolean alive = board.isAlive(0, 0);
        Assertions.assertFalse(alive);
    }

    @Test
    public void invalidPositionNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            board.isAlive(-1,-1);
        });
    }

    @Test
    public void invalidPosition() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            board.isAlive(10,11);
        });
    }

    @Test
    public void setAliceAndCheck() {
        board.setAlive(0,0);
        boolean alive = board.isAlive(0, 0);
        Assertions.assertTrue(alive);
    }

    @Test
    public void setAliceAndCheckInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            board.setAlive(-1,10);
        });
    }

    @Test
    public void numberOfNeighborInEmptyBoard() {
        int n = board.countNeighbors(5,5);
        Assertions.assertEquals(0,n);
    }

    @Test
    public void numberOfNeighbor() {
        board.setAlive(5,4);
        int n = board.countNeighbors(5,5);
        Assertions.assertEquals(1,n);
    }

    @Test
    public void numberOfNeighborOnEdge() {
        board.setAlive(0,4);
        board.setAlive(0,6);
        int n = board.countNeighbors(0,5);
        Assertions.assertEquals(2,n);
    }
}