
public class TicTacToeTest {
	public static void main(String[] args) {
		TicTacToe ticTacToe = new TicTacToe();
		boolean success =  ticTacToe.playTicTacToe();
		while(!success) {
			System.out.println("Enter error, please try again.");
			success =  ticTacToe.playTicTacToe();
		}
	}
}
