package betterdotcom;

import betterdotcom.DotCom;

public class DotComGame {

	public static void main(String[] args) {
		
		//	Variable to track how many guesses the user makes
		int numOfGuesses = 0;
		
		//	Class that contains methods for getting user input
		GameHelper helper = new GameHelper();
		
		//	Create instance of the game
		DotCom theDotCom = new DotCom();
		
		//	Choose a random number for the first cell and use it to help create the cell location array
		int nRandomNum = (int) (Math.random() * 5);
		int[] anLocations = {nRandomNum, nRandomNum + 1, nRandomNum + 2};
		
		theDotCom.SetLocationCells(anLocations);
		
		//	Check to see if the game is still alive
		boolean bIsAlive = true;
		while(bIsAlive)
		{
			//	Get the user input using the class we have created earlier
			String szGuess = helper.GetUserInput("enter a number");
			
			//	Check the actual guess
			String szResult = theDotCom.CheckYourself(szGuess);
			
			numOfGuesses++;
			
			//	If the result was a kill, end the game and print out the results
			if(szResult.equals("kill"))
			{
				bIsAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}

	}

}
