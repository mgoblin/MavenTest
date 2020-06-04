package ru.arl;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static int SIZE;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static char[][] mapArray;
    public static int lastX;
    public static int lastY;

    public static int getLastX() {
        return lastX;
    }

    public static void setLastX(int lastX) {
        TicTacToe.lastX = lastX;
    }

    public static int getLastY() {
        return lastY;
    }

    public static void setLastY(int lastY) {
        TicTacToe.lastY = lastY;
    }

    public static int getSIZE() {
        return SIZE;
    }

    public static void setSIZE(int SIZE) {
        TicTacToe.SIZE = SIZE;
    }


    public static void main(String[] args) {
        GameLogic.game(2);
    }

    static boolean checkWin(char dot) { //проверка победы
        int diag1, diag2, horiz, vert;
        for (int i = 0; i < SIZE; i++) {
            horiz = 0;
            vert = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == dot) {
                    horiz++;
                }
                if (map[j][i] == dot) {
                    vert++;
                }
            }
            if (horiz == SIZE || vert == SIZE) {
                return true; //проверка по горизонтали и вертикали
            }
        }
        diag1 = 0;
        diag2 = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == dot) {
                diag1++;
            }
            if (map[i][SIZE - i - 1] == dot) {
                diag2++;
            }
        }
        if (diag1 == SIZE || diag2 == SIZE) {
            return true; //проверка по диагоналям
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static boolean aiTurn(int x, int y) {
        if (isCellValid(x, y)) {
            System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
            map[y][x] = DOT_O;
            return true;
        } else {
            return false;
        }
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " "); //печать горизонтальных чисел
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " "); //печать вертикальных чисел
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " "); //печать инициализированных элементов массива
            }
            System.out.println();
        }
        System.out.println();
//        printMapArray();
    }

//    public static void printMapArray() {
//        mapArray = new char[SIZE + 1][SIZE + 1];
//        for (char i = 0; i < SIZE; i++) {
//            mapArray[0][i] = i; //направляющие числа по гор.
//        }
//        for (char i = 1; i < SIZE; i++) {
//            mapArray[i][0] = i; //направляющие числа по верт.
//        }
//        for (int i = 1; i < SIZE; i++) {
//            for (int j = 1; j < SIZE; j++) {
//                mapArray[i][j] = map[i - 1][j - 1];
//            } //копируем элементы массива map
//        }
//    }
//
//    public static void print() {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                System.out.println(mapArray[i][j]);
//            }
//        }
//    }
}

