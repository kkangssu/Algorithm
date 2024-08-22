import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution_1288_새로운불면증치료법 {

	//0~9까지의 숫자를 모두 보는 경우는 몇번째 양을 센 시점인가?
	//중복을 허용하지 않는 set을 이용해 set 안에 0~9까지 모두 저장된 시점에 반복문 break
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
				if(set.size() == 10) break;		//n%10의 결과만 set에 저장되므로 set 안에는 0~9까지의 숫자만 저장됨 ->  set의 크기만 구하면 된다
				numSheep++;
			}
			sb.append("#" + t + " " + num*numSheep + "\n");
		}
		
		System.out.println(sb.toString());

	}

}

