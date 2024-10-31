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
	//일단 dp로 풀려면 정렬이 되어 있어야 함 -> 시작점을 기준으로 정렬하기 위해 class 생성
	
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
			//자기자신만 연결된다 생각하면 dp 최소값은 1
			for (int j = 0; j < i; j++) {
				//교차된다면
				if(wire[i].e > wire[j].e) {
					dp[i] = Math.max(dp[i], dp[j]+1);
				}
			}
			//연결할 수 있는 전깃출 최대값 계산
			max = Math.max(max, dp[i]);
		}
		//없애야하는 전깃줄 최소값
		System.out.println(N - max);
	}

}
