package ru.arl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static ru.arl.TicTacToe.*;

public class TestTicTacToe {
    private static final int SIZE = getSIZE();

    @Test
    public void testInitMap() {
        try {
            setSIZE(3);
            TicTacToe.initMap();
            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    assertEquals(map[row][column], DOT_EMPTY);
                }
            }
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testIsCellValid() {
        assertFalse(isCellValid(0, 0));
    }

    @Test
    public void testPlaceFull() {
        try {
            setSIZE(5);
            map = new char[2][2];
            map[1][1] = DOT_X;

            assertFalse(isCellValid(1, 1));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testGetSetSize() {
        try {
            setSIZE(1);
            assertEquals(getSIZE(), 1);
        } finally {
            setSIZE(SIZE);
        }
    }
}

