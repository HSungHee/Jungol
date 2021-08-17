package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_문제은행_1828 {
	static class Fridge implements Comparable<Fridge> {
		int low, high;

		public Fridge(int low, int high) {
			this.low = low;
			this.high = high;
		}
		
		@Override
		public int compareTo(Fridge o) {
			int value = this.high - o.high;
			if(value != 0) return value;
			return this.low - o.low;
		}
		
		@Override
		public String toString() {
			return "("+low+", "+high+")";	
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	// 화학물질의 수
		int cnt = 0;			// 필요한 냉장고 수
		
		Fridge[] fridge = new Fridge[N];
		
		// N개의 화학물질의 최저, 최고 온도 입력받기
		for(int i=0; i<N; i++) {
			fridge[i] = new Fridge(sc.nextInt(), sc.nextInt());
		}
		
		ArrayList<Fridge> list = new ArrayList<Fridge>();
		Arrays.sort(fridge);

		int low = fridge[0].low;	// 첫번째 화학물질의 최저 온도 
		int high = fridge[0].high;	// 첫번째 화학물질의 최고 온도
		cnt = 1;
		
		for(int i=1; i<N; i++) {	// 1 ~ N-1 탐색
			if(high < fridge[i].low) {	// 최고온도가 현재의 최소온도보다 크다면, 겹쳐지지 않으므로 새로운 정보로 갱신
				cnt++;		// 냉장고 갯수 +1
				high = fridge[i].high;	// 최고온도 현재의 최고온도로 갱신
			}
		}
		System.out.println(cnt);
	}
}