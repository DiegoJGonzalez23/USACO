

import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("lineup.in");
		FileWriter fw = new FileWriter("lineup.out");

		Scanner sc = new Scanner(fr);
		

		HashMap<String, String[]> pairs = new HashMap<>();

		int N = sc.nextInt();
		HashSet<String> hascow = new HashSet<>();

		for(int i = 0; i < N; i++){

			String pair1 = sc.next();

			String useless = sc.next();
			useless = sc.next();
			useless = sc.next();
			useless = sc.next();

			String pair2  = sc.next();
			hascow.add(pair1);
			hascow.add(pair2);

			if(pair1.compareTo(pair2) > 0){ // pair2 comes before pair 1

				if(pairs.containsKey(pair2)){

					String otherpair = pairs.get(pair2)[0];
					if(pair1.compareTo(otherpair) > 0){ //otherpair comes before pair1

						String[] ss = {pair2, pair1};
						pairs.put(otherpair, ss);
						pairs.remove(pair2);

					}

					else{
						String[] ss = {pair2, otherpair};
						pairs.put(pair1, ss);
						pairs.remove(pair2);


					}



				}

				else{

					String[] nn = {pair1};
					pairs.put(pair2, nn);

				}

				
				






			}


			else{ // pair1 comes before pair2

				if(pairs.containsKey(pair1)){

					String otherpair = pairs.get(pair1)[0];
					if(pair2.compareTo(otherpair) > 0){ // otherpair comes before pair2

						String[] ss = {pair1, pair2};
						pairs.put(otherpair, ss);
						pairs.remove(pair1);

					}

					else{
						String[] ss = {pair1, otherpair};
						pairs.put(pair2, ss);
						pairs.remove(pair1);


					}



				}

				else{

					String[] nn = {pair2};
					pairs.put(pair1, nn);

				}




			}




		}



		String[] alphcows = {"Bessie", "Buttercup", "Belinda", "Beatrice", "Bella", "Blue", "Betsy",  "Sue"};
		Arrays.sort(alphcows);

		for(String cow: alphcows){

			if(pairs.containsKey(cow)){


				if(pairs.get(cow).length == 1){

					

					fw.write("" + cow);
					fw.write('\n');
					fw.write("" + pairs.get(cow)[0] );
					fw.write('\n');

				}

				else{


					fw.write("" + cow);
					fw.write('\n');
					fw.write("" + pairs.get(cow)[0] );
					fw.write('\n');
					fw.write("" + pairs.get(cow)[1] );
					fw.write('\n');



				}


			}


			else if (!hascow.contains(cow)){
				
				fw.write("" + cow );
				fw.write('\n');
			}



		}







		
		fw.close();
	}
}
