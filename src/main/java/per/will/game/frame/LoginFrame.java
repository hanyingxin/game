package per.will.game.frame;

import per.will.game.service.UserService;
import per.will.game.service.impl.UserServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 01467885 on 2020/6/19.
 */
public class LoginFrame extends JFrame implements ActionListener {

    private JPanel mainPanel = new JPanel(); // 创建面板容器，使用默认的布局管理器
    private JLabel usernameLabel = new JLabel("用户名");
    private JLabel passwordLabel = new JLabel("密 码");
    private JTextField usernameTextField = new JTextField(10);
    private JTextField passwordTextField = new JPasswordField(20);
    public JButton loginButton = new JButton("登录");
    public JButton registerButton = new JButton("注册");
    public JButton updateButton = new JButton("修改密码");
    public JButton deleteButton = new JButton("删除用户");

    UserService userService = new UserServiceImpl();

    /**
     * 登录页面
     */
    public LoginFrame() {
        this.setSize(300, 250); // 设置窗口大小
        this.setLocationRelativeTo(null); // 把窗口位置设置到屏幕中心
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 当点击窗口的关闭按钮时退出程序（没有这一句，程序不会退出）

        Font font = new Font("微软雅黑", Font.BOLD, 12);
        super.setTitle("登录");
        mainPanel.setLayout(null);
        usernameLabel.setBounds(20, 20, 60, 30);
        usernameTextField.setBounds(90, 20, 140, 30);
        passwordLabel.setBounds(20, 60, 60, 30);
        passwordTextField.setBounds(90, 60, 140, 30);
        loginButton.setBounds(30, 120, 90, 20);
        registerButton.setBounds(140, 120, 90, 20);
        updateButton.setBounds(30, 150, 90, 20);
        deleteButton.setBounds(140, 150, 90, 20);

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameTextField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordTextField);
        mainPanel.add(loginButton);
        mainPanel.add(registerButton);
        mainPanel.add(updateButton);
        mainPanel.add(deleteButton);

        usernameLabel.setFont(font);
        passwordLabel.setFont(font);
        loginButton.setFont(font);
        registerButton.setFont(font);
        updateButton.setFont(font);
        deleteButton.setFont(font);

        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        updateButton.addActionListener(this);
        deleteButton.addActionListener(this);

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            login();
        }
//        else if (e.getSource() == registerButton) {
//            zhuce();
//        } else if (e.getSource() == updateButton) {
//            updatepass();
//        } else if (e.getSource() == deleteButton) {
//            deleteuser();
//        }
    }

    public void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        if (userService.login(username, password)) {
            JOptionPane.showMessageDialog(null, "登录成功！");
            //super.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "用户名或密码错误！");
        }
    }


}
