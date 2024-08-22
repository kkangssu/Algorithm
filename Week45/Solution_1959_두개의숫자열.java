
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1959_두개의숫자열 {
    static int T;
    static int N;
    static int M;
    static Integer[] a;
    static Integer[] b;
    static int sum;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new Integer[N];
            b = new Integer[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }
             
            int max = 0;
            //배열 a와 배열 b 중 어떤 배열이 더 길지 모르기 때문에 경우 나눔
            if(N < M) {
                for (int i = 0; i <= M-N; i++) {
                    sum = 0;
                    int idx = i;
                    for (int j = 0; j < N; j++) {
                        sum += a[j]*b[idx++];
                    }
                    max = Math.max(max, sum);
                }
            }
            else if(N == M) {
                sum = 0;
                for (int i = 0; i < N; i++) {
                	sum += a[i]*b[i];
                }
            }
            else {
                for (int i = 0; i <= N-M; i++) {
                    sum = 0;
                    int idx = i;
                    for (int j = 0; j < M; j++) {
                    	sum += a[idx++]*b[j];
                    }
                    max = Math.max(max, sum);
                }
            }
             
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb.toString());
 
    } 
}
