package ru.arl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static ru.arl.TicTacToe2.*;

public class TestTicTacToe2 {
    @Test
    public void test1InitMap() {
        TicTacToe2.initMap();
        for(int row = 0; row < SIZE; row++) {
            for(int column = 0; column < SIZE; column++) {
                assertEquals(map[row][column], DOT_EMPTY);
            }
        }

        map[0][0] = DOT_X;
        initMap();

        for(int row = 0; row < SIZE; row++) {
            for(int column = 0; column < SIZE; column++) {
                assertEquals(map[row][column], DOT_EMPTY);
            }
        }
    }
}
