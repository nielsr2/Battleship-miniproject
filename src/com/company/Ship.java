package com.company;

public class Ship {
    int length;
    StringBuilder health = new StringBuilder("");
    boolean vertical, dead;
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
        this.place();
        System.out.println("dimension"+ dimension +" length: " + length + " identifier: " + identifier + " vertical " + vertical + " X: " + X + " Y: " + Y);
    }

    Ship(Field field, int length, String identifier, boolean vertical, int X, int Y) {
        this(field, length, identifier);


        this.place(vertical, X, Y);
    }

    void place(boolean vertical, int X, int Y) {
        this.vertical = vertical;
        this.X = X;
        this.Y = Y;
    }

    void place() {
        boolean vertical = Math.random() < 0.5;
        int randomX = (int) (Math.random() * ((this.dimension - 1) + 1)) + 0;
        int randomY = (int) (Math.random() * ((this.dimension - 1) + 1)) + 0;

        System.out.println(randomX + " " + randomY + " " + vertical);
        if (outOfBound()) {
            System.out.println("fail");
            this.place();
//            this.place(vertical, randomX, randomY);
        } else {
            System.out.println("success");
            this.place(vertical, randomX, randomY);
        }
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

    String[][] addShiptoField(String[][] field) {
        System.out.println(this.X + " " + this.Y);
        if (vertical) {
            for (int i = X; i < this.length + X; i++) {
                field[i][this.Y] = this.identifier;
            }
        } else {
            for (int i = Y; i < this.length + Y; i++) {
                field[this.X][i] = this.identifier;
            }
        }

        return field;

    }

    boolean outOfBound() {
//        System.out.println("BOUNDS, X: " + (this.X + this.length) + " Y: " + (this.Y + length));
        if (!this.vertical){
            int bah = this.X + this.length;
            System.out.println("VERT" + bah);}
        else {
            int bah = this.Y + this.length;
            System.out.println("HOR" + bah);
        }
        if ( !this.vertical && (this.X + this.length) < (this.dimension)){
//                || this.Y + length < this.dimension) {


            System.out.println("TOO BIG X");
            return true;
        }
        if ( this.vertical && (this.Y + this.length) < (this.dimension)){
            System.out.println("TOO BIG Y");
            return true;
        }
        else
            System.out.println("GOOD SIZE");
            return false;
    }
}
