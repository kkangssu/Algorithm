import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2565_전깃줄 {
	
	static class Wire implements Comparable<Wire>{
		int s, e;
		Wire(int s, int e){
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Wire o) {
			return this.s - o.s;
		}
	}
	static int[] lis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int num = Integer.parseInt(br.readLine());
		Wire[] wires = new Wire[num];
		lis = new int[num];	//최장 증가 수열 LIS
		int len = 0;
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			wires[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(wires);
		
		for (int i = 0; i < num; i++) {
			int n = binarySearch(len, wires[i].e);	//lis에 현재 전깃줄 wires[i]가 들어갈 위치를 이진탐색으로 찾음
			lis[n] = wires[i].e;
			if(n == len) len++;
			//n == len: 추가된 위치가 LIS 배열의 끝 -> 배열의 길이가 늘어난다
			//n < len: n의 위치에 있는 숫자가 현재 전깃줄의 wires[i].e로 변경 -> 배열 길이는 늘어나지 않는다
		}
		
		System.out.println(num-len);
		
	}

	static int binarySearch(int len, int now) {
		int left = 0;
		int right = len;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(lis[mid] < now) left = mid + 1;
			else right = mid;
		}
		
		return left;
	}

}
