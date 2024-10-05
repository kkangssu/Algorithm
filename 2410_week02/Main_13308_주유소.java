package s2410_w2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13308_주유소 {
	
	static class Node{
		int next;
		int l;
		Node(int next, int l){
			this.next = next;
			this.l = l;
		}
	}
	static int city, road;
	static int[] price;
	static List<Node>[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		city = Integer.parseInt(st.nextToken());
		road = Integer.parseInt(st.nextToken());
		price = new int[city+1];
		list = new ArrayList[city+1];
		for (int i = 0; i <= city; i++) {
			list[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		//주유비
		for (int i = 1; i <= city; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		//도로
		for (int i = 0; i < road; i++) {
			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			list[c1].add(new Node(c2, l));
			list[c2].add(new Node(c2, l));
		}
		
	}

}
