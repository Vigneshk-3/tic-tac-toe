// TIC-TAC-TOE

import java.util.*;

public class main
{
    
    public static String checkWinner(String[] board){
        for(int ind = 0; ind < 8 ; ind++){
            String finish  = null;
            
            switch(ind){
                case 0 :
                    finish = board[0] + board[1] + board[2];
                    break;
                case 1:
                    finish = board[3]+ board[4] + board[5];
                    break;
                case 2:
                    finish = board[6]+ board[7] + board[8];
                    break;
                case 3:
                    finish = board[0]+ board[3] + board[6];
                    break;
                case 4:
                    finish = board[1]+ board[4] + board[7];
                    break;
                case 5:
                    finish = board[2]+ board[5] + board[8];
                    break;
                case 6:
                    finish = board[0]+ board[4] + board[8];
                    break;
                case 7:
                    finish = board[2]+ board[4] + board[6];
                    break;

            }
            if (finish.equals("XXX")){
                return "X";
                
            }
            else if(finish.equals("OOO")) {
                return "O";
            }
            
            for (int pos =0 ; pos<9 ; pos++){ 
                if(!board[pos].equals("X") && !board[pos].equals("O")) {
                    break;
                }
                else if (pos == 8){
                    return "draw";
                }
            }
            
            
        }
        return null;
    }
    
    public static void printBoard(String[] board){
        System.out.println("-------------");
        System.out.println("| " +board[0] + " | " +board[1] +" | "+ board[2] + " |");
        System.out.println("-------------");
        System.out.println("| " +board[3] + " | " +board[4] +" | "+ board[5] + " |");
        System.out.println("-------------");
        System.out.println("| " +board[6] + " | " +board[7] +" | "+ board[8] + " |");
        System.out.println("-------------");
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] board = new String[9]; // X or O
		String turn = "X", winner = null;
		int pos = 0;
		
		for(int i = 0; i<9 ; i++) board[i] = String.valueOf(i+1);
		printBoard(board);
		
		while(winner == null){
		    if(turn.equals("X"))  System.out.print("Player 1, please enter the position: ");
		    else System.out.print("Player 2, please enter the position: ");

		   	pos = sc.nextInt();
		   	
		   	if(!(pos>0 && pos <= 9)) {
		   	    System.out.println("Enter the right postion!! This is invalid");
		   	    continue;
		   	}
		    
		    if(board[pos-1].equals(String.valueOf(pos))) {
		        board[pos - 1] = turn;
		        if(turn == "X"){
		            turn = "O";
		            
		        }
		        else {
		            turn = "X";
		            

		        }
		        printBoard(board);
		        winner = checkWinner(board);
		    }
		    else{
		        System.out.print("The Postion you have entered is already Filled ");
		    }
		}
		
		if(winner.equals("draw")){
		    System.out.print("The game is draw, Thanks for playing!!!");
		    
		}
		else{
		    System.out.print("The Winner is "+ winner);
		}
		
	}
}