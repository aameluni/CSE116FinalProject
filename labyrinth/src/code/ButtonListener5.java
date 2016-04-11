package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener5 implements ActionListener{
	Board board;
	
	public ButtonListener5(Board b){
		board= b;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.playerPickup();
		board.changeState();
	}

}
