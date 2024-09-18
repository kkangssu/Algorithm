package boj2409_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6087_레이저통신 {
	
	static class RC implements Comparable<RC>{
		int r;
		int c;
		int m;		//거울 수
		int d;
		RC(int r, int c, int m, int d){
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
		}
		@Override
        public int compareTo(RC o) {
            return this.m - o.m;
        }
	}
	
	static int R, C;
	static boolean[][] map;
	static int[] node;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][][] visited;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new boolean[R][C];
		node = new int[4];
		visited = new int[R][C][4];
		min = Integer.MAX_VALUE;
		int n = 0;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
				if(str.charAt(j) == '.') map[i][j] = true;
				else if((str.charAt(j) == 'C')) {
					map[i][j] = true;
					node[n++] = i;
					node[n++] = j;
				}
			}
		}
		laser();
		System.out.println(min);
	}

	static void laser() {
		Queue<RC> pq = new PriorityQueue<>();
		pq.offer(new RC(node[0], node[1], 0, -1));
		
		while(!pq.isEmpty()) {
			RC now = pq.poll();
			int r = now.r;
			int c = now.c;
			int mirror = now.m;
			int direction = now.d;
			
			if(r == node[2] && c == node[3]) {
				min = Math.min(min, mirror);
				continue;
			}
			
			if(mirror >= min) continue;
			
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				int nm = mirror;
				if(i != direction && direction != -1) nm++;
				
				if(!check(nr, nc)) continue;
				if(!map[nr][nc]) continue;
				if((i + 2) % 4 == direction) continue;
				if(visited[nr][nc][i] <= nm) continue;
				
				visited[nr][nc][i] = nm;
				//System.out.println(nr + " " + nc + " -> " + nm);
				pq.offer(new RC(nr, nc, nm, i));
			}
		}
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= R || c < 0 || c >= C) return false;
		return true;
			
	}

}
