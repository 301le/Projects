import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {

	CourseDBStructure CDBSE;

	public CourseDBManager() {
		CDBSE = new CourseDBStructure(50);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {

		CourseDBElement data = new CourseDBElement(id, crn, credits, roomNum, instructor);

		CDBSE.add(data);
	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			CourseDBElement data = CDBSE.get(crn);
			return data;
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {

		if (!input.exists())
			throw new FileNotFoundException();
		Scanner read = new Scanner(input);

		while (read.hasNextLine()) {

			String data = read.nextLine();
			String[] str = data.split(" ");

			CourseDBElement e = new CourseDBElement();
			e.setID(str[0]);
			e.setCRN(Integer.parseInt(str[1]));
			e.setCredits(Integer.parseInt(str[2]));
			if (str[4].equals("Learning")) {
				e.setRoom("Distance Learning");

				String a = "";
				for (int i = 5; i < str.length; i++)
					a += str[i];
				e.setName(a);
			} else {
				e.setRoom(str[3]);
				String a = "";
				for (int i = 4; i < str.length; i++)
					a += str[i];
				e.setName(a);
			}

			CDBSE.add(e);
		}
		read.close();
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> array = new ArrayList<>();

		for (int i = 0; i < CDBSE.b; i++) {
			if (CDBSE.hashTable[i] == null)
				continue;
			else {

				for (int j = 0; j < CDBSE.hashTable[i].size(); j++) {
					array.add(CDBSE.hashTable[i].get(j).toString());
				}
			}
		}
		return array;
	}

}