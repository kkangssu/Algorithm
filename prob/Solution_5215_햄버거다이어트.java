package swea0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트 {
	
	static int T;
	static int N;
	static int Cal;
	static int[][] score;
	//static boolean[] visited;
	static int maxScore;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Cal = Integer.parseInt(st.nextToken());
			//visited = new boolean[N];
			maxScore = 0;
			score = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}
			
			makeHam(0, 0, -1);
			sb.append("#").append(t).append(" ").append(maxScore).append("\n");
		}

		System.out.println(sb.toString());
	}

	static void makeHam(int cal, int sco, int idx) {
		if(cal > Cal) return;
		else {
			maxScore = Math.max(maxScore, sco);
		}
		
		for (int i = idx+1; i < N; i++) {
			makeHam(cal+score[i][1], sco+score[i][0], i);
		}
		
	}

}
