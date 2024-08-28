package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15658_연산자끼워넣기2 {
	
	static int n;
	static int[] num;
	static int[] oper;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());

		//숫자
		num = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		//연산자
		oper = new int[4];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		calcul(num[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calcul(int number, int idx) {
		if(idx == n) {
			max = Math.max(max, number);
			min = Math.min(min, number);
		}
		if(idx < n) {
			for(int i = 0; i < 4; i++) {
				if(oper[i] > 0) {
					oper[i]--;
					if(i == 0) {
						calcul(number + num[idx], idx+1);
					}
					else if(i == 1) {
						calcul(number - num[idx], idx+1);
					}
					else if(i == 2) {
						calcul(number * num[idx], idx+1);
					}
					else {
						calcul(number / num[idx], idx+1);
					}
					
					oper[i]++;
				}
			}
		}
		
	}

}