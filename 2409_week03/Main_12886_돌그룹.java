package boj2409_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12886_돌그룹 {
	
	static class Stone{
		int a;
		int b;
		int c;
		Stone(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
	static int[] stone;
	static int sum;
	static boolean[][] visited;
	static Queue<Stone> que;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		stone = new int[3];
		visited = new boolean[1501][1501];
		for (int i = 0; i < 3; i++) {
			stone[i] = Integer.parseInt(st.nextToken());
			sum += stone[i];
		}
		
		if(sum % 3 != 0) System.out.println(0);
		else {
			System.out.println(exchange());
		}

	}

	static int exchange() {
        que = new ArrayDeque<>();
        que.offer(new Stone(stone[0], stone[1], stone[2]));
        visited[stone[0]][stone[1]] = true;

        while (!que.isEmpty()) {
            Stone s = que.poll();
            int a = s.a;
            int b = s.b;
            int c = s.c;

            if (a == b && b == c) {
                return 1;
            }

            exchange(a, b, c);
            exchange(a, c, b);
            exchange(b, c, a);
        }
        return 0;
    }

    static void exchange(int x, int y, int z) {
        if (x != y) {
            int nx = x > y ? x - y : 2 * x;
            int ny = x > y ? y * 2 : y - x;
            if (visited[nx][ny]) return;
            visited[nx][ny] = true;
            que.offer(new Stone(nx, ny, z));
        }
    }
}