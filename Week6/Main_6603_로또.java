package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	
	static int[] num;	//k개의 수 -> 입력됨
	static int[] arr;	//k개의 수 중 뽑은 6개의 수
	static int k;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		 while(true) {
			String str = br.readLine();
			if(str.equals("0")) { //0이 나오면 끝
				break;
			}
			
			st = new StringTokenizer(str);
			k = Integer.parseInt(st.nextToken());
			num = new int[k];
			arr = new int[6];
			visited = new boolean[k];
			for(int j = 0; j < k; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			lotto(0, 0);
			sb.append("\n");
		 }

		 System.out.println(sb.toString());
	}
	
	public static void lotto(int dp, int prev) {
		
		if(dp == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = prev; i < k; i++) {
			if(!visited[i]) {
				arr[dp] = num[i];
				visited[i] = true;
				lotto(dp+1, i+1);
				visited[i] = false;
			}
		}
	}

}
