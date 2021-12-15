package fr;
import java.util.*;
import java.io.*;
import java.lang.Math;


public class theGreatRevegetation {
	
	static boolean codebroken = false;

	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter("closing.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int pastures = Integer.parseInt(st.nextToken());
		int cows = Integer.parseInt(st.nextToken());
		
		
		// Make DFS
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean[] visited  = new boolean[pastures];
		char[] samediff = new char[cows];
		boolean[] checker = new boolean[pastures];
		
		for(int i  = 0; i < pastures; i++){
			visited[i] = false;
			graph.add(new ArrayList<Integer>());
		}
		
		// End DFS
		
		//Gather edges
		
		for(int i = 0; i < cows; i++){
			st = new StringTokenizer(br.readLine());
			String differentorsame = (st.nextToken());
			char diffsame = differentorsame.charAt(0);
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			if(diffsame == 'S'){	
				graph.get(x).add(y);
				graph.get(y).add(x);

			}
			
			else{
				graph.get(x).add(-y);
				graph.get(y).add(-x);
			}
			
		}
		
		
		checker[0] = true;
		dfs(graph, visited, 0, checker);
		int nextunvisitnoded = nextunvisitnode(visited, pastures);
		int numberofconnectedcomponents = 1;
		
		while(nextunvisitnoded != -1){
			numberofconnectedcomponents++;
			dfs(graph,visited,nextunvisitnoded, checker);
			if(codebroken){
				System.out.println(0);
				break;
			}
			
			nextunvisitnoded = nextunvisitnode(visited, pastures);

		}
		
		System.out.println(Math.pow(2.0, numberofconnectedcomponents));
		

	}
	
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startnode, boolean[] checker){
		
		visited[startnode] = true;
		
		for(Integer next: graph.get(startnode)){
			
			if(checker[Math.abs(startnode)]){
				if(next<0){
					
					if(checker[Math.abs(next)]){
						codebroken = true;
						
					}
					
					else{
						checker[Math.abs(next)] = false;
					}
					
				}
				
				else{
					if(!checker[Math.abs(next)]){
						codebroken = true;
						
					}
					
					else{
						checker[Math.abs(next)] = true;
					}
					
				}
				
				
			}
			
			else{
				
				if(next<0){
					
					if(!checker[Math.abs(next)]){
						codebroken = true;
					}
					
					else{
						checker[Math.abs(next)] = true;
					}
					
					
				}
				
				
				else{
					if(checker[Math.abs(next)]){
						codebroken = true;
					}
					
					else{
						checker[Math.abs(next)] = false;
					}
					
					
				}
					
				}
				
			
			
				
				
			
			
			
			if(!visited[Math.abs(next)]){
				dfs(graph,visited, Math.abs(next), checker);
				
			}
			
		}
		
		
		
	}
	
	public static int finalcount = 0;
	public static int nextunvisitnode(boolean[] visited, int pastures){
		
		for(int i = finalcount; i< pastures; i++){
			if(!visited[i]){
				return finalcount;
			}
			
			else{
				finalcount++;
			}
			
			
		}
		return -1;
		
		
	}

}
