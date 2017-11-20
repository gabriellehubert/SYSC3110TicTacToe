import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The view to accompany the TicTacToeModel
 * @author Gabrielle
 *
 */
public class TicTacToeView extends JFrame{
	
	private JPanel mainPanel, footerPanel;
	private JLabel status;
	private TicTacToeModel model;
	private TicTacToeButtonListener controller;
	private ArrayList<TicTacToeButton> buttonList;
	
	/**
	 * Sets up the look of the frame with a grid of JButtons of 3 x 3
	 */
	public  TicTacToeView(TicTacToeModel model)
	{
		super("TicTacToe");
		this.model = model;
		setSize(500, 500);
		mainPanel = new JPanel();
		footerPanel = new JPanel();
		status = new JLabel("Game Status: in game");
		mainPanel.setLayout(new GridLayout(3, 3));
		footerPanel.add(status);
		setLayout(new BorderLayout());
		
		add(mainPanel, BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH); 
		
		controller = new TicTacToeButtonListener(this, model);
		buttonList = new ArrayList<TicTacToeButton>();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				TicTacToeButton jb = new TicTacToeButton(j, i);
				jb.addActionListener(controller);
				buttonList.add(jb);
				mainPanel.add(jb);
			}	
		}
		setVisible(true);
		
	}
	
	/**
	 * Sets the model for this view
	 * @param m TicTacToeModel
	 */
	public void setTicTacToeModel(TicTacToeModel m)
	{
		model = m;
	}
	
	/**
	 * Changes the status label to the current game status
	 * @param s
	 */
	public void setStatus(String s)
	{
		status.setText("Game Status: " + s);
	}
	
	public ArrayList<TicTacToeButton> getButtonList() {
		return buttonList;
	}

	public void setButtonList(ArrayList<TicTacToeButton> buttonList) {
		this.buttonList = buttonList;
	}

	public void disable()
	{
		for(TicTacToeButton b: buttonList)
		{
			b.setEnabled(false);
		}
	}
	
	public static void main(String args[])
	{
		TicTacToeModel model = new TicTacToeModel();
		TicTacToeView view = new TicTacToeView(model);
		model.setTicTacToeView(view);
	}
	
}
