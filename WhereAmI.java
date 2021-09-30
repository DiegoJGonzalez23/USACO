//package Usac;
import java.io.*;
import java.util.*;




public class WhereAmI {

	public static void main(String[] args) throws IOException {
		
		FileReader inp = new FileReader("whereami.in");
		Scanner sc = new Scanner(inp);

		FileWriter out = new FileWriter("whereami.out");
		
		int N = sc.nextInt();
		
		String word = sc.next() + " ";
		
		
		for(int i = 1; i < word.length(); i++){
			
			int x = 0; // index count
			int y = 0;
			String[] subsets = new String[word.length()-i];
			
			int point1 = 0;
			int point2 = i;
			
			
			
			
			while(point2 < word.length()){
				
				String subset = word.substring(point1, point2);
				
				
				point1++;
				point2++;
				
					if(point1 == 1){
						subsets[x] = subset;
						y++;
						x++;
					}
				
					else{
						
					
					
					if(subsetchecker(subsets, subset)){
						break;
					}
					
					else{
						subsets[x] = subset;
						y++;
						x++;
					}
					
					}
					
				
				
								
				
				
				
			}
			
			
			if(y == word.length() - i){
				out.write("" + i);
				sc.close();
				out.close();
				break;
			}
			
			
			
			
		}
		
		
	}
	
	public static boolean subsetchecker(String[] subsets, String subset){
		
			
		
		for(String x: subsets){
			
			if(x != null){
				
			
			if (x.equals(subset)){
				return true;
			}
		}
			
			
		}
		
		
		return false;
	}

}
