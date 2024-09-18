package boj2409_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2138_전구와스위치 {
	
	static int N;
	static boolean[] startBulb;
	static boolean[] endBulb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		startBulb = new boolean[N];
		endBulb = new boolean[N];
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			if(str.charAt(i) == 1) startBulb[i] = true;
		}
		
		int push0 = pushSwitch(0, 1, 1);
		int unpush0 = pushSwitch(0, 0, 0);
	}

	private static int pushSwitch(int p, int idx, int num) {
		if(idx == N) {
			return num;
		}
		return -1;
	}

}
