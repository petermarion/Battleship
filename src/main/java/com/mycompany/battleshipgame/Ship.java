package com.mycompany.battleshipgame;

import com.mycompany.battleshipgame.Board;
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PeterMarion
 */

//All code is transfered from eclipse

public class Ship {
    int shipID;
    String shipName;
    int shipType;
    int shipSize;
    int shipHits = 0;
    boolean shipSunk = false;
    Tile locationHead;
    char shipDirection;
    Tile location[];
        
        
    public int getShipID() {
	return this.shipID;
    }

    public int getType() {
        return this.shipType;
    }

    public int getSize() {
        return this.shipSize;
    }

    public boolean isSunk() {
        for (Tile tile : location) {		//for all tiles
            if (tile.getStatus() == '-') {	//if one tile is unseen, then not sunk
                return false;
            }
        }
        return true;
    }

    public String getName() {
        return this.shipName;
    }

    public char getDirection() {
        return this.shipDirection;
    }

    public void setDirection(char direction) {
        this.shipDirection = direction;
    }

    public Tile[] getLocation() {
        return this.location;
    }

    public int setLocation(Board board, int row, int col, char direction, Ship ship) {
        ship.setDirection(direction);
        /*
         * return values: 
         * 		0: no error, success
         * 		1: invalid coordinates
         * 		2: not enough space for ship in that direction
         * 		3: ship already in that space
         */

        if (row<0||row>7 || col<0||col>7) {	//invalid coordinates
            return 1;
        }

        if((direction == 'N' && (row - shipSize < 0)) ||
            (direction == 'W' && (col - shipSize < 0)) ||
            (direction == 'S' && (row + shipSize > 8)) ||
            (direction == 'E' && (col + shipSize > 8))) {	//not enough space in that direction
            return 2;
        }



        //check if space is available for a new ship
        int row_offset = 0;
        int col_offset = 0;
        for(int i = 0; i < shipSize; i++) {
            if (board.getTile(row+row_offset, col+col_offset).getShipID() != 0) {	//if tile already contains ship
                return 3;
            }
            if(direction == 'N') {row_offset--;}
            if(direction == 'W') {col_offset--;}
            if(direction == 'S') {row_offset++;}
            if(direction == 'E') {col_offset++;}
        }
        //Now that we know spaces are available, set spaces to filled
        for(int i = 0; i < shipSize; i++) {
            if(direction == 'N') {row_offset++;}
            if(direction == 'W') {col_offset++;}
            if(direction == 'S') {row_offset--;}
            if(direction == 'E') {col_offset--;}
            //update tile
            Tile tile = board.getTile(row+row_offset, col+col_offset);
            tile.setShipID(shipID);
            tile.setShip(ship);
            tile.setForeground(Color.black);    
            tile.setBackground(Color.black);   
            ship.location[i] = tile;    
            System.out.printf("Placed ship\n");
        }

        return 0;
    }
}
