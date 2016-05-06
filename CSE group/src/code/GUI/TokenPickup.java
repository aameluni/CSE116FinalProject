package code.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model.Model;
import code.pawn.Pawn;

public class TokenPickup implements ActionListener {
	Pawn _pawn;
	Model _model;
	public TokenPickup(Model m, Pawn p)
	{
		_pawn = p;
		_model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!_model.firstMove)
		_pawn.pickUpToken();
	}

}
