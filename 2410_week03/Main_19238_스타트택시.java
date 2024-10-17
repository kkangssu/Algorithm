package s10_w3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {
	
	static class RC implements Comparable<RC>{
		int r;
		int c;
		int p;
		RC(int r, int c, int p){
			this.r = r;
			this.c = c;
			this.p = p;
		}
		@Override
		public int compareTo(RC o) {
			if(this.p != o.p) return o.p - this.p;
			else if(this.r != o.r) return this.r - o.r;
			else return this.c - o.c;
		}
	}
	static int N, M, P;
	static int[][] map;
	static RC[] end;
	static RC start;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		start = new RC(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, P);
		end = new RC[M+2];
		for (int i = 2; i < M+2; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken())-1;
			int sc = Integer.parseInt(st.nextToken())-1;
			int er = Integer.parseInt(st.nextToken())-1;
			int ec = Integer.parseInt(st.nextToken())-1;
			end[i] = new RC(er, ec, 0);
			map[sr][sc] = i;
		}
		
		
		
		for (int i = 0; i < M; i++) {
			
			if(bfs1()) {
				P = start.p;
				if(!bfs2(map[start.r][start.c])) {
					P = -1;
					break;
				}
			}
			else {
				P = -1;
				break;
			}
		}
		System.out.println(P);

	}

	static boolean bfs1() {
		visited = new boolean[N][N];
		visited[start.r][start.c] = true;
		Queue<RC> pq = new PriorityQueue<>();
		pq.offer(start);
		//System.out.println(start.p);
		//System.out.println(start.r + " " + start.c);
		
		while(!pq.isEmpty()) {
			RC now = pq.poll();
			//System.out.println(now.p + " -> " + now.r +", " + now.c);
			
			if(now.p == 0) continue;
			if(map[now.r][now.c] > 1) {
				start = now;
				//System.out.println("손님: " + start.r + ", " + start.c);
				return true;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 1) continue;
				if(visited[nr][nc]) continue;
				//System.out.println("new: " + nr + " "+ nc);
				
				visited[nr][nc] = true;
				pq.offer(new RC(nr, nc, now.p-1));
			}
		}
		return false;
	}
	
	static boolean bfs2(int idx) {
		map[start.r][start.c] = 0;
		visited = new boolean[N][N];
		visited[start.r][start.c] = true;
		Queue<RC> que = new ArrayDeque<>();
		que.offer(start);
		
		while(!que.isEmpty()) {
			RC n = que.poll();
			if(n.r == end[idx].r && n.c == end[idx].c) {
				if (n.p < 0) return false;
				P += (start.p - n.p);
				//System.out.println("사용연료: " + (start.p-n.p));
				//System.out.println("남은연료: " + P);
				start = new RC(n.r, n.c, P);
				return true;
			}
			for (int i = 0; i < 4; i++) {
				int nr = n.r + dr[i];
				int nc = n.c + dc[i];
				
				if(!check(nr, nc)) continue;
				if(visited[nr][nc]) continue;
				if(map[nr][nc] == 1) continue;
				if(n.p == 0) continue;
				
				visited[nr][nc] = true;
				que.offer(new RC(nr, nc, n.p-1));
			}
		}
		return false;
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

}
