package s10_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_10711_모래성 {
	
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int H, W;
	static int[][] map;
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static int t = 0;
	static Queue<RC> que = new ArrayDeque<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		for (int i = 0; i < H; i++) {
			String str = br.readLine();
			for (int j = 0; j < W; j++) {
				char ch = str.charAt(j);
				if(ch == '.') {
					map[i][j] = 0;
					que.offer(new RC(i, j));
				}
				else {
					map[i][j] = str.charAt(j) - '0';
				}
			}
		}
		bfs();
		System.out.println(t-1);
		
	}

	private static void bfs() {
		while(!que.isEmpty()) {
			System.out.println("q: " + que.size());
			int s = que.size();
			for (int q = 0; q < s; q++) {
				RC z = que.poll();
				System.out.println("zero: " + z.r + " " + z.c);
				for (int i = 0; i < 8; i++) {
					int nr = z.r + dr[i];
					int nc = z.c + dc[i];
					if(!check(nr, nc)) continue;
					if(map[nr][nc] == 0) continue;	//이미 무너진 칸은 넘김
					if(map[nr][nc] != 0) map[nr][nc]--;
					if(map[nr][nc] == 0) que.offer(new RC(nr, nc));	//새로 무너진 칸만 que에 저장 
				}
			}
			t++;
		}
	}
	
	static boolean check(int r, int c) {
		return r >= 0 && r < H && c >= 0 && c < W;
	}

}
