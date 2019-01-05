/**
 * 
 * @author 18tsuetaki
 *
 */
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *the class that holds the tester
 */
public class RomanToDecimalTester {

	@Test
	/**
	 * The tester for the romanToDecimal function in the RomanToDecimal function. It returns true or false depending 
	 * if the statements are processed with the correct result outputed.
	 */
	public void RomanToDecimal() {
		assertEquals(RomanToDecimal.romanToDecimal("I"),1);
		assertEquals(RomanToDecimal.romanToDecimal("V"),5);
		assertEquals(RomanToDecimal.romanToDecimal("X"),10);
		assertEquals(RomanToDecimal.romanToDecimal("L"),50);
		assertEquals(RomanToDecimal.romanToDecimal("IC"),101);
		assertEquals(RomanToDecimal.romanToDecimal("VD"),505);
		assertEquals(RomanToDecimal.romanToDecimal("M"),1000);
		assertNotEquals("this is not right", RomanToDecimal.romanToDecimal("I"),2);
	}

}
