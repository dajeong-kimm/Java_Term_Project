import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		this.setTitle("SHOE-MART");
		this.setBounds(350,50,1100,900);
		
		//이동하고자 하는 패널 추가
		this.getContentPane().add(new ProductPage(this));
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
