package csvReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class csvReader {

	public static void main(String[] args) {
		//Initial Values
		String csvFile = "testCSV.csv";
		int firstDiv = 0;
		int secondDiv = 0;
		int thirdDiv = 0;
		
		int firstPoint = 0;
		int secondPoint = 0;
		int thirdPoint = 0;
		
		//Object Array for temporary storage of results
		Object[] records = new Object[6];
		
		//Array to store lists of results
		Object[] list = new Object[3];
		
		//File Reader
		try {
			Scanner sc = new Scanner(new File(csvFile));
			
			//Skipping Header
			sc.nextLine();
		
			while (sc.hasNextLine()) {
				//Adding current line of CSV to array
				records = sc.nextLine().split(",");
				
				//Retrieving division and point values for comparison
				int division = Integer.valueOf(records[3].toString());
				int points = Integer.valueOf(records[4].toString());
				
				//Adding top 3 values to array
				if (division >= firstDiv && points > firstPoint) {
					list[0] = records;
					firstDiv = division;
					firstPoint = points;
				} else if (division >= secondDiv && points > secondPoint) {
					list[1] = records;
					secondDiv = division;
					secondPoint = points;
				} else if (division >= thirdDiv && points > thirdPoint) {
					list[2] = records;
					thirdDiv = division;
					thirdPoint = points;
				}
				
			}
			
			
			//Closing Scanner
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}


