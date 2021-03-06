import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ThreadEx extends Thread{
	public void run() {
		try {
			//다운로드 받을 URL을 생성
			URL url = new URL(
				"http://blogfiles.naver.net/MjAxOTA5MDFfMjA3/MDAxNTY3MzM0NDgzNjMx.EPa-D2rEzpjWaqNtLsTdLfgykWOdWdJn5654C30DLjUg.8c3ClE3TwyYxzeX6SzLVOEyM3WP_ygBAwsDo3qwOVjog.JPEG.yhu7710/%B3%F3%B1%B8.jpg");
			//연결 객체 생성 하고 옵션 설정
			//연결 객체 만들기
			HttpURLConnection con = 
				(HttpURLConnection)
					url.openConnection();
			//연결 옵션 만들기
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			
			//바이트 단위로 데이터를 전송받을 스트림을 생성
			BufferedInputStream bis = 
				new BufferedInputStream(
					con.getInputStream());
			
			//바이트 배열을 저장할 파일 출력 스트림을 생성
			PrintStream ps = 
				new PrintStream("C://Users//30415//Desktop//인//농구.jpg");
			
			while(true) {
				//데이터를 저장할 배이트 배열 생성
				byte [] b = new byte[512];
				//데이터를 읽어서 b에 저장하고 읽은 개수를
				//len에 저장
				int len = bis.read(b);
				//읽은 데이터가 없으면 종료
				if(len <= 0) {
					break;
				}
				//b 배열에서 읽은 개수만큼만 기록
				ps.write(b, 0, len);
			}
			//버퍼를 이용하기 때문에 모아서 출력을 합니다.
			//종료할 때는 혹시 버퍼에 내용이 남아있을 수 있기 
			//때문에 flush를 호출해서 남은 내용을 출력
			ps.flush();
			//정리 작업
			ps.close();
			bis.close();
			con.disconnect();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}

public class ImageDownload {
	public static void main(String[] args) {
		//파일의 존재 여부 확인
		File f = new File("C://Users//30415//Desktop//인//농구.jpg");
		if(f.exists() == true) {
			System.out.println("파일이 이미 존재합니다.");
			System.exit(0);
		}else {
			System.out.println("파일이 존재하지 않아서"
					+ " 다운로드를 받습니다.");
			//스레드를 이용해서 다운로드
			ThreadEx th = new ThreadEx();
			th.start();
		}
		
	}
}