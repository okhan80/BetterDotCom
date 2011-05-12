package betterdotcom;

import java.util.ArrayList;

public class DotCom {

	private String m_szName;
	private ArrayList<String> m_aLocationCells;


	public String CheckYourself(String szUserInput) {
		
		//	Variable that will hold the result we will return.
		//	The default value will be "miss"
		String szResult = "miss";
		
		//	Check to see if the user guess is in the array list
		//	by asking for its index. If it is not in the list
		//	then indexOf returns a -1
		int nIndex = m_aLocationCells.indexOf(szUserInput);

		//	If the index is greater than or equal to zero
		//	the user guess is definitely in the list
		if(nIndex >= 0)
		{
			m_aLocationCells.remove(nIndex);
			
			//	If the list is empty this is the killing blow
			if(m_aLocationCells.isEmpty())
			{
				szResult = "kill";
				System.out.println("Ouch! You sunk " + m_szName + "  :-(");
			}
			else
			{
				szResult = "hit";
			}
			
		}
		
		return szResult;
		
	}

	public void SetLocationCells(ArrayList<String> loc) {
		// TODO Auto-generated method stub
		m_aLocationCells = loc;
		
	}

	public void SetName(String szName) {
		// TODO Auto-generated method stub
		m_szName = szName;
	}

}
