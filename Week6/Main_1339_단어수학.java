package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
//import java.util.ArrayList;
//import java.util.Comparator;

public class Main_1339_단어수학 {
	
	public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		/*
		 * ABC + ABCD
		 * word[A] = 100+1000
		 * word[B] = 10+100
		 * word[C] = 1+10
		 * word[D] = 1
		 */
		int[] word = new int[26];
		int wordN = 0;
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			int k = str.length();	
			int idx = 0;
			for(int j = (int) Math.pow(10, k-1); j > 0; j /= 10) {
				char ch = str.charAt(idx++);
				if(word[ch-'A'] == 0) wordN++;
				word[ch - 'A'] += j;
			}
		}
		
		//1번 ArrayList 사용 -> 100ms
//		ArrayList<Integer> list = new ArrayList<>();
//		for(int i = 0; i < 26; i++) {
//			if(word[i] != 0) {
//				list.add(word[i]);
//			}
//		}
//		list.sort(Comparator.reverseOrder());
//		
//		int answer = 0;
//		int idx = 0;
//		while(idx < list.size()) {
//			answer += list.get(idx)*(9-idx);
//			idx++;
//		}
		

		//2번 배열 사용 -> 100ms		
		Arrays.sort(word);
		int answer = 0;
		int idx = 25;
		for (int j = 0; j < wordN; j++) {
			answer += word[idx]*(9-j);
			idx--;
		}

		System.out.println(answer);
	}

}
