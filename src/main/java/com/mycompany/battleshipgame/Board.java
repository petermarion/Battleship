package com.mycompany.battleshipgame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PeterMarion
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Board {
    int userID;
    Tile tiles[][];

    public Board(int userID) {
        this.userID = userID;
        this.tiles = new Tile[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile newtile = new Tile(i, (char)(j+65));
                //newtile.setRow(i);
                //newtile.setCol((char)(j+65));
                this.tiles[i][j] = newtile;
            }
        }
    }

    public void enable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tiles[i][j].setEnabled(true);
            }
        } 
    }
    
    public void disable() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.tiles[i][j].setEnabled(false);
            }
        } 
    }
    
    public int getID() {
        return this.userID;
    }

    public Tile getTile(int row, int col) {
        return this.tiles[row][col];
    }

    public void setTile(int row, int col, Tile tile) {
        this.tiles[row][col] = tile;
    } 
    
    //setChoice()
    
    public ArrayList<Ship> setRandom() {
        Random rand = new Random();
        int row;
        int col;
        int dir;
        char directions[] = {'N', 'S', 'E', 'W'};
        ArrayList<Ship> ships = new ArrayList<>();

        //set carrier location
        Ship carrier = new AircraftCarrier(1);
        ships.add(carrier);
        do {
            row = rand.nextInt(8);
            col = rand.nextInt(8);
            dir = rand.nextInt(4);
        } while (carrier.setLocation(this, row, col, directions[dir], carrier) != 0);

        //set battleship location
        Ship battleship = new Battleship(2);
        ships.add(battleship);
        do {
            row = rand.nextInt(8);
            col = rand.nextInt(8);
            dir = rand.nextInt(4);
        } while (battleship.setLocation(this, row, col, directions[dir], battleship) != 0);

        //set cruiser location
        Ship cruiser = new Cruiser(3);
        ships.add(cruiser);
        do {
            row = rand.nextInt(8);
            col = rand.nextInt(8);
            dir = rand.nextInt(4);
        } while (cruiser.setLocation(this, row, col, directions[dir], cruiser) != 0);

        //set submarine location
        Ship submarine = new Submarine(4);
        ships.add(submarine);
        do {
            row = rand.nextInt(8);
            col = rand.nextInt(8);
            dir = rand.nextInt(4);
        } while (submarine.setLocation(this, row, col, directions[dir], submarine) != 0);

        //set destroyer location
        Ship destroyer = new Destroyer(5);
        ships.add(destroyer);
        do {
            row = rand.nextInt(8);
            col = rand.nextInt(8);
            dir = rand.nextInt(4);
        } while (destroyer.setLocation(this, row, col, directions[dir], destroyer) != 0);


        return ships;
    }
}

