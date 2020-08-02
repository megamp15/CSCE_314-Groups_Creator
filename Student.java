// Description of Class: 
// Student class that is a subclass of abstract Person with two more data members: UIN and Rank.
// The class has constructor, getters, setters, equals, and toString to complete the class profile. 
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

public class Student extends Person{
	//Privata Data Members
	private String UIN;
	private Rank Rank;
	
	//Paramterized Constructor- The constructor calls the super function to call the person constructor to set the firstName and lastName data members.
	public Student(String firstName, String lastName, String uIN, Rank rank) {
		super(firstName, lastName);
		UIN = uIN;
		this.Rank = rank;
	}
	
	//getters amd setters
	public String getUIN() {
		return UIN;
	}
	public Rank getRank() {
		return Rank;
	}
	public void setUIN(String uIN) {
		UIN = uIN;
	}
	public void setRank(Rank rank) {
		this.Rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((UIN == null) ? 0 : UIN.hashCode());
		result = prime * result + ((Rank == null) ? 0 : Rank.hashCode());
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
		Student other = (Student) obj;
		if (UIN == null) {
			if (other.UIN != null)
				return false;
		} else if (!UIN.equals(other.UIN))
			return false;
		if (Rank != other.Rank)
			return false;
		return true;
	}
	//toString function for outputting Student data members.
	@Override
	public String toString() {
		return "Student [UIN=" + UIN + ", rank=" + Rank + "]";
	}
}
