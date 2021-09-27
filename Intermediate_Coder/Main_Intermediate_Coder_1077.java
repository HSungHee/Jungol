package jungol;

import java.io.StringReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main_Intermediate_Coder_1077 {

	static class Goods implements Comparable<Goods> {
		int weight;
		int value;
		
		Goods(int weight, int value){
			this.weight = weight;
			this.value = value;
		}
		
		@Override
		public int compareTo(Goods o) {
			return this.weight - o.weight;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		sc = new Scanner(new StringReader(src));
		int N = sc.nextInt();
		int W = sc.nextInt();
			
		Goods[] goods = new Goods[N+1];
		goods[0] = new Goods(0,0);	
		
		int[][] bags = new int[N+1][W+1];
		int[] D = new int[W+1];	// 최대 가치 저장 배열
	
		for(int n=1; n<=N; n++) {
			int weight = sc.nextInt();
			int value = sc.nextInt();
			goods[n] = new Goods(weight, value);
		}
			
		Arrays.sort(goods); 
		
		for(int i=1; i<=W; i++) {
			int max = 0;
			for(int j=1; j<=N; j++) {
				if(i-goods[j].weight>=0) {
					// 		     		    같은 열, 이전 행 값과		현재 가치 + 현재무게를 뺀 무게의 최대가치의 합 중 더 큰것
					bags[j][i] = Math.max(bags[j][i-1], goods[j].value+D[i-goods[j].weight]);	
				} else {
					bags[j][i] = bags[j][i-1];
				}
				max = Math.max(max, bags[j][i]);	// 현재 열값 갱신이 끝난 후, 해당 열의 최대값과 max 중 더 큰 값을 max로 갱신
			}
			D[i] = max;	// D값을 max로 갱신
		}
		
		for(int[] ba : bags) {
			for(int b : ba) {
				System.out.print(b + "\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int d : D) {
			System.out.print(d + "\t");
		}
		System.out.println();
		System.out.println(D[W]);
	}
	static String src = "4 14 \r\n" + 
			"2 40 \r\n" + 
			"5 110 \r\n" + 
			"10 200 \r\n" + 
			"3 50";
}
