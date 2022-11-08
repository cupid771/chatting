package chattingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup_Back{
	private String NickNameforGoToDB;
	private String PasswordforGoToDB;
	
	private String Sign_up_done;
	private String Sign_up_fail;
	public Signup_Back(String NickNameforGoToDB, String PasswordforGoToDB){
		
		this.NickNameforGoToDB = NickNameforGoToDB;
		this.PasswordforGoToDB = PasswordforGoToDB;
		
	}
	
	public String Signup_process() {
		try {
			// MySQL DB용 드라이로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			// DB연결 
			Connection conn =
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatting", "root", "123456");
			
			// sql문장
			String sql = "insert into user_info values(?,?)";
			PreparedStatement pstmt = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, NickNameforGoToDB);
				pstmt.setString(2, PasswordforGoToDB);
				int result = pstmt.executeUpdate();
				
				if(result ==1) {
					System.out.print("데이터 삽입성공!");
					Sign_up_done = "회원가입 성공!";
					
			
				}} catch(Exception e) {
					System.out.print("데이터 삽입실패!");
				}
			
			
			
			// DB연결해제 
			conn.close();
			System.out.println("mysql 연결해제 성공");
		}
		catch(ClassNotFoundException error) {
			System.out.println("mysql driver 미설치 또는 드라이버 이름 오류");
		}
		catch(SQLException error) {
			System.out.println("DB접속오류");
		}
		
		return Sign_up_done;
	}

	public void IDCheck() {
		// TODO Auto-generated method stub
		return;
	}
	
	
	
	
	
}


	

