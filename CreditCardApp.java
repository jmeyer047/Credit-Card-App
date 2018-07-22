package oop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreditCardApp {

	public static void main(String[] args) {
		List<String[]> data = new ArrayList<String[]>();
		String filename = "C:\\Users\\jmeye\\eclipse-workspace\\JavaTraining\\src\\oop\\creditcards.txt";
		String datarow;
		double cost = 0.00;
		double credit = 0.00;
		double debit = 0.00;
		
		File file = new File(filename);
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			while((datarow = br.readLine()) != null) {
				String[] line = datarow.split(",");
				data.add(line);
				//System.out.println(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//[date, debit/credit, location, amount(double)]
		for(String[] row: data) {
			//System.out.println(row[1]);
			if(row[1].contains("CREDIT") || row[1].contains("FEE")) {
				//credit = Double.parseDouble(row[4]);
				cost -= Double.parseDouble(row[3]);
				//System.out.println(cost);
			}
			else if(row[1] == "DEBIT") {
				cost += Double.parseDouble(row[3]);
				//System.out.println(cost);
			}
		}
		
		if(cost < 0) {
			double percent = cost*0.1;
			cost += percent;
			System.out.println("Warning, you underpaid. You will be charged a 10% fee.");
		}
		else if(cost==0) {
			System.out.println("Thank you.");
		}
		else {
			System.out.println("Thank you. You overpaid by "+cost);
		}
	}

}
