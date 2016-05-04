package fileConverter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import code.Model.*;


public class FileConv {
	private static File f;
	private static Scanner s;
	private static String l;
	private Model model;
	public FileConv(Model m)
	{
		
		f = new File("Data.mls");
		model = m;
		
	}
	public void save()
	{
		try {
				if(f.createNewFile())
				{
					make();
					System.out.println("Save Complete");
				}
				else 
					System.out.println("File Already Exists");
			} catch (IOException e1) {
				System.out.println("Failed to Save");
			}
	}
	public void make() throws FileNotFoundException
	{
		l = model.toString();
		PrintWriter p = new PrintWriter(f);
		p.print(l);
		p.close();
	}
	public void read()
	{
		try {
			s = new Scanner(f);
			model.setPlayers(s.nextLine());
			model.setTiles(s.nextLine());
			int i= Integer.parseInt(s.nextLine());
			if(i!=0)
				model.firstMove=false;
			else
				model.firstMove=true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found, failed to restore.");
		}
		
	}
	public void setFile(File f)
	{
		this.f = f;
	}
}
	
	
	


