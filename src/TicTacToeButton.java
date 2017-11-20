import javax.swing.JButton;

/**
 * A button for the TicTacToeView that stores its own row and column values
 * @author Gabrielle
 *
 */
public class TicTacToeButton extends JButton{
	
	private int col;
	private int row;
	
	public TicTacToeButton(int col, int row)
	{
		super();
		this.col = col;
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

}
