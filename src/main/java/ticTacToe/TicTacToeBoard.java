/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Button;

/**
 *
 * @author raymo
 */
public class TicTacToeBoard {
    private Button[][] board;
    private String[][] stringBoard;
    private String winner;
    
    public TicTacToeBoard(Button[][] board) {
        this.board = board;
        this.stringBoard = new String[3][3];
    }
    
    public void inputBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                this.stringBoard[row][column] = this.board[row][column].getText();
            }
        }
    }
    
    
    public boolean checkForWin() {
        //check for wins in rows
        for (int row = 0; row < stringBoard.length; row++) {
            String rowWin = "";
            for (int column = 0; column < stringBoard[row].length; column++) {
                rowWin += stringBoard[row][column];
                if (rowWin.equals("XXX")) {
                	this.winner = "X";
                    return true;
                }
                else if (rowWin.equals("OOO")) {
                	this.winner = "O";
                	return true;
                }
            }
        }
        
        //check for wins in columns
        for (int column = 0; column < stringBoard.length; column++) {
            String columnWin = "";
            for (int row = 0; row < stringBoard[column].length; row++) {
                columnWin += stringBoard[row][column];
                if (columnWin.equals("XXX")) {
                	this.winner = "X";
                    return true;
                }
                else if (columnWin.equals("OOO")) {
                	this.winner = "O";
                	return true;
                }
            }
        }
        
        String firstDiagWin = stringBoard[0][0] + stringBoard[1][1] + stringBoard[2][2];
        String secondDiagWin = stringBoard[0][2] + stringBoard[1][1] + stringBoard[2][0];
        
        if (firstDiagWin.equals("XXX") || secondDiagWin.equals("XXX")) {
        	this.winner = "X";
            return true;
        }
        if (firstDiagWin.equals("OOO") || secondDiagWin.equals("OOO")) {
        	this.winner = "O";
            return true;
        }
        
        return false;
    }
    
    public String getWinner() {
    	return this.winner;
    }
    
    public void clearBoard() {
    	for (int i = 0; i < 3; i++) {
    		for (int j = 0; j < 3; j++) {
    			this.board[i][j].setText(" ");
    			this.stringBoard[i][j] = " ";
    		}
    	}
    }
    
}
