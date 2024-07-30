package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2005 {
	
	//1 ≤ N ≤ 10 매 테스트 케이스마다 새로 삼가형 만들 필요 없음
	static int[][] tri = new int[10][10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =  new StringBuilder();
		
		//max 사용 이유: 이전 테스트케이스에서 파스칼 삼각형을 이미 max까지 만들었기 때문에
		//현재 테스트케이스의 N이 max보다 작거나 같은 경우 이미 만들어진 파스칼 삼각형에서 출력
		//N이 max보다 큰 경우 max부터 N까지만 삼각형을 만들고 출력
		int max = 0;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 0; t < testCase; t++) {
			sb.append("#").append(t+1).append("\n");
			int N = Integer.parseInt(br.readLine());
			//현재 테스트케이스의 N이 가장 큰 경우 -> 삼각형 추가
			if(max < N) {
				makeTri(max, N);
				max = N;
			}
			//파스칼 삼각형 프린트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i+1; j++) {
					sb.append(tri[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb.toString());

	}

	public static void makeTri(int m, int n) {
		
		for (int i = m; i < n; i++) {
			tri[i][0] = 1;
			tri[i][i] = 1;
			for (int j = 1; j < i; j++) {
				tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
			}
		}
		return;
	}

}
