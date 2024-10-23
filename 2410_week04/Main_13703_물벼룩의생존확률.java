package s2410_w4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13703_물벼룩의생존확률 {
	
	static int l, t;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        l = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        if(l == 0) System.out.println(0);
        else {
        	long[][] dp = new long[t + 1][t + l + 1];
            
            dp[0][l] = 1;
            
            for (int T = 0; T < t; T++) {
                for (int L = 0; L <= t + l; L++) {
                    if (dp[T][L] == 0) continue;
                    
                    if (L > 0) {
                        //수면 도달 -> 죽음
                        if (L - 1 > 0) {
                            dp[T + 1][L - 1] += dp[T][L];
                        }
                    }
                    
                    //아래로 이동
                    if (L < t + l) {
                        dp[T + 1][L + 1] += dp[T][L];
                    }
                }
            }
            
            //생존하는 경우
            long live = 0;
            for (int i = 1; i <= t + l; i++) {
            	live += dp[t][i];
            }
            System.out.println(live);
        }
    }
}
