
//어디에 단ㄷ어가 들어갈 수 있을까
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1979 {
	
	static int[][] map;
	static int n;
	static int k;
	static int[] wordLength;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			wordLength = new int[n+1];	//길이 k가 들어갈 수 있는 자리 개수 = wordLength[k]
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < n; i++) {
				findLength(i);
			}
			
			
			sb.append("#" + t + " "+ wordLength[k] + "\n");
			
		}
		
		System.out.println(sb.toString());

	}
	
	//wordLength[] 채우는 메서드
	static void findLength(int i) {
		int sumR = 0;
		int sumC = 0;
		for (int j = 0; j < n; j++) {
			if(map[i][j] == 1) {
				sumR++;
			}
			else if(j == 0) {
				sumR = 0;
			}
			else {
				wordLength[sumR]++;
				sumR = 0;
			}
			
			
			if(map[j][i] == 1) {
				sumC++;
			}
			else if(j == 0) {
				sumC = 0;
			}
			else {
				wordLength[sumC]++;
				sumC = 0;
			}
			
		}
		wordLength[sumR]++;
		wordLength[sumC]++;
	}

}
