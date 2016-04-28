package code.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import code.Model.Model;
import code.pawn.Pawn;

public class UseMagicWand implements ActionListener {
	private Pawn _pawn;
	private Model _model;
	public UseMagicWand(Model m , Pawn p)
	{
		_pawn = p;
		_model = m;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		_pawn.useMagicWand();
		_model.gameChanged();
	}
}
