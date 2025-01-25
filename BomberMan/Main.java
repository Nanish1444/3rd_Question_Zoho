import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game bomber = new Game(12);
        bomber.place('F','H','P');
        bomber.place('J','J','K');
        bomber.place('D','G','V');
        bomber.place('H','I','V');
        bomber.place('B','B','B');
        bomber.place('F','I','B');
        bomber.printBoard();
        System.out.println();

        //Play 
        boolean play = true;

        while(play){
            System.out.println("Enter your Move : ");
            char move=scan.next().charAt(0);
            char nextMove=bomber.movePlayer(move);
            if(nextMove=='D'){
                System.out.println("Player is Death");
                break;
            }
            else if(nextMove=='W'){
                System.out.println("Player win the game");
                break;
            }
            else if(move=='M'){
                System.out.println("Press 1 Plant Bomb");
                System.out.println("Press 2 Blast Bomb");
                int bomb=scan.nextInt();
                bomber.plantBomb(bomb);
            }
            bomber.printBoard();
        }
    }
}