package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16197_두동전 {
	
	static class RC{
		int r1;
		int c1;
		int r2;
		int c2;
		int move;
		RC(int r1, int c1, int r2, int c2, int move){
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.move = move;
		}
	}
	
	static int N, M;
	static boolean[][] map;
	static int[][] coin;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		coin = new int[2][2];
		int idx = 0;
		visited = new boolean[N][M][N][M];
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				if(ch == 'o') {
					coin[idx][0] = i;
					coin[idx++][1] = j;
				}
				else if(ch == '#') {
					map[i][j] = true;
				}
			}
		}
		
		int min = move();
		System.out.println(min);
	}

	static int move() {
		Queue<RC> que = new LinkedList<>();
		que.offer(new RC(coin[0][0], coin[0][1], coin[1][0], coin[1][1], 0));
		
		while(!que.isEmpty()) {
			RC now = que.poll();
			int r1 = now.r1;
			int c1 = now.c1;
			int r2 = now.r2;
			int c2 = now.c2;
			int move = now.move;
			
			if(move >= 10) return -1;
			
			for (int i = 0; i < 4; i++) {
				int nr1 = r1 + dr[i];
				int nc1 = c1 + dc[i];
				int nr2 = r2 + dr[i];
				int nc2 = c2 + dc[i];
				int fall = 0;
				
				if(!check(nr1, nc1)) fall++;
				if(!check(nr2, nc2)) fall++;
				
				if(fall == 1) return move+1;
				if(fall == 2) continue;
				
				if(map[nr1][nc1]) {
					nr1 = r1;
					nc1 = c1;
				}
				if(map[nr2][nc2]) {
					nr2 = r2;
					nc2 = c2;
				}
				if(visited[nr1][nc1][nr2][nc2]) continue;
				visited[nr1][nc1][nr2][nc2] = true;
				que.offer(new RC(nr1, nc1, nr2, nc2, move+1));
			}
		}
		return -1;
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
	}
}
