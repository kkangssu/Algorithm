package boj2408_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class RC{
	int r;
	int c;
	RC(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main_14502_연구소 {
	
	static int N, M;
	static boolean[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static RC[] V;		//초기 바이러스 위치 배열
	static int cnt;		//안전영역 수
	static int max;		//최대 안전영역 수
	static int vN;		//초기 바이러스 수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		V = new RC[10];
		cnt = N*M;		//바이러스 퍼지기 전 안전영역
		max = 0;
		vN = 0;
		
		//map -> 바이러스가 퍼질 수 없는 곳은 true
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 2) {	//바이러스 위치라면
					V[vN++] = new RC(i, j);
					map[i][j] = true;
					cnt--;
				}
				else if (n == 1) {		//벽
					map[i][j] = true;	
					cnt--;
				}
			}
		}
		cnt -= 3;		//벽 3개 생성
		makeWall(0, 0);

		System.out.println(max);
	}

	//DFS로 벽 3개 선택
	static void makeWall(int idx, int tmp) {
		if(idx == 3) {
			//
			boolean[][] visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				visited[i] = Arrays.copyOf(map[i], M);
			}
			virus(visited);
			return;
		}
		
		for (int i = tmp; i < N*M; i++) {
			if(!map[i/M][i%M]) {
				System.out.println(i/M + ", " + i%M);
				map[i/M][i%M] = true;
				makeWall(idx+1, i+1);
				map[i/M][i%M] = false;
			}
		}
	}

	//BFS로 안전영역 확인
	static void virus(boolean[][] visited) {
		int count = cnt;
		Queue<RC> q = new  LinkedList<>();
		for (int i = 0; i < vN; i++) {
			q.offer(V[i]);
		}
		
		while(!q.isEmpty()) {
			RC rc = q.poll();
			for (int i = 0; i < 4; i++) {
				if(check(rc.r+dr[i], rc.c+dc[i]) && !map[rc.r+dr[i]][rc.c+dc[i]] && !visited[rc.r+dr[i]][rc.c+dc[i]]) {
					//범위 내 + 벽, 초기 바이러스 위치가 아닌 곳 + 아직 방문하지 않은 곳인 경우
					visited[rc.r+dr[i]][rc.c+dc[i]] = true;
					RC nrc = new RC(rc.r+dr[i], rc.c+dc[i]);
					q.offer(nrc);
					count--;		//안전 영역 감소
				}
			}
		}
		max = Math.max(max, count);
	}

	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
			
	}
}
