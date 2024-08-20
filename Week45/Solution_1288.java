import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_1288 {
	
	static int T;
	static Set<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			set = new HashSet<>();
			int num = Integer.parseInt(br.readLine());
			int numSheep = 1;
			while(true) {
				long n = num*numSheep;
				while(n > 0) {
					set.add((int) (n%10));
					n /= 10;
				}
				if(set.size() == 10) break;
				numSheep++;
			}
			sb.append("#" + t + " " + num*numSheep + "\n");
		}
		
		System.out.println(sb.toString());

	}

}

