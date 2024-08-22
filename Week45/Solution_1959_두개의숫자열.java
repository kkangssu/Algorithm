
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1959_두개의숫자열 {
    static int T;
    static int N;
    static int M;
    static String[] a;
    static String[] b;
    static int sum;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = new String[N];
            b = new String[M];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                a[i] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                b[i] = st.nextToken();
            }
             
            int max = 0;
            if(N < M) {
                for (int i = 0; i <= M-N; i++) {
                    sum = 0;
                    for (int j = 0; j < N; j++) {
                        opp(a[j], b[j+i]);
                    }
                    max = Math.max(max, sum);
                }
            }
            else if(N == M) {
                sum = 0;
                for (int i = 0; i < N; i++) {
                    opp(a[i], b[i]);
                }
            }
            else {
                for (int i = 0; i <= N-M; i++) {
                    sum = 0;
                    for (int j = 0; j < M; j++) {
                        opp(a[j+i], b[j]);
                    }
                    max = Math.max(max, sum);
                }
            }
             
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb.toString());
 
    }
     
    static void opp(String i, String j) {
        if(i.charAt(0) == '-' && j.charAt(0) == '-') {
            i = i.substring(1);
            j = j.substring(1);
            sum += Integer.parseInt(i)*Integer.parseInt(j);
        }
        else if(i.charAt(0) == '-') {
            i = i.substring(1);
            sum -= Integer.parseInt(i)*Integer.parseInt(j);
        }
        else if(j.charAt(0) == '-') {
            j = j.substring(1);
            sum -= Integer.parseInt(i)*Integer.parseInt(j);
        }
        else {
            sum += Integer.parseInt(i)*Integer.parseInt(j);
        }
         
    }
 
}
