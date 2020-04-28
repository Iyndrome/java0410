
public class PrimeCheck {

	public static void main(String[] args) {
		//2부터 1000까지의 소수의 개수 구하기
		//소수(prime) : 2부터 자신의 절반이 되는 숫자까지 나누어서 
		//나누어 떨어지지 않으면 소수
		
		//데이터 개수를 저장할 변수
		int cnt = 0; 
		
		//2부터 1000까지 
		for(int i =2; i<=1000; i=i+1) { 
		//나누어지는지 확인하기 위한 변수
		boolean flag = false;
		//2부터 자신의 절반이 되는 숫자까지
		for(int j=2; j<= i/2; j=j+1) {
		//for(int j=2; j<= Math.sqrt(i); j=j+1) { 로 해도 가능하다
		//나누어 떨어진 경우
		if(i % j == 0) { 
		flag = true;
		break; 		
		}
		}
		//나누어 진적이 없으면 소수
		if(flag == false) { 
		System.out.printf("%4d", i);
		cnt = cnt + 1;
		}
	}
	System.out.println("\n소수 개수:" + cnt);
	
	}
 }
