package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1976_여행을가자_unionFind {
	
	static int N, M;
	static int[] route;
	static int[] parent; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		route = new int[M];
		parent = new int[N+1];
		for (int i = 0; i <= N; i++) {
			parent[i] = i;
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(st.nextToken().equals("1")) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken());
		}

		boolean canGo = true;
		int cityParent = find(route[0]);
		for (int i = 1; i < M; i++) {
			if(find(route[i]) != cityParent) {
				canGo = false;
				break;
			}
		}
		
		System.out.println(canGo? "YES":"NO");
	}

	static int find(int x) {
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x != y) parent[x] = y;
	}
}
