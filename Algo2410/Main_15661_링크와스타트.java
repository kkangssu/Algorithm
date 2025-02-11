package Algo2410;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main_15661_링크와스타트 {

	public static int n;
	public static int[][] ability;
	public static int min_differ;
	public static boolean[] pick;
	
	public static void main(String[] args) throws IOException {
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
		
		LinkStart(0, -1);

		System.out.println(min_differ);

	}

	public static void LinkStart(int member, int prev) {
		if(member >= 1) {		//각 팀의 인원이 정해지지 않음 -> 한명 이상이 된 경우부터 모두 비교해야함
			min_differ = Math.min(min_differ, differ(member));
		}
		
		for(int i = prev+1; i < n; i++) {
			if(!pick[i]) {
				pick[i] = true;
				LinkStart(member+1, i);
				pick[i] = false;
			}
		}
	}
	
	public static int differ(int member) {
		int[] start = new int[member];
		int[] link = new int[n - member];
		
		int dp1 = 0;
		int dp2 = 0;
		//pick[i]가 true면 start팀 멤버, false면 link팀 멤버 각 배열에 저장
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
		for(int i = 0; i < member; i++) {
			for(int j = 0; j < member; j++) {
				sum_start += ability[start[i]][start[j]];
			}
		}
		for(int i = 0; i < n - member; i++) {
			for(int j = 0; j < n - member; j++) {
				sum_link += ability[link[i]][link[j]];
			}
		}
		int diff = Math.max(sum_start - sum_link, sum_link - sum_start);
		
		return diff;
	}

}
