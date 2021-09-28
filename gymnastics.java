//package s;

// Diego Gonzalez
// Problem solved during APCSA


import java.io.*;
import java.util.*;

public class gymnastics {

	public static void main(String[] args) throws IOException {
		
		FileInputStream in = null;
	    FileOutputStream out = null;
		
		in = new FileInputStream("gymnastics.in");
		FileWriter myWriter = new FileWriter("gymnastics.out");
		Scanner sc = new Scanner(in);
		int finalcount = 0;
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		int[][] scores = new int[n][k];
		
		for(int i = 0; i < k; i++){
			for(int p = 0; p < n; p++){
				int cow = sc.nextInt();
				scores[cow-1][i] = p+1;
			}
			
		}
		
		
		
		for(int[] j: scores){
			
		
			
			for(int[] r: scores){
				int count = 0;
				int index = 0;
				for(int p: r){
					if (j[index] < p){
						count++;
					}
					index++;
				}
			
			
			
			 if(count == k){
				finalcount++;
			}
			
		}
		
		
		
		
		

	}
		myWriter.write("" + finalcount);
		
		in.close();
		myWriter.close();

}
}
