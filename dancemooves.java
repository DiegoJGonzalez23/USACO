package s;
import java.io.*;
import java.util.*;

public class dancemooves {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int amountcows = Integer.parseInt(st.nextToken());
		int changes = Integer.parseInt(st.nextToken());
		cow[] cowline = new cow[amountcows];
		cow[] tempcows = new cow[amountcows];
		
		for(int i = 1; i < amountcows+1; i++){
			cow thisone = new cow(i);
			cowline[i-1] = thisone;
			tempcows[i-1] = thisone;
			thisone.visited.add(i);
			
		} 
		
	
		
		
		int arr[][] = new int[changes][2];
		
		for(int i = 0; i < changes; i++){
			st = new StringTokenizer(br.readLine());
			
			arr[i][0] =Integer.parseInt(st.nextToken());
			arr[i][1] =Integer.parseInt(st.nextToken());
		
			
		}
		

		int y = 1;
		while(arraycheck(tempcows, cowline) || (y == 1)){

			
			
			
			int pos1 = arr[(y-1) % changes][0];
			int pos2 = arr[(y-1) % changes][1];
			
			cow temp = cowline[pos1-1];
			cowline[pos1-1].visited.add(pos2);
			cowline[pos2-1].visited.add(pos1);
			
			cowline[pos1-1] = cowline[pos2-1];
			cowline[pos2-1] = temp;
			
			
			
			
			y++;
			
			//for(cow r: cowline){System.out.print(r.cowid + " ");}
			//System.out.println();
			//for(cow r: tempcows){System.out.print(r.cowid + " ");}
			
		}
		
		
		for(cow r: cowline){
			System.out.println(r.visited.size());
		}
		
		

	}
	
	
	
	public static class cow{
		public int cowid;
		public HashSet<Integer> visited = new HashSet<>();
		
	
		
		
		public cow(int id){
			cowid = id;
		}
		
	}
	
	
	public static boolean arraycheck(cow[] arr1, cow[] arr2){
	
		int z = 0;
		for(cow t: arr1){
			if (arr2[z].cowid != t.cowid){
				return true;
			}
			z++;
		}
		
		return false;
		
		
	}

}
