package csvReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class csvReader {

	public static void main(String[] args) {
		//Initial Values
		String csvFile = "testCSV.csv";
		
		//Object Array for temporary storage of results
		Object[] records = new Object[6];
		
		//Arraylist to store lists of results
		ArrayList<Object[]> list = new ArrayList<Object[]>();
		
		//File Reader
		try {
			Scanner sc = new Scanner(new File(csvFile));
			
			//Skipping Header
			sc.nextLine();
		
			while (sc.hasNextLine()) {
				//Adding current line of CSV to array
				records = sc.nextLine().split(",");
				
				//Adding retrieved results to arraylist
				list.add(records);
			}
			
			//Temporary print for verification
			for (int i = 0; i < list.size(); i++) {
				System.out.println(Arrays.toString(list.get(i)));
			}
			
			
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
