package s09_week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 문자열 배열 + 문자열 연결은 시간, 메모리를 많이 사용하지 않을까?
* 그래서 oper[num]에는 이전 num에서 num을 만든 명령어 char을 저장
* before[num]에 이전 num을 저장해 backtracking하는 방법
* 방법1) backtracking하는 과정을 stack에 저장해 모두 저장 후 뒤에서부터 뽑아내기
* 방법2) StringBuilder에 저장한 후 sb.reverse하기
* -> StringBuilder가 메모리 덜 사용
*/

public class Main_9019_DSLR_backtrack {
	
	static int[] before;
	static char[] oper;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            before = new int[10000];
            oper = new char[10000];
            
            sb.append(bfs(A, B)).append("\n");
        }
        
        System.out.println(sb);
    }
    
    static String bfs(int A, int B) {
        Queue<Integer> queue = new ArrayDeque<>();
        
        Arrays.fill(before, -1);
        
        queue.offer(A);
        before[A] = A;
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            if (now == B) break;
            
            int d = D(now);
            int s = S(now);
            int l = L(now);
            int r = R(now);
            
            if (before[d] == -1) {
                oper[d] = 'D';
                before[d] = now;
                queue.offer(d);
            }
            if (before[s] == -1) {
                oper[s] = 'S';
                before[s] = now;
                queue.offer(s);
            }
            if (before[l] == -1) {
                oper[l] = 'L';
                before[l] = now;
                queue.offer(l);
            }
            if (before[r] == -1) {
                oper[r] = 'R';
                before[r] = now;
                queue.offer(r);
            }
        }
        
        return backtrack(A, B);
    }
    
    static String backtrack(int A, int B) {
        StringBuilder sb = new StringBuilder();
        int num = B;
        while (num != A) {
            sb.append(oper[num]);
            num = before[num];
        }
        return sb.reverse().toString();
    }
    
    static int D(int n) {
        return (n * 2) % 10000;
    }
    
    static int S(int n) {
        return n == 0 ? 9999 : n - 1;
    }
    
    static int L(int n) {
        return (n % 1000) * 10 + n / 1000;
    }
    
    static int R(int n) {
        return (n % 10) * 1000 + n / 10;
    }
}
