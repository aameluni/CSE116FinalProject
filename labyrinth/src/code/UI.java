package code;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UI{

	private JFrame _window;
	private JPanel _boardPanel;
	private JPanel _boardPanel2;
	private Board _board;

	public UI (Board board){
		_board=board;	
		_board.setObserver(this);
		_window = new JFrame("Master Labyrinth");
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_window.setFocusable(true);
		_window.setLayout(new FlowLayout());
//		_window.setFocusTraversalKeysEnabled(false);
		_boardPanel = new JPanel();
		_boardPanel.setLayout(new GridLayout(9,9));
		for (int x=0; x<9; x++){
			for (int y=0; y<9; y++){
				JButton b= new JButton ();
				b.setPreferredSize(new Dimension(125, 75));
				b.setOpaque(true);
				Font font = new Font("SansSerif", Font.PLAIN, 9);
				b.setFont(font);
				b.setLayout(new BoxLayout(b,3));
				
				_boardPanel.add(b);
				
				if ((x>0&&x<8) && (y>0&&y<8)){
					JButton b1= new JButton ();
					b.add(b1);
					b.addActionListener(new ButtonListener3(this, _board,y-1,x-1));
					b1.setVisible(false);
				}
				else if(x%2!=0 || y%2!=0 || ((x==0||x==8) && (y==0 || y ==8))){
					b.setVisible(false);
				}
				else
				{
					if(x==0)
					{
						
						b.addActionListener(new ButtonListener(this,_board,y-1,-1));
					}
					if(x==8)
					{
						
						b.addActionListener(new ButtonListener(this,_board,y-1,7));
					}
					if(y==0)
					{
						
						b.addActionListener(new ButtonListener(this,_board,-1,x-1));
					}
					if(y==8)
					{
						
						b.addActionListener(new ButtonListener(this,_board,7,x-1));
					}
				}
				
			}
		}
		
		_window.add(_boardPanel);
		_boardPanel2 = new JPanel();
		_boardPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		JButton extra = new JButton();
		Font font = new Font("SansSerif", Font.PLAIN, 9);
		extra.setFont(font);
		extra.setPreferredSize(new Dimension(125, 75));
		extra.addActionListener(new ButtonListener2(board));
	
		JLabel l=new JLabel();
		l.setText("Click tile in order to rotate");
		JLabel l1=new JLabel();
		l1.setText("EXTRA TILE");
		_boardPanel2.add(l1);
		_boardPanel2.add(extra);
		_boardPanel2.add(l);
		JButton endturn = new JButton("End Turn");
		endturn.addActionListener(new ButtonListener4(this));
		_boardPanel2.add(endturn);
		JButton tokenpickup = new JButton("Pickup Token");
		tokenpickup.addActionListener(new ButtonListener5(_board));
		_boardPanel2.add(tokenpickup);
		JLabel l2=new JLabel();
		_boardPanel2.add(l2);
		_boardPanel2.setLayout(new GridLayout(6,1));
		_window.add(_boardPanel2);
		_window.pack();
		_window.setVisible(true);
		enablePlayers(false);
		update();
		
		

	}
	
	public void update()
	{
		clearB1();
		for(int k=0; k<_board.getPlayerList().size();k++)
		{
			int x =_board.getPlayerList().get(k).getX();
			int y =_board.getPlayerList().get(k).getY();
			int ss =0;
			
			for(int i=0;i<7;i++)
			{
				int counter =10+ss;
				for(int j=0;j<7;j++)
				{
					JButton b =(JButton) _boardPanel.getComponent(counter);
					String s = _board.getBoard().get(i).get(j).toString();
					b.setText(s);
					counter+=9;
					JButton b1 = (JButton)b.getComponent(0);
					if(x==i && y==j)
						{
						b1.setVisible(true);
						b1.setText(_board.getPlayers(_board.getBoard().get(i).get(j)));
						}
					
				}
				counter++;
				ss++;
			}	
			
		}
		JButton b1  = (JButton) _boardPanel2.getComponent(1);
		b1.setText(_board.getExtra().toString());
		JLabel l = (JLabel) _boardPanel2.getComponent(5);
		l.setText(_board.checkGameState());
		//_window.repaint();
	}
	public void clearB1()
	{
		int count=10;
		for(int i=0;i<7;i++)
		{
			
			for(int j=0;j<7;j++)
			{
				JButton b = (JButton)_boardPanel.getComponent(count);
				JButton b1 = (JButton)b.getComponent(0);
				b1.setVisible(false);
				b1.setText("");
				count++;
			}
			count+=2;
		}
	}
	public void disableShift(boolean b)
	{
		for(int i=0;i<81;i++)
		{
			JButton tm;
			if(i<9||i>72||i%9==0 || (i-8)%9==0)
			{
				tm = (JButton) _boardPanel.getComponent(i);
				if(b)
				tm.setEnabled(false);
				else
					tm.setEnabled(true);
			}
			
		}
		
	} 
	public void enablePlayers(boolean bo)
	{
		
		int count=10;
		for(int i=0;i<7;i++)
		{
			
			for(int j=0;j<7;j++)
			{
				JButton b = (JButton)_boardPanel.getComponent(count);
				if(bo)
				b.setEnabled(true);
				else
					b.setEnabled(false);
				count++;
			}
			count+=2;
		}
	}
	public void stopper()
	{
		_board.rotatePlayerTurn();
		disableShift(false);
		enablePlayers(false);
	}

}
