import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_나무자르기 {
	
	static int N;
	static int M;
	static int[] tree;
	static int H;
	static int min;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new int[N];
		max = 0;
		min = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > max) max = tree[i];
		}
		findH();
		
		System.out.println(min-1);
		
	}
	
	//Binary Search
	static void findH() {
		while(min < max) {
			long sum = 0L;
			H = (max+min)/2;
			
			for (int i = 0; i < N; i++) {
				if(tree[i] > H) {
					sum += tree[i]- H;
				}
			}
			if(sum < M) {
				max = H;
			}
			else {
				min = H+1;
			}
		}
	}

}
