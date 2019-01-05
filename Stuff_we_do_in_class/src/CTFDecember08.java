import java.util.Scanner;

public class CTFDecember08 {
	public static String secretMessage(String yes, final String no)	{
		String maybe = "";
		yes = yes.toUpperCase();
		for(int i = 0, j = 0; i < yes.length(); i++)	{
			char wha = yes.charAt(i);
			if(wha < 'A' || wha > 'Z')
				continue;
			maybe += (char)((wha + no.charAt(j) - 2 * 'A') % 26 + 'A');
			j = ++j % no.length();
		}
		return maybe;
	}
	
    public static String notSoSecretMessage(String yes, final String no)	{
    	String maybe = "";
    	yes = yes.toUpperCase();
        for (int i = 0, j = 0; i < yes.length(); i++)	{
        	char wha = yes.charAt(i);
            if (wha < 'A' || wha > 'Z')
                continue;
            maybe += (char) ((wha - no.charAt(j) + 26) % 26 + 'A');
            j = ++j % no.length();
        }
        return maybe;
    }
	
	public static void main(String[] args)	{
        String key = "a"
        		+ "";
        String secretMsg = "CWUVNCWSMEORGIIFMMGO";
        System.out.println("Welcome to the mind-bender!");
        System.out.println("Here is your secret message: " + secretMsg);
        Scanner keyIn = new Scanner(System.in);
        String keepGoing = "";
        do	{
        		System.out.print("What is the secret: ");
        		key = keyIn.nextLine();
        		
        		System.out.println("And the winner is: " + notSoSecretMessage(secretMsg, key));
        }while(!keepGoing.toUpperCase().equals("YES"));
        System.out.println("I would agree. Bye now!");
	}
}
