//package sss;
import java.io.*;
import java.util.*;
import java.lang.Math;
public class BreedCounting {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter("bcount.out");
		StringTokenizer st = new StringTokenizer(br.readLine());

		int cows = Integer.parseInt(st.nextToken());
		int queries = Integer.parseInt(st.nextToken());
		
		int[] id = new int[cows];
		for(int i = 0; i < cows; i++){
			st = new StringTokenizer(br.readLine());
			id[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count1 = new int[cows];
		int[] count2 = new int[cows];
		int[] count3 = new int[cows];
		count1[0] = 0;
		count2[0] = 0;
		count3[0] = 0;
		if(id[0] == 1){
			count1[0] += 1;
		}
		if(id[0] == 2){
			count2[0] += 1;
		}
		if(id[0] == 3){
			count3[0] += 1;
		}
		
		for(int i = 1; i < cows; i++){
			
			if(id[i] == 1){
				count1[i] = 1+count1[i-1];
				count2[i] = count2[i-1];
				count3[i] = count3[i-1];
			}
			if(id[i] == 2){
				count2[i] = 1+count2[i-1];
				count1[i] = count1[i-1];
				count3[i] = count3[i-1];
			}
			if(id[i] == 3){
				count3[i] = 1+count3[i-1];
				count2[i] = count2[i-1];
				count1[i] = count1[i-1];
			}
			
			
			
		}
		
		// Now we deal with the queries, done with the prefix sums
		
		for(int i = 0; i < queries; i++){
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			
			if(a== 0){
				pw.print(count1[b] + " ");
				pw.print(count2[b] + " ");
				pw.print(count3[b]);
				pw.println();
			}
			else{
				pw.print(count1[b]-count1[a-1]+ " ");
				pw.print(count2[b]-count2[a-1]+" ");
				pw.print(count3[b]-count3[a-1]);
				pw.println();
			}
			
			
		}
		
		
		pw.close();
	}

}
