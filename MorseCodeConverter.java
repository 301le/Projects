import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree morseCodeTree = new MorseCodeTree();

	public MorseCodeConverter() {
	}

	static String convertToEnglish(File codeFile) throws FileNotFoundException {

		String sentenceInMorse = "";
		String sentenceInEnglish;

		Scanner scanner = new Scanner(codeFile);

		while (scanner.hasNext()) {
			sentenceInMorse += scanner.nextLine();
		}

		sentenceInEnglish = convertToEnglish(sentenceInMorse);

		return sentenceInEnglish;
	}

	static String convertToEnglish(String code) {

		String sentenceInEnglish = "";

		String[] wordsInMorseArray = code.split("/");

		for (String wordInMorse : wordsInMorseArray) {

			String[] lettersInMorseArray = wordInMorse.split(" ");
			String wordInEnglish = "";

			for (String letter : lettersInMorseArray) {
				if (!(letter.equals(("")))) {
					wordInEnglish += morseCodeTree.fetch(letter);
				}
			}

			wordInEnglish += " ";
			sentenceInEnglish += wordInEnglish;
		}

		return sentenceInEnglish.substring(0, sentenceInEnglish.length() - 1);
	}

	static String printTree() {

		ArrayList<String> arrayListTree = new ArrayList<>();

		arrayListTree = morseCodeTree.toArrayList();

		String stringTree = "";

		for (String letter : arrayListTree) {
			stringTree += letter + " ";
		}

		return stringTree;
	}

}