import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Dylan Le
 *
 */
public class PasswordCheckerSTUDENT_Test {

	ArrayList<String> passwordsArray;
	
	@Before
	public void setUp() throws Exception {
		String[] arr = {"$ZMAbcz432!", "MNB789mnb"};
		passwordsArray = new ArrayList<String>();
		passwordsArray.addAll(Arrays.asList(arr));
	}

	@After
	public void tearDown() throws Exception {
		passwordsArray = null;
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		
		try {
            PasswordCheckerUtility.isValidLength("ZzMmAa");
            assertTrue("InvalidSequenceException isn't thrown", true);
        } catch (LengthException e) {
            assertTrue("LengthException successfully thrown", false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.isValidLength("N7aSs");
            assertTrue("InvalidSequenceException isn't thrown", false);
        } catch (LengthException e) {
            assertTrue("LengthException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
            PasswordCheckerUtility.hasUpperAlpha("K7Ggk9");
            assertTrue("NoUpperAlphaException isn't thrown", true);
        } catch (NoUpperAlphaException e) {
            assertTrue("NoUpperAlphaException successfully thrown", false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.hasUpperAlpha("hkj672^");
            assertTrue("NoUpperAlphaException isn't thrown", false);
        } catch (NoUpperAlphaException e) {
            assertTrue("NoUpperAlphaException successfully thrown", true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
            PasswordCheckerUtility.hasLowerAlpha("Z6zMm8");
            assertTrue("NoLowerAlphaException isn't thrown", true);
        } catch (NoLowerAlphaException e) {
            assertTrue("NoLowerAlphaException successfully thrown", false);
        } catch (Exception e) {
          
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.hasLowerAlpha("ZZKKWW99");
            assertTrue("NoLowerAlphaException isn't thrown", false);
        } catch (NoLowerAlphaException e) {
            assertTrue("NoLowerAlphaException successfully thrown", true);
        } catch (Exception e) {
    
            assertTrue("Wrong exception is thrown", false);
        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
            PasswordCheckerUtility.isWeakPassword("H7hSs1)");
            assertTrue("WeakPasswordException isn't thrown", true);
        } catch (WeakPasswordException e) {
            assertTrue("WeakPasswordException successfully thrown", false);
        } catch (Exception e) {
          
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.isWeakPassword("lmou1@H");
            assertTrue("WeakPasswordException isn't thrown", true);
        } catch (WeakPasswordException e) {
            assertTrue("WeakPasswordException successfully thrown", false);
        } catch (Exception e) {
    
            assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
            PasswordCheckerUtility.hasSameCharInSequence("P2pSs33DdLl");
            assertTrue("InvalidSequenceException isn't thrown", true);
        } catch (InvalidSequenceException e) {
            assertTrue("InvalidSequenceException successfully thrown", false);
        } catch (Exception e) {
     
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.hasSameCharInSequence("LLLuu897");
            assertTrue("InvalidSequenceException isn't thrown", false);
        } catch (InvalidSequenceException e) {
            assertTrue("InvalidSequenceException successfully thrown", true);
        } catch (Exception e) {
  
            assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
            PasswordCheckerUtility.hasDigit("P2pSs33DdLl");
            assertTrue("NoDigitException isn't thrown", true);
        } catch (NoDigitException e) {
            assertTrue("NoDigitException successfully thrown", false);
        } catch (Exception e) {
           
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.hasDigit("MMNNeePP");
            assertTrue("NoDigitException isn't thrown", false);
        } catch (NoDigitException e) {
            assertTrue("NoDigitException successfully thrown", true);
        } catch (Exception e) {
      
            assertTrue("Wrong exception is thrown", false);
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
            PasswordCheckerUtility.isValidPassword("MmSsGgYy890!");
            assertTrue("Exception isn't thrown", true);
        
        } catch (Exception e) {
          
            assertTrue("Wrong exception is thrown", false);
        }
		
		try {
            PasswordCheckerUtility.isValidPassword("MmSsGgYy890");
            assertTrue("Exception isn't thrown", false);
        
        } catch (Exception e) {
          
            assertTrue("Exception is thrown", true);
        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> results = PasswordCheckerUtility.getInvalidPasswords(passwordsArray);
		
		assertEquals(results.get(0),("MNB789mnb -> The password must contain at least one special character"));
		
	}
	
}