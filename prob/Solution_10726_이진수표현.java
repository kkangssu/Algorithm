package swea0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_10726_이진수표현 {
	
	static int T;
	static int N;
	static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean onoff = true;
			
			for (int i = 0; i < N; i++) {
				if(M%2 == 0) {
					onoff = false;
					break;
				}
				M /= 2;
			}
			
			if(onoff) {
				sb.append("#").append(t).append(" ").append("ON\n");
			}
			else {
				sb.append("#").append(t).append(" ").append("OFF\n");
			}
		}
		System.out.println(sb.toString());
	}

}
