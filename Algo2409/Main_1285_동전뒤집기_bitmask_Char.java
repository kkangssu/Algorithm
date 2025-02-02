package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1285_동전뒤집기_bitmask_Char {
	
	static int N;
	static char[][] map;
	static int[] flip;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		flip = new int[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		flip();
		System.out.println(min);
	}

	static void flip() {
		for (int row = 0; row < (1<<N); row++) {	//i를 2진수로 표현했을 때 1인 자리를 뒤집음
			int sum = 0;
			for (int i = 0; i < N; i++) {		//col을 기준으로 뒤집는 열의 동전 확인
				char tmp;
				int back = 0;
				for (int j = 0; j < N; j++) {
					tmp = map[j][i];
					if((row & (1<<j)) != 0) {
						tmp = (tmp == 'T')? 'H' : 'T';
					}
					if(tmp == 'T') back++;
				}
				back = back < N-back ? back : N-back;
				sum +=  back;
			}
			min = Math.min(min, sum);
		}
		
	}
}
