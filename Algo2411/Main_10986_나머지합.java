package Algo2411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986_나머지합 {
	
	static int N, M;
	static long[] sum;
	static long num;
	static long[] mod;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sum = new long[N+1];
		mod = new long[M];
		mod[0] = 1;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum[i] = (sum[i-1] + n) % M;
			num += mod[(int) sum[i]]++;
		}
		
		System.out.println(num);
	}

}
