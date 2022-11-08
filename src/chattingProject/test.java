package chattingProject;

public class test {
	private String NickNameforGoToDB = "cupid771";
	private String PasswordforGoToDB = "!Atlantis771";
	private String EmailforGoToDB = "qwzdqa@naver.com";
	private Signup_Back_prototype sbp;
	
	
	public test() {
	
	
	
	sbp = new Signup_Back_prototype(NickNameforGoToDB,PasswordforGoToDB,EmailforGoToDB);
	
	int IDCheck = sbp.IDCheck();
	int PWCheck = sbp.PWCheck();
	int EmailCheck = sbp.EmailCheck();
	int signup =sbp.signup();
	
	System.out.println(IDCheck);
	
	System.out.println(PWCheck);
	
	System.out.println(EmailCheck);
	
	System.out.println(signup);
	
	
	}
	
	public static void main(String[] args) {
		new test();
	}
	

}


