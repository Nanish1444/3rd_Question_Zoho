import java.util.*;

class Game {
    char[][] board;
    int bombRow=-1;
    int bombCol=-1;
    int prevRow=0;
    int prevCol=0;
    int row;
    int col;
    Game(int mapsize){
        board=new char[mapsize][mapsize];
        initialzeBoard();
    }

    private void initialzeBoard(){
        //make a  row and col as a alphabet
        for(int i=1;i<board[0].length;i++){
            board[0][i]=(char)((i-1)+'A');
        }
        for(int i=1;i<board.length;i++){
            board[i][0]=(char)((i-1)+'A');
        }
        // print wall around a board
        for(int i=1;i<board.length;i++){
            for(int j=1;j<board.length;j++){
                if(i==1||j==1||i==board.length-1||j==board[0].length-1){
                    board[i][j]='*';
                }
            }
        }

        // place a walls
        for(int i=3;i<board.length;i+=2){
            for(int j=3;j<board[i].length;j+=2){
                board[i][j]='*';
            }
        }


    }
    public void printBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void place(char start,char end,char obj){
        if(obj=='P'){
            row=1+start-'A';
            col=1+end-'A';
        }
        board[1+start-'A'][1+end-'A']=obj;
    }
    public char movePlayer(char in){
        if(in=='W'){
            if(row-1>=0 && board[row-1][col]=='V'){
                return 'D';
            }
            if(row-1>=0 && board[row-1][col]=='K'){
                return 'W';
            }
            if(row-1>=0 && board[row-1][col]!='*' && board[row-1][col]!='B'){
                board[row-1][col]='P';
                board[row][col]=' ';
                prevRow=row;
                prevCol=col;
                row-=1;
            }
        }
        else if(in=='S'){
             if(row+1>0 && board[row+1][col]=='V'){
                return 'D';
            }
            if(row+1>0 && board[row+1][col]=='K'){
                return 'W';
            }
            if(row+1<board.length-1 && board[row+1][col]!='*' && board[row+1][col]!='B'){
                board[row+1][col]='P';
                board[row][col]=' ';
                prevRow=row;
                prevCol=col;
                row+=1;
            }
        }
        else if(in=='D'){
             if(col+1<board.length-1 && board[row][col+1]=='V'){
                return 'D';
            }
            if(col+1<board.length-1 && board[row][col+1]=='K'){
                return 'W';
            }
            if(col+1<board.length-1 && board[row][col+1]!='*' && board[row][col+1]!='B'){
                board[row][col+1]='P';
                board[row][col]=' ';
                prevCol=col;
                prevRow=row;
                col+=1;
            }
        }
        else if(in=='A'){
            if(col-1>0 && board[row][col-1]=='V'){
                return 'D';
            }
            if(col-1>0 && board[row][col-1]=='K'){
                return 'W';
            }
            if(col-1>0 && board[row][col-1]!='B' && board[row][col-1]!='*'){
                board[row][col-1]='P';
                board[row][col]=' ';
                prevCol=col;
                prevRow=row;
                col-=1;
            }
        }
        else if(in=='Z'){
            if(row+1<board.length && col-1>0 && board[row+1][col-1]=='V'){
                return 'D';
            }
            if(row+1<board.length && col-1>0 && board[row+1][col-1]=='K'){
                return 'W';
            }
            if(row+1<board.length && col-1>0 && board[row+1][col-1]!='B' && board[row+1][col-1]!='*'){
                board[row+1][col-1]='P';
                board[row][col]=' ';
                prevRow=row;
                prevCol=col;
                row+=1;
                col-=1;
            }
        }
        else if(in=='X'){
            if(row+1<board.length && col+1<board[0].length && board[row+1][col+1]=='V'){
                return 'D';
            }
            if(row+1<board.length && col+1<board[0].length && board[row+1][col+1]=='K'){
                return 'W';
            }
            if(row+1<board.length && col+1<board[0].length && board[row+1][col+1]!='B' && board[row+1][col+1]=='*'){
                board[row+1][col+1]='P';
                board[row][col]=' ';
                prevRow=row;
                prevCol=col;
                row+=1;
                col+=1;
            }
        }
        else if(in=='Q'){
            if(row-1>0 && col-1<board[0].length && board[row-1][col-1]=='V'){
                return 'D';
            }
            if(row-1>0 && col-1<board[0].length && board[row-1][col-1]=='K'){
                return 'W';
            }
            if(row-1>0 && col-1<board[0].length && board[row-1][col-1]!='B'&& board[row-1][col-1]!='*'){
                board[row-1][col-1]='P';
                board[row][col]=' ';
                prevRow=row;
                prevCol=col;
                row-=1;
                col-=1;
            }
        }
        else if(in=='E'){
            if(row-1>0 && col+1<board[0].length && board[row-1][col+1]=='V'){
                return 'D';
            }
            if(row-1>0 && col+1<board[0].length && board[row-1][col+1]=='K'){
                return 'W';
            }
            if(row-1>0 && col+1<board[0].length && board[row-1][col+1]!='B'&& board[row-1][col+1]!='*'){
                board[row-1][col+1]='P';
                board[row][col]=' ';
                prevCol=col;
                prevRow=row;
                row-=1;
                col+=1;
            }

        }
        return ' ';
    }
    public void plantBomb(int in){
        if(in==1){
            board[row][col]='O';
            board[prevRow][prevCol]='P';
            bombRow=row;
            bombCol=col;
            row=prevRow;
            col=prevCol;
        }
        else if(in==2){
            if(bombRow==-1 && bombCol==-1){
                System.out.println("No Bomb detected");
                return;
            }
            if(bombRow-1>=0 && (board[bombRow-1][bombCol]=='V'||board[bombRow-1][bombCol]=='B')){
                board[bombRow-1][bombCol]=' ';
                board[bombRow][bombCol]=' ';
                bombRow=-1;
                bombCol=-1;
            }
            if(bombRow+1>0 && (board[bombRow+1][bombCol]=='V' || board[bombRow+1][bombCol]=='B')){
                board[bombRow+1][bombCol]=' ';
                board[bombRow][bombCol]=' ';
                bombRow=-1;
                bombCol=-1;
            }
            if(bombCol+1<board.length-1 && (board[bombRow][bombCol+1]=='V' || board[bombRow][bombCol+1]=='B')){
                board[bombRow][bombCol+1]=' ';
                board[bombRow][bombCol]=' ';
                bombRow=-1;
                bombCol=-1;
            }
             if(bombCol-1>0 && (board[bombRow][bombCol-1]=='V' || board[bombRow][bombCol-1]=='B')){
                board[bombRow][bombCol-1]=' ';
                board[bombRow][bombCol]=' ';
                bombRow=-1;
                bombCol=-1;
            }
           
        }
    }
}
