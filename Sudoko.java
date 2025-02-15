class Solution {
    public static boolean isValid(char b[][],int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(b[row][i]==ch)return false;
            if(b[i][col]==ch)return false;
            if(b[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==ch)return false;
        }
        return true;
    }
    public static boolean sudoko(char board[][]){
        for(int row=0;row<9;row++){
            for(int col=0;col<9;col++){
                if(board[row][col]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(board,row,col,ch)){
                            board[row][col]=ch;
                            if(sudoko(board)){
                                return true;
                            }
                            else{
                                board[row][col]='.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        sudoko(board);
    }
}