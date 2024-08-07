
//초심자의 회문 검사
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1989 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			String str = br.readLine();
			char[] word = str.toCharArray();
			boolean palin = true;
			
			//word.length/2까지 범위로 하면 시간이 단축될줄 알았는데
			//그닥 차이 없음 -> 단어길이가 최대 10자라서 그런듯
			for (int i = 0; i < word.length; i++) {
				if(word[i] != word[word.length-1-i]){
					palin = false;
					break;
				}
			}
			if(palin) {
				sb.append("#" + t + " " + 1 + "\n");
			}
			else {
				sb.append("#" + t + " " + 0 + "\n");
			}
		}
		System.out.println(sb.toString());
	}

}
