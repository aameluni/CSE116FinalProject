package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener3 implements ActionListener{

	private Board b;
	private Player p;
	private Tile t;
	private int x;
	private int y;
	public ButtonListener3(UI u, Board bo, int x, int y)
	{
		b=bo;
		p=b.getCP();
		this.x=x;
		this.y=y;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		t=b.getBoard().get(x).get(y);
		if(p.legitMove(t))
			{
			p.playerMove(t);
			b.changeState();
			}
	}
	

}
