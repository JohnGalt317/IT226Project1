package edu.ilstu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 * @author Christopher Runyan
 */
public class DriverHelper {
	DataReader dReader=new DataReader();
	
	public void printMenu(){
		System.out.print("Choices:\n\"A\": Add data (You will need to enter an input filename)"
				+ "\n\"S\": Save data (You will need to enter a student ID and output filename)"
				+ "\n\"G\": Return data (Returns student, grade, and course specific information)"
				+ "\n\"E\": Exit the program"
				+ "\n\nEnter choice here: ");
	}
	
	public boolean validateInput(String input){
		boolean valid=false;
		
		if(input.length()==1){
			if(input.equalsIgnoreCase("A")||input.equalsIgnoreCase("S")||input.equalsIgnoreCase("G")||input.equalsIgnoreCase("E")){
				valid=true;
			}
		}
		
		return valid;
	}
	
	public void optionA(Scanner kb){
		String inputFileName="";
		String firstLine="";
		String[] lines=new String[300];
		int counter=0;
		
		System.out.print("Enter name of input file (course-semester-year.csv): ");
		inputFileName=kb.nextLine();
		try{
			Scanner reader=new Scanner(new BufferedReader(new FileReader(inputFileName)));
			//read first line
			firstLine=reader.nextLine();
			//read each line after and put into array
			while(reader.hasNextLine()){
				lines[counter]=reader.nextLine();
				counter++;
			}
			//find size of filled string array, pass to data reader
			dReader.setStudentArraySize(counter);
			//use DataReader to process data
			dReader.formatData(firstLine, lines);
			//return student array from DataReader
			//find size of filled student array
			//add each student in array to linked list
			reader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void optionS(Scanner kb){
		String studentID="";
		String outputFileName="";
		
		System.out.print("Enter student ID for student to save data from: ");
		studentID=kb.nextLine();
		//validate student ID is associated with a real one
		System.out.print("Enter the name of the text file the student's information should be saved to (firstname-lastname): ");
		outputFileName=kb.nextLine();
		
		try{
			PrintWriter writer=new PrintWriter(outputFileName+".txt");
			//print student data from student id
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void optionG(Scanner kb){
		
	}
}
