package Algo2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] cnt = new int[N+1];
		List<Integer>[] list = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			cnt[b]++;
		}
		
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i < N+1; i++) {
			if(cnt[i] == 0) que.offer(i);
		}
		while(!que.isEmpty()) {
			int now = que.poll();
			sb.append(now).append(" ");
			
			for(int i: list[now]) {
				cnt[i]--;
				if(cnt[i] == 0) que.offer(i);
			}
		}
		
		System.out.println(sb.toString());
	}

}
