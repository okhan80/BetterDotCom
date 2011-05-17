package betterdotcom;

//	Need to import input and output from java
import java.io.*;
import java.util.*;

public class GameHelper {
	
	//	Instance Variables
	private static final String M_SZALPHABET = "abcdefg";
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
		ArrayList<String> alAlphaCells = new ArrayList<String>();
		String[] pszAlphaCoords = new String [nComSize];			//	holds 'f6' type coords
		String szTemp = null;										//	temporary String for concatination
		int[] anCoords = new int[nComSize];							//	current candidate coords
		int nAttempts = 0;											//	number of attempts
		boolean bSuccess = false;									//	have we found proper location
		int nLocation = 0;											//	current starting location
		
		m_nComCount++;
		
		//	Set the horizontal increment
		int nIncr = 1;
		
		//	If the dot com is an odd number
		if((m_nComCount % 2) == 1)
		{
			nIncr = m_nGridLength;
		}
		
		while(!bSuccess && nAttempts++ < 200)
		{
			nLocation = (int) (Math.random() * m_nGridSize);
			
			//System.out.print(" try " + nLocation);
			int nX = 0;
			bSuccess = true;
			while(bSuccess && nX < nComSize)
			{
				if(m_arrGrid[nLocation] == 0)
				{
					anCoords[nX++] = nLocation;
					nLocation += nIncr;
					
					if(nLocation >= m_nGridSize)
					{
						bSuccess = false;
					}
					
					if(nX > 0 && (nLocation % m_nGridLength == 0))
					{
						bSuccess = false;
					}

				}
				else
				{
					//System.out.print(" used " + nLocation);
					bSuccess = false;
				}
			}
		}
		
		int nXCoord = 0;
		int nRow = 0;
		int nColumn = 0;
		//System.out.println("\n");
		while(nXCoord < nComSize)
		{
			m_arrGrid[anCoords[nXCoord]] = 1;
			nRow = (int) (anCoords[nXCoord] / m_nGridLength);
			nColumn = anCoords[nXCoord] % m_nGridLength;
			szTemp = String.valueOf(M_SZALPHABET.charAt(nColumn));
			
			alAlphaCells.add(szTemp.concat(Integer.toString(nRow)));
			nXCoord++;
			//	Comment back in this line of code to see where the ships are so you can
			//	test and cheat :)
			//System.out.print(" coord "+nXCoord+" = " + alAlphaCells.get(nXCoord - 1));
			
		}
		
		//System.out.println("\n");
		
		return alAlphaCells;
	}	//	end ArrayList()
	
}	//	end GameHelper class
