package com.company;

public class Field {
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

        this.printField();
    }

    void printField() {
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

    void setRandomShips() {
//        for (Ship s : this.ships) {
//        for (int i = 0; i < ships.length; i++) {
        ships[0] = new Ship(this, 6, "2");
//        ships[1] = new Ship(this, 3, "3");
//        ships[2] = new Ship(this, 4, "4");
//        ships[3] = new Ship(this, 5, "5");
//        ships[4] = new Ship(this, 6, "6");
//            s = new Ship(2, "1", true, randomX, randomY);
        this.fieldArray = ships[0].addShiptoField(this.fieldArray);
        printField();
//        for (Ship s : this.ships) {
//            this.fieldArray = s.addShiptoField(this.fieldArray);
//            printField();
//        }

    }

    void newShip(int length, String identifier, boolean vertical, int X, int Y) {
//        int length, String identifier,boolean vertical, int X, int Y
    }


    void placeShip(Ship ship, boolean vertical, int X, int Y) {
        ship.place(vertical, X, Y);

        this.printField();
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

                    printField();
                    return true;
                }
            }
            return false;
        } else {
            fieldArray[x][y] = "o";
            printField();
            return false;
        }

    }
}
