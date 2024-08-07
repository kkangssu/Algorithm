
//수도 요금 경쟁
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1284 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine());
		for (int t = 1; t <= testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aFee = Integer.parseInt(st.nextToken());	//A사 1L당 요금
			int bFee = Integer.parseInt(st.nextToken());	//B사 기본 요금
			int bMax = Integer.parseInt(st.nextToken());	//B사 기본요금 범위
			int bExtra = Integer.parseInt(st.nextToken());	//B사 1L당 추가요금
			int water = Integer.parseInt(st.nextToken());	//사용 수도 양
			
			aFee *= water;
			if(water <= bMax) {
				sb.append("#" + t + " " + Math.min(aFee, bFee) + "\n");
			}
			else {
				bFee += (water - bMax)*bExtra;
				sb.append("#" + t + " " + Math.min(aFee, bFee) + "\n");
			}
		}
		
		System.out.println(sb.toString());

	}

}
