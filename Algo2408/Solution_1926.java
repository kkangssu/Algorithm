package Algo2408;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1926 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			//숫자 안에 3, 6, 9가 포함되는지 확인 -> charAt() 사용 -> 숫자를 String으로
			String num = i + "";
			//문자열 num 안에 3, 6, 9가 포함되어 있으면 true, 없으면 false
			boolean b = false;
			for (int j = 0; j < num.length(); j++) {
				if(num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
					sb.append("-");
					b = true;
				}
			}
			if(b == false) {
				sb.append(i);
			}
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}

}
