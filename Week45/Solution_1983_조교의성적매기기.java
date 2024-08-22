import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1983_조교의성적매기기 {
	
	static int T;
	static int N;
	static int K;
	static int[] score;
	static String[] alpha = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	int scoreK = 0;
        	int num = N/10;
        	score = new int[N];
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		score[i] = 35*Integer.parseInt(st.nextToken())
        					+ 45*Integer.parseInt(st.nextToken())
        						+ 20*Integer.parseInt(st.nextToken());
        		if(i == K-1) scoreK = score[i];
			}
        	//System.out.println(scoreK);
        	int group = 0;
        	Arrays.sort(score);
        	//System.out.println(Arrays.toString(score));
        	for (int i = 0; i < N; i+=num) {
				if(scoreK <= score[N-i-1]) continue;
				else if(scoreK > score[N-i-1]) {
					group = i/num-1;
					//System.out.println((N-i-1) + " " + score[N-i-1]+ " "+ group);
					break;
				}
			}
        	sb.append("#" + t + " " + alpha[group] + "\n");
        }
        System.out.println(sb.toString());
	}
}
