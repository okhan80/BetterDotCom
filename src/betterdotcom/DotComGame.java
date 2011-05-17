package betterdotcom;

import java.util.ArrayList;

import betterdotcom.DotCom;

public class DotComGame {

	//	Instance variables
	//	Declare and instantiate a GameHelper instance class
	private GameHelper m_Helper = new GameHelper();
	
	//	Declare and instantiate an ArrayList to hold the list of DotComs
	private ArrayList<DotCom> m_alDotComList = new ArrayList<DotCom>();
	
	//	Declare an int variable to hold the number of guesses
	private int m_nNumOfGuess = 0;
	
	//	Class Method declarations
	//	Declare a game setup method to create and initialize
	//	the DotCom objects
	public void SetUpGame()
	{
		//	Make the three DotCom Objects
		//	Create the three DotCom Objects
		DotCom firstCom = new DotCom();
		DotCom secondCom = new DotCom();
		DotCom thirdCom = new DotCom();
		
		//	Set a name for each DotCom
		firstCom.SetName("Pets.com");
		secondCom.SetName("Amazon.com");
		thirdCom.SetName("Foobar.com");
		
		//	Add them to the ArrayList
		m_alDotComList.add(firstCom);	
		m_alDotComList.add(secondCom);
		m_alDotComList.add(thirdCom);
		
		//	Instructions for the suer
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, Amazon.com, Foobar.com");
		System.out.println("Try to sink them all in the fewest number of guesses!");
		
		//	Loop through each of the DotCom objects in the array
			//	Call the PlaceDotCom() method from the helper class
			//	to get a randomly selected location for this
			//	DotCom
			//	Set the location for each DotCom based upon the 
			//	result of the method call
		for(DotCom enemies : m_alDotComList)
		{
			enemies.SetLocationCells(m_Helper.PlaceDotCom(3));
		}
		
	}	//	end SetUpGame()
	
	//	Declare a start playing method that asks the player for guesses
	//	and calls the checkUserGuess() method until all the DotCom objects
	//	are removed from play
	public void StartPlaying()
	{
		//	Repeat while any DotComs exist
			//	Get the user input by calling the helper GetUserInput() method
			//	Evaluate the user's guess by the CheckUserGuess() method
		while(!m_alDotComList.isEmpty())
		{
			CheckUserGuess(m_Helper.GetUserInput("Enter your guess"));
		}
		
		//	Then finish off the game once this is done
		FinishGame();
		
	}	//	end StartPlaying()
	
	//	Declare a method that checks the guess the user makes that loops through
	//	through all the remaining DotCom objects and calls each one's CheckYourself
	//	method
	public void CheckUserGuess(String szUserGuess)
	{
		//	Find out if there is a hit ( and kill) on any DotCom
		
		//	Increment the number of user guesses
		m_nNumOfGuess++;
		//	Set a local String variable to "miss", this assumption is that the user will miss most of the time
		String szResult = "miss";
		
		//	Loop through each of the DotCom Objects in the array list
		for(DotCom enemies : m_alDotComList)
		{
			szResult = enemies.CheckYourself(szUserGuess);
			
			if(szResult.equals("hit"))
			{
				break;
			}
			
			else if(szResult.equals("kill"))
			{
				m_alDotComList.remove(enemies);
				break;
			}
		}
			//	Evaluate the user's guess by calling the CheckYourself method
			//	Set the result variable to "hit" or "kill" if appropriate
			//	If the result is a kill, remove the DotCom object from the array list
		System.out.println(szResult);
		//	Display the result value to the user
		
	}	//	end CheckUserGuess()
	
	//	Declare a finish game method that prints a message about how the user did based upon how
	//	many guesses it took to sink the DotCom objects
	public void FinishGame()
	{
		//	Display a generic "game over" message then:
		System.out.println("Game Over sucka!!!");
		System.out.println("It took you " + m_nNumOfGuess + " guesses to destroy all the Dot Coms!");
		//	If the number of user guesses is small,
			//	Display a congratulations message
		//	else
			//	Display an insulting one
		if(m_nNumOfGuess < 25)
		{
			System.out.println("Wow! You rocked this round!!!");
		}
		else
		{
			System.out.println("I've seen a pig who is randomly chewing on a mouse find the ships faster than you!");
		}
		
	}	//	end FinishGame()
	
	public static void main(String[] args) {
		DotComGame game = new DotComGame();
		game.SetUpGame();
		game.StartPlaying();
	}	//	end main()
		
}	//	end DotComGame class
