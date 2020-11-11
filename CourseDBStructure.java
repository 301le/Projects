import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface {

	int b;
	LinkedList<CourseDBElement>[] hashTable;

	public CourseDBStructure(int size) {
		this.b = size;
		hashTable = new LinkedList[size];
	}

	public CourseDBStructure(String test, int size) {
		this.b = size;
		hashTable = new LinkedList[size];
	}

	@Override
	public void add(CourseDBElement element) {

		int hashIndex = element.hashCode();

		if (hashTable[hashIndex % b] == null) {
			LinkedList<CourseDBElement> link = new LinkedList<>();
			hashTable[hashIndex % b] = link;
			link.add(element);
		}

		else if (!hashTable[hashIndex % b].contains(element)) {
			hashTable[hashIndex].add(element);
		}

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		int hashIndex = String.valueOf(crn).hashCode();

		if (hashTable[hashIndex % b] == null) {
			throw new IOException();
		}

		for (int i = 0; i < hashTable[hashIndex % b].size(); i++) {
			if (hashTable[hashIndex % b].get(i).getCRN() == crn)
				return hashTable[hashIndex % b].get(i);
		}

		throw new IOException();
	}

	@Override
	public int getTableSize() {

		return b;
	}

}