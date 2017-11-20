/**
 * The model behind a simple TicTacToe game
 * @author Gabrielle
 *
 */
public class TicTacToeModel 
{
	static final int SIZE = 3;
	char board[][];
	boolean turnPlayer1;
	
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
	
	public void play(int row, int col)
	{
		if(turnPlayer1)
		{
			board[col][row] = 'X';
		}
		else
		{
			board[col][row] = 'O';
		}
	}
	
	public Status checkStatus()
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
				else
				{
					return Status.INGAME;
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
				else if(board[i][0] == 'Y')
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
			else if(board[0][0] == 'Y')
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
			else if(board[0][2] == 'Y')
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
	
}
