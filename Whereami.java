//package s;
// Diego Gonzalez 9.28.21
// Done During APCSA

import java.io.*;
import java.util.*;

public class Whereami {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader in = new FileReader("whereami.in");
		FileReader out = new FileReader("whereami.out");
		
		Scanner sc = new Scanner(in);
		
		int n = sc.nextInt();
		
		String colors = sc.next();
		
		
		for(int length = 0; length < n; length++){
			
			String[] subcolors = new String[n-length+1];
			int index = 0;
			int x = 0;
			int h = 0;
			int y = length+1;
			for(int p = 0; p < (n-length+2); p++){
				String sub = colors.substring(x,y);
				x++;
				y++;
				
				if(inString(subcolors, sub) == 0){
					subcolors[index] = sub;
				}
				
				else{
					h = 1;
					break;
				}
				
				index++;
			}
			
			
			if(h == 0){
				System.out.println(length+1);
				break;
			}
			
			
			
		}
	}
	
	
	
	public static int inString(String[] s, String subs){
		
		int count = 0;
		
		for(String x: s){
			if(s.equals(subs)){
				count++;
			}
		}
		return count;
		
	}

}
