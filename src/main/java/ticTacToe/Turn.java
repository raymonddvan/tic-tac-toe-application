/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author raymo
 */
public class Turn {
    private String turn;
    private int numberOfTurns;
    
    public Turn() {
        this.turn = "X";
    }
    
    public void switchTurns() {
    	this.numberOfTurns++;
        if (this.turn.equals("X")) {
            this.turn = "O";
            return;
        }
        this.turn = "X";
    }
    
    public String getTurn() {
        return this.turn;
    }
    
    public void resetTurn() {
    	this.numberOfTurns = 0;
    	this.turn = "X";
    }
    
    public int getNumberOfTurns () {
    	return this.numberOfTurns;
    }
 }
