package betterdotcom;

//	Need to import input and output from java
import java.io.*;
import java.util.*;

public class GameHelper {
	
	//	Instance Variables
	private static final String m_szAlphabet = "abcdefg";
	private int m_nGridLength = 7;
	private int m_nGridSize = 49;
	private int[] m_arrGrid = new int[m_nGridSize];
	private int m_nComCount = 0;
	
	//	Methods
	public String GetUserInput(String szPrompt)
	{
		String szInputLine = null;
		System.out.print(szPrompt + " ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			szInputLine = is.readLine();
			
			if(szInputLine.length() == 0)
			{
				return null;
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("IOException: " + e);
		}
		
		return szInputLine.toLowerCase();
		
	}	//	end GetUserInput()
	
	public ArrayList<String> PlaceDotCom(int nComSize)
	{
		
	}
	
}	//	end GameHelper class
