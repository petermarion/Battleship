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
public class Destroyer extends Ship {
    
    public Destroyer(int shipID) {		//constructor
        this.shipID = shipID;
        shipType = 5;
        shipSize = 2;
        location = new Tile[2];
        shipName = "Destroyer";
    }
}
