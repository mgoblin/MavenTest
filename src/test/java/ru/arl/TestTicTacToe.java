package ru.arl;

import org.junit.Test;

import static org.junit.Assert.*;
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
        try {
            setSIZE(3);
            assertFalse(isCellValid(-1, -1));
        } finally {
            setSIZE(SIZE);
        }
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

    @Test
    public void testMapIsNotFull() {
        try {
            setSIZE(1);
            initMap();
            assertFalse(isMapFull());
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testIsMapFull() {
        try {
            setSIZE(1);
            initMap();
            map[0][0] = DOT_X;
            assertTrue(isMapFull());
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testCheckWinGor() {
        try {
            setSIZE(2);
            initMap();
            map[0][0] = DOT_X;
            map[0][1] = DOT_X;
            assertTrue(checkWin(DOT_X));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testCheckWinVert() {
        try {
            setSIZE(2);
            initMap();
            map[0][0] = DOT_X;
            map[1][0] = DOT_X;
            assertTrue(checkWin(DOT_X));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testCheckWinDiag1() {
        try {
            setSIZE(2);
            initMap();
            map[0][0] = DOT_X;
            map[1][1] = DOT_X;
            assertTrue(checkWin(DOT_X));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testCheckWinDiag2() {
        try {
            setSIZE(2);
            initMap();
            map[0][1] = DOT_X;
            map[1][0] = DOT_X;
            assertTrue(checkWin(DOT_X));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testCheckWinFalse() {
        try {
            setSIZE(2);
            initMap();
            map[0][1] = DOT_X;
            map[1][0] = DOT_X;
            assertFalse(checkWin(DOT_O));
        } finally {
            setSIZE(SIZE);
        }
    }

    @Test
    public void testHumanTurn () {
        try {
            setSIZE(1);
            initMap();
        } finally {

        }
    }

//    @Test
//    public void test () {
//        try {
//
//        } finally {
//
//        }
//    }
//
//    @Test
//    public void test () {
//        try {
//
//        } finally {
//
//        }
//    }
}

