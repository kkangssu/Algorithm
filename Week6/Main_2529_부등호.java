package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2529_부등호 {
	public static char[] sign;
	public static boolean[] visited;
	public static int n;
	static int min;
	static int max;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		sign = new char[n];
		visited = new boolean[10];
		String str = br.readLine();
		for(int i = 0; i < n; i++) {
			sign[i] = str.charAt(i*2);
		}

		max = 0;
		min = Integer.MAX_VALUE;

		findNum(0, 0, 0);
		

		System.out.println(max);
		System.out.println(min);
	}
	
	static void findNum(int idx, int sum, int i) {
		//System.out.println(idx + " " +i + " " + n);
		if(idx == n+1) {
			//System.out.println(sum);
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for (int j = 0; j <= 9; j++) {
			if(idx == 0) {
				visited[j] = true;
				findNum(idx+1, j, j);
				visited[j] = false;
			}
			else if(!visited[j]) {
				if(sign[idx-1] == '>' && j < i) {
					//System.out.println((idx-1) + " " + j);
					visited[j] = true;
					findNum(idx+1, sum*10+j, j);
					visited[j] = false;
				}
				else if(sign[idx-1] == '<' && j > i){
					//System.out.println((idx-1) + " " + j);
					visited[j] = true;
					findNum(idx+1, sum*10+j, j);
					visited[j] = false;
				}
			}
		}	
	}
}

