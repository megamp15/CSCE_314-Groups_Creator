// Description of Class: 
// Builds the teams using the input data gathered by the Utility class' readFile function. Ouputs file to results.txt using Utility class' writeResults function.
// The main function to build the class is construct_group which calls the following functions: 
// The sort function uses the JavaKnowledgeComparator class to sort the collection  by javaKnowledge data member using data parsed from the input file using the readFile function in Utility.
// The separate_by_section separates the sorted collection into two arraylist sec502 and sec503 for the two sections.
// The group_together takes students from either end of the  arraylists and concatenates the two students data members into a string that is put into the pairs arrayList. 
// The group_together is called twice for each of the section arrayList.
// The results function uses the Utility class' writeResults to output the formatted string in pairs to results.txt 
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

import java.util.*;

public class TeamBuilder {
	//private data members
	private Student314 teams;
	private Utility util;
	private JavaKnowledgeComparator compare;
	// private ArrayList data members that are used in multiple functions below
	private ArrayList<Student314> students;
	private ArrayList<Student314> sec502;
	private ArrayList<Student314> sec503;
	private ArrayList<String> pairs;


	//default constructor that intializes the data members
	public TeamBuilder() {
		util = new Utility();
		compare = new JavaKnowledgeComparator();
		students = new ArrayList<Student314>();
		pairs = new ArrayList<String>();
		sec502 = new ArrayList<Student314>();
		sec503 = new ArrayList<Student314>();

	}
	
	public void sort(String fileName) {
		//Calls readfile in utility and we use the getter from utility to get the ArrayList Collection that has Students314 objects. 
		util.readFile(fileName, students);
		//Using the javaKnowledgeComparator we sort the collection by JavaKnowledge from lowest to highest.
		Collections.sort(students,compare);	
	}
	
	//Uses the collection and separates the students into two arraylist based on their section.
	public void separate_by_section() {
		//Iterate through entire collection
		for(int i=0;i<students.size();i++){
			//Add to sec502 arraylist if it matches the Student314 object's section data member. Otherwise we add to sec503 arraylist.
			if (students.get(i).getSection()==502) {
				sec502.add(students.get(i));
			}
			else {
				sec503.add(students.get(i));
			}
		}
	}
	
	//Uses a collection Arraylist to group two students from each end of the collection. The collection will be sorted due to the driver calling sort function before construct_group.
	public void group_together(ArrayList <Student314> slist) {
		int i=0; //Always want first object in array
		int j=slist.size()-1; //Always want last object in array
		while(j>=0) { //Until j becomes 0 which means there are no more objects in array.
			if(j!=i) { // two objects from beginning of array and end of array are accessed by getter functions to construct the string that will be outputed in results.txt. This string is added to a String arraylist collection called pairs.
				pairs.add(slist.get(i).getSection()+" - "+ slist.get(i).getFirstName()+ " " +slist.get(i).getLastName()+ " ("+ slist.get(i).getJavaKnowledge() + ") "+ slist.get(j).getFirstName()+ " " +slist.get(j).getLastName()+ " ("+ slist.get(j).getJavaKnowledge() + ") ");
			}
			else { //We have a odd number and there is still a single student in the arraylist so we construct a string for only that object.
				pairs.add("Substitue student for section "+slist.get(i).getSection()+" - "+ slist.get(i).getFirstName()+ " " +slist.get(i).getLastName()+ " ("+ slist.get(i).getJavaKnowledge() + ") ");
			}
			slist.remove(i); //remove first object in collection;
			if(j!=i) {
				slist.remove(j-1); //remove last object in collection.
			}
			j=slist.size()-1; //update j index to current last object after removing first and last objects.
		}
	}
	
	//Calls separate by section and group_together to construct the groupings of two people per section. This is called in the driver class.
	public void construct_group(){
		separate_by_section();
		group_together(sec502);
		group_together(sec503);
	}
	
	//Uses the utility writeResults function to output the groupings in the pairs arraylist to results.txt
	public void results() {
		util.writeResults(pairs);
	}
}

