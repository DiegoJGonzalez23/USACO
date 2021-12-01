
import java.io.*;

import java.util.*;
public class swap {
	
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("swap.in");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		Scanner sc = new Scanner(fr);
		
		int n = sc.nextInt(); // number of cows
		int m = sc.nextInt(); // number of changes
		int k = sc.nextInt(); // number of iterations
		
		int[] cows = {1,2,3,4,5,6,7};
		pair[] pairs = new pair[m];
		int[] og = {1,2,3,4,5,6,7};
		for (int i = 0; i < m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			pairs[i] = new pair(x-1,y-1);
				
		}
		
		int[][] arrarr = new int[100000][n];
		int newcount = -1;
		int count = 0;
		int g = 1;
		while((!(Arrays.equals(cows, og)) && count != k) || g == 1){
			g = 0;
			for(pair p: pairs){
				
				int[] change = new int[p.y-p.x+1];
				int temp = p.y;
				int r= 0;
				while(temp>=p.x){
					change[r] = cows[temp];
					temp--;
					r++;
				}
				
				temp = p.y;
				int temp2 = p.x;
				r= 0;
				while(temp>=p.x){
					cows[temp2] = change[r];
					temp2++;
					temp--;
					r++;
				}
				newcount++;
				arrarr[newcount] = cows;
		
					
		
				}
				
				count++;
			}
		
		if(count == k){
			for(int p: cows){
				pw.println(p);

			}
		}
		
		if(Arrays.equals(cows, og)){
			
			int[] rightone = arrarr[newcount-((m*k) % (newcount+1))];
			for(int p: rightone){
		
				pw.println( p );
				
				
			}
		}
		
		
		
	
		
		
		
			
		}
		
		
		
		
	
	
	static class pair{
		public int x;
		public int y;
		
		public pair(int xx, int yy){
			x = xx;
			y = yy;
		}
		
		
		
		
	}
	
	
	

}

