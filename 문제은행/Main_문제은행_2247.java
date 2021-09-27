package jungol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_문제은행_2247 {
	static int used;		// 가장 길게 머문 시간
	static int unused;		// 가장 길게 한 명도 머물지 않았던 시간
	
	static class Library implements Comparable<Library>{
		int start, end;
		
		public Library(int start, int end) {
			this.start = start; 
			this.end = end;
		}
		@Override
		public int compareTo(Library o) {
			int value = this.start - o.start;	// start를 기준으로 오름차순 정렬
			if(value != 0) return value;		// start 값이 같다면
			return o.end - this.end;			// end 값을 기준으로 내림차순 정렬
		}
		
		public String toString() {
			return "("+start+", "+end+")";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();		// 학생 수
		
		Library[] librarys = new Library[N];
		for(int i=0; i<N; i++) {
			librarys[i] = new Library(sc.nextInt(), sc.nextInt());
		}
		
		Arrays.sort(librarys);	// 시작시간(start)를 기준으로 오름차순 정렬 
		
		// 첫번째 학생의 시작시간, 끝시간 대입
		int start = librarys[0].start;	
		int end = librarys[0].end;
		
		used = end - start;
		unused = 0;
		
		for(int i=1; i<N; i++) {
			if(end >= librarys[i].start) {	// end가 현재의 start보다 크거나 같다면 (연속해서 이용)
				if(end < librarys[i].end) {	// end가 현재의 end보다 작다면
					end = librarys[i].end;	// 뒤의 end로 end값 갱신
				}
				used = Math.max(used, end-start);	// end 갱신후, 원래의 used 값과 현재 end를 기준으로 이용시간을 비교하여 큰 값으로 used 갱신
			} else {	// end가 현재의 start보다 작은 경우는 연속하지 않고 중간에 빈 시간이 발생한 경우
				unused = Math.max(unused, librarys[i].start - end);		// 현재의 start - end를 하여 중간에 빈 시간 구해서 기존의 unused와 비교하여 큰 값으로 갱신
				start = librarys[i].start;		// start를 현재의 start로 갱신 (새출발)
				end = librarys[i].end;			// end를 현재의 end로 갱신 (새로운 끝)
			}
		}		
		System.out.println(used + " " + unused);
	}
}
