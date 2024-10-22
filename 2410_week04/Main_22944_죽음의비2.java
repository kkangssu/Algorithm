package s2410_w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_22944_죽음의비2 {

	static class RC{
		int r;
		int c;
		RC(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int N, H, D;
	static List<RC> u = new ArrayList<>();	//우산 위치
	static boolean[] visited;
	static RC s;	//출발지
	static RC e;	//도착지
	static int minTime;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				char ch = str.charAt(j);
				if(ch == 'S') {
					s = new RC(i, j);
				}
				else if(ch == 'E') {
					e = new RC(i, j);
				}
				else if(ch == 'U') {
					u.add(new RC(i, j));
				}
			}
		}
		visited = new boolean[u.size()];
		minTime = Integer.MAX_VALUE;
		dfs(s, 0, H, 0);
		
		System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
		
	}

	static void dfs(RC now, int t, int hp, int d) {
		//도착지까지 갈 수 있는지 확인
		int toE = len(now, e);
		//System.out.println(toE + " - "  + (hp+d) +" - " + t);
		if(hp + d - toE >= 0) {
			minTime = Math.min(minTime, t+toE);
			return;
		}
		//우산에 도달할 수 있는지 확인
		for (int i = 0; i < u.size(); i++) {
			if(visited[i]) continue;			
			int l = len(now, u.get(i));	
			//System.out.println("l: " + l + " m: " + (hp+d));
			if(l > hp+d) continue;
			int nhp = hp;
			if(l > d + 1) {
				nhp -= (l - d - 1);
			}
			if(nhp <= 0) continue;
			visited[i] = true;
			//System.out.println("h: " + nhp);
			dfs(u.get(i), t+l, nhp, D-1);
			visited[i] = false;
			
		}
		return;
	}
	
	static int len(RC now, RC next) {
		return Math.abs(next.r - now.r) + Math.abs(next.c - now.c);
	}
}
