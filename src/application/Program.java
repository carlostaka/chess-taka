/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import Chess.ChessMatch;
import boardgame.Board;

/**
 *
 * @author carlos
 */
public class Program {
    public static void main (String [] args){
        Chess.ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
