package com.company;

import java.util.Scanner;

public class Viewer {
    String[][] fieldArray = new String[10][10];
    int fieldDimensions;
    int x = 5;
    int y = 5;

    void refresh() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.fieldArray[i][j] = "-";
                if (i == this.x && this.y == j) {
                    this.fieldArray[x][y] = "Ø";
                }
            }
        }
        printField(this.fieldArray);
    }
    boolean selecting;

    void selecting() {
        selecting = true;
        refresh();
        Scanner sc = new Scanner(System.in);
//        while (selecting) {
        System.out.println(this.x + " " + this.y);
        System.out.println("w, a, s ,d :");
//        String dir = ;
        cursor(sc.next().toString());
        refresh();

//        }
    }
    void cursor(String key) {
        System.out.println(key);
        System.out.println(key);
        String w = "war";
        System.out.println(w.getClass() + " " + key.getClass());
//        System.out.println(key == "w");
        if (key.equals("w")) {
            this.x = this.x - 1;
            System.out.println("w");
            System.out.println(this.x + " " + this.y);
            this.selecting();
        }
        if (key.equals("s")) {
            this.x++;
            System.out.println(this.x + " " + this.y);
            this.selecting();
        }
        if (key.equals("a")) {
            this.y--;
            System.out.println(this.x + " " + this.y);
            this.selecting();
        }
        if (key.equals("d")) {
            this.y++;
            System.out.println(this.x + " " + this.y);
            this.selecting();
        }
        refresh();
        if (key == "fire")
            System.out.println("FIRED");
    }



    void printField(String[][] field) {
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println(" 0  1  2  3  4  5  6  7  8  9  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            for (int j = 0; j < 10; j++) {
                System.out.print(" ");
                System.out.print(field[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}