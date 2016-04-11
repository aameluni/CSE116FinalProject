package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener2 implements ActionListener {

	private Board b;
	public ButtonListener2(Board bo)
	{
		
		b=bo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Tile t = b.getExtra();
		int i = t.getRandom()+1;
		if(i>3)
			i=0;
		t.setRandom(i);
		t.setPath();
		b.changeState();
	}

}
