package s2410_w2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1516_게임개발 {
	
	static List<List<Integer>> list;
	static int[] dp;
	static int[] degree;
	static int[] time;
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		degree = new int[N+1];
		time = new int[N+1];
		list = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			time[i] = Integer.parseInt(st.nextToken());
			while(true) {
				int n = Integer.parseInt(st.nextToken());
				if(n == -1) {
					break;
				}
				list.get(n).add(i);
				degree[i]++;
			}
		}
		
		DP();

		for (int i = 1; i <= N; i++) {
			sb.append(dp[i]).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	static void DP() {
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                que.offer(i);
                dp[i] = time[i];
            }
        }
		while(!que.isEmpty()) {
			int now = que.poll();
				
			for(int next: list.get(now)) {
				dp[next] = Math.max(dp[next], dp[now] + time[next]);
				if(--degree[next] == 0) {
					que.offer(next);
				}
			}
		}
	}
}
