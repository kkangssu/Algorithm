package Algo2409;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_16198_에너지모으기_list {
	
	static List<Integer> energy;
	static int n;
	static int maxEnergy = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		energy = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			energy.add(Integer.parseInt(st.nextToken()));
		}
		
		sumEnergy(0);
		
		System.out.println(maxEnergy);

	}
	
	public static void sumEnergy(int sumE) {
		if(energy.size() == 2) {
			maxEnergy = Math.max(maxEnergy, sumE);
			return;
		}
		
		for (int i = 1; i < energy.size()-1; i++) {
			int get = energy.get(i-1) * energy.get(i+1);
			int remove = energy.remove(i);
			
			sumEnergy(sumE+get);
			energy.add(i, remove);
			
		}
	}

}
