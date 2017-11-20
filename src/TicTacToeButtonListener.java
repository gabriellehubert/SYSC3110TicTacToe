import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeButtonListener implements ActionListener{

	private TicTacToeModel model;
	private TicTacToeView view;
	
	public TicTacToeButtonListener(TicTacToeView view, TicTacToeModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TicTacToeButton b = (TicTacToeButton) e.getSource();
		int row = b.getRow();
		int col = b.getCol();
		model.play(col, row);
		b.setEnabled(false);
		
	}

}
