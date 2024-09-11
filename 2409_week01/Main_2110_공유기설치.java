package s09_week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
	
	static int H, R;
	static int[] house;
	static int[] router;
	static int maxD;
	static int minD;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		H = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		house = new int[H];
		router = new int[R];
		for (int i = 0; i < H; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house);
		
		minD = 1;
		maxD = house[H-1] - house[0] + 1;
		
		install();
		
		System.out.println(max);
	}

	static void install() {
		while(minD < maxD) {
			int mid = (maxD + minD)/2;
			int start = house[0];
			int cntR = 1;
			for (int i = 0; i < H; i++) {
				if(house[i] - start >= mid) {
					start = house[i];
					cntR++;
				}
			}
			if(cntR < R) maxD = mid;
			else minD = mid+1;
		}
		
		max = minD-1;
	}

	
}
