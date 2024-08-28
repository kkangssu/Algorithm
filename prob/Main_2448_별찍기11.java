package boj2408_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2448_별찍기11 {
	
	static int N;
	static boolean[][] star;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		star = new boolean[N][2*N-1];
		
		draw(N, 0, N-1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2*N-1; j++) {
				if(star[i][j]) {
					sb.append("*");
				}
				else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

	static void draw(int idx, int r, int c) {
		if(idx == 3) {
			makeStar(r, c);
			return;
		}
		
		//삼각형 3구역으로 나누기
		idx /= 2;
		//위
		draw(idx, r, c);
		draw(idx, r + idx, c - idx);
		draw(idx, r + idx, c + idx);
	}

	static void makeStar(int r, int c) {
		star[r][c] = true;
		star[r+1][c-1] = star[r+1][c+1] = true;
		star[r+2][c-2] = star[r+2][c-1] = star[r+2][c] = star[r+2][c+1] = star[r+2][c+2] = true;
		
	}

}
