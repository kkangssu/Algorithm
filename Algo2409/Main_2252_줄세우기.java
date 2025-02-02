package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {
	
	static int N, M;
	static int[] count;
	static List<Integer>[] list;
	static Queue<Integer> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		count = new int[N+1];
		que = new ArrayDeque<>();
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			count[b]++;
		}
		
		System.out.println(topologi());
	}

	static String topologi() {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(count[i]==0) que.offer(i);
		}
		
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(" ");
			
			for(int i: list[now]) {
				count[i]--;
				if(count[i] == 0) que.offer(i);
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}

}
