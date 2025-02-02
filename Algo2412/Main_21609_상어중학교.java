package Algo2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21609_상어중학교 {
	
	static int N, M;
	static int[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static RC max;
	static int score;
  static boolean[][] visited, boolean[][] visitedRainbow;
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		findBlock();
		System.out.println(score);
	}
	
	static void findBlock() {
		visited = new boolean[N][N];
		int maxBlock = 0;
		int maxRainbow = 0;
		
		for (int i = 0; i < N*N; i++) {
		  visitedRainbow = new boolean[N][N];
			int sr = i/N;
			int sc = i%N;
			if(visited[sr][sc]) continue;
			if(map[sr][sc] <= 0) continue;
			
			int color = map[sr][sc];
			int block = 1;
			int rainbow = 0;
			Queue<RC> que = new ArrayDeque<>();
			que.offer(new RC(sr, sc));
			visited[sr][sc] = true;
			
			while(!que.isEmpty()) {
				RC now = que.poll();
				for (int j = 0; j < 4; j++) {
					int nr = now.r + dr[j];
	                int nc = now.c + dc[j];
					if(!check(nr, nc)) continue;
					if(map[nr][nc] != color && map[nr][nc] != 0) continue;
					if(visited[nr][nc]) continue;
					if(map[nr][nc] == 0 && visitedRainbow[nr][nc]) continue;
					
					if(map[nr][nc] == color) visited[nr][nc] = true;
					if(map[nr][nc] == 0) {
						visitedRainbow[nr][nc] = true;
						rainbow++;
					}
					que.offer(new RC(nr, nc));
					block++;
				}
			}
			if(block < 2) continue;
			
			if(maxBlock < block || 
			           (maxBlock == block && rainbow > maxRainbow) ||
			           (maxBlock == block && rainbow == maxRainbow && sr > max.r) ||
			           (maxBlock == block && rainbow == maxRainbow && sr == max.r && sc > max.c)) {
			            maxBlock = block;
			            maxRainbow = rainbow;
			            max = new RC(sr, sc);
			}
		}
		if(maxBlock == 0) return;
		deleteBlock();
		score += maxBlock*maxBlock;
		findBlock();
	}
	
	static void deleteBlock() {
		Queue<RC> que = new ArrayDeque<>();
		que.offer(max);
		int color = map[max.r][max.c];
		while(!que.isEmpty()) {
			RC now = que.poll();
			int r = now.r;
			int c = now.c;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(!check(nr, nc)) continue;
				if(map[nr][nc] != color && map[nr][nc] != 0) continue;
				
				map[nr][nc] = -10;
				que.offer(new RC(nr, nc));
			}
		}
		gravity();
		Rotation();
		gravity();
	}

	static void Rotation() {
		int[][] copy = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = map[j][N-i-1];	
			}
		}
		for (int i = 0; i < N; i++) {
			System.arraycopy(copy[i],0, map[i], 0, N);
		}		
	}

	static void gravity() {
		for (int i = 0; i < N; i++) {
			for (int j = N-1; j >= 0; j--) {
				if(map[j][i] < 0) continue;
				int nr = j+1;
				while(true) {
					if(nr == N) break;
					if(map[nr][i] == -10) {
						map[nr][i] = map[nr-1][i];
						map[nr-1][i] = -10;
						nr++;
					}
					else break;
				}
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
    }
}
