package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_문제은행_1370 {
	static class Room implements Comparable<Room> {
		int no; 		// 회의 번호
		int stime;		// 시작 시간
		int etime;		// 종료 시간
		public Room(int no, int stime, int etime) {
			this.no = no;
			this.stime = stime;
			this.etime = etime;
		}
		
		@Override
		public int compareTo(Room o) {
			int time = etime - o.etime;		// 시간이라 underflow 걱정을 안해도된다.
			if(time==0) {
				time = stime - o.stime;
			}
			return time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Room> list = new ArrayList<>(N);
		String line;
		StringTokenizer st;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new Room(	Integer.parseInt(st.nextToken()), 	// 회의 번호 입력
								Integer.parseInt(st.nextToken()), 	// 회의 시작시간 입력
								Integer.parseInt(st.nextToken())	// 회의 끝나는 시간 입력
							));
		}
		
		// 최고의 가치를 기준으로 정렬
		Collections.sort(list);
		ArrayList<Integer> cnums = new ArrayList<>(N);
		
		// 첫번째가 최고의 가치이므로 선택
		cnums.add(list.get(0).no);
		
		// 종료시간과 시작시간을 비교해줘야 하므로
		int end = list.get(0).etime;
		
		for(int i=1; i<N; i++) {
			// 다음 선택할 회의의 시작시간은 이전 회의의 종료시간과 같거나 커야한다
			if(end <= list.get(i).stime) {
				cnums.add(list.get(i).no);
				// 종료 시간이 바뀌었으므로 갱신
				end = list.get(i).etime;
			}
		}
		System.out.println(cnums.size());
		
		for(Integer no : cnums) {
			System.out.printf(no+" ");
		}
		
	}
}
