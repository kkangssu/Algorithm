import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//좌표 클래스
class point {
	int r;
	int c;
	point(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main_15686_치킨배달 {
	
	static int N;		//도시 크기
	static int M;		//최대 치킨집 수
	static int[][] map;		//도시 지도
	static int house;		//집 수
	static int chicken;		//치킨집 수
	static int[][] L;	//L[n][m]: n번째 집에서 m번째 치킨집까지 거리
	static List<point> H;	//집 좌표
	static List<point> C;	//치킨집 좌표
	static int minL;
	static int[] chickenArr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		H = new ArrayList<>();
		C = new ArrayList<>();
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					house++;
					H.add(new point(i, j));
				}
				else if(map[i][j] == 2) {
					chicken++;
					C.add(new point(i, j));
				}
			}
		}
		L = new int[chicken][house];
		chickenArr = new int[M];
		
		for (int i = 0; i < chicken; i++) {
			ChickenL(i);
		}
		
		minL = Integer.MAX_VALUE;
		
		findMinLength(0, -1);
		
		System.out.println(minL);
		
	}

	static void findMinLength(int dp, int tmp) {
		if(dp == M) {
			int sum = 0;
			for (int i = 0; i < house; i++) {
				int min = L[chickenArr[0]][i];
				for (int j = 1; j < M; j++) {
					min = Math.min(min, L[chickenArr[j]][i]);
				}
				sum += min;
			}
			minL = Math.min(minL, sum);
			return;
		}
		
		for (int i = tmp+1; i < chicken; i++) {
			chickenArr[dp] = i;
			System.out.println("dp: " + dp + " i: " + i);
			findMinLength(dp+1, i);
		}
		
	}

	//각 집에서 치킨집 i까지의 거리를 배열에 저장하는 메서드
	static void ChickenL(int i) {
		int r = C.get(i).r;
		int c = C.get(i).c;
		int idxH = 0;
		for(point p: H) {
			L[i][idxH] = Math.abs(r-p.r) + Math.abs(c-p.c);
			idxH++;
		}
		return;
	}

}
