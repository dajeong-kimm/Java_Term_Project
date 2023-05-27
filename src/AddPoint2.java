import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class AddPoint2 extends JPanel {

   UserController uc = new UserController();
   int point;
   User user = uc.getLogin();
   
   public AddPoint2(JFrame mf, int totalSum) {

	// Load custom font (defaultFont로 설정)
		  Font defaultFont = Font.getFont("Dialog");
		  
      this.setLayout(new BorderLayout());
      this.setBackground(Color.white);
   
      JPanel top = new JPanel();
      top.setBackground(new Color(241, 194, 50));

      this.add(top,"North");
      
      Image logo = new ImageIcon("image/logo.png").getImage().getScaledInstance(150, 150, 0);
         // 만들어진 이미지 객체를 JLabel에 넣기
         JLabel logo1 = new JLabel(new ImageIcon(logo));top.add(logo1, BorderLayout.WEST);
      
        JLabel text = new JLabel("MY PAGE");
      top.add(text);
      text.setFont(defaultFont.deriveFont(50f));
      
      JLabel title = new JLabel("MYPAGE");
      title.setFont(new Font("맑은고딕", Font.BOLD, 20));
      title.setBounds(310, 220, 100, 30);
    
      JPanel main = new JPanel();
      main.setBackground(new Color(106, 168, 79));
      main.setLayout(null);
      add(main);
      // Main
      JButton pointT = new JButton("포인트 충전");
      pointT.setFont(defaultFont.deriveFont(30f));
      pointT.setBackground(Color.WHITE);
      pointT.setBounds(280,100,520,100);
      main.add(pointT);
      
      TextField box = new TextField();
      box.setFont(defaultFont.deriveFont(50f));
      box.setBackground(new Color(241, 194, 50));
      box.setBounds(280,250,520,70);
      main.add(box);
      
      
      JLabel text1 = new JLabel("금액");
      text1.setFont(defaultFont.deriveFont(30f));
      text1.setBackground(new Color(106, 168, 79));
      text1.setBounds(180,250,200,70);
      main.add(text1);
      
      JButton button2 = new JButton("충전하기" );
      button2.setForeground(Color.black);
      button2.setFont(defaultFont.deriveFont(30f));
      button2.setBackground(Color.white);
      button2.setBounds(280,380,240,70);
      main.add(button2);
      
      button2.addActionListener(new ActionListener() {

  		@Override
  		public void actionPerformed(ActionEvent e) {
  		      
				Dialog checkPwdDialog = new Dialog(mf, "비밀번호 확인");
				checkPwdDialog.setBounds(750, 400, 250, 70);
				checkPwdDialog.setSize(300, 200);
				checkPwdDialog.setLayout(null);

				JLabel text1 = new JLabel("결제 비밀번호");
				text1.setBounds(30, 30, 150, 20);
				checkPwdDialog.add(text1);

				TextField pass = new TextField();
				pass.setBounds(30, 50, 200, 100);
				pass.setEchoChar('*');

				JButton ok = new JButton("확인");
				checkPwdDialog.add(ok);
				ok.setBounds(30, 150, 60, 20);
				checkPwdDialog.add(pass);
				
				ok.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String userPwd="";
						userPwd=user.getPaypwd();
						
						if (pass.getText().equals(userPwd)) {
							JOptionPane.showMessageDialog(null, "확인되었습니다.");

							point = user.getPoint();
							System.out.println(box.getText());
							point += Integer.parseInt(box.getText());
							user.setPoint(point);
							uc.saveLogin(user);
							System.out.println("포인" + user.getPoint());

							ArrayList<User> list = uc.openList();
							for (int i = 0; i < list.size(); i++) {
								System.out.println("cnffur3");
								if (list.get(i).getId().equals(user.getId())) {
									System.out.println("cnffur4");
										list.get(i).setPoint(point);
										System.out.println("list에 있는 포인트"+list.get(i).getPoint());
										uc.saveList(list);
									}
								}
		                   
		                   mf.getContentPane().removeAll();
		                   mf.getContentPane().add(new Payment(mf,totalSum));
		                   mf.repaint();
		                   mf.setVisible(true);
		                   checkPwdDialog.dispose();
		                   	                   
		                } else {
		                   JOptionPane.showMessageDialog(null, "비밀번호를 다시 입력해주세요.", "비밀번호 오류", JOptionPane.ERROR_MESSAGE);
		                }
						
					}
					
				});
				JButton cancel = new JButton("취소");
		          checkPwdDialog.add(cancel);
		          cancel.setBounds(90,150,60,20);
		          checkPwdDialog.setVisible(true);
		          
		          cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 checkPwdDialog.dispose();

					}
		        	  
		          });
		          checkPwdDialog.add(pass);							
  		}	  
        });
      JButton goBack = new JButton("뒤로가기");
      goBack.setForeground(Color.black);
      goBack.setFont(defaultFont.deriveFont(30f));
      goBack.setBackground(Color.WHITE);
      goBack.setBounds(560, 380,240, 70);
      main.add(goBack);
      
      goBack.addMouseListener(new MouseAdapter() {

          @Override
          public void mouseClicked(MouseEvent e) {
             mf.getContentPane().removeAll();
             mf.getContentPane().add(new Payment(mf, totalSum));
             mf.repaint();
             mf.setVisible(true);

          }
       });
      
   }
}