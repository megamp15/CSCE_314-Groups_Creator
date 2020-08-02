// Description of Class: 
// The comparator for Student314 objects for the javaKnowledge data member. 
// Used by the sort function in TeamBuilder class to sort the collection by javaKnowledge data member: lowest to highest.
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

import java.util.Comparator;

public class JavaKnowledgeComparator implements Comparator<Student314>{
	@Override
	public int compare(Student314 s1, Student314 s2) { //compares two Student314 objects
	    {   
	        if(s1.getJavaKnowledge() < s2.getJavaKnowledge()) {return -1;} //if first Student314 object's java knowledge is less than second Student314 object's java knowledge
	        else if(s1.getJavaKnowledge() > s2.getJavaKnowledge()) {return 1;} //if first Student314 object's java knowledge is greater than second Student314 object's java knowledge
	        else { return 0;} //if first Student314 object's java knowledge is equal to second Student314 object's java knowledge
	    }
	}
}