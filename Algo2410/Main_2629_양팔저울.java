package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2629_양팔저울 {
	
	static int N, M;
	static int[] chu;
	static boolean[][] weight;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		chu = new int[N+1];
		weight = new boolean[N+1][15001];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());	
		}
		
		dp(0, 0);
		
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(a > 15000) sb.append("N ");
			else sb.append(weight[N][a]? "Y ": "N ");
		}

		System.out.println(sb.toString());
	}


	static void dp(int idx, int w) {
		if(weight[idx][w]) return;
	    weight[idx][w] = true;
	    System.out.println(idx + " " + w);
	    if(idx == N) return;

	    //System.out.println(idx);
	    dp(idx+1, w);
	    dp(idx+1, w + chu[idx+1]);
	    dp(idx+1, Math.abs(w - chu[idx+1]));
	}

}
