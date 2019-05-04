package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;

import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminal;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;




public class Battleship {
    Player[] players = new Player[2];
    Screen screen;


    boolean cursor = true;
    Battleship() {
        System.out.print("PLAYER ONE :");
        Scanner sc = new Scanner(System.in);
        players[0] = new Player(sc.next());
        System.out.println("Hello " + players[0].name + "");
        Player p1 = players[0];
        Field p1f = p1.field;
        p1.field.ships[0] = new Ship(p1f, 2, "2");
        p1f.fieldArray = p1f.ships[0].placeShipByInput(p1f.fieldArray);
        p1.field.ships[0] = new Ship(p1f, 3, "3");
        p1f.fieldArray = p1f.ships[0].placeShipByInput(p1f.fieldArray);


    }

}


