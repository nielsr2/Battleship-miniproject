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

import javax.swing.JFrame;


public class Battleship extends JFrame {
    Player[] players = new Player[2];
    Screen screen;
    KeyListener kl;
    boolean cursor = true;
    Battleship() {
        System.out.print("PLAYER ONE :");
        Scanner sc = new Scanner(System.in);
        players[0] = new Player(sc.next());
        System.out.print("HELLO" + players[0].name + "PUT IN YOUR SHIPS");
        players[0].field.placeShipsRoutine();


    }

}


