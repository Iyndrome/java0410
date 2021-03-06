package example;

public class Palindrome {

	public static void main(String[] args) {
		String msg = "ABCBA";
		//문자열의 길이를 len 에 대입
		int len = msg.length();
		
		int i;
		//절반이 되는 지점까지
		//아래처럼 작성을 하게되면 
		//if 의 조건을 만족하면 반복문을 중단합니다.
		//if 조건을 만족하지 않았다는 것을 반복문을 끝까지 수행하지
		//않았다는 것입니다.
		//이 경우 반복문을 끝까지 수행하면 i의 값은 len/2 입니다.
		for(i=0; i<len/2; i=i+1) {
			//앞에서 글자를 가져오기 뒤에서 글자를 가져와서 비교
			//2개의 글자가 다르면 반복문을 중단
			if(msg.charAt(i) != msg.charAt(len-i-1)) {
				break;
			}
		}
		
		if(i == len/2) {
			System.out.println("팰린드롬");
		}else {
			System.out.println("펠린드롬 아님");
		}

	}

}
