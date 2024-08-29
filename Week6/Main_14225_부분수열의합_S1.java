package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14225_부분수열의합_S1 {

	static int n;			//수열 개수
	static int[] arr;		//수열
	static boolean[] visited;	//수열 더한 값 -> true
	static int min;		//수열 합으로 만들 수 없는 최소 값
	static int sum;		//수열 총 합
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		min = 0;
		sum = 0;
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}
		visited = new boolean[sum+2];
		cal(0, 0);
		
		for (int i = 1; i <= sum+1; i++) {
			if(!visited[i]) {
				min = i;
				break;
			}
		}
		System.out.println(min);
		
	}
	
	public static void cal(int idx, int sum) {
		if(idx > 0) {
			visited[sum] = true;
		}
		
		for (int i = idx; i < n; i++) {
			cal(i+1, sum+arr[i]);
		}
		
	}

}
