package csvReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class csvReader {
	
	static int firstDiv = 10;
	static int secondDiv = 10;
	static int thirdDiv = 10;
	
	static int firstPoint = 0;
	static int secondPoint = 0;
	static int thirdPoint = 0;
	
	

	public static void main(String[] args) {
		//Initial Values
		String csvFile = "testCSV.csv";
		
		//Array to store lists of results
		Object[][] list = new Object[3][6];
		
		//Object Array for temporary storage of results
		Object[] records = new Object[6];
		
		
		
		//File Reader
		try {
			Scanner sc = new Scanner(new File(csvFile));
			
			//Skipping Header
			sc.nextLine();
		
			while (sc.hasNextLine()) {
				//Adding current line of CSV to array
				records = sc.nextLine().split(",");
				
				//Sorting Value
				list = sort(records, list);
			
			}
			
			//Printing output
			System.out.print("Records: \n" + printValue(list[0])  + printValue(list[1]) + printValue(list[2]));
			
			//Closing Scanner
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}
	
	public static Object[][] sort(Object[] record, Object[][] sortedList){
			
			Object[] buffer = new Object[6];
			
			//Retrieving division and point values for comparison
			int division = Integer.valueOf(record[3].toString());
			int points = Integer.valueOf(record[4].toString());
			
			//Adding top 3 values to array
			if (division < firstDiv || (division <= firstDiv && points > firstPoint)) {
				firstDiv = division;
				firstPoint = points;
				
				//Checking if a value needs to be re-sorted
				if(sortedList[0][0] != null) {
					//Adding current value to buffer
					buffer = sortedList[0]; 
					//Replacing Value
					sortedList[0] = record;
					sortedList = sort(buffer, sortedList);
				} else {
					sortedList[0] = record;
				}
				
			} else if (division < secondDiv || (division == secondDiv && points > secondPoint)) {
				secondDiv = division;
				secondPoint = points;
				
				//Checking if a value needs to be re-sorted
				if(sortedList[1][0] != null) {
					//Adding current value to buffer
					buffer = sortedList[1]; 
					sortedList[1] = record;
					sortedList = sort(buffer, sortedList);
				} else {
					sortedList[1] = record;
				}
				
			} else if (division < thirdDiv || (division <= thirdDiv && points > thirdPoint)) {
				thirdDiv = division;
				thirdPoint = points;
				
				//Checking if a value needs to be re-sorted
				if(sortedList[2][0] != null) {
					//Adding current value to buffer
					buffer = sortedList[2]; 
					//Replacing Value
					sortedList[2] = record;
					sortedList = sort(buffer, sortedList);
				} else {
					sortedList[2] = record;
				}
				
			}
			
			return sortedList;
			
		}
	
	

	public static String printValue(Object[] record) {
		String output;
		
		//Arranging String
		output = ("- name: " + record[0].toString() + " " +  record[1].toString() + "\n"
				+ "details: In Division " + record[3].toString() + " from " + record[2].toString() + " performing " + record[5].toString() + "\n");
		
		return output;
	}
	
}



