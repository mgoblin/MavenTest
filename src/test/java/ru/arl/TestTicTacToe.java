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
        map = new char[2][2];
        map[1][1] = DOT_X;

        assertEquals(isCellValid(1, 1), false);
    }

//    @Test
//    public void TestPrintMap() {
//        setSIZE(1);
//        initMap();
//        printMap();
//        String[][] expectedGrid = new String[1][1];
//        expectedGrid[0][0] = "0";
//        expectedGrid[0][1] = "1";
//        expectedGrid[1][0] = "1";
//        expectedGrid[1][1] = "•";
//
//        for (int row = 0; row < SIZE; row++) {
//            for (int column = 0; column < SIZE; column++) {
//                assertEquals(printMap()[row][column], DOT_EMPTY);
//            }
//        }
//    }
}

