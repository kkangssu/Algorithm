package s2410_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {
	
	static class Wire implements Comparable<Wire>{
		int s;
		int e;
		Wire(int s, int e){
			this.s =  s;
			this.e = e;
		}

		@Override
		public int compareTo(Wire o) {
			return this.s - o.s;
		}
	}
	static int N;
	static Wire[] wire;
	static int[] dp;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		wire = new Wire[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			wire[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		Arrays.sort(wire);
		max = 1;
		dp[0] = 1;
		
		for (int i = 1; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(wire[i].e > wire[j].e) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(N - max);
	}

}
