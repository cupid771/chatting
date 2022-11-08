package chattingProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.mysql.cj.protocol.Resultset;

//이곳에는 아이디중복검사함수, 비밀번호 유효성 검사 함수   가있다

public class Signup_Back_prototype {
	private String NickNameforGoToDB;
	private String PasswordforGoToDB;
	private String EmailforGoToDB;

	public Signup_Back_prototype(String NickNameforGoToDB, String PasswordforGoToDB, String EmailforGoToDB) {

		this.NickNameforGoToDB = NickNameforGoToDB;
		this.PasswordforGoToDB = PasswordforGoToDB;
		this.EmailforGoToDB = EmailforGoToDB;
	}

	// 아이디 중복체크 함수
	public int IDCheck() {

		int result = -1;

		try {
			// DB 연결 과정
			Connection conn;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatting", "root", "123456");

			// 아이디 비교(DB와 비교하여 원래 존재하는 아이디는 쓰지못하게함
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = ("select u_nickname from user_info where u_nickname = ?");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NickNameforGoToDB);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = 0;

			} else {

				result = 1;

			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 중복된 아이디가 존재하면 0을 아니면 1을 리턴한다
		return result;
	}

	// 비밀번호 유효성 검사 함수
	public int PWCheck() {
		int result = -1;

		// 비밀번호 유효성 검사식1 : 숫자, 특수문자가 포함되어야 한다.
		String regExp_symbol = "([0-9].*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*[0-9])";
		// 비밀번호 유효성 검사식2 : 영문자 대소문자가 적어도 하나씩은 포함되어야 한다.
		String regExp_alpha = "([a-z].*[A-Z])|([A-Z].*[a-z])";

		// 정규표현식 컴파일
		Pattern pattern_symbol = Pattern.compile(regExp_symbol);
		Pattern pattern_alpha = Pattern.compile(regExp_alpha);

		// 문자 매칭
		Matcher matcher_symbol = pattern_symbol.matcher(PasswordforGoToDB);
		Matcher matcher_alpha = pattern_alpha.matcher(PasswordforGoToDB);

		if (matcher_symbol.find() && matcher_alpha.find()) {
			result = 1;
		} else {
			result = 0;
		}
		// 비밀번호를 사용할 수 있다면 1을 아니면 0을 반환한다
		return result;

	}

	// 이메일 중복체크함수
	public int EmailCheck() {

		int result = -1;

		try {
			// DB 연결 과정
			Connection conn;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatting", "root", "123456");

			// 아이디 비교(DB와 비교하여 원래 존재하는 아이디는 쓰지못하게함
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			String sql = ("select u_email from user_info where u_email = ?");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, EmailforGoToDB);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				result = 0;

			} else {

				result = 1;

			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 중복된 아이디가 존재하면 0을 아니면 1을 리턴한다
		return result;
	}

	// 회원가입 조건 모두 만족후 회원정보를 DB에 저장하는 함수
	public int signup() {

		int result = -1;

		try {
			// DB 연결 과정
			Connection conn;
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chatting", "root", "123456");

			// sql문장
			PreparedStatement pstmt = null;
			int rs;
			String sql = "insert into user_info values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, NickNameforGoToDB);
			pstmt.setString(2, PasswordforGoToDB);
			pstmt.setString(3, EmailforGoToDB);
			rs = pstmt.executeUpdate();

			if (rs == 1) {
				result = 1;

			} else {
				result = 0;
			}

			// DB연결해제
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}
}
