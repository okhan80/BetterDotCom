package betterdotcom;

//	Need to import input and output from java
import java.io.*;

public class GameHelper {
	
	//	Method to get the user input
	public String GetUserInput(String szPrompt)
	{
		//	Creating a string to hold the input
		String szInputLine = null;
		
		//	Print out the message prompt and a space to allow for input
		System.out.print(szPrompt + ": ");
		
		//	using a try/catch block to make sure the input is valid
		try
		{
			//	Setting up the input so that it can correctly capture the input from the user
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			szInputLine = is.readLine();
			
			//	If nothing is inputed then the method will return nothing
			if(szInputLine.length() == 0)
			{
				return null;
			}
			
		}
		catch(IOException e)
		{
			//	If there is an error print it out here
			System.out.println("IOException: " + e);
		}
		
		//	Return whatever input was captured
		return szInputLine;
		
	}
}
