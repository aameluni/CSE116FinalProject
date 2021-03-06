package code;

import java.io.File;

import javax.swing.SwingUtilities;

import code.GUI.GUI;
import code.Model.Model;
import code.pawn.Pawn;

public class Driver {

	public static void main(String[] args) {
		Model model = new Model();
		
		if(args.length==1 && args[0].indexOf(".mls")!=-1)
		{
			model.restore(new File(args[0]));
			SwingUtilities.invokeLater(new GUI(model));
		}
		if ( args.length == 0 ) {
			model.pawns[0] = new Pawn(2,2, model,"player 1","red");
			model.pawns[1] = new Pawn(4,4, model,"player 2","blue");
			model.pawns[2] = new Pawn(2,4, model,"player 3","green");
			model.pawns[3] = new Pawn(4,2, model,"player 4","black");
			SwingUtilities.invokeLater(new GUI(model));
			}
		else if ( args.length == 2 ){
			model.pawns[0] = new Pawn(2,2, model,args[0],"red");
			model.pawns[1] = new Pawn(4,4, model,args[1],"blue");
			SwingUtilities.invokeLater(new GUI(model));

		}
		else if ( args.length == 3 ){
			model.pawns[0] = new Pawn(2,2, model,args[0],"red");
			model.pawns[1] = new Pawn(4,4, model,args[1],"blue");
			model.pawns[2] = new Pawn(2,4, model,args[2],"green");
			SwingUtilities.invokeLater(new GUI(model));

		}
		else if ( args.length == 4 ){
			model.pawns[0] = new Pawn(2,2, model,args[0],"red");
			model.pawns[1] = new Pawn(4,4, model,args[1],"blue");
			model.pawns[2] = new Pawn(2,4, model,args[2],"green");
			model.pawns[3] = new Pawn(4,2, model,args[3],"black");
			SwingUtilities.invokeLater(new GUI(model));
		}
	}
	

}
