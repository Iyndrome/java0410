import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		try {
			//UDP 받는 소켓 생성
			DatagramSocket ds = new DatagramSocket(9003);
			while(true) { 
				System.out.println("서버 대기 중...");
				//데이터를 받으려면 아래와 같이 먼저 받을 데이터를 저장할 배열을 만들어야한다. 
				//받을 데이터를 저장할 배열
				byte [] data = new byte[1024];
				//데이터 받기
				DatagramPacket dp = new DatagramPacket(data, 1024);
				ds.receive(dp);
				//보낸 곳의 주소와 내용 출력
				System.out.println("보낸곳:" + dp.getAddress().getHostAddress());
				
				//보낸 문자는 바이트배열이기 때문에 문자열로 만들어줘야한다.
				String msg = new String(data);
				System.out.println("보낸 메시지:" + msg);
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
