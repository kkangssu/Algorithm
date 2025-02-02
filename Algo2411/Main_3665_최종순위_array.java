package Algo2411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665_최종순위_array {
	
	static int n, m;
	static int[] lastYear;
	static boolean[][] graph;
	static int[] in;
	static Queue<Integer> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			lastYear = new int[n+1];
			graph = new boolean[n+1][n+1];
			in = new int[n+1];
			que = new ArrayDeque<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
				for (int j = 1; j < i; j++) {
					graph[lastYear[i]][lastYear[j]] = true;
					in[lastYear[i]]++;
				}
			}
//			for (int i = 1; i <= n; i++) {
//				for (int j = 1; j <= n; j++) {
//					System.out.print(graph[lastYear[i]][lastYear[j]] + " ");
//				}
//				System.out.println();
//			}
			m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(graph[a][b]) {
					graph[a][b] = false;
					in[a]--;
					graph[b][a] = true;
					in[b]++;
				}
				else if(graph[b][a]) {
					graph[b][a] = false;
					in[b]--;
					graph[a][b] = true;
					in[a]++;
				}
			}
			for (int i = 1; i <= n; i++) {
				if(in[i] == 0) que.offer(i);
			}
			
			System.out.println(find());

		}

	}

	static String find() {
		StringBuilder sb = new StringBuilder();
		int result = 0;
		while(!que.isEmpty()) {
			if(que.size() > 1) return "IMPOSSIBLE";
			int a = que.poll();
//			System.out.println("a: " + a);
			result++;
			sb.append(a).append(" ");
			for (int i = 1; i <= n; i++) {
				if(graph[i][a]) {
					in[i]--;
					graph[i][a] = false;
					if(in[i] == 0) que.offer(i);
				}
			}
		}
//		System.out.println(result);
		if(result == n) return sb.toString();
		else return "IMPOSSIBLE";
	}

}
