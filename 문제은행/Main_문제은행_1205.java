package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_문제은행_1205 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] numbers = new int[N];
		
		// 카드 입력 받기
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);	// 오름차순 정렬
		
		int zero = 0;	// 0의 개수 저장 변수
		int start = 0;	// 0이 아닌 첫 인덱스 값
		for(int i=0; i<N; i++) {
			if(numbers[i]==0) zero++;
			else {
				start = i;
				break;
			}
		}
		
		int cnt = 1;	// 탐색하며 현재 스트레이트 수 count
		int max = Integer.MIN_VALUE;	// 최대 스트레이트 수
		for(int i=start; i<N-1; i++) {
			int zeroCnt;
			if(zero>0) zeroCnt = zero;
			else zeroCnt = -1;			
			for(int j=i+1; j<N; j++) {
				if(numbers[j]-numbers[j-1]==1) cnt++;
				else if(numbers[j]-numbers[j-1]>1) {
					if(zeroCnt==0) break;
					else if(numbers[j]-numbers[j-1]-1 <= zeroCnt) {
						zeroCnt-=(numbers[j]-numbers[j-1]-1);
						cnt+=(numbers[j]-numbers[j-1]);
					} else {
						break;
					}
					
				}
			}
			if(zeroCnt!=-1)	cnt+=zeroCnt;
			max = Math.max(max, cnt);
			cnt = 1;
		}
		if(zero==numbers.length) max--;
		System.out.println(max);		
	}
}
