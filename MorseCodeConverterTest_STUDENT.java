import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class MorseCodeConverterTest_STUDENT {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish(".... . -.-- / -.-. .... .- .-. .-.. .. . / -.. --- "
				+ "/ -.-- --- ..- / .-- .- -. - / .- / -... .- .-.. .-.. --- --- -.");
		assertEquals("hey charlie do you want a balloon", converter1);
		{
		}
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1 = "how do i love thee let me count the ways";
		getFile("howDoILoveThee.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1, converter1);

		String test2 = "love looks not with the eyes but with the mind";
		getFile("LoveLooksNot.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2, converter2);

	}

	public void getFile(String in) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if (status == JFileChooser.APPROVE_OPTION) {
			try {
				inputFile = chooser.getSelectedFile();
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}