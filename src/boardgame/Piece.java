/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardgame;

/**
 *
 * @author carlos
 */
public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
    
    public abstract boolean[][] possibleMoves();
    
    public boolean possibleMoves(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    
    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMoves();
        for (boolean[] mat1 : mat) {
            for (int j = 0; j<mat.length; j++) {
                if (mat1[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
