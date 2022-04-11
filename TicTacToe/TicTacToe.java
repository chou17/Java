import java.util.Scanner;

enum XO {
	X, O, EMPTY
};

class TicTacToe {
	private XO[][] board;
	private Scanner input = new Scanner(System.in);

	//constructor
	public TicTacToe() {
		this.board = new XO[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) 
				board[i][j] = XO.EMPTY;
		}
	}

	//To play game
	public boolean playTicTacToe() {
		System.out.print("Do you(X player) want to do first or second?(Please enter first or second): ");
		String firstOrSecond = input.nextLine();
		if(firstOrSecond.compareTo("first") != 0 && firstOrSecond.compareTo("second") != 0) 
			return false;
		// first or second play
		boolean isFirst = false;
		if (firstOrSecond.compareTo("first") == 0) {
			System.out.print("Player X go first.");
			isFirst = true;
		}
		else
			System.out.print("Player O go first.");
		
		for (int move = 0; move < 9; move++) {
			// first or second play
			if (isFirst) {
				if(move % 2 == 0) 
				    selectPosition(XO.X);
				else 
					selectPosition(XO.O);
			}
			else {
				if(move % 2 == 0) 
				    selectPosition(XO.O);
				else 
					selectPosition(XO.X);
			}
			
			printBoard();
			// Check who is winner 
			if(move>4) {// at least 5 move for first player to win
			    if (winner() != XO.EMPTY) {
				    System.out.println("\nPlayer " + winner() + " won the game!");
				    return true;
			    }
			}
		}
		
		System.out.println("\nTie!");
		return true;
	}

	//how to print the board
	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[i][j]==XO.EMPTY)
					System.out.print(" ");
				else
				    System.out.print(board[i][j]);
				if (j != 2) 
					System.out.print(" | ");
			}
			System.out.println();
		}
		
	}
	
	 //Select correct position
	 
	private void selectPosition(XO player) {
		boolean correct = false;
		System.out.println("\nPlayer " + player + "  is selecting:");

		while (!correct) {
			//get row
			System.out.print("Please enter the row: ");
			int row = input.nextInt();
			while(row < 0 || row > 2) {
				System.out.println("\nWrong enter, please enter a number between 0 & 2.");
				System.out.print("Please enter the row: ");
				row = input.nextInt();
			}
			//get column
			System.out.print("Please enter the column: ");
			int col = input.nextInt();
			System.out.println();
			while(col < 0 || col > 2){
				System.out.println("\nWrong enter, please enter a number between 0 & 2.");
				System.out.print("Please enter the column: ");
				col = input.nextInt();
				System.out.println();
			}
			//fill
			if (board[row][col] == XO.EMPTY) {
				board[row][col] = player;
				correct = true;
			} 
			//if the position was already filled
			else 
				System.out.println("This position was already filled, please choose another one!");
		}
	}

	public XO winner() {
		// Check horizontal
		for (int row = 0; row < 3; row++) {
			if(board[row][0]==XO.EMPTY)
				continue;
			XO player = board[row][0];
			if(player==board[row][1] && player==board[row][2])
				return player;
		}
		// Check vertical
		for (int col = 0; col < 3; col++) {
			if(board[0][col]==XO.EMPTY)
				continue;
			XO player = board[0][col];
			if(player==board[1][col] && player==board[2][col])
				return player;
		}
		// Check diagonal
		if(board[1][1]!=XO.EMPTY) {
			XO player = board[1][1];
		    if((player==board[0][0] && player== board[2][2]) ||
		       (player==board[0][2] && player == board[2][0]) )
		    	return player;
		}
		return XO.EMPTY;
	}
}