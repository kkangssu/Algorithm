package Algo2412;

import java.util.*;

class programmers_L2_석유시추 {
    
  static boolean[][] visited;
	static int[] oil;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int R, C;
	static class RC{
		int r, c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
    
  public int solution(int[][] land) {
    R = land.length;
		C = land[0].length;
		visited = new boolean[R][C];
		oil = new int[C];
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(land[r][c] == 0) continue;
				if(visited[r][c]) continue;
				bfs(r, c, land);
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < C; i++) {
			max = Math.max(max, oil[i]);
		}
        return max;
  }
  
	static void bfs(int r, int c, int[][] land) {
		Queue<RC> que = new ArrayDeque<>();
		que.offer(new RC(r, c));
		int maxC = c;
		int minC = c;
		int sum = 0;
		visited[r][c] = true;
		while(!que.isEmpty()) {
			RC now = que.poll();
			sum++;
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if(!check(nr, nc)) continue;
				if(land[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				
				if(nc > maxC) maxC = nc;
				if(nc < minC) minC = nc;
				visited[nr][nc] = true;
				que.offer(new RC(nr, nc));
			}
		}

		for (int i = minC; i <= maxC; i++) {
			oil[i] += sum;
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
