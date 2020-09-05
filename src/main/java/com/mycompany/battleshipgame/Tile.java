package com.mycompany.battleshipgame;


import com.mycompany.battleshipgame.Ship;
import java.awt.Color;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PeterMarion
 */
public class Tile extends JButton {
    char status = '-';	//- = UNKNOWN, M = MISS, H = HIT
    int shipID = 0;		//0 if no ship
    int row = -1;
    int col = 'x';
    Ship ship;
    Color defaultColor = Color.BLUE;

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getStatus() {
            return this.status;
    }

    public void setStatus(char status) {
            this.status = status;
    }

    public int getShipID() {
            return this.shipID;
    }

    public void setShipID(int shipID) {
            this.shipID = shipID;
    }

    public int getRow() {
            return this.row;
    }

    public void setRow(int row) {
            this.row = row;
    }

    public char getCol() {
            return (char)this.col;
    }

    public void setCol(char col) {
            this.col = col;
    }

    public Ship getShip() {
            return this.ship;
    }

    public void setShip(Ship ship) {
            this.ship = ship;
    }
    
    public Color getDefaultColor() {
        return this.defaultColor;
    }
    //use to change default color to be reverted to after selecting
    public void setDefaultColor(Color color) {
        this.defaultColor = color;
    }
    
    public void setColor(Color color) {
        this.setBackground(color);
        this.setForeground(color);
    }
    
    //reset color to default color (i.e. blue for ocean, or black for ship)
    public void resetColor() {
        this.setBackground(defaultColor);
        this.setForeground(defaultColor);
    }
    
//    public void initButton() {
//        this.button.setPreferredSize(new java.awt.Dimension(32, 32));
//    }
//    
//    public JButton getButton() {
//        return this.button;
//    }
    
}