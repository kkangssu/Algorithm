package boj2408_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	
	static int N, M;
	static boolean[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static Queue<Integer> qr;		//바이러스 위치 r
	static Queue<Integer> qc;		//바이러스 위치 c
	static int cnt;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		qr = new  LinkedList<>();
		qc = new LinkedList<>();
		cnt = N*M;
		max = 0;
		
		//map -> 바이러스가 퍼질 수 없는 곳은 true
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 2) {	//바이러스 위치라면
					qr.offer(i);
					qc.offer(j);
					map[i][j] = true;
					cnt--;
				}
				else if (n == 1) {
					map[i][j] = true;	//벽
					cnt--;
				}
			}
		}
		System.out.println("cnt: " + cnt);
		makeWall(0, 0);

		System.out.println(max);
	}

	static void makeWall(int idx, int tmp) {
		if(idx == 3) {
			int p = virus();
			System.out.println("Fcnt: " + p);
			max = Math.max(max, p);
			return;
		}
		
		for (int i = tmp; i < N*M; i++) {
			if(!map[i/M][i%M]) {
				map[i/M][i%M] = true;
				makeWall(idx+1, i+1);
				map[i/M][i%M] = false;
			}
		}
		
	}

	static int virus() {
		int cntCopy = cnt;
		boolean[][] arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.copyOf(map[i], M);
		}
		
		while(!qr.isEmpty()) {
			int r = qr.poll();
			int c = qc.poll();
			
			for (int i = 0; i < 4; i++) {
				if(check(r+dr[i], c+dc[i]) && !map[r+dr[i]][c+dc[i]] && !arr[r+dr[i]][c+dc[i]]) {
					qr.offer(r+dr[i]);
					qc.offer(c+dc[i]);
					cntCopy--;
					arr[r+dr[i]][c+dc[i]] = true;
				}
			}
		}
		return cntCopy;
	}

	static boolean check(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= M) return false;
		return true;
			
	}
}
