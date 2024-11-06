package s2411_w1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임 {
	
	static int N, M;
	static int[] parent;
	static boolean[] visited;
	static int time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(union(a, b)) {
				time = i + 1;
				break;
			}
		}
		System.out.println(time);
	}

	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return true;
		if(a < b) parent[b] = a;
		else parent[a] = b;
		return false;
	}

	static int find(int i) {
		if(parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}

}
