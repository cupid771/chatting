package chattingProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Signup_GUI extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel SignUp_GUIPanel = new JPanel();

	private JTextField NickNameset_Text = new JTextField(20);
	private JTextField Passwordset_Text = new JTextField(20);
	private JTextField Emailset_Text = new JTextField(30);

	private JLabel NickNameset_Label = new JLabel("원하는 유저이름 입력");
	private JLabel Passwordset_Label = new JLabel("원하는 비밀번호 입력");
	private JLabel Emailset_Label = new JLabel("이메일 입력");

	private JButton NickNameTest_Button = new JButton("아이디 중복 확인");
	private JButton PasswordTest_Button = new JButton("비밀번호 사용 가능 여부");
	private JButton EmailTest_Button = new JButton("이메일 사용 가능 여부");

	private JButton SignUpDone_GUI_Button = new JButton("완료");

	private Signup_Back_prototype sbp;

	public Signup_GUI() {
		setTitle("Sign UP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 400);
		setResizable(false);
		setVisible(true);
		SignUpDone_GUI_Button.setPreferredSize(new Dimension(260, 40));
		SignUpDone_GUI_Button.addActionListener(this);

		PasswordTest_Button.setPreferredSize(new Dimension(260, 40));
		PasswordTest_Button.addActionListener(this);

		NickNameTest_Button.setPreferredSize(new Dimension(260, 40));
		NickNameTest_Button.addActionListener(this);

		EmailTest_Button.setPreferredSize(new Dimension(260, 40));
		EmailTest_Button.addActionListener(this);

		SignUp_GUIPanel.add(NickNameset_Label);
		SignUp_GUIPanel.add(NickNameset_Text);
		SignUp_GUIPanel.add(NickNameTest_Button);

		SignUp_GUIPanel.add(Passwordset_Label);
		SignUp_GUIPanel.add(Passwordset_Text);
		SignUp_GUIPanel.add(PasswordTest_Button);

		SignUp_GUIPanel.add(Emailset_Label);
		SignUp_GUIPanel.add(Emailset_Text);
		SignUp_GUIPanel.add(EmailTest_Button);

		SignUp_GUIPanel.add(SignUpDone_GUI_Button);

		add(SignUp_GUIPanel);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String NickNameforGoToDB = NickNameset_Text.getText();
		String PasswordforGoToDB = Passwordset_Text.getText();
		String EmailforGoToDB = Emailset_Text.getText();

		// 닉네임 중복검사 버튼 이벤트처리
		if (e.getSource() == NickNameTest_Button) {

			sbp = new Signup_Back_prototype(NickNameforGoToDB, PasswordforGoToDB, EmailforGoToDB);
			int IDCheck = sbp.IDCheck();

			if (IDCheck == 0) {
				NickNameTest_Button.setText("아이디사용불가능");
			}
			if (IDCheck == 1) {
				NickNameTest_Button.setText("아이디사용가능");
			}

		}
		// 비밀번호 유효성검사 버튼 이벤트처리
		if (e.getSource() == PasswordTest_Button) {

			sbp = new Signup_Back_prototype(NickNameforGoToDB, PasswordforGoToDB, EmailforGoToDB);
			int PWCheck = sbp.PWCheck();

			if (PWCheck == 0) {
				PasswordTest_Button.setText("비밀번호사용불가능");
			}
			if (PWCheck == 1) {
				PasswordTest_Button.setText("비밀번호사용가능");
			}

		}

		// 이메일 중복검사 버튼 이벤트처리
		if (e.getSource() == EmailTest_Button) {

			sbp = new Signup_Back_prototype(NickNameforGoToDB, PasswordforGoToDB, EmailforGoToDB);
			int EmailCheck = sbp.EmailCheck();

			if (EmailCheck == 0) {
				EmailTest_Button.setText("이메일사용불가능");
			}
			if (EmailCheck == 1) {
				EmailTest_Button.setText("이메일사용가능");
			}

		}

		if (e.getSource() == SignUpDone_GUI_Button) {
			sbp = new Signup_Back_prototype(NickNameforGoToDB, PasswordforGoToDB, EmailforGoToDB);
			int SignupDone = sbp.signup();

			if (SignupDone == 1) {
				JOptionPane.showMessageDialog(null, "회원가입 완료!");
				dispose();
			}
			if (SignupDone == 0) {

			}
		}
	}
}
