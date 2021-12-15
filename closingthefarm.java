package ProblemsSilver;
import java.util.*;
import java.io.*;


public class closingthefarm{
	public static HashSet<Integer> closed = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter("closing.out");
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());
		
	
		
		// Setting up graph, and dfs structures
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean[] visited = new boolean[nodes];
		
		for(int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<Integer>()); // initialize the arraylists
			visited[i] = false;
		}
		
		for(int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			
			graph.get(x).add(y);
			graph.get(y).add(x);

		}
		int p = 0;
		dfs(graph, visited, 0);
		for(boolean x: visited) {
			if(!x) {
				p = 1;
				pw.println("NO");
			}
		}
		if(p==0) {
			pw.println("YES");
		}
		 // ^^ Checking connected before any changes
		for(int i = 0; i < nodes; i++) {visited[i] = false;}
		// reseting visited;
		for(int i = 0; i < nodes; i++) {
			st = new StringTokenizer(br.readLine());
			int closedbarn = Integer.parseInt(st.nextToken())-1;
			
			if(i == nodes-1) {
				continue;
			}
			else {
			
			
			graph.get(closedbarn).clear();
			closed.add(closedbarn);
			//System.out.println(closed);
			//System.out.println(closed.contains(closedbarn));
			
			dfs(graph, visited, nextopennode(nodes));
			p  = 0;
			for(int r = 0; r < nodes; r++) {
				
				if(!visited[r] && !closed.contains(r)) {
				
					p=1; 
					pw.println("NO");
					break;
				}
			}
			if(p == 0) {
				pw.println("YES");
			}
			
			
			
			
			//after
			for(int j = 0; j < nodes; j++) {visited[j] = false;}
			}
			
		}
		pw.close();
		
		
		
		
		
		
	}
	
	public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int startnode) {
		visited[startnode] = true;
		
		for(Integer next: graph.get(startnode)) {
			
			if(!visited[next]) {
				dfs(graph, visited, next);
			}
			
			
		}

	}
	
	public static int nextopennode(int nodes) {
		
		for(int i = 0; i < nodes; i++) {
			
			if(!closed.contains(i)) {
		
				return i;
			}
	
		
	}
		return -1;
		

}
}
