package code;

public class Recipe {
	/**
	 * @author Wiechec
	 * Class is a placeholder only for future implementation.
	 */
	int[] tokens = new int[3];
	public Recipe(){
		setRecipe();
	}
	public int[] getRecipe(){
		return tokens;
	}
	public void setRecipe(){
		int card=0;
		for(int i=0; i<3;i++)
		{
			card =(int)(Math.random()*21);
			if(card==0)
			{
				card=25;
			}
			for(int j=0; j<tokens.length;j++)
			{
				if(card==tokens[j])
				{	i--;
					tokens[j]=0;
				}
			}
			tokens[i]=card;
		}	
	}
	public String toString()
	{
		return tokens[0] + ", " + tokens[1] + ", " + tokens[2];
	}
}
