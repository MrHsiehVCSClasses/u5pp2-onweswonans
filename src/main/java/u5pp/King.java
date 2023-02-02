package u5pp;

public class King extends ChessPiece {

    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
        // checks if bishop can move in direction user inputs
    public boolean canMoveTo(int row, int col){
        if(super.canMoveTo(row, col) == true){
            if(movingNextToKing(row, col) == true){
                if(row == this.row - 1 || row == this.row + 1 || col == this.col - 1 || col == this.col + 1){
                    return true;
                }
                return false;
            }
        }
        return false;

    }

    private boolean movingNextToKing( int row, int col){
        return true;
    }

    public void moveTo(int row, int col){
        board[row][col] = board[this.row][this.col];
        board[this.row][this.col] = null;
        this.row = row;
        this.col = col;
}
    
    
    public String toString(){
        return isWhite == true ? "K" : "k";
    }
}
