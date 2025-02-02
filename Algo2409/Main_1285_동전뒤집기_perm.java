package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1285_동전뒤집기_perm {
	
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
		
		permRow(0);

		System.out.println(min);
	}

	
	static void permRow(int idx) {
		if(idx == N) {
			int back = flipRow();
			min = Math.min(min, back);
			return;
		}
		
		flip[idx] = 1;		//뒤집기
		permRow(idx+1);
		flip[idx] = 0;		//뒤집지 않기
		permRow(idx+1);
		
	}

	static int flipRow() {
		int sum = 0;
		for (int i = 0; i < N; i++) {		//col을 기준으로 뒤집는 열의 동전 확인
			int tmp = 0;
			int col = 0;
			for (int j = 0; j < N; j++) {
				tmp = map[j][i];
				if(flip[j] == 1) {
					tmp = tmp == 1? 0: 1;
				}
				if(tmp == 0) col++;
			}
			col = col < N-col ? col : N-col;
			sum +=  col;
		}
		return sum;
	}

}
