package s09_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//640ms
/*
* ㅏ인 경우
*	idx = 4가 idx=3에 붙을 수도, idx=2에 붙을 수도 있음
*	idx == 2인 경우 tetromino(idx+1, sum+map[nr][nc], r, c)로 다음 칸으로 넘어가지 않는 경우 생각
*	--> idx = 2인 경우에만 경우의 수가 2개
*/

public class Main_14500_테트로미노_2 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int max;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				tetromino(1, map[i][j], i, j);
				visited[i][j] = false;
			}
		}
		
		System.out.println(max);
		
	}
	
	static void tetromino(int idx, int sum, int r, int c) {
		if(idx == 4) {
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if(!check(nr, nc)) continue;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(idx == 2) tetromino(idx+1, sum+map[nr][nc], r, c);
			tetromino(idx+1, sum+map[nr][nc], nr, nc);
			visited[nr][nc] = false;
		}
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
	}

}
