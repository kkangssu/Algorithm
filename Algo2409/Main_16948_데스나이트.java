package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16948_데스나이트 {
	
	static int N;
	static int Sr;	//출발r
	static int Sc;	//출발c
	static int Er;	//도착r
	static int Ec;	//도착c
	//static boolean[][] visited;
	static int[][] visited;
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	static int minMove;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Sr = Integer.parseInt(st.nextToken());
		Sc = Integer.parseInt(st.nextToken());
		Er = Integer.parseInt(st.nextToken());
		Ec = Integer.parseInt(st.nextToken());
		
		//visited = new boolean[N][N];
		visited = new int[N][N];
		minMove = -1;

		move();
		
		System.out.println(minMove);
	}

	static void move() {
		Queue<Integer> r = new LinkedList<>();
		Queue<Integer> c = new LinkedList<>();
		//Queue<Integer> m = new LinkedList<>();
		r.offer(Sr);
		c.offer(Sc);
		//m.offer(0);
		//visited[Sr][Sc] = true;
		while(!r.isEmpty()) {
			int nowR = r.poll();
			int nowC = c.poll();
			//int nowM = m.poll();
			int nowM = visited[nowR][nowC];
			
			for (int i = 0; i < 6; i++) {
				int nextR = nowR +dr[i];
				int nextC = nowC +dc[i];
				int nextM = nowM +1;
				
				if(nextR == Er && nextC == Ec) {
					minMove = nextM;
					return;
				}
				
				if(check(nextR, nextC) && visited[nextR][nextC] == 0) {
					//System.out.println(nextM + ": " + nextR + ", " + nextC);
					r.offer(nextR);
					c.offer(nextC);
					//m.offer(nextM);
					visited[nextR][nextC] = nextM;
					//visited[nextR][nextC] = true;
				}
			}
		}
	}

	static boolean check(int nextR, int nextC) {
		if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= N ) return false;
		return true;
	}

}
