package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener4 implements ActionListener {

	UI ui;
	public ButtonListener4(UI u )
	{
		ui=u;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ui.stopper();
	}

	
}
