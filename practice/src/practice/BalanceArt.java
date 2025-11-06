package practice;

import java.util.*;
import java.io.*;

public class BalanceArt {
	static class Edge {
		int to;
		int rev;
		
		long cap;
		
		Edge(int to, long cap, int rev)
		{
			this.to = to;
			this.cap = cap;
			this.rev = rev;
		}
	}
	
	
	static List<Edge>[] graph;
	static int[] level;
	static int[] iter;
	
	static int n;
	static int m;
	
	static int[][] edges;
	static int[] diskCounts;
	
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter the number of spheres");
		
		
		n = scnr.nextInt();
		
		System.out.println("Enter the number of wires connecting the spheres");
		
		
		m = scnr.nextInt();
		
		edges = new int[m][3];
		
		diskCounts = new int[m];
		
		long totalDisks = 0;
		
		
		for (int i  = 0; i < m; i++)
		{
			edges[i][0] = scnr.nextInt() - 1; // u
			edges[i][1] = scnr.nextInt() - 1; // v
			edges[i][2] = scnr.nextInt(); //disks
			diskCounts[i] = edges[i][2];
			totalDisks += edges[i][2];
		}
		
		//Binary search for maxixmum balance number B
		
		
		long low = 0;
		
		long high = totalDisks / n;
		
		
		long maxB = 0;
		
		while (low <= high)
		{
			long mid = (low + high) / 2;
			
			if( canAchieveBalance(mid))
			{
				maxB = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		long remaining = totalDisks - (maxB * n);
		System.out.println(remaining);
			
			
		}
		
		
		
		static boolean canAchieveBalance(long b) {
			if ( b == 0 ) return true;
			
			
			//1. Source 
			int source = n + m; 
			
			//2. Sink
			int sink = n + m + 1;
			//3. totalNodes
			
			int totalNodes = n + m + 2;
			
			// INitialize graph
			
			graph = new ArrayList[totalNodes];
			
			for (int i  = 0; i < totalNodes; i++)
			{
				graph[i] = new ArrayList<>();
			}
			
			
			
			
			// Source to spheres : capacity B 
			
			
			
			
			
			for ( int i  = 0; i < n; i++)
			{
				addEdge(source,i, b); // Come back to this
			}
			
			
			//Sphere to edges and edges to spheres
			
			for ( int i  = 0; i < m; i++)
			{
				int u = edges[i][0];
				int v = edges[i][1];
				int disks = edges[i][2];
				int edgeNode = n + i;
				
				
				addEdge(edgeNode,sink , disks); // Come back to this

				addEdge(u, edgeNode, Long.MAX_VALUE);
				addEdge(v, edgeNode, Long.MAX_VALUE);
				
			}
			
			
			long maxFlow = maxFlow(source,sink);
			return maxFlow == b * n;
			
		}
		
		
		
		static void addEdge( int from, int to, long cap) 
		{
			graph[from].add(new Edge(to, cap, graph[to].size()));
			graph[to].add(new Edge(from, 0, graph[from].size() -  1));
			
		}
		
		
		static void bfs(int s) 
		{
			Arrays.fill(level, -1);
			
			Queue<Integer> queue = new LinkedList<>();
			
			level[s] = 0;
			queue.add(s);
			while(!queue.isEmpty())
			{
				int v = queue.poll();
				for ( Edge e : graph[v])
				{
					if ( e.cap > 0 && level[e.to]< 0) 
					{
						level[e.to] = level[v] + 1;
						queue.add(e.to);
					}
				}
			}
		}

	static long dfs( int v , int t , long f)
	{
		if ( v == t ) return f;
		
		for (; iter[v] < graph[v].size(); iter[v]++)
		{
			Edge e = graph[v].get(iter[v]);
			if (e.cap > 0 && level[v] < level[e.to])
			{
				long d = dfs(e.to, t, Math.min(f,  e.cap));
				if (d > 0)
				{
					e.cap -= d;
					graph[e.to].get(e.rev).cap += d;
					return d;
				}
			}
		}
		return 0;
			
	}
	
	static long maxFlow(int s, int t) 
	{
		
		level = new int[graph.length];
		iter = new int[graph.length];
		
		long flow = 0;
		
		while(true) 
		{
			bfs(s);
			
			if (level[t] < 0 ) return flow;
			Arrays.fill(iter, 0);
			long f;
			while (( f = dfs(s,t, Long.MAX_VALUE)) > 0)
			{
				flow += f;
			}
		}
	}	
}
