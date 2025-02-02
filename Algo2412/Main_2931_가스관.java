package Algo2412;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2931_가스관 {
	
	static class RC {
        int r, c;
        RC(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
	static int R, C;
	static int[][] map;
	static RC start, blank;
	static char blankC;
	static int[] dr4 = {-1, 0, 1, 0};
    static int[] dc4 = {0, 1, 0, -1};
    static int[] dr2 = {1, 0, -1, 0, -1, 0, 1, 0, 1, -1, 0 , 0};
    static int[] dc2 = {0, 1, 0, 1, 0, -1, 0, -1, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				char ch = str.charAt(j);
				if(ch == 'M') {
					start = new RC(i, j);
					map[i][j] = 10;
				}
				else if(ch == 'Z') {
					map[i][j] = 10;
				}
				else if(ch >= '1' && ch <= '4') {
					map[i][j] = ch - '0';
				}
				else if(ch == '|') {
					map[i][j] = 5;
				}
				else if(ch == '-') {
					map[i][j] = 6;
				}
				else if(ch == '+') {
					map[i][j] = 7;
				}
			}
		}
		findPath();
		
		System.out.println((blank.r+1) + " " + (blank.c+1) + " " + blankC);
	}

	static void findPath() {
		boolean[][] visited = new boolean[R][C];
		visited[start.r][start.c] = true;
		Queue<RC> que = new ArrayDeque<>();
		for (int i = 0; i < 4; i++) {
			int nr = start.r + dr4[i];
			int nc = start.c + dc4[i];
			if(!check(nr, nc)) continue;
			if(map[nr][nc] == 0) continue;
			que.offer(new RC(nr, nc));
			visited[nr][nc] = true;
		}

		while(!que.isEmpty()) {
			RC now = que.poll();
			int r = now.r;
			int c = now.c;
			
			int nowN = map[r][c];
			if(nowN > 0 && nowN < 7) {
				for (int i = 0; i < 2; i++) {
					int nr = r + dr2[2*(nowN-1) + i];
					int nc = c + dc2[2*(nowN-1) + i];

					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					que.offer(new RC(nr, nc));
				}
			}
			else if(nowN == 7) {
				for (int i = 0; i < 4; i++) {
					int nr = r + dr4[i];
					int nc = c + dc4[i];
					if(visited[nr][nc]) continue;
					visited[nr][nc] = true;
					que.offer(new RC(nr, nc));
				}
			}
			else if(nowN == 0) {
				blank = new RC(r, c);
				fill();
				break;
			}
		}
	}

	static void fill() {
		int n = 0;
		for (int i = 0; i < 4; i++) {
			int nr = blank.r + dr4[i];
			int nc = blank.c + dc4[i];
			n = n << 1;
			if(!check(nr, nc)) {
				continue;
			}

			if(i == 0) {
				if(map[nr][nc] == 1 || map[nr][nc] == 4 || map[nr][nc] == 5 || map[nr][nc] == 7) n += 1;
			}
			else if(i == 1) {
				if(map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 6 || map[nr][nc] == 7) n += 1;
			}
			else if(i == 2) {
				if(map[nr][nc] == 2 || map[nr][nc] == 3 || map[nr][nc] == 5 || map[nr][nc] == 7) n += 1;
			}
			else if(i == 3) {
				if(map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 6 || map[nr][nc] == 7) n += 1;
			}
		}

		if(n == 6) blankC = '1';
		else if(n == 12) blankC = '2';
		else if(n == 9) blankC = '3';
		else if(n == 3) blankC = '4';
		else if(n == 10) blankC = '|';
		else if(n == 5) blankC = '-';
		else blankC = '+';
	}

	static boolean check(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
