package swea0827;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_6808_규영이와인영이의카드게임 {
	
	static int T;
	static int[] A;
	static int[] B;
	static Set<Integer> aNum;
	static boolean[] visited;
	static int win;
	static int loose;
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			A = new int[9];
			B = new int[9];
			aNum = new HashSet<>();
			win = 0;
			loose = 0;
			visited = new boolean[9];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				A[i] = Integer.parseInt(st.nextToken());
				aNum.add(A[i]);
			}
			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if(!aNum.contains(i)) {
					B[idx++] = i;
				}
			}
			
			game(0, 0, 0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(loose).append("\n");
		}
		System.out.println(sb.toString());
	}


	static void game(int idx, int kyu, int in) {
		if(idx == 9) {
			if(kyu > in) win++;
			else if(kyu < in) loose++;
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visited[i]) {
				int newKyu = kyu;
				int newIn = in;
				if(B[i] > A[idx]) newIn += B[i] + A[idx];
				else newKyu += B[i] + A[idx];
				visited[i] = true;
				game(idx+1, newKyu, newIn);
				visited[i] = false;
			}
			else continue;
		}
		
	}

}
