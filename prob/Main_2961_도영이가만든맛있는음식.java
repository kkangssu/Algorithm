import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2961_도영이가만든맛있는음식 {
	
	static int N;
	static long acer;
	static long acid;
	static int[][] taste;
	static long min;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		taste = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		makeFood(0, 1, 0);
		System.out.println(min);
	}

	static void makeFood(long ace, long aci, int idx) {
		if(idx != 0) {
			min = Math.min(min, Math.abs(aci-ace));
		}
		
		for (int i = idx; i < N; i++) {
			makeFood(ace+taste[i][1], aci*taste[i][0], i+1);
		}
	}

}
