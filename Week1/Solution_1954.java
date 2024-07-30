package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1954 {
  static int[][] arr;
  //방향: 우 하 좌 상
	static int[] dy = {1, 0, -1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int m;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append("#").append(i+1).append("\n");
			int m = Integer.parseInt(br.readLine());
			int[][] arr = new int[m][m];
			
			int x = 0;
			int y = 0;
			
			//시작
			arr[x][y] = 1;
			int idx = 0;    //방향 idx
			for (int j = 2; j <= m*m; j++) {
				//다음 칸 [x+dx[idx]][y+dy[idx]]이 범위를 넘어가거나 이미 지나간 칸이면
				//방향 변경
				if(x+dx[idx] == m || y+dy[idx] == m || x+dx[idx] < 0 || y+dy[idx] < 0 
						|| arr[x+dx[idx]][y+dy[idx]] != 0) {
					//방향 범위 0 ~ 3
					idx = (++idx) % 4;
				}
				x += dx[idx];
				y += dy[idx];
				arr[x][y] = j;
			}
			
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < m; k++) {
					sb.append(arr[j][k]).append(" ");
				}
				sb.deleteCharAt(sb.length()-1);
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}