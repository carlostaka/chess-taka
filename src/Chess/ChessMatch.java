/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

import Chess.pieces.King;
import Chess.pieces.Rook;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

/**
 *
 * @author carlos
 */
public class ChessMatch {
    private Board board;
    
    public ChessMatch(){
        board = new Board(8, 8);
        initialSetup();
    }
    
    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++){
            for (int j = 0; j < board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
    
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturePiece = makeMove(source, target);
        return (ChessPiece)capturePiece;
    }
    
    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }
    
    private void validateSourcePosition(Position position){
        if(!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }
        if (!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
    }
    
    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }
    
    private void initialSetup(){
        
        placeNewPiece('C',1, new Rook(Color.WHITE, board));
        placeNewPiece('C',2 ,new Rook(Color.WHITE, board));
        placeNewPiece('D',2,new Rook(Color.WHITE, board));
        placeNewPiece('E',2, new Rook(Color.WHITE, board));
        placeNewPiece('E',1 ,new Rook(Color.WHITE, board));
        placeNewPiece('D',1,new King(Color.WHITE, board));
        
        placeNewPiece('C',7, new Rook(Color.BLACK, board));
        placeNewPiece('C',8 ,new Rook(Color.BLACK, board));
        placeNewPiece('D',7,new Rook(Color.BLACK, board));
        placeNewPiece('E',7, new Rook(Color.BLACK, board));
        placeNewPiece('E',8 ,new Rook(Color.BLACK, board));
        placeNewPiece('D',8,new King(Color.BLACK, board));
        
        
    } 
    
}
