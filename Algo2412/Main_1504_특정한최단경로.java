package Algo2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1504_특정한최단경로 {
	
	static class Node implements Comparable<Node>{
		int e;
		int c;
		Node(int e, int c){
			this.e = e;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
	static int N, E;
	static ArrayList<Node>[] graph;
	static int[] must;
	static final int max = 1000000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}
		must = new int[2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2; i++) {
			must[i] = Integer.parseInt(st.nextToken());
		}
		
		long route1 = max;
		long r1 = dijkstra(1, must[0]);
		long r2 = dijkstra(must[0], must[1]);
		long r3 = dijkstra(must[1], N);
		if(InRange(r1, r2, r3)) {
			route1 = r1 + r2 + r3;
		}
		long route2 = max;
		r1 = dijkstra(1, must[1]);
		r2 = dijkstra(must[1], must[0]);
		r3 = dijkstra(must[0], N);
		if(InRange(r1, r2, r3)) {
			route2 = r1 + r2 + r3;
		}
		
		if(route1 == route2 &&  route1 == max) {
			System.out.println(-1);
		}
		else {
			System.out.println(route1 < route2 ? route1 : route2);

		}
	}

	static boolean InRange(long a, long b, long c) {
		return a < max && b < max && c < max;
	}

	static long dijkstra(int s, int e) {
		int[] dist = new int[N+1];
        Arrays.fill(dist, max);
        dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(dist[now.e] < now.c) continue;
			for(Node next: graph[now.e]) {
				int cost = now.c + next.c;
				if(dist[next.e] > cost) {
					dist[next.e] = cost;
					pq.offer(new Node(next.e, cost));
				}
			}
		}
		return dist[e];
		
	}

}
