package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2001 {
	
	static int n;
	static int m;
	static int[][] flies;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			max = 0;	//죽인 파리 최대값 max
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			//영역 n
			n = Integer.parseInt(st.nextToken());
			//파리채 크기 m
			m = Integer.parseInt(st.nextToken());
			flies = new int[n][n];
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < n; k++) {
					flies[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			die();	//최대로 죽인 파리 수 구하는 메서드
			sb.append("#").append(i+1).append(" " + max).append("\n");
		}
		System.out.println(sb.toString());

	}

	public static void die() {
		//i=0, j=0, n=2인 경우 0,0 / 0,1 / 1,0 / 1,1의 합을 구함
		for (int i = 0; i <= n-m; i++) {
			for (int j = 0; j <= n-m; j++) {
				int sum = 0;
				for (int k = 0; k < m*m; k++) {
					int x = i + k%m;
					int y = j + k/m;

					sum += flies[y][x];
				}
				max = Math.max(max, sum);
			}
		}	
	}
}
