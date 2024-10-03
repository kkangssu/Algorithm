package s2410_w1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12015_가장긴증가하는부분수열2_dp {
	
	static int N, max;
	static int[] A, l;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		l = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		dp();
		
		System.out.println(max);
	}

	static void dp() {
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < i; j++) {
				if(A[j] < A[i]) {
					l[i] = Math.max(l[i], l[j]+1);
				}
			}
			max = Math.max(max, l[i]);
		}
	}
}
