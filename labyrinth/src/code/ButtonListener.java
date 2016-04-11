package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ButtonListener implements ActionListener {

	private Board board;
	private int _x;
	private int _y;
	private UI ui;
	public ButtonListener(UI u, Board b, int x, int y){
	board=b;
	_x=x;
	_y=y;
	ui=u;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.tileShifting(_x, _y);
		ui.disableShift(true);
		ui.enablePlayers(true);
		board.changeState();
		
	}
	

}
