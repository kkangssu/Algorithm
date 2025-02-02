package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1285_동전뒤집기_bitmask_3 {
	
	static int N;
	static int[] map;
	static int[] flip;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N];
		flip = new int[N];
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				if(str.charAt(j) == 'T') map[i] |= (1 << j);		//앞면일 때 1
			}
			//System.out.println(Integer.toBinaryString(map[i]));
		}
		
		flip();
		System.out.println(min);
	}

	static void flip() {
		for (int row = 0; row < (1<<N); row++) {	//i를 2진수로 표현했을 때 1인 자리를 뒤집음
			int sum = 0;
			for (int i = 0; i < N; i++) {			//col을 기준으로 뒤집는 열의 동전 확인
				int back = Integer.bitCount(map[i] ^ row);
				back = back < N-back ? back : N-back;
				sum +=  back;
			}
			min = Math.min(min, sum);
		}
		
	}
}
