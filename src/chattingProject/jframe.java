package chattingProject;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class jframe {
	public static void main(String[] args) {
		LoginGUI1 LG = new LoginGUI1();
	}

}


class LoginGUI1 extends JFrame implements ActionListener {
	// 유저의 로그인 창
	private JPanel Login_GUIPanel = new JPanel();
	private JTextField NickName_Text = new JTextField(20);
	private JTextField Password_Text = new JTextField(20);
	private JTextField Port_Text = new JTextField(20);
	private JTextField IPAddress_Text = new JTextField(20);
	private JLabel NickName_Label = new JLabel("유저 입력");
	private JLabel Password_Label = new JLabel("비밀번호 입력");
	private JLabel Port_Label = new JLabel("입력창1");
	private JLabel IPAddress_Label = new JLabel("입력창2");
	private JButton Login_GUI_Button = new JButton("버튼1");
	private JButton GoSignUp_GUI_Button = new JButton("버튼2");

	public LoginGUI1() {
		setTitle("Jframe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(300, 350);
		setResizable(false);
		setVisible(true);
		Login_GUI_Button.setPreferredSize(new Dimension(260, 40));
		GoSignUp_GUI_Button.setPreferredSize(new Dimension(260, 40));
		Login_GUI_Button.addActionListener(this);
		GoSignUp_GUI_Button.addActionListener(this);
		Login_GUIPanel.add(Port_Label);
		Login_GUIPanel.add(Port_Text);
		Login_GUIPanel.add(IPAddress_Label);
		Login_GUIPanel.add(IPAddress_Text);
		Login_GUIPanel.add(Login_GUI_Button);
		Login_GUIPanel.add(GoSignUp_GUI_Button);
		add(Login_GUIPanel);
	}

	public void actionPerformed(ActionEvent e) {
		// 닉네임, 주소, 포트값을 버튼을 통해 입력받습니다.
		try {
			if (e.getSource() == Login_GUI_Button) {
				String NickName = NickName_Text.getText().trim();
				String IPAddress = IPAddress_Text.getText().trim();
				int Port = Integer.parseInt(Port_Text.getText().trim());
				new Client_ChatGUI(NickName, IPAddress, Port);
				setVisible(false);
			}
		} catch (Exception a) {
			
			JOptionPane.showMessageDialog(null, "버튼 1클릭!");
		}
		
		try {
			if(e.getSource() == GoSignUp_GUI_Button) {
				Signup_GUI SG = new Signup_GUI();
			}
		}catch (Exception a) {
			JOptionPane.showMessageDialog(null, "나오지 않는창");
		}
		
		
	}
	
	

}
