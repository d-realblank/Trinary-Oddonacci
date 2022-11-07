import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class App {


	public static void main(String[] args) {

		//Creating Files
		try {
			
			//OddoOut file to print results
			File OddoOut = new File("OddoOut.txt");
			if (OddoOut.createNewFile()) {
				System.out.println("File created: " + OddoOut.getName());
			} else {
				System.out.println("File Appended.");}
			
			//OddoAnalysis file for time analysis
			File OddoAnalysis = new File("OddoAnalysis.txt");
			if (OddoAnalysis.createNewFile()) {
				System.out.println("File created: " + OddoAnalysis.getName());
			} else {
				System.out.println("File Appended.");}
			
		} catch (IOException e) {
			System.err.println("An error occurred with opening the files.");
			e.printStackTrace();
		}

		
		double startTime,endTime,duration;

		//Arrays for running
		long[] linearArray;
		long binaryArray;
		long[] linearArray1 = new long[10];//Linear		
		long[] binaryArray1 = new long[10];// Binary
		
		
		//
		try
		{
			PrintWriter pr1 = new PrintWriter("OddoAnalysis.txt");    
			// Linear
			pr1.println("Time analysis for Linear calculator:");
			for (int i = 1; i <= 9; i++) {
				startTime = System.nanoTime();
				linearArray = linearFibonacci(i*5-1);
				linearArray1[i-1] = linearArray[0];
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				pr1.println("Iteration " + (i) + " Time Taken: " + duration/1000000 + "ms");
			}
			
			// Binary
			pr1.println("Time analysis for Binary calculator:");
			for (int i = 1; i <= 9; i++) {
				startTime = System.nanoTime();
				binaryArray = binaryOddonacci(i*5-1);
				binaryArray1[i-1] = binaryArray;
				endTime = System.nanoTime();
				duration = (endTime - startTime);
				pr1.println("Iteration " + (i) + " Time Taken: " + duration/1000000 + "ms");
			}
			pr1.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("No such file exists.");}

		//Printing output of each version in a text file
		try {
			PrintWriter pr = new PrintWriter("OddoOut.txt");   
			pr.println("Linear Calculator Results:");
			for (int i = 0; i < 9; i++) {
				pr.println(linearArray1[i]);
			}
			pr.println("\nBinary Calculator Results:");
			for (int i = 0; i < 9; i++) {
				pr.println(binaryArray1[i]);
			}
			pr.close();
		}
		
		catch (Exception e)	{
			e.printStackTrace();
			System.out.println("An error occurred with opening the files.");
		}
		System.out.println("\nTesting tailBinaryFib method:");
	}

	// Returns the nth Oddonacci number (inefficiently)
	public static long binaryOddonacci(int n) {
		if (n <= 2){
			return 1;
		}else 
			return binaryOddonacci(n-3) + binaryOddonacci(n-2) + binaryOddonacci(n-1);
		}

	//Returns an array containing the tripplet of Oddonacci numbers, F(n), F(n-1)
	public static long[] linearFibonacci(int n){
		if (n <= 2) {
			long[] answer = {1,1,1};
			return answer;
		} else {
			long[] temp = linearFibonacci(n-1);									// return {O(n-1), O(n-2), O(n-3)}
			long[] answer = {temp[0] + temp[1] + temp[2], temp[0], temp[1]};	// we want {O(n),O(n-1),O(n-2)}
			return answer;
		}
	}
	

}