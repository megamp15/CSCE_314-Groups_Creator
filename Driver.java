// Description of Class: 
// Driver class that builds an instance of the TeamBuilder class and calls three different functions of the TeamBuilder class: sort(), construct_group(), results(). 
// The sort function takes the input file location as a string. 
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu


public class Driver {
	public static void main(String[] args) {
		TeamBuilder teamMaker = new TeamBuilder(); //Creates object teamMaker of class TeamBuilder.
		teamMaker.sort("./CSCE_314-Survey Data.csv"); //Calls TeamBuilder's sort function that takes in the input file path to csv file
		teamMaker.construct_group(); //Calls TeamBuilder's construct_group function that creates two person groups.
		teamMaker.results(); //Calls TeamBuilder's results function that outputs the groups to a results.txt file.
	}
}