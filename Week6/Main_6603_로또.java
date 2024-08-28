package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6603_로또 {
	
	static int[] num;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		
		 while(true) {
			String str = br.readLine();
			if(str.equals("0")) {
				break;
			}
			
			st = new StringTokenizer(str);
			int k = Integer.parseInt(st.nextToken());
			num = new int[k];
			arr = new int[k];
			visited = new boolean[k];
			for(int j = 0; j < k; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			lotto(k, 0, -1);
			sb.append("\n");
		 }

		 System.out.println(sb.toString());
	}
	
	public static void lotto(int k, int dp, int prev) {
		
		if(dp == 6) {
			for(int i = 0; i < 6; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}
		
		for(int i = prev+1; i < k; i++) {
			if(!visited[i]) {
				arr[dp] = num[i];
				visited[i] = true;
				lotto(k, dp+1, i);
				visited[i] = false;
			}
		}
	}

}
