package s09_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//640ms
/*
* 각 칸(i, j)에서 시작해서 델타 +  DFS로 4칸을 구하고 sum 비교
*/
public class Main_14500_테트로미노 {
	
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
			
			if(check(nr, nc)) {
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				tetromino(idx+1, sum+map[nr][nc], nr, nc);	//다음 칸을 nr, nc에 이어진 칸으로 찾는 경우
				tetromino(idx+1, sum+map[nr][nc], r, c);	//다음 칸을 r, c에 이어진 칸으로 찾는 경우
				visited[nr][nc] = false;
			}
		}
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
	}

}
