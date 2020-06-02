package ru.arl;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe2 {
    public static int SIZE = 5;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static int lastX = 0;
    public static int lastY = 0;

    public static void setLastX(int lastX) {
        TicTacToe2.lastX = lastX;
    }

    public static void setLastY(int lastY) {
        TicTacToe2.lastY = lastY;
    }

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
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

    public static int plusOrNot() { //метод возвращает модификацию (1, 0, -1) для посленего значения ввода игрока
        //Задумка в том, что робот приследует символ противника, мешаясь под ногами
        int rFA = 0;
        int randomForAi = (int) (Math.random() * 3);
        if (randomForAi == 2) {
            rFA = 1;
        }else if(randomForAi == 1) {
            rFA = 0;
        } else {
            rFA = -1;
        }
        return rFA;
    }

    public static void aiTurn() {
        int x, y;
        do {
            x = lastX + plusOrNot();
            y = lastY + plusOrNot();
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            lastX = x; //запоминаем
            y = sc.nextInt() - 1;
            lastY = y; //запоминаем
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
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
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
