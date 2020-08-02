// Description of Class: 
// Student314 class that is a subclass of Student with two more data members: JavaKnowledge and Section
// The class has constructor, getters, setters, equals, and toString to complete the class profile. 
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

public class Student314 extends Student{
	//Privata Data Members
	private int JavaKnowledge;
	private int section;
	
	//Paramterized Constructor - The constructor calls the super function to call the Student constructor to set the firstName, lastName, UIN, and rank data members.
	public Student314(String firstName, String lastName, String uIN, Rank rank, int javaKnowledge, int section) {
		super(firstName, lastName, uIN, rank);
		JavaKnowledge = javaKnowledge;
		this.section = section;
	}
	
	//getters amd setters
	public int getJavaKnowledge() {
		return JavaKnowledge;
	}

	public int getSection() {
		return section;
	}

	public void setJavaKnowledge(int javaKnowledge) {
		JavaKnowledge = javaKnowledge;
	}

	public void setSection(int section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + JavaKnowledge;
		result = prime * result + section;
		return result;
	}
	//equals to compare two objects.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student314 other = (Student314) obj;
		if (JavaKnowledge != other.JavaKnowledge)
			return false;
		if (section != other.section)
			return false;
		return true;
	}
	//toString function for outputting Person data members.
	@Override
	public String toString() {
		return "Student314 [JavaKnowledge=" + JavaKnowledge + ", section=" + section + "]";
	}
}
