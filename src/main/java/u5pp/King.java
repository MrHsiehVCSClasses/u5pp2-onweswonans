package u5pp;

public class King extends ChessPiece {

    public King(ChessPiece[][] board, int row, int col, boolean isWhite) {
        super(board, row, col, isWhite);
    }
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

    private boolean movingNextToKing(int row, int col){
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j<board.length ; j++){
                if((board[i][j].toString().equals("k") || board[i][j].toString().equals("K")) && board[i][j] != board[this.row][this.col]){
                    
                }
            }
        }
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
