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
		int n;	//높이
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
		
		int y = melt();	//빙산이 두 덩어리 이상으로 분리되는 최초의 시간
		System.out.println(y);

	}

	static int melt() {
		int year = 1;
		while(!ice.isEmpty()) {
			boolean flag = false;	//높이가 0이 되는 빙산이 있다면 -> 덩어리 개수 체크
			int size = ice.size();		//남아있는 빙산 개수
			Queue<RC> update = new ArrayDeque<>();
			for (int i = 0; i < size; i++) {
				RC now = ice.poll();
				int r = now.r;
				int c = now.c;
				int n = now.n;
				for (int j = 0; j < 4; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					if(map[nr][nc] == 0) n--;	//주변 0의 개수만큼 높이 감소
				}
				
				if(n <= 0) {
					n = 0;	//최소 높이는 0
					flag = true;	//아예 녹아버린 빙산이 존재
					update.offer(now);	//빙산이 동시에 녹으므로 한 턴이 끝난 후 높이가 0이 되는 빙산 업데이트
				}
				else {	//빙산이 녹아도 높이가 0보다 큰 경우
					map[r][c] = n;	//바로 업데이트 -> 다른 빙산에 영향 주지 않음
					ice.offer(new RC(r, c, n));
				}
			}
			while(!update.isEmpty()) {	//높이가 0이 된 빙산 업데이트
				RC i = update.poll();
				map[i.r][i.c] = 0;
			}
			
			if(ice.size() == 0) continue;	//남은 빙하가 없다면  -> 덩어리가 2개 이상이 될 수 없움
			if(flag) {	//높이가 0이된 빙하가 있는 경우 = 덩어리 확인
				if(!bfs()) return year; //덩어리가 분리된 경우(bfs() = false인 경우가 덩어리가 2개 이상인 경우)
			}
			year++;
		}
		return 0;
		
	}

	static boolean bfs() {
		int width = 0;
		visited = new boolean[N][M];
		Queue<RC> part = new ArrayDeque<>();	//덩어리1은 여기에 저장
		part.offer(ice.peek());
		visited[ice.peek().r][ice.peek().c]  = true;
		while(!part.isEmpty()) {
			RC now = part.poll();
			int r = now.r;
			int c = now.c;
			width++;
			if(width == ice.size()) return true;	//덩어리1의 너비 = 전체 빙하의 개수 -> 빙하가 한덩어리
			
			for (int i = 0; i < 4; i++) {	//연결된 빙하를 Part에 저장
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(!check(nr, nc)) continue;
				if(map[nr][nc] == 0) continue;
				if(visited[nr][nc]) continue;
				visited[nr][nc] = true;
				part.offer(new RC(nr, nc, 0));
			}
		}
		return false;	//빙하가 한 덩어리 이상
	}
	static boolean check(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < M;
	}
}
