package u5pp;

public class ChessPiece {
    int row;
    int col;
    boolean isWhite;
    ChessPiece board[][];

    public ChessPiece(ChessPiece[][] board, int row, int col, boolean isWhite){
        this.row = row;
        this.col = col;
        this.isWhite = isWhite;
        this.board = board;
    }

    public ChessPiece[][] getBoard(){
        return board;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return col;
    }

    public boolean getIsWhite(){
        return isWhite;
    }
    // checks if bishop can move in direction user inputs
    public boolean canMoveTo(int row, int col){
        if(row < 0 || row > board.length-1){
            System.out.println("out of bounds silly goose");
            return false;
        } else if(col < 0 || col > board[row].length-1){
            System.out.println("out of bounds silly goose");
            return false;
        } else if (board[row][col] != null){
            if(board[row][col].isWhite == board[this.row][this.col].isWhite){
                System.out.println("dont hurt your friends");
                return false;
            }
        }
        System.out.println("looks good boss no problem here");
        return true;

    }   
    //makes sure it can make the move diagonally 
    public boolean clearDiagnal(int row, int col){
        System.out.println("entering clearDiagnal at" + row +" " + col);
        int colcnt = 1;
        int rowcnt = 1;
        if(row > this.row){
            if(col > this.col){
                for( int i = this.row; i < row -1; i++ ){
                    if(board[row - rowcnt][col - colcnt] != null){
                        
                        System.out.println("in here row>this.row");
                        return false;
                    }
                    colcnt+=1;
                    rowcnt+=1;
                }
            } else{
                for(int i =this.row; i < row -1; i++){
                    if(board[row -rowcnt][col + colcnt] !=null){
                        System.out.println("row>this.row & else");
                        return false;
                    }
                    colcnt+=1;
                    rowcnt+=1;
                }
            }
        } else{
            if(col < this.col){
                for(int i = row; i < this.row-1; i++){
                    if(board[row + rowcnt][col + colcnt] != null){
                        System.out.println(i);
                        System.out.println(row + " " + rowcnt + " " + col + " " + colcnt);
                        System.out.println("in : else col < this.col");
                        return false;
                    }
                    colcnt +=1;
                    rowcnt +=1;
                }
            }else {
                for(int i = row; i <this.row-1; i++){
                    if(board[row+rowcnt][col -colcnt] != null){
                        System.out.println("in else else");
                        return false;
                    }
                    colcnt +=1;
                    rowcnt +=1;
                }
            }
        }
        return true;
    }
    //checks for moves that are horizontal and vertical. if not, returns false
    public boolean clearHorNVert(int row, int col){
        if(this.row == row && this.col != col){
            if(col > this.col){
                for(int i = col ; i < this.col; i++ ){
                    if(board[this.row][i] != null){
                        System.out.println("111");
                        return false;
                    }
                }
            }else{
                for(int i = col +1 ; i < this.col ; i++){
                    if(board[this.row][i] != null){
                        System.out.println("118");
                        return false;
                    }
                }
            }
        } else{
            if(row > this.row){
                for(int i = this.row +1; i < row; i++){
                    if(board[i][this.col] != null){
                        System.out.println("127");
                        return false;
                    }
                }
            }else{
                for(int i = row +1; i < this.row; i++){
                    if(board[i][this.col] != null){
                        System.out.println("134");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void moveTo(int row, int col){
        if(canMoveTo(row, col) == true){
            board[row][col] = board[this.row][this.col];
            board[this.row][this.col] = null;
            this.row = row;
            this.col = col;
        }
    }

    public String toString(){
        return isWhite ? "O" : "o";
    }
}
