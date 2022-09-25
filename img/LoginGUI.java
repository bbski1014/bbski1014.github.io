package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;

public class LoginGUI extends JFrame{
    private JFrame frame;

    private JLabel label1;
    private JLabel label2;

    private JTextField username;
    private JPasswordField pwd;

    private JButton button1;
    private JButton button2;
    private JButton button3;


    public LoginGUI(){
        frame = new JFrame("LoginGUI");
        setSignInField();
        setButtons();

        initGUI();
    }

    public void initGUI(){

        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setBounds(500,300,350,200);

        frame.add(label1);
        frame.add(username);
        frame.add(label2);
        frame.add(pwd);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void setSignInField(){
        label1 = new JLabel("account: ");
        label2 = new JLabel("password: ");

        username = new JTextField("student",20);
        pwd = new JPasswordField("123456",20);
        pwd.setEchoChar('*');
    }

    public void setButtons(){
        button1 = new JButton("Sign in");
        button2 = new JButton("Sign out");
        button3 = new JButton("Exit");

        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);

        button1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char []ch= pwd.getPassword();
                String number = new String(ch);
                if(username.getText().equals("student") && number.equals("123456"))
                    JOptionPane.showMessageDialog(null, "Sign in already!");
                else
                    JOptionPane.showMessageDialog(null, "Account or Password is false!");
            }
        });

        button2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Sign out already!");
            }
        });

        button3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bye!");
                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            }
        });

    }

    public static void main(String[] args) {
       new LoginGUI();
    }
}
