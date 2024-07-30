package week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2007 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int testCase = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < testCase; i++) {
			String str = br.readLine();
			//문자열의 첫번째 글자 ch에 저장
			char ch = str.charAt(0);
			//마디의 길이 l
			int l = 0;
			//마디의 최대 길이가 10이므로 범위 내에서만 반복되는 문자열을 찾는다
			for (int j = 1; j < 11; j++) {
				if(str.charAt(j) == ch) {	//첫 글자 ch와 동일한 문자가 나오면
					//첫 문자 ~ 동일한 문자 전까지 문자열 = 동일한 문자 ~ 같은 길이 문자열가 일치하는지 확인
					if(str.substring(0, j).equals(str.substring(j, 2*j))) {
						l = j;
						break;
					}
				}
			}
			sb.append("#").append(i+1).append(" ").append(l).append("\n");
		}
		System.out.println(sb.toString());
	}

}