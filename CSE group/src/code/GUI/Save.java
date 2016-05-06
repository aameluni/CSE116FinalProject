package code.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model.Model;

public class Save implements ActionListener{
	Model m;
	public Save(Model mo)
	{
		m=mo;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(m.firstMove)
		m.save();
	}
	
}
