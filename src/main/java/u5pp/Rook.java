package u5pp;

public class Rook extends ChessPiece {

    public Rook(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }

    public boolean canMoveTo(int row, int col){
        if(super.canMoveTo(row, col) == true){
            if(row == this.row && col != this.col){
                if(clearHorNVert(row, col) == true){
                    return true;
                }
                return false;
            } else if (row != this.row && col == this.col){
                if(clearHorNVert(row, col) == true){
                    return true;
                }
                return false;
            }
            return false;
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
        return isWhite == true ? "R" : "r";
    }
}