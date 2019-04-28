package com.company;

public class Player {
    Field field;

    Player() {
        field = new Field(10);
//        this.defaultShips();
        this.field.setRandomShips();
//        fire(1,1);
//        fire(0,0);
//        fire(1,2);
//        fire(1,3);
//        fire(1,4);
//        fire(1,5);

    }
    void defaultShips(){
//        this.field.ships = new Ship[5];
//        this.field.ships[0] = new Ship(2, "1");
//        this.field.placeShip(this.field.ships[0],true, 1,1);
////        this.field.ships[0] = new Ship(2, "1");
//        this.field.placeShip(this.field.ships[0],true, 1,1);

    }
    void fire(int x, int y) {
    field.checkFire(x,y);
    }
}



