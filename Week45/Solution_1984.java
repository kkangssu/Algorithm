import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1984 {

	static int[] arr = new int[10];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int testCase = Integer.parseInt(st.nextToken());
		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			int sum = 0;
			for (int j = 1; j < 9; j++) {
				sum += arr[j];
			}
			int avg = sum/8;
			if(sum%8 >= 4) avg++;
			sb.append("#").append(i+1).append(" ").append(avg + "\n");
		}
		
		System.out.println(sb.toString());

	}

}
