/*
Author: Tenny Akihary
Class: CSC 191
Project Lab 5
Purpose: To allow two users to play tic, tac, toe using a 2D array.
 */
package tennyakiharylab5;
import java.util.Scanner;
public class TennyAkiharyLab5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean gameover = true; //to quit the program/game loop
        String again;
        //player win values, count for turn switching, and for row and column input
        int px = 0, po = 0, cnt = 1, rin = 0, cin = 0;
        System.out.println("                          TIC!");
        System.out.println("                              TAC!");
        System.out.println("                                  TOE!");
        System.out.println("                         ***WARNING***");
        System.out.println("***If you place your X or O in a used space, the game will end!***");
        System.out.println("     ***If this happens you will get a chance to restart.***");
        //Create loop for endless play until prompted otherwise
        do{
            //create the array to hold x / o char values
            char[][] ttt = new char[3][3];
            ttt = reset(ttt);
            do{
                printTurn(ttt);
                if(cnt == 1){
                    System.out.print("              Enter a row(1, 2, 3) for player X: ");
                    rin = in.nextInt();
                    System.out.print("              Enter a column(1, 2, 3) for player X: ");
                    cin = in.nextInt();
                    if(ttt[rin-1][cin-1] != ' '){
                        System.out.println("SPACE WAS USED....ENDING GAME.");
                        break;
                    }
                    ttt[rin-1][cin-1] = 'X';
                    cnt--;
                } else {
                    System.out.print("              Enter a row(1, 2, 3) for player O: ");
                    rin = in.nextInt();
                    System.out.print("              Enter a column(1, 2, 3) for player O: ");
                    cin = in.nextInt();
                    if(ttt[rin-1][cin-1] != ' '){
                        System.out.println("SPACE WAS USED....ENDING GAME.");
                        break;
                    }
                    ttt[rin-1][cin-1] = 'O';
                    cnt++;
                }
                
                int t = isWinner(ttt);
                if(t == 1){
                    System.out.println("X is the winner!");
                    px++;
                    gameover = false;
                } else if(t == 2){
                    System.out.println("O is the winner!");
                    po++;
                    gameover = false;
                }
                
                
            }while(gameover);
            
            System.out.print("Play another game?(y/n): ");
            again = in.next();
            
        }while(again.charAt(0) != 'n');
        
        System.out.println("Thank you for playing!");
        System.out.println("X player has won "+px+" times. O player won "+po+" times.");
    }
    
    //method to print the board
    public static void printTurn(char[][] a){
        System.out.print("                      -------------------");
        System.out.println("");
        for (int r = 0; r < a.length; r++) {
            System.out.print("                      |  ");
            for (int c = 0; c < a[r].length; c++) {
                System.out.printf("%1s", a[r][c]);
                System.out.print("  |  ");
            }
            System.out.println();
            System.out.print("                      -------------------");
            System.out.println();
        }
    }
    
    public static char[][] reset(char[][] a){
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                a[r][c] = ' ';
            }
        }
        return a;
    }
    
    //method to check 3 of a kind
    public static int isWinner(char[][] a){
        int t = 0;
        
        //check horizontally
        if((a[0][0] == a[0][1] && a[0][0] == a[0][2])&& a[0][0] != ' '){
            if(a[0][0] == 'X')
                t = 1;
            else
                t = 2;
        }
        if((a[1][0] == a[1][1] && a[1][0] == a[1][2])&& a[1][2] != ' '){
            if(a[1][0] == 'X')
                t = 1;
            else
                t = 2;
        }
        if((a[2][0] == a[2][1] && a[2][0] == a[2][2])&& a[2][2] != ' '){
            if(a[2][0] == 'X')
                t = 1;
            else
                t = 2;
        }
        
        //check virtically
        if((a[0][0] == a[1][0] && a[0][0] == a[2][0])&& a[0][0] != ' '){
            if(a[0][0] == 'X')
                t = 1;
            else
                t = 2;
        }
        if((a[0][1] == a[1][1] && a[0][1] == a[2][1])&& a[0][1] != ' '){
            if(a[0][1] == 'X')
                t = 1;
            else
                t = 2;
        }
        if((a[0][2] == a[1][2] && a[0][2] == a[2][2])&& a[0][2] != ' '){
            if(a[0][2] == 'X')
                t = 1;
            else
                t = 2;
        }
        
        //check diagonally
        if((a[0][0] == a[1][1] && a[0][0] == a[2][2])&& a[0][0] != ' '){
            if(a[0][0] == 'X')
                t = 1;
            else
                t = 2;
        }
        if((a[0][2] == a[1][1] && a[1][1] == a[2][0])&& a[0][2] != ' '){
            if(a[0][2] == 'X')
                t = 1;
            else
                t = 2;
        }
        
        return t;
    }
}
