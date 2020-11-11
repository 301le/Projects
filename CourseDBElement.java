public class CourseDBElement implements Comparable {

	String ID, room, name;
	int CRN, credits;

	public CourseDBElement() {
		ID = "";
		room = "";
		name = "";
		CRN = 0;
		credits = 0;
	}

	public CourseDBElement(String ID, int CRN, int credits, String room, String name) {
		this.ID = ID;
		this.CRN = CRN;
		this.credits = credits;
		this.room = room;
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public String getRoom() {
		return room;
	}

	public String getName() {
		return name;
	}

	public int getCRN() {
		return CRN;
	}

	public int getCredits() {
		return credits;
	}

	public int hashCode() {
		return String.valueOf(CRN).hashCode();
	}

	public void setCRN(int CRN) {
		this.CRN = CRN;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	@Override
	public int compareTo(CourseDBElement num) {
		if (CRN > num.CRN)
			return 1;
		else if (CRN < num.CRN)
			return -1;
		else
			return 0;
	}

	public String toString() {
		String str = "";
		str = "\nCourse:" + ID + " CRN:" + CRN + " Credits:" + credits + " Instructor:" + name + " Room:" + room;
		return str;
	}
}