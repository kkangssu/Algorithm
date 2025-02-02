package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1285_동전뒤집기_bitmask_Int {
	
	static int N;
	static int[][] map;
	static int[] flip;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		flip = new int[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j) == 'H') map[i][j] = 1;		//앞면일 때 1
			}
		}
		
		flip();
		System.out.println(min);
	}

	static void flip() {
		for (int row = 0; row < (1<<N); row++) {	//i를 2진수로 표현했을 때 1인 자리를 뒤집음
			int sum = 0;
			for (int i = 0; i < N; i++) {		//col을 기준으로 뒤집는 열의 동전 확인
				int tmp = 0;
				int back = 0;
				for (int j = 0; j < N; j++) {
					tmp = map[j][i];
					if((row & (1<<j)) != 0) {
						tmp = tmp == 1? 0 : 1;
					}
					if(tmp == 0) back++;
				}
				back = back < N-back ? back : N-back;
				sum +=  back;
			}
			min = Math.min(min, sum);
		}
		
	}
}
