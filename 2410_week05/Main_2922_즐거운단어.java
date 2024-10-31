package s10_w5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2922_즐거운단어 {
	
	static String str;
	static long num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		boolean flag = false;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'L') {
				flag = true;	//flag는 L이 포함되면 true
				break;
			}
		}
		make(0, 1, 0, 0, flag);
		System.out.println(num);
	}

	static void make(int idx, long n, int ja, int mo, boolean flag) {
		if(idx == str.length()) {
			if(!flag) return;	//L이 들어가지 않은 경우
			num += n;
			//System.out.println("num: " + num);
			//System.out.println();
			return;
		}
		
		//System.out.println(str.charAt(idx) + " " + n);
		if(str.charAt(idx) == '_') {
			if(ja < 2) {
				//System.out.println("put L");
				make(idx+1, n, ja+1, 0, true);
				/System.out.println("put ja");
				make(idx+1, n*20, ja+1, 0, flag);
				//flag = true면 이미 있어서 넣지 않은 경우
				//flag = false면 다음 _에서 넣어줄꺼야
			}
			if(mo < 2) {
				//System.out.println("put mo");
				make(idx+1, n*5, 0, mo+1, flag);
			}
			return;
		}
		else if(str.charAt(idx) == 'A' || str.charAt(idx) == 'E' || str.charAt(idx) == 'I' || str.charAt(idx) == 'O' || str.charAt(idx) == 'U') {
			if(mo+1 == 3) return;
			make(idx+1, n, 0, mo+1, flag);
			return;
		}
		else {
			if(ja+1 == 3) return;
			make(idx+1, n, ja+1, 0, flag);
			return;
		}
		
	}

}
