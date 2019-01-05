

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	private int findKeyword(String statement, String goal, int startPos){ 
		String phrase = statement.trim().toLowerCase(); goal = goal.toLowerCase();
		int psn = phrase.indexOf(goal, startPos);
		int counter = 1;
		while (psn >= 0){ 
			String before = " ", after = " ";
			if (psn > 0){ 
				before = phrase.substring(psn - 1, psn); 
				}
			if (psn + goal.length() < phrase.length()){ 
				after = phrase.substring(psn + goal.length(),psn + goal.length() + 1);
	/* determine the values of psn, before, and after at this point in the method. */ 
			}
			System.out.println(counter+ " " +psn+" "+before+" "+after );
			counter++;
	     if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))&&((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0))) 
	     	return psn;
	     psn = phrase.indexOf(goal, psn + 1);
	 } 
	return -1;
	}

	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.trim().length() ==0){
			response = "Say something, please." ;
		}
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (findKeyword(statement,"mother",0) >= 0
				|| findKeyword(statement,"father",0) >= 0
				|| findKeyword(statement,"brother",0) >= 0
				|| findKeyword(statement,"sister",0) >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (findKeyword(statement,"cat",0)>=0
				|| findKeyword(statement,"dog",0)>=0){
			response = "Tell me more about your pets.";
		}
		else if (findKeyword(statement,"Mr",0)>=0){
			response = "He sounds like a good teacher";
		}
		else if (findKeyword(statement,"Ms",0)>=0){
			response = "She sounds like a good teacher";
		}
		else if(findKeyword(statement,"satan",0)>=0){
			response = "hail satan";
		}
		else if(findKeyword(statement,"yes",0)>=0){
			response = "thats nice would you like to continue to talk";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
			}

			return response;
		}
}

