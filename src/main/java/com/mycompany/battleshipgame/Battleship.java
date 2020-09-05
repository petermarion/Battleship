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
public class Battleship extends Ship{
    
    public Battleship(int shipID) {		//constructor
        this.shipID = shipID;
        shipType = 2;
        shipSize = 4;
        location = new Tile[4];
        shipName = "Battleship";
    }
}
