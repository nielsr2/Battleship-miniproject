package com.company;

public class Ship {
    int length;
    StringBuilder health = new StringBuilder("");
    boolean vertical, dead;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    int X;
    int Y;
    String identifier;
    int dimension;

    Ship(Field field, int length, String identifier) {
        this.length = length;
        this.dimension = field.fieldDimensions;
        for (int i = 0; i < length; i++) {
            this.health.append(identifier);
        }
        this.identifier = identifier;
        this.dead = false;


        System.out.println("dimension" + dimension + " length: " + length + " identifier: " + identifier + " vertical " + vertical + " X: " + X + " Y: " + Y);
    }

    //    Ship(Field field, int length, String identifier, boolean vertical, int X, int Y) {
//        this(field, length, identifier);
//
//
//        this.place(vertical, X, Y);
//    }
    String[][] init(String[][] field) {
//        field
        this.place();
        if (this.crossing(field)){
            System.out.println("DUPE!!!!!");
            this.place();
        }
        return this.addShiptoField(field);
    }

    void place(boolean vertical, int X, int Y) {
        this.vertical = vertical;
        this.X = X;
        this.Y = Y;
    }

    void place() {
        boolean vertical = Math.random() < 0.5;
        int randomX, randomY;
        if (vertical) {
            randomX = (int) (Math.random() * ((this.dimension - 1 - this.length) + 1)) + 0;
            randomY = (int) (Math.random() * ((this.dimension - 1) + 1)) + 0;
        } else {
            randomX = (int) (Math.random() * ((this.dimension - 1) + 1)) + 0;
            randomY = (int) (Math.random() * ((this.dimension - 1 - this.length) + 1)) + 0;
        }

        this.place(vertical, randomX, randomY);

//        System.out.println(randomX + " " + randomY + " " + vertical);
//        if (outOfBound()) {
//            System.out.println("fail");
//            this.place();
////            this.place(vertical, randomX, randomY);
//        } else {
//            System.out.println("success");
//            this.place(vertical, randomX, randomY);
//        }
    }

    void printStatus() {
        System.out.println(this.health);
    }

    void takeHit(int X, int Y) {
        System.out.println("TAKEN HIT AT " + X + ", " + Y);
        int hit;
        if (this.vertical) {
            hit = Y - this.Y;
        } else {
            hit = X - this.X;
        }
        health.setCharAt(hit, 'x');
        System.out.println("SHIP HIT AT " + hit + " OUT OF " + this.length);
        printStatus();
    }

    boolean checkDeath() {
        if (health.toString().contains(this.identifier)) {
            System.out.println("SHIP NOT DESTROYED");
            return false;
        } else {
            System.out.println("SHIP DESTROYED");
            return true;
        }
    }

    String[][] markDead(String[][] field) {
        if (this.vertical) {
            for (int i = this.Y; i < this.length + 1; i++) {
                field[X][i] = "X";
            }
        } else {
            for (int i = X; i < this.length + 1; i++) {
                field[i][Y] = "X";
            }
        }
        return field;
    }

    void printField(String[][] field) {
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

    // CHECK IF [][] OCCUPIED
    boolean crossing(String[][] field) {
        boolean found = false;
        if (vertical) {
            for (int i = X; i < this.length + X; i++) {
                if (field[i][this.Y] != "-") {
                    System.out.println(field[i][this.Y]);
                    found = true;
                    break;
                }
            }
            if (found)
            return true;
        } else if (!vertical) {
            for (int i = Y; i < this.length + Y; i++) {
                if (field[this.X][i] != "-") {
                    System.out.println(field[i][this.Y]);
                    found = true;
                    break;
                }
                if (found)
                    return true;
            }
        } else {
            return false;
        }
        return false;
    }
//  Add to Field and return
    String[][] addShiptoField(String[][] field) {
//        this.printField(field)
        System.out.println(this.X + " " + this.Y);

//        if (vertical) {
//            boolean alreadyPlaced = false;
//            for (int i = X; i < this.length + X; i++) {
//                if (field[i][this.Y] != "-") {
//                    alreadyPlaced = true;
//                    System.out.println("FAIL");
//                    this.place();
//                    this.addShiptoField(field);
////                    break;
//                }
//            }
        if (vertical) {
            for (int i = X; i < this.length + X; i++) {
                field[i][this.Y] = this.identifier;
            }
        }

        if (!vertical) {
            for (int i = Y; i < this.length + Y; i++) {
                field[this.X][i] = this.identifier;
            }

        }

        return field;

    }

   void printShipPosition() {
        String[][] field = Field.emptyField();
        if (vertical) {
            for (int i = X; i < this.length + X; i++) {
                field[i][this.Y] = this.identifier;
            }
        }

        if (!vertical) {
            for (int i = Y; i < this.length + Y; i++) {
                field[this.X][i] = this.identifier;
            }

        }
        this.printField(field);

    }
//    boolean outOfBound() {
////        System.out.println("BOUNDS, X: " + (this.X + this.length) + " Y: " + (this.Y + length));
//        if (!this.vertical){
//            int bah = this.X + this.length;
//            System.out.println("VERT" + bah);}
//        else {
//            int bah = this.Y + this.length;
//            System.out.println("HOR" + bah);
//        }
//        if ( !this.vertical && (this.X + this.length) < (this.dimension)){
////                || this.Y + length < this.dimension) {
//
//
//            System.out.println("TOO BIG X");
//            return true;
//        }
//        if ( this.vertical && (this.Y + this.length) < (this.dimension)){
//            System.out.println("TOO BIG Y");
//            return true;
//        }
//        else
//            System.out.println("GOOD SIZE");
//            return false;
//    }
}
