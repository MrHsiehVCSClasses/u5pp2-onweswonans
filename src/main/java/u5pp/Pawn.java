package u5pp;

public class Pawn extends ChessPiece{
    public boolean isFirstMove;
    Pawn(ChessPiece board[][], int row, int col, boolean isWhite){
        super(board, row, col, isWhite);
        isFirstMove = true;
    }
    

    public boolean canMoveTo(int row, int col) {
        if(super.canMoveTo(row, col) == true){
            if(board[this.row][this.col].isWhite == true && row == this.row +1 || board[this.row][this.col].isWhite == false && row == this.row -1){
                System.out.println("not moving backwards");
                if(col == this.col + 1 || col == this.col - 1){
                    System.out.println("is entering attack mode");
                    if(board[row][col] == null){
                        return false;
                    } else if(board[row][col].isWhite == board[this.row][this.col].isWhite){
                        return false;
                    }
                    return true;
                }
                if(board[row][col] != null){
                    System.out.println("you are cripple, cant attack front");
                    return false;
                }
                System.out.println("gooda");
                return true;
            } else if(board[this.row][this.col].isWhite == true && row == this.row +2 && isFirstMove == true || board[this.row][this.col].isWhite == false && row == this.row -2 && isFirstMove == true){
                if(board[row][col] != null){
                    System.out.println("you are cripple, cant attack front");
                    return false;
                }
                System.out.println("good");
                return true;

            }
                System.out.println("is moving backwards naughty boi");
            return false;
        }
        return false;
}

public void moveTo(int row, int col){
        isFirstMove = false;
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
}










    public String toString(){
        return isWhite == true ? "P" : "p";
    }
}
