package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1963_소수경로2 {
	

	static int T, a, b;
	static boolean[] prime;
	static boolean[] visited;
	static Queue<Integer> num;
	static Queue<Integer> change;

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
			
			int change = bfs();
			
			if(change < 0) sb.append("Impossible").append("\n");
			else sb.append(change).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int bfs() {
		num = new ArrayDeque<>();
		change = new ArrayDeque<>();
		num.offer(a);
		change.offer(0);
		visited[a] = true;
		
		while(!num.isEmpty()) {
			int number = num.poll();
			int c = change.poll();
			if(number == b) return c;
			//System.out.println(number + " " + c);
			changeNumber(number, c);			
		}
		return -1;
	}

	static void changeNumber(int number, int ch) {
		int[] digits = new int[4];
        
        for (int i = 3; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 9; j++) {
                if (digits[i] == j) continue; // 원래 숫자와 같은 숫자 제외

                int newNumber = 0;
                for (int k = 0; k < 4; k++) {
                    if (k == i) {	// i번째 자리 숫자 변경
                        newNumber = newNumber * 10 + j;
                    } else {
                        newNumber = newNumber * 10 + digits[k];
                    }
                }
                if(newNumber < 1000) continue;
                if(visited[newNumber]) continue;
                if(prime[newNumber]) continue;
                
                visited[newNumber] = true;
                num.offer(newNumber);
                change.offer(ch+1);
                //System.out.println(newNumber + " " + (ch+1));
            }
        }
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
