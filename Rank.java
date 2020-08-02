// Description of Class: 
// Rank public class used in program to denote Freshmen, Sophomore, Juinor, and Seniors.
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

public enum Rank { 
	Freshman(1), Sophomore(2), Junior(3), Senior(4);
	private int r;
	Rank(int i) {this.r = i;}
	public int getRank() {
		return this.r;
	}
}
