package ru.arl;

import static ru.arl.TicTacToe.*;

public class GameLogic {
    static void game(int size) {
        setSIZE(size);
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

            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            while (aiTurn(x, y)){
                x = rand.nextInt(SIZE);
                y = rand.nextInt(SIZE);
            }

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
}
