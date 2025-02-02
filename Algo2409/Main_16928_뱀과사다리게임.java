package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16928_뱀과사다리게임 {
	
	static int L;
	static int S;
	static int[] map;
	//static int minPath;
	static int[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new int[101];
		visited = new int[101];
		
		for (int i = 0; i < L+S; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		
		move(1);
		
		System.out.println(visited[100]);

	}

	static void move(int i) {
		Queue<Integer> loc = new LinkedList<>();
		Queue<Integer> m = new LinkedList<>();
		loc.offer(i);
		m.offer(0);
		visited[i] = 0;
		
		while(!loc.isEmpty()) {
			int nowLoc = loc.poll();
			int nowMove = m.poll();
			
			
			//주사위 던지기
			for (int j = 1; j <= 6; j++) {
				int nextLoc = nowLoc + j;
				int nextMove = nowMove+1;
				//100에 도착하면 최소 주사위 횟수인지 확인
				//그 다음 j부터는 무조건 100 넘음 -> break
				if(nextLoc > 100) {
					continue;
				}
				
				//뱀이나 사다리가 있는 칸인 경우 -> 이동
				if(map[nextLoc] != 0) {	//사다리 + 뱀
				nextLoc = map[nextLoc];
				}
				
				//100에 도착하면 리턴
				if(nextLoc == 100) {
					visited[100] = nextMove;
					return;
				}
				
				//이미 지나간 위치는 더 적은 횟수의 주사위로 지나간 것 -> 지금 경로 폐기
				if(visited[nextLoc] != 0) continue;
				
				loc.offer(nextLoc);
				m.offer(nextMove);
				visited[nextLoc] = nextMove;				
			}
		}
	}
}
