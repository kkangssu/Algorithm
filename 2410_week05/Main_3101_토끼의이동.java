package s2410_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_3101_토끼의이동 {
	
	static int N, K;
	static String str;
	static long sum;
	static long[] start;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		str = br.readLine();
		sum = 1;
		start = new long[2*N-1];
		start[0] = 1;
		for (int i = 1; i < N; i++) {
	        start[i] = start[i-1] + i;
	    }
	    start[2*N-2] = 1l*N*N;
	    for (int i = 2; i < N; i++) {
	        start[2*N-1-i] = start[2*N-i] - i;
	    }
		move();
		System.out.println(sum);
	}

	static void move() {
		int r = 0;
		int c = 0;
		int diagonal = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if(ch == 'U') {
				r -= 1;
			}
			else if(ch == 'D') {
				r += 1;
			}
			else if(ch == 'L') {
				c -= 1;
			}
			else {
				c += 1;
			}
			diagonal = r+c;
			long ex = 0;

			if(diagonal%2 == 1) {
				if(diagonal < N) {
					ex = start[diagonal] + r;
					sum += ex;
				}
				else {
					ex = start[diagonal] + (N-c-1);
					sum += ex;
				}
			}
			else {
				if(diagonal < N) {
					ex = start[diagonal] + c;
					sum += ex;
				}
				else {
					ex = start[diagonal] + (N-r-1);
					sum += ex;
				}
				
			}
		}	
	}
}
