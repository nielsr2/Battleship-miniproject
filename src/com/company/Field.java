package com.company;

public class Field extends Viewer {
    String[][] fieldArray;
    int fieldX;
    int fieldY;
    int fieldDimensions;
    Ship[] ships = new Ship[5];



    Field(int fieldDimensions) {
        this.fieldDimensions = fieldDimensions;
        this.fieldArray = new String[this.fieldDimensions][this.fieldDimensions];
        for (int i = 0; i < this.fieldDimensions; i++) {
            for (int j = 0; j < this.fieldDimensions; j++) {
                this.fieldArray[i][j] = "-";
            }
        }
//        this.printThisField();
    }

    void printThisField() {
        System.out.print("\n");
        System.out.print("\n");
        System.out.print("\n");
        System.out.println(" 0  1  2  3  4  5  6  7  8  9  ");
        for (int i = 0; i < this.fieldDimensions; i++) {
            System.out.print(i);
            for (int j = 0; j < this.fieldDimensions; j++) {
                System.out.print(" ");
                System.out.print(this.fieldArray[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    static void printField(String[][] field) {
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





    ;

    void setRandomShips() {
//        for (Ship s : this.ships) {
//        for (int i = 0; i < ships.length; i++) {
        ships[0] = new Ship(this, 2, "2");
        ships[1] = new Ship(this, 3, "3");
        ships[2] = new Ship(this, 4, "4");
        ships[3] = new Ship(this, 5, "5");
        ships[4] = new Ship(this, 6, "6");
//            s = new Ship(2, "1", true, randomX, randomY);
//        this.fieldArray = ships[0].addShiptoField(this.fieldArray);
//        printThisField();
        for (Ship s : this.ships) {
            this.fieldArray = s.init(this.fieldArray);
            printThisField();
        }

    }

    void placeShip(Ship ship, boolean vertical, int X, int Y) {
        ship.place(vertical, X, Y);

        this.printThisField();
    }

    boolean checkFire(int x, int y) {
        if (fieldArray[x][y] != "-") {
            String identifier = fieldArray[x][y];
            for (Ship ship : ships) {
                if (ship.identifier == identifier) {

                    fieldArray[x][y] = "x";
                    ship.takeHit(x, y);
                    if (ship.checkDeath()) {
                        this.fieldArray = ship.markDead(this.fieldArray);
                    } else {

                    }

                    printThisField();
                    return true;
                }
            }
            return false;
        } else {
            fieldArray[x][y] = "o";
            printThisField();
            return false;
        }

    }

    static String[][] emptyField(int dimensions) {
        dimensions = 10;
        String[][] emptyField = new String[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                emptyField[i][j] = "-";
            }
        }
        return emptyField;
    }


    static void printField2(String[][] field) {
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
