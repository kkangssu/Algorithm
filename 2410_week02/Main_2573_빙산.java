package s2410_w2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	
	static class RC{
		int r;
		int c;
		int n;
		RC(int r, int c, int n){
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<RC> ice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ice = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) ice.offer(new RC(i, j, map[i][j]));
			}
		}
		
		int y = melt();
		System.out.println(y);

	}

	static int melt() {
		int year = 1;
		while(!ice.isEmpty()) {
			boolean flag = false;
			int size = ice.size();
			Queue<RC> update = new ArrayDeque<>();
			for (int i = 0; i < size; i++) {
				RC now = ice.poll();
				int r = now.r;
				int c = now.c;
				int n = now.n;
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if(map[nr][nc] == 0) n--;
				}
				
				if(n <= 0) {
					n = 0;
					flag = true;
					update.offer(now);
				}
				else {
					map[r][c] = n;
					ice.offer(new RC(r, c, n));
				}
			}
			while(!update.isEmpty()) {
				RC i = update.poll();
				map[i.r][i.c] = 0;
			}
			//System.out.println(year);
			//pr();
			if(ice.size() == 0) continue;
			if(flag) {
				if(!bfs()) return year;
			}
			year++;
		}
		return 0;
		
	}

	static boolean bfs() {
		int width = 0;
		visited = new boolean[N][M];
		Queue<RC> part = new ArrayDeque<>();
		part.offer(ice.peek());
		visited[ice.peek().r][ice.peek().c]  = true;
		while(!part.isEmpty()) {
			RC now = part.poll();
			int r = now.r;
			int c = now.c;
			width++;
			if(width == ice.size()) return true;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				part.offer(new RC(nr, nc, 0));
			}
		}
		return false;
	}
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
	
//	static void pr() {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("");
//	}

}
