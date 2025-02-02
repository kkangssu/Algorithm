package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1976_여행을가자_BFS {
	
	static int N, M;
	static List<Integer>[] city;
	static boolean[] visited;
	static int[] route;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		city = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			city[i] = new ArrayList<>();
		}
		route = new int[M];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(st.nextToken().equals("1")) {
					city[i].add(j);
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			
		}

		boolean canGo = true;
		for (int i = 0; i < M-1; i++) {
			int now = route[i];
			int next = route[i+1];
			if(!move(now, next)) {
				canGo = false;
				break;
			}
		}
		
		System.out.println(canGo? "YES":"NO");
	}

	static boolean move(int now, int next) {
		visited = new boolean[N+1];
		Queue<Integer> que = new PriorityQueue<>();
		que.offer(now);
		while(!que.isEmpty()) {
			int n = que.poll();
			if(n == next) return true;
			
			if(visited[n]) continue;
			visited[n] = true;
			for(int nex: city[n]) {
				if(visited[nex]) continue;
				que.offer(nex);
			}
		}
		return false;
	}

}
