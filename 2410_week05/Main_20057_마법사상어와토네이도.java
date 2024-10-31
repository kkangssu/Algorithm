package s10_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도 {
	
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {-1, 0, 1, 0};
	//모래 이동 비율
	//밖 4칸
	static int[] sr1 = {0, -2, 0, 2};
	static int[] sc1 = {-2, 0, 2, 0};
	static int[] sp1 = {5, 2, 0, 2};
	//안 8칸
	static int[] sr2 = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] sc2 = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] sp2 = {0, 10, 7, 1, 0, 1, 7, 10};
	static int out;	//나간 모래

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		System.out.println(out);
	}
	
	static void bfs() {
		//시작점
		int r = N/2;
		int c = N/2;
		int cnt = 0;
		int move = 1;
		int d = 0;
		
		while (true) {
			//같은 move는 두번만 이동
			//두번 이동했으면 move+1
			if (cnt == 2) {
				cnt = 0;
				move++;
			}

			for (int i = 0; i < move; i++) {

				int nr = r + dr[d];
				int nc = c + dc[d];
				//다음 이동 칸의 모래 양이 0이면 날리는 모래 없음
				if (map[nr][nc] > 0) {
					tornado(nr, nc, d);
				}
				r = nr;
				c = nc;
				if(r == 0 && c == 0) break;	//0, 0에 도착하면 끝
			}
			if(r == 0 && c == 0) break;
			cnt++;
			d = (d + 1) % 4;
		}
	}
	
	static void tornado(int r, int c, int d) {
		if(map[r][c] < 10) {	//모래의 양이 10보다 작으면 a칸 외의 칸으로 모래가 이동하지 못 함
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(!check(nr, nc)) out += map[r][c];
			else {
				map[nr][nc] += map[r][c];
			}
		}
		else {
			int moveSand = 0;
			//밖 칸
			for (int i = 0; i < 4; i++) {
				int nr = r + sr1[i];
				int nc = c + sc1[i];
				int s = (int) (map[r][c] * sp1[(d+i)%4] * 0.01);
				moveSand += s;
				if(!check(nr, nc)) out += s;
				else {
					map[nr][nc] += s;
				}
			}
			//안 칸
			for (int i = 0; i < 8; i++) {
				int nr = r + sr2[i];
				int nc = c + sc2[i];
				int s = (int) (map[r][c] * sp2[(2*d+i)%8] * 0.01);
				moveSand += s;
				if(!check(nr, nc)) out += s;
				else {
					map[nr][nc] += s;
				}
			}
			//비율이 a인 칸 계산
			int nnr = r + dr[d];
			int nnc = c + dc[d];
			if(!check(nnr, nnc)) out += (map[r][c] - moveSand);
			else {
				map[nnr][nnc] += (map[r][c] - moveSand);
			} 
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
