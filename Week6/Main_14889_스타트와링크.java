package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	
	public static int N;
	public static int[][] ability;
	public static int min;
	public static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		visited = new boolean[N];
		min = 1000;		//1<=S<=100, 4<=N<=20
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		teamStart(0, 0);

		System.out.println(min);

	}
	
	public static void teamStart(int member, int prev) {
		if(member == N/2) {
			//start팀인 사람은 visited = true, link팀인 사람은 visited = false
			differ();
			return;
		}
		
		for(int i = prev; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				teamStart(member+1, i+1);
				visited[i] = false;
			}
		}
	}
	
	public static void differ() {
		int[] start = new int[N/2];
		int[] link = new int[N/2];
		
		int dp1 = 0;
		int dp2 = 0;
		//pick[i]가 true면 start팀 멤버, false면 link팀 멤버
		for(int i = 0; i < N; i++) {
			if(visited[i]) {
				start[dp1++] = i;
			}
			else {
				link[dp2++] = i;
			}
		}
		
		int sumStart = 0;
		int sumLink = 0;
		for(int i = 0; i < N/2; i++) {
			for(int j = 0; j < N/2; j++) {
				sumStart += ability[start[i]][start[j]];
				sumLink += ability[link[i]][link[j]];
			}
		}
		min = Math.min(min, Math.abs(sumStart-sumLink));
		return;
	}

}