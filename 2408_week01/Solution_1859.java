package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1859 {

	static int testCase;
	static int n;
	static long price[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			n = Integer.parseInt(br.readLine());
			price = new long[n];
			st = new StringTokenizer(br.readLine());
			long buy = 0;
			long money = 0;
			
			for (int j = 0; j < n; j++) {
				price[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < n-1; j++) {
				 for (int k = j+1; k < n; k++) {
					if(price[j] < price[k]) {
						buy++;
						money -= price[j];
						break;
					}
					else if(k == n-1) {
						money += price[j] * buy;
						buy = 0;
					}
					
				}
			}
			money += price[n-1]*buy;
			sb.append("#").append(i+1).append(" " + money).append("\n");
		}
		System.out.println(sb.toString());
	}
}
