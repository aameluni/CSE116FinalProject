package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

	private Board board;
	private int _x;
	private int _y;
	public ButtonListener(Board b, int x, int y){
	board=b;
	_x=x;
	_y=y;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.tileShifting(_x, _y);
		board.changeState();
		System.out.println("here");
	}
	

}
