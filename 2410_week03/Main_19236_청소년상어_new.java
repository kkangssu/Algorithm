package s10_w3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.LinkOption;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_19236_청소년상어_new {
	//↑, ↖, ←, ↙, ↓, ↘, →, ↗ 
	static class Fish{
		int n;
		int d;
		boolean die;
		Fish(int n, int d, boolean die){
			this.n = n;
			this.d = d;
			this.die = die;
		}
	}
	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	static Fish[][] map;
	static RC[] location;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new Fish[4][4];
		location = new RC[17];
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int n = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken())-1;
				map[i][j] = new Fish(n, d, false);
				location[n] = new RC(i, j);
			}
		}
		map[0][0].die = true;
		dfs(0, 0, map[0][0].d, map[0][0].n);
		
		System.out.println(max);
		
	}

	static void dfs(int sr, int sc, int sd, int sum) {
		//System.out.println("new Sahrk: " + sr +", " + sc + " " + sd +" -> " + sum);
		//물고기 이동
		move(sr, sc);
		
//		for (int i = 0; i < 4; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(map[i][j].n + " ");
//			}
//			System.out.println("");
//		}
		
		//배열 복사
		Fish[][] tmpM = new Fish[4][4];
		RC[] tmpL = new RC[17];
		for(int i = 0; i < 4; i++){
			System.arraycopy(map[i], 0, tmpM[i], 0, 4);
		}
		System.arraycopy(location, 0, tmpL, 0, 17);
		
		//상어 이동 가능 위치 찾기
		//System.out.println(sd);
		int nsr = sr;
		int nsc = sc;
		for (int i = 0; i < 4; i++) {
			nsr += dr[sd];
			nsc += dc[sd];
			if(!check(nsr, nsc)) break;
			if(map[nsr][nsc].die) continue;
			
			//System.out.println(nsr + " " + nsc);
			map[nsr][nsc] = new Fish(map[nsr][nsc].n, map[nsr][nsc].d, true);
			dfs(nsr, nsc, map[nsr][nsc].d, sum+map[nsr][nsc].n);
			
			
			//배열 되돌리기
			for(int j = 0; j < 4; j++){
				System.arraycopy(tmpM[j], 0, map[j], 0, 4);
			}
			System.arraycopy(tmpL, 0, location, 0, 17);
			//map[nsr][nsc] = new Fish(map[nsr][nsc].n, map[nsr][nsc].d, false);
		}
		//System.out.println("-------------------------------");
		max = Math.max(max, sum);
		return;
	}
	
	
	static void move(int sr, int sc) {
		for (int i = 1; i <= 16; i++) {
			int r = location[i].r;
			int c = location[i].c;
			int d = map[r][c].d;
			
			if(map[r][c].die) continue;//이미 먹힌 물고기 이동할 필요 없음
			for (int j = 0; j < 8; j++) {
				int nd = (d + j)%8;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				if(!check(nr, nc)) continue;
				if(nr == sr && nc == sc) continue;	//해당 위치에 상어가 있는 경우
				//System.out.println("change: " + i + " (" + r +", " + c + ") -> (" + nr + ", " + nc+") " + nd);
				Fish tmp = map[nr][nc];
				map[nr][nc] = new Fish(i, nd, false);
				map[r][c] = tmp;
				location[i] = new RC(nr, nc);
				location[tmp.n] = new RC(r, c);
				break;
			}
		}
	}

	static boolean check(int r, int c) {
		return r >= 0 && r < 4 && c >= 0 && c < 4;
	}

}
