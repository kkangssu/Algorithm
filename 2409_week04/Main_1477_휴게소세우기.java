package s09_week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1477_휴게소세우기 {
	
	static int N, M, L;
	static int[] rest;
	static int[] interval;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		rest = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			rest[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(rest);
		System.out.println(Arrays.toString(rest));
		
		//휴게소 간 간격 구하기 -> interval[]
	}

}
