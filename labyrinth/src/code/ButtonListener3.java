package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener3 implements ActionListener{

	private Board b;
	private Player p;
	private Tile t;
	public ButtonListener3(Board bo, int x, int y)
	{
		b=bo;
		p=b.getCP();
		t=b.getBoard().get(x).get(y);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(p.legitMove(t))
			{
			p.playerMove(t);
			System.out.println("break");
			System.out.println(t.hasPlayer(b.getPlayerList()));
			System.out.println(b.getPlayers(t));
			b.changeState();
			}
			b.changeState();
	}
	

}
