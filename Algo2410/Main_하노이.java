package Algo2410;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_하노이 {
	
	static int N;
	static StringBuilder sb;
	static int move;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		hanoi(N, 1, 2, 3);
		
		System.out.println(move);
		System.out.println(sb.toString());
	}

	static void hanoi(int n, int dep, int trans, int arr) {
		if(n == 1) {
			sb.append(dep).append(" ").append(arr).append("\n");
			move++;
			return;
		}
		
		hanoi(n-1, dep, arr, trans);
		sb.append(dep).append(" ").append(arr).append("\n");
		move++;
		hanoi(n-1, trans, dep, arr);
	}

}
