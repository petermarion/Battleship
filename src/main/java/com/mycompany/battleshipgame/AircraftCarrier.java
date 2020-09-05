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
public class AircraftCarrier extends Ship {
    
    public AircraftCarrier(int shipID) {		//constructor
        this.shipID = shipID;
        shipType = 1;
        shipSize = 5;
        location = new Tile[5];
        shipName = "Carrier";
    }
}
