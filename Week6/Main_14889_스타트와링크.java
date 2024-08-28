package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	
	public static int n;
	public static int[][] ability;
	public static int min_differ;
	public static boolean[] pick;

	public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		pick = new boolean[n];
		min_differ = 1000;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StartLink(0, -1);

		System.out.println(min_differ);

	}
	
	public static void StartLink(int member, int prev) {
		if(member == n/2) {
			min_differ = Math.min(min_differ, differ());
		}
		
		for(int i = prev+1; i < n; i++) {
			if(!pick[i]) {
				pick[i] = true;
				StartLink(member+1, i);
				pick[i] = false;
			}
		}
	}
	
	public static int differ() {
		int[] start = new int[n/2];
		int[] link = new int[n/2];
		
		int dp1 = 0;
		int dp2 = 0;
		//pick[i]가 true면 start팀 멤버, false면 link팀 멤버
		for(int i = 0; i < n; i++) {
			if(pick[i]) {
				start[dp1++] = i;
			}
			else {
				link[dp2++] = i;
			}
		}
		
		int sum_start = 0;
		int sum_link = 0;
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				sum_start += ability[start[i]][start[j]];
				sum_link += ability[link[i]][link[j]];
			}
		}
		int diff = Math.max(sum_start - sum_link, sum_link - sum_start);
		
		return diff;
	}

}