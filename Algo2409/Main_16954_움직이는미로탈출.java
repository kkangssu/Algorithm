package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/*
 * 도착지점까지 도달했는지 확인할 필요 없음
 * 현재 위치 위에 벽이 없으면 무조건 도착
 * 8초까지 살아 남으면 무조건 도착
 */

public class Main_16954_움직이는미로탈출 {
	
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static boolean[][] map;
	static int[] wall;	//각 줄 벽의 수
	static RC wook;		//욱제 위치
	static int sumWall;	//전체 벽의 수
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1, 0};	//8방 + 그대로있기
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new boolean[8][8];
		wall = new int[8];
		wook = new RC(7, 0);
		for (int i = 0; i < 8; i++) {
			String str = br.readLine();
			for (int j = 0; j < 8; j++) {
				if(str.charAt(j) == '#') {
					map[i][j] = true;
					wall[i]++;
					sumWall++;
				}
			}
		}
		
		if(sumWall == 0) System.out.println(1);		//벽이 하나도 없다 = 도착
		else {
			System.out.println(move());
		}

	}

	static int move() {
		Queue<RC> que = new ArrayDeque<>();
		que.offer(new RC(wook.r, wook.c));
		int time = 0;
		
		while(!que.isEmpty()) {
			int size = que.size();		//size동안은 같은 시간대
			for (int i = 0; i < size; i++) {
				RC nWook = que.poll();
				int r = nWook.r;
				int c = nWook.c;
				
				if(map[r][c]) continue;
				if(sumWall == 0) return 1;
				
				int sumUpperWall = 0;		//욱제 위치 위로 벽이 없다 = 도착
				for (int j = 0; j < r; j++) {
					sumUpperWall += wall[j];
				}
				if(sumUpperWall == 0) return 1;
				if(time == 8) return 1;		//8초까지 살아남음 = 도착
				
				for (int j = 0; j < 9; j++) {
					int nr = r + dr[j];
					int nc = c + dc[j];
					
					if(!check(nr, nc)) continue;
					if(map[nr][nc]) continue;
					que.offer(new RC(nr, nc));
				}
			}
			moveWall(time++);
		}
		return 0;
	}
	
	static void moveWall(int t) {
		sumWall -= wall[7];		//마지막 줄 벽은 모두 사라짐
		for (int i = 7; i > t; i--) {
			for (int j = 0; j < 8; j++) {
				map[i][j] = map[i-1][j];
			}
			wall[i] = wall[i-1];
		}
		wall[t] = 0;
	}
	
	static boolean check(int r, int c) {
		if(r < 0 || r >= 8 || c < 0 || c >= 8) return false;
		return true;
			
	}
	

}
