
import java.io.*;
import java.util.*;

public class highcard{
	public static void main(String[] args) throws IOException {
		 BufferedReader r = new BufferedReader(new FileReader("highcard.in"));
		 PrintWriter pw = new PrintWriter(new FileWriter("highcard.out"));

	

		StringTokenizer st = new StringTokenizer(r.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		ArrayList<Integer> opps = new ArrayList<>();
		ArrayList<Integer> mine = new ArrayList<>();
		HashSet<Integer> o = new HashSet<>();
		for(int i = 0; i < n; i++){
			st = new StringTokenizer(r.readLine());
			int x = Integer.parseInt(st.nextToken());
			opps.add(x);
			o.add(x);
		}
		
		for(int i = 1; i < 2*n+1; i++){
			if(o.contains(i)){

			}
			else{
				mine.add(i);
			}
		}
		Collections.sort(opps);
		Collections.sort(mine);

		int count = 0;

		for(int i = 0 ; i < opps.size(); i++){

			int current = opps.get(i);
			while(true){

				if(mine.size() == 0){
					break;
				}
				if(mine.get(0)> current){
					count++;
					mine.remove(0);
					break;
				}
				else{
					mine.remove(0);
				}



			}

			




		}
		pw.println(count);
		pw.close();










	


	}

	
}
