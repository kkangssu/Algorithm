package Algo2409;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* A를 가공한 수는 모두 10000 이하 -> visited[10000]
* oper[num] -> oper[이전 num] + 이전 num에서 num을 만든 명령어
* B에 도달했을 때 oper[B]는 B까지의 명령어들 문자열
* 3816ms
*/

public class Main_9019_DSLR {
    
    static int T, A, B;
    static boolean[] visited;
    static String[] oper;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            visited = new boolean[10000];
            oper = new String[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            
            String result = bfs();
            sb.append(result).append("\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static String bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(A);
        visited[A] = true;
        oper[A] = "";
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == B) return oper[B];
            
            int d = D(now);
            int s = S(now);
            int l = L(now);
            int r = R(now);
            
            if (!visited[d]) {
                visited[d] = true;
                oper[d] = oper[now] + "D";
                queue.offer(d);
            }
            if (!visited[s]) {
                visited[s] = true;
                oper[s] = oper[now] + "S";
                queue.offer(s);
            }
            if (!visited[l]) {
                visited[l] = true;
                oper[l] = oper[now] + "L";
                queue.offer(l);
            }
            if (!visited[r]) {
                visited[r] = true;
                oper[r] = oper[now] + "R";
                queue.offer(r);
            }
        }
        
        return "";
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
