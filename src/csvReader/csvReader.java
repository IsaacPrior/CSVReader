package csvReader;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class csvReader {

	public static void main(String[] args) {
		//Initial Values
		String csvFile = "testCSV.csv";
		
		Object[] records = new Object[6];
		
		//File Reader
		try {
			Scanner sc = new Scanner(new File(csvFile));
			//sc.useDelimiter(",");
			
			//Skipping Header
			sc.nextLine();
		
			while (sc.hasNextLine()) {
				//Adding current line of CSV to array
				records = sc.nextLine().split(",");
				
				//Temporary print for verification
				System.out.println(Arrays.toString(records));

			}
			
			
			
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
