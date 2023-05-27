import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class LoginForm extends JFrame {

    private UserDataSet users;

    private JLabel lblId;
    private JLabel lblPw;
    private JTextField tfId;
    private JPasswordField tfPw;
    private JButton btnLogin;
    private JButton btnJoin;

    public LoginForm() {
        users = new UserDataSet();
        init();
        setDisplay();
        addListeners();
        showFrame();
    }

    public void init() {
        Dimension lblSize = new Dimension(80, 30);
        int tfSize = 10;
        Dimension btnSize = new Dimension(100, 25);

        lblId = new JLabel("ID");
        lblId.setPreferredSize(lblSize);
        lblPw = new JLabel("Password");
        lblPw.setPreferredSize(lblSize);

        tfId = new JTextField(tfSize);
        tfPw = new JPasswordField(tfSize);

        btnLogin = new JButton("Login");
        btnLogin.setPreferredSize(btnSize);
        btnJoin = new JButton("Join");
        btnJoin.setPreferredSize(btnSize);
    }

    public UserDataSet getUsers() {
        return users;
    }

    public String getTfId() {
        return tfId.getText();
    }

    public void setDisplay() {
        JPanel pnlNorth = new JPanel(new GridLayout(0, 1));

        JPanel pnlId = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlId.add(lblId);
        pnlId.add(tfId);

        JPanel pnlPw = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlPw.add(lblPw);
        pnlPw.add(tfPw);

        pnlNorth.add(pnlId);
        pnlNorth.add(pnlPw);

        JPanel pnlSouth = new JPanel();
        pnlSouth.add(btnLogin);
        pnlSouth.add(btnJoin);

        pnlNorth.setBorder(new EmptyBorder(0, 20, 0, 20));
        pnlSouth.setBorder(new EmptyBorder(0, 0, 10, 0));

        add(pnlNorth, BorderLayout.NORTH);
        add(pnlSouth, BorderLayout.SOUTH);
    }
    

    public void addListeners() {
        btnJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JoinForm joinForm = new JoinForm(LoginForm.this);
                joinForm.clearFields();
                joinForm.setVisible(true);
            }
        });
       

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredId = tfId.getText();
                String enteredPw = String.valueOf(tfPw.getPassword());

                if (enteredId.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "아이디를 입력하세요.",
                            "로그인폼",
                            JOptionPane.WARNING_MESSAGE);
                } else if (users.contains(new User(enteredId))) {
                    User user = users.getUser(enteredId);

                    if (enteredPw.isEmpty()) {
                        JOptionPane.showMessageDialog(LoginForm.this,
                                "비밀번호를 입력하세요.",
                                "로그인폼",
                                JOptionPane.WARNING_MESSAGE);
                    } else if (!user.getPw().equals(enteredPw)) {
                        JOptionPane.showMessageDialog(LoginForm.this,
                                "비밀번호가 일치하지 않습니다.");
                    } else {
                        InformationForm infoForm = new InformationForm(LoginForm.this);
                        infoForm.setTaCheck(user.toString());
                        setVisible(false);
                        infoForm.setVisible(true);
                        tfId.setText("");
                        tfPw.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this,
                            "존재하지 않는 Id입니다.",
                            "로그인폼",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                int choice = JOptionPane.showConfirmDialog(
                        LoginForm.this,
                        "로그인 프로그램을 종료합니다.",
                        "종료",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }

    public void showFrame() {
        setTitle("Login");
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
