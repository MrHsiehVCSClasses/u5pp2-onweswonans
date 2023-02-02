package u5pp;

public class Knight extends ChessPiece {

    public Knight(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
    
    public boolean canMoveTo(int row, int col){
        if(super.canMoveTo(row, col) == true){
            if(java.lang.Math.abs(this.row - row) == 2 && java.lang.Math.abs(this.col - col) == 1){
                return true;
            } else if(java.lang.Math.abs(this.col - col) == 2 && java.lang.Math.abs(this.row - row) == 1){
                return true;
            }
        }
        return false;
    }

    public void moveTo(int row, int col){
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
    }

    public String toString(){
        return isWhite == true ? "N" : "n";
    }
}
