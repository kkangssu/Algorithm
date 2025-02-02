package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1963_소수경로 {
	

	static int T, a, b;
	static boolean[] prime;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		isPrime();

		T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			visited = new boolean[10000];
			
			if(a == b) sb.append(0).append("\n");
			else {
				int change = bfs();
				
				if(change < 0) sb.append("Impossible").append("\n");
				else sb.append(change).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		Queue<Integer> num = new ArrayDeque<>();
		Queue<Integer> change = new ArrayDeque<>();
		num.offer(a);
		change.offer(0);
		visited[a] = true;
		
		while(!num.isEmpty()) {
			int number = num.poll();
			int c = change.poll();
			if(number == b) return c;
			
			for (int j = 1; j <= 9; j++) {
				int cNum = changeN(number, 0, j);
				if(prime[cNum]) continue;
				if(visited[cNum]) continue;
				//System.out.println((c+1) + " " + number + " -> " + cNum);
				visited[cNum] = true;
				num.offer(cNum);
				change.offer(c+1);
			}
			for (int i = 1; i < 4; i++) {
				for (int j = 0; j <= 9; j++) {
					int cNum = changeN(number, i, j);
					if(prime[cNum]) continue;
					if(visited[cNum]) continue;
					//System.out.println((c+1) + " " + number + " -> " + cNum);
					visited[cNum] = true;
					num.offer(cNum);
					change.offer(c+1);
				}
			}
		}
		return -1;
	}

	static int changeN(int number, int i, int j) {
		StringBuilder sb = new StringBuilder();
		String sNum = number+"";
		if(i == 0) {
			sb.append(j).append(sNum.charAt(1)).append(sNum.charAt(2)).append(sNum.charAt(3));
		}
		else if(i == 1) {
			sb.append(sNum.charAt(0)).append(j).append(sNum.charAt(2)).append(sNum.charAt(3));
		}
		else if(i == 2) {
			sb.append(sNum.charAt(0)).append(sNum.charAt(1)).append(j).append(sNum.charAt(3));
		}
		else {
			sb.append(sNum.charAt(0)).append(sNum.charAt(1)).append(sNum.charAt(2)).append(j);
		}
		//System.out.println(sb.toString());
		return Integer.parseInt(sb.toString());
	}

	static void isPrime() {
		prime = new boolean[10000];
		for (int i = 2; i < 100; i++) {
			if(prime[i] == true) continue;
			for (int j = i*2; j < 10000; j += i) {
				prime[j] = true;
			}
		}
		
	}

}
