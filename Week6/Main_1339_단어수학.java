package study0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Main_1339_단어수학 {
	
	public static void main(String[] args) throws Exception {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] word = new int[26];
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			int k = str.length();			
			for(int j = 0; j < k; j++) {
				char ch = str.charAt(j);
				int result = 1;
				for(int l = j; l < k-1; l++) {
					result *= 10;
				}
				word[ch - 'A'] += result;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < 26; i++) {
			list.add(word[i]);
		}
		list.sort(Comparator.reverseOrder());
		
		int answer = 0;
		for(int i = 9; i >= 0; i--) {
			answer += list.get(9 - i) * i;
		}

		System.out.println(answer);
	}

}
