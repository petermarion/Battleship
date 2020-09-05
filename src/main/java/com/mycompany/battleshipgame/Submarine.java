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
public class Submarine extends Ship {
    public Submarine(int shipID) {		//constructor
        this.shipID = shipID;
        shipType = 4;
        shipSize = 3;
        location = new Tile[3];
        shipName = "Submarine";
    }
}
