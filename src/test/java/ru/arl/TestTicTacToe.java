package ru.arl;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static ru.arl.TicTacToe.*;

public class TestTicTacToe {
    private static final int SIZE = getSIZE();

    @Test
    public void testInitMap() {
        TicTacToe.initMap();
        for (int row = 0; row < SIZE; row++) {
            for (int column = 0; column < SIZE; column++) {
                assertEquals(map[row][column], DOT_EMPTY);
            }
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
            setSIZE(0);
        }
    }

}

