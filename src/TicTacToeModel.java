/**
 * The model behind a simple TicTacToe game
 * @author Gabrielle
 *
 */
public class TicTacToeModel 
{
	private static final int SIZE = 3;
	private char board[][];
	private boolean turnPlayer1;
	private TicTacToeView view;
	
	/**
	 *  Creates an empty board, and sets the turn to Player 1
	 */
	public TicTacToeModel()
	{
		board = new char[3][3];
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				board[i][j] = ' ';
			}
		}
		turnPlayer1 = true;
			
	}
	
	/**
	 * Provides the current game board
	 * @return char[][]
	 */
	public char[][] getBoard() {
		return board;
	}
	
	/**
	 * Sets the board
	 * @param board: char[][]
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}
	
	/**
	 * If true, it is Player 1 (X) turn. Otherwise, it is Player 2 (O) turn
	 * @return boolean
	 */
	public boolean isTurnPlayer1() {
		return turnPlayer1;
	}

	/**
	 * Sets the turn to Player 1(X) if true. Otherwise, sets the turn to Player 2 (O)
	 * @param turnPlayer1
	 */
	public void setTurnPlayer1(boolean turnPlayer1) {
		this.turnPlayer1 = turnPlayer1;
	}
	
	/**
	 * Enters a character on the board
	 * @param row: int
	 * @param col: int
	 */
	public void play(int col, int row)
	{
		if(turnPlayer1)
		{
			board[col][row] = 'X';
			updateBoard(col, row, "X");
		}
		else
		{
			board[col][row] = 'O';
			updateBoard(col, row, "O");
		}
		updateStatus();
		turnPlayer1 = !turnPlayer1;
		
	}
	
	private void updateBoard(int col, int row, String c) {
		for(TicTacToeButton b: view.getButtonList())
		{
			if(b.getRow() == row && b.getCol() == col)
			{
				b.setText(c);
			}
		}
		
	}

	/**
	 * Sets the view for this model
	 * @param v
	 */
	public void setTicTacToeView(TicTacToeView v)
	{
		view = v;
	}
	
	/**
	 * Gives the status of the game. This method checks for column wins, row wins and diagonal wins first. If
	 * those are positive, the winner is provided. Otherwise, the game is in play or is a tie. This is 
	 * determined by whether or not the board is full
	 * @return
	 */
	private Status checkStatus()
	{
		//Check rows for a win
		for(int i = 0; i<3; i++)
		{

			if(board[0][i] == board[1][i] && board[1][i] == board[2][i])
			{
				if(board[0][i] == 'X')
				{
					return Status.PLAYER1WIN;
				}
				else if(board[0][i] == 'Y')
				{
					return Status.PLAYER2WIN;
				}
			}
		}
		
		//Check columns for a win
		for(int i = 0; i<3; i++)
		{
			if(board[i][0] == board[i][1] && board[i][1] == board[i][2])
			{
				if(board[i][0] == 'X')
				{
					return Status.PLAYER1WIN;
					
				}
				else if(board[i][0] == 'O')
				{
					return Status.PLAYER2WIN;
				}
			}
		}
		//Check diagonals for a win
		if(board[0][0] == board[1][1] && board[1][1] == board[2][2])
		{
			if(board[0][0] == 'X')
			{
				return Status.PLAYER1WIN;
			}
			else if(board[0][0] == 'O')
			{
				return Status.PLAYER2WIN;
			}
		}
		
		if(board[0][2] == board[1][1] && board[1][1] == board[2][0])
		{
			if(board[0][2] == 'X')
			{
				return Status.PLAYER1WIN;
			}
			else if(board[0][2] == 'O')
			{
				return Status.PLAYER2WIN;
			}
		}
		
		//Check if board is still empty
		for(int i = 0; i<3; i++)
		{
			for(int j = 0; j<3; j++)
			{
				if(board[i][j] == ' ')
				{
					return Status.INGAME;
				}
			}
		}
		
		//No wins, board is full. Result is a tie
		return Status.TIE;
		
	}
	
	/**
	 * Updates the status in the view
	 * 
	 */
	public void updateStatus()
	{
		Status s = checkStatus();
		switch (s)
		{
			case INGAME:
				view.setStatus("in game");
				break;
			case PLAYER1WIN:
				view.setStatus("player 1 wins!");
				view.disable();
				break;
			case PLAYER2WIN:
				view.setStatus("player 2 wins!");
				view.disable();
				break;
			case TIE:
				view.setStatus("tie!");
				view.disable();
		}
	}
	
}
