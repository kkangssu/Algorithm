
//숫자 배열 회전
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1961 {

	static int N;
	static int[][] nums;
	static int[][][] turnNums90;
	//turnNums90[0]은 90도 회전
	//turnNums90[1]은 180도 회전
	//turnNums90[2]은 270도 회전
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			sb.append("#" + t + "\n");
			N = Integer.parseInt(br.readLine());
			nums = new int[N][N];
			turnNums90 = new int[3][N][N];

			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			turn90(nums, turnNums90[0]);
			turn90(turnNums90[0], turnNums90[1]);
			turn90(turnNums90[1], turnNums90[2]);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < N; k++) {
						sb.append(turnNums90[j][i][k]);
					}
					sb.append(" ");
				}
				sb.append("\n");				
			}
		}
		System.out.println(sb.toString());
	}
	//배열을 90도 돌리는 메서드
	static void turn90(int[][] arr, int[][]arr2) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr2[j][N-i-1] = arr[i][j];
			}
		}
	}

}
