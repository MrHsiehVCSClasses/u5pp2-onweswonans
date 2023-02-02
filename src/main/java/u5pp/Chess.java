package u5pp;

import java.util.Scanner;

public class Chess {

    public void play(Scanner scan){
        Scanner my = new Scanner(System.in);
        InputHelper help = new InputHelper(my);
        
        //int[] place = help.getChessLocation("select start location");
        ChessPiece[][] chessBoard = new ChessPiece[8][8];
        //ChessPiece me = new ChessPiece(chessBoard, 1, 2, true);
        ChessPiece player = new Queen(chessBoard, 7, 0, true);
        ChessPiece me2 = new Queen(chessBoard, 0, 0, false);
        //ChessPiece me3 = new ChessPiece(chessBoard, 2, 3, false);
        //ChessPiece me4 = new ChessPiece(chessBoard, 2, 1, false);
        //chessBoard[1][2] = me;
        chessBoard[7][0] = player;
        chessBoard[0][0] = me2;
        //chessBoard[2][3] = me3;
        // chessBoard[2][1] = me4;
        System.out.print(boardToString(chessBoard));

        while(true){
        int[] home = help.getChessLocation("where you gunna move?");
        player.moveTo(home[0], home[1]);
        System.out.print(boardToString(chessBoard));
        }
        //while(getWinner(chessBoard) == 0){

        }




    public static int getWinner(ChessPiece[][] board){
        int oop = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == null){
                    //this does nothing because null is nothing and nothing is nothing so nothing can never be something
                }else if(board[i][j].toString().equals("K")){
                    oop += 1;
                }else if (board[i][j].toString().equals("k")){
                    oop -=1;
                }
            }
        }
        return oop;
    }

    /**
     * Used to print a chess board out.
     */
    public static String boardToString(ChessPiece[][] board) {

        String output = "";
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }
        
        output += "\n";
        output += "  " + "┌───" + "┬───".repeat(7) + "┐";
        output += "\n";
        for(int r = 0; r < board.length; r++) {
            output += (r)+1 + " │";
            for(int c = 0; c < board[r].length; c++) {
                output += " ";
                if(board[r][c] == null) {
                    output += " ";
                } else {
                    output += board[r][c];
                }
                output += " │";
            }
            output += (" " + (r+1));
            output += "\n";
                    
            if(r == board.length-1) {
                output += "  " + "└───" + "┴───".repeat(7) + "┘";
            } else {
                output += "  " + "├───" + "┼───".repeat(7) + "┤";
            }
            output += "\n";
        }
        
        output += " ".repeat(3);

        for(int i = 0; i < 8; i++) {
            output += " " + (char)('a' + i) + "  ";
        }

        return output;
        
    }

}
