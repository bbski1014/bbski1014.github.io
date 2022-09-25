package GUI作业;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JfExample extends JFrame {

    private JFrame jf;
    private JButton jb1,jb2,jb;
    private JPanel jp,jp2;


    private ImageIcon img;
    private JLabel label;

    private JTextArea jt;
    private JDialog jd;


    public JfExample(){
        //窗口生成
        jf = new JFrame("GUI Work");

        //文本域生成
        jt = new JTextArea(18,30);
        jt.setLineWrap(true);
        //按键生成
        jb1 = new JButton("Button1");
        jb2 = new JButton("Button2");
        jb = new JButton("Exit");
        //按钮可行
        jb1.setEnabled(true);
        jb2.setEnabled(true);
        jb.setEnabled(true);
        //按钮响应设置
        jb1.addActionListener(new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                jt.append("Keep running! ");
                int r, g, b;
                r = (int) (Math.random() * 255);
                g = (int) (Math.random() * 255);
                b = (int) (Math.random() * 255);

                Color cc = new Color(r, g, b);
                if (e.getSource() == jb1) {
                    jp.setBackground(cc);

                }
            }
        });

        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initChildWindow();
            }
        });

        jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Bye!");
                System.exit(0);
            }
        });

        //生成面板，添加组件，加入容器
        jp = new JPanel(new FlowLayout());

        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb);
        jp.add(jt);
        jf.add(jp);

        initGUI();

    }

    private void setBackground(){
        img = new ImageIcon("src/IMG/lie.png");//要设置的背景图片
        label = new JLabel(img);//将背景图放在标签里。
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));//将背景标签添加到JFrame的LayeredPane面板里。
        label.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        jp.add(label);
        jp = (JPanel)this.getContentPane();
        jp.setOpaque(false);//把我的面板设置为不可视
        jp.setLayout(new FlowLayout(FlowLayout.CENTER));//把我的面板设置为绝对布局
        jf.add(jp);
    }

    private void initGUI(){
        jf.setBounds(500,300,500,400);
        jt.setLayout(new FlowLayout(FlowLayout.CENTER));
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void initChildWindow(){
        //子窗口生成
        jd = new JDialog(jf,"ChildWindow");
        jd.setBounds(100,300,300,400);
        jd.setLayout(new FlowLayout(FlowLayout.LEFT));
        jd.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

    }

    public static void main(String[] args) {
        new JfExample();
    }

}


