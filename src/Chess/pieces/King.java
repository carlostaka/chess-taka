/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess.pieces;

import Chess.ChessPiece;
import Chess.Color;
import boardgame.Board;

/**
 *
 * @author carlos
 */
public class King extends ChessPiece{

    public King(Color color, Board board) {
        super(color, board);
    }
    
    @Override
    public String toString(){
        return "K";
    }
    
}
