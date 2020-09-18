import java.util.ArrayList;

public class PasswordCheckerUtility {
	public PasswordCheckerUtility(){}
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if(password.equals(passwordConfirm)) {
			return;
		}
		throw new UnmatchedException();
	}
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		if(password.equals(passwordConfirm)) {
			return true;
		}
		return false;
	}
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<String>();
		for(String password: passwords) {
			try {
				if(isValidPassword(password)) {}
			}catch(LengthException a) {
				invalidPasswords.add(password + " -> The password must be at least 6 characters long");
			}catch(NoUpperAlphaException b) {
				invalidPasswords.add(password + " -> The password must contain at least one uppercase alphabetic character");
			}catch(NoLowerAlphaException c) {
				invalidPasswords.add(password + " -> The password must contain at least one lower case alphabetic character");	
			}catch(NoDigitException d) {
				invalidPasswords.add(password + " -> The password must contain at least one digit");	
			}catch(NoSpecialCharacterException e) {
				invalidPasswords.add(password + " -> The password must contain at least one special character");
			}catch(InvalidSequenceException f) {
				invalidPasswords.add(password + " -> The password cannot contain more than two of the same character in sequence");
			}
		}
		return invalidPasswords;
	}
	public static boolean hasBetweenSixAndNineChars(String password) {
		if(password.length() > 5 && password.length() < 10) {
			return true;
		}
		return false;
	}
	public static boolean isWeakPassword(String password) throws Exception {
		if(hasBetweenSixAndNineChars(password)) {
			return false;
		}
		else {
			if(isValidPassword(password)) {
				return true;
			}
			return false;
		}	
	}
	public static boolean hasDigit(String password) throws NoDigitException {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		String specialCharacters = " !\"#$%&'()*+,-./;:<=>?@[\\]^_`{|}~";
		for(int i = 0; i < password.length(); i++) {
			for(int j = 0; j < specialCharacters.length(); j++) {
				if(password.charAt(i) == specialCharacters.charAt(j)) {
					return true;
				}
			}
		}
		throw new NoSpecialCharacterException();
	}
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		for(int i = 0; i < password.length(); i++) {
			if(password.charAt(i) >= 65 && password.charAt(i) <=90) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		for(int i = 0; i < password.length();i++) {
			if(password.charAt(i) >= 97 && password.charAt(i) <=123) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		for(int i = 0; i < password.length()-2; i++ ) {
			if(password.charAt(i) == password.charAt(i+1) && password.charAt(i+1) == password.charAt(i+2)) {
				throw new InvalidSequenceException();
			}
			
		}
		return true;
	}
	public static boolean isValidPassword(String password) throws LengthException, NoSpecialCharacterException, NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException{
		 isValidLength(password);
		 hasUpperAlpha(password);
		 hasLowerAlpha(password);
		 hasDigit(password);
		 hasSpecialChar(password);
		 hasSameCharInSequence(password);
		return true; 
			
		}
	public static boolean isValidLength(String password) throws LengthException {
		if(password.length() > 5) {
			return true;
		}
		throw new LengthException();
	}
}
