// Description of Class: 
// The Utility class has two main functions:
// The readFile function takes a string filename to open and read line by line using scanner. Each line is parsed by split and parsed further to get desired the desired data for the Student314 parameterized constructor.
// The student object created is then put into a students arraylist collection that is passed in the parameter. There is error logging for the rank, javaKnowledge, and section data members since they get converted to integers and rank is of enum data type.
// There is error logging if the input file could not be found as well.
// The writeResults function takes a collection arraylist of strings and writes the contents of the collection to results.txt using printWriter. There is errorlog writting if the results.txt was not able to opened or written to.
// Name: Mahir Pirmohammed
// UIN: 927006039
// Email: megamp15@tamu.edu

import java.io.*;
import java.util.*;

public class Utility {

	//readFile function that uses input file from paramter to gather the student data and place Student314 objects into the students Arraylist collection.	
	public boolean readFile(String file, ArrayList<Student314> students){
		//ErrorFile creation and writing with error catch.
		File errorFile = new File("ErrorLog.txt"); 
		PrintWriter writer = null;
		try {
		writer = new PrintWriter(errorFile);
		}
		catch(IOException e){
			System.out.println("Was not able to create/write to ErrorFile.");	
			e.printStackTrace(); // prints error(s)
		}
		
		//Main input file reading.
		try
		{
			//Scanner for read input line by line.
			Scanner infile = new Scanner(new FileReader(file));
			infile.nextLine(); //ignore header of the csv file
			while(infile.hasNext()) { //for loop that runs till end of file (eof)
				String line = infile.nextLine(); // updates to next line in file.
				String[] data = line.split(","); //Split by comma because csv.
				//String variables for parsed data
				String fname = "";
				String lname = "";
				String uin = "";
				String rankstr= "";
				String javakstr=data[1];
				String secstr="";
				//Check if data[4] string is equal to expression because of extra comma in some input lines because of "I would like to stay with my partner if possible" section
				if(data[4].matches(" time to move on\"")){
					//Parse correct data from string data list.
					String[] name = data[5].split(" ");
					String[] email = data[7].split("@"); 
					String[] sec = data[6].split(" ");
					//Assign final parsed data to variables for parameterized constructor and Error logging.
					fname=name[0];
					lname=name[1];
					uin=email[0];
					rankstr=data[8];
					secstr=sec[0];
				}else {
					//Parse correct data from string data list.
					String[] name = data[4].split(" ");
					String[] email = data[6].split("@"); 
					String[] sec = data[5].split(" ");
					//Assign final parsed data to variables for parameterized constructor and Error logging.
					fname=name[0];
					lname=name[1];
					uin=email[0];
					rankstr=data[7];
					secstr=sec[0];
				}
				// Errors in rank from bad input so we use regex expr to see if the rank is a digit from 1-4.
				if(rankstr.matches("\\d?[1-4]")) {
					Rank r = null;
					int javaK = -1;
					//Accesses Rank enum to assign the correct rank to r variable for Student314 object.
					for (Rank r1: Rank.values())
					{
						if (r1.getRank() == Integer.parseInt(rankstr)) {
							r = r1;
						}
					}
					//Errors in javaKnowledge from bad input so we use regex expr to see if the rank is a digit from 1-5
					if(data[1].matches("\\d?[1-5]")) {
						javaK = Integer.parseInt(data[1]);
						//Errors in section from bad input so we use regex expr to see if the section is 502 or 503.
						if(secstr.matches("(502|503)")){
							//Student314 parametrized constructor if it passes all the bad input checks for rank, javaKnowledge, and section
							Student314 s = new Student314(fname,lname,uin,r,javaK,Integer.parseInt(secstr));
							//Add to private data member that is storing each Student314 object
							students.add(s);
						}
						else {
							//Write error if invalid section found into Errorlog.txt
							writer.println("Student "+fname+" "+lname+" has an invalid section, "+secstr+" from input file. The student is not included in final groupings.");
						}
					}
					else {
						//Write error if invalid javaKnowledge found into Errorlog.txt
						writer.println("Student "+fname+" "+lname+" has an invalid javaKnowledge, "+data[1]+" from input file. The student is not included in final groupings.");
					}
				}
				else {
					//Log bad input into Errorlog.txt
					writer.println("Student "+fname+" "+lname+" has an invalid Rank, "+rankstr+" from input file. The student is included in the final groupings.");
					//Still create object for the student but the Rank is null (unknown) because of bad input.
					Student314 s = new Student314(fname,lname,uin,null,Integer.parseInt(data[1]),Integer.parseInt(secstr));
					//Add to private data member that is storing each Student314 object
					students.add(s);
				}
			}
			//close input file.
			infile.close();
		} 
		catch (FileNotFoundException e) 
		{
			//Error in opening input file so we write to Errorlog.txt and close file.
			writer.println("Input File not found in Driver from TeamBuilder sort function call");
			writer.close();
			e.printStackTrace(); // prints error(s) to console
			return false; //unsuccessfully read input data
		}
		//close writing to Errorlog.txt to close and save file.
		writer.close();
		return true; //successfully read input data
	}
	
	//writing results to results.txt
	public boolean writeResults(ArrayList<String> t){
		try
		{
			//Opening results.txt in unappend mode and creating writer to this file.
			FileWriter out = new FileWriter("results.txt", false);
			PrintWriter writer = new PrintWriter(out);
			//Using the ArrayList passed in parameter we go through the entire arrayList and write the contents of the arraylist to results.txt
			for(int i=0; i<t.size();i++) {
				writer.println(t.get(i));
			}
			//close writing to results.txt to close and save file.
			writer.close();
		}
		catch (IOException  e)
		{
			//Error in writing to output file so we write to Errorlog.txt and close file.
			FileWriter errorFile = null;
			try {
				errorFile = new FileWriter("Errorlog.txt", false);
			} catch (IOException e1) {
				e1.printStackTrace(); // prints error(s) to console for errorFile opening.
			}
			PrintWriter writer = new PrintWriter(errorFile);
			writer.println("Was not able to write to results.txt file. Exception in writeResults function in Utility class");
			writer.close();
			e.printStackTrace(); // prints error(s) to console
			return false; //could not write to results.txt
		}
		return true; //successfully wrote to results.txt
	}
}
