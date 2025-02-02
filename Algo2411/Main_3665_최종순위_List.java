package Algo2411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3665_최종순위_List {
	
	static int n, m;
	static int[] lastYear;
	static List<Integer>[] graph;
	static int[] in;
	static Queue<Integer> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			lastYear = new int[n+1];
			graph = new ArrayList[n+1];
			in = new int[n+1];
			que = new ArrayDeque<>();
			for (int i = 0; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
				for (int j = 1; j < i; j++) {
					graph[lastYear[i]].add(lastYear[j]);
					in[lastYear[i]]++;
				}
			}

			m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(graph[a].contains(b)) {
					graph[a].remove(Integer.valueOf(b));
					in[a]--;
					graph[b].add(a);
					in[b]++;
				}
				else if(graph[b].contains(a)) {
					graph[b].remove(Integer.valueOf(b));
					in[b]--;
					graph[a].add(b);
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

			result++;
			sb.append(a).append(" ");
			for (int i = 1; i <= n; i++) {
				if(graph[i].contains(a)) {
					in[i]--;
					graph[i].remove(Integer.valueOf(a));
					if(in[i] == 0) que.offer(i);
				}
			}
		}

		if(result == n) return sb.toString();
		else return "IMPOSSIBLE";
	}

}
